import FurhatGUI from 'furhat-gui'
import React from 'react'
import * as ReactDOM from "react-dom"
import {Screen} from "./Screen"
import {actions, initState, ModalState} from "./model"

/**
 * Application level update function.
 * @param state - current state of the application
 * @param action - requested action
 * @returns {*} - new state returned by calling the action function (defined here) with the action parameters.
 */
function update(state, action) {
    const actionHandler = {
        [actions.ClearScreen]: () => ({
            ...state,
            title: null,
            text: null,
            options: null,
            results: null,
            modal: ModalState.NoModal
        }),
        [actions.AppendText]: ({text}) => ({...state, text: [state.text, text].join('\n')}),
        [actions.ShowOnScreen]: ({title, text}) => ({
            ...state,
            title,
            text,
            options: null,
            results: null,
            modal: ModalState.NoModal
        }),
        [actions.ShowOptions]: ({options, prompt, shouldAppend, delay, title}) => ({
            ...state,
            options,
            optionsDelay: delay,
            text: shouldAppend ? [state.text, prompt].join("\n") : prompt,
            title: title != null ? title : state.title,
            selectedOption: null,
            buttonsDisabled: false,
            results: null,
            modal: ModalState.NoModal
        }),
        [actions.SetButtonsClickable]: ({value}) => ({...state, buttonsDisabled: !value}),
        [actions.ToggleText]: () => ({...state, menuShown: false, showText: !state.showText}),
        [actions.SetFurhatDispatcher]: ({dispatcher}) => ({...state, dispatcher}),
        [actions.SendUserResponse]: ({response}) => ({
            ...state,
            selectedOption: response,
            command: () => (state.dispatcher({
                event_name: "UserResponse",
                response
            }))
        }),
        [actions.ShowResults]: ({results}) => ({...state, results, modal: ModalState.NoModal}),
        [actions.OptionSelected]: ({option}) => ({...state, selectedOption: option}),
        [actions.ToggleMenuShown]: () => ({...state, menuShown: !state.menuShown}),
        [actions.ShowFurhatModal]: ({calledFromGui}) => ({
            ...state,
            modal: ModalState.AboutFurhat,
            menuShown: calledFromGui ? false : state.menuShown,
            command: calledFromGui ? () => state.dispatcher({event_name: "TellAboutFurhat"}) : state.command
        }),
        [actions.CloseModal]: ({calledFromGui}) => ({
            ...state,
            modal: ModalState.NoModal,
            command: calledFromGui ? () => (state.dispatcher({event_name: "ModalClosed"})) : state.command
        }),
        [actions.UserClickedExit]: () => ({
            ...state,
            menuShown: false,
            command: () => state.dispatcher({event_name: "GoHome"})
        }),
        [actions.Restart]: () => ({
            title: null,
            text: null,
            options: null,
            results: null,
            modal: ModalState.NoModal,
            menu: false,
            command: () => state.dispatcher({event_name: "Restart"})
        }),
        [actions.SetLanguage]: ({language, calledFromGui = false}) => ({
            ...state,
            language,
            command: calledFromGui ? () => (state.dispatcher({event_name: "SelectLanguageGui", language})) : state.command
        }),
        [actions.GetLanguage]: () => ({
            ...state,
            command: () => state.dispatcher({event_name: "GetLanguageGui" })
        })
    }[action.constructor];
    return typeof actionHandler === "function" ? actionHandler(action) : state
}

/**
 * run the `command` (a function with no parameters) and if it returns a promise or a non-null value assume it's an
 * action and call the action handler on it.
 * Warning: since this is invoked from the action handler beware of infinite recursion.
 * @param command
 * @param onResult
 */
function runCommand(command, onResult) {
    if (typeof command === "function") {
        const promise = command()
        if (promise != null && typeof promise.then === "function") {
            promise.then(onResult)
        } else if (promise != null) {
            onResult(promise)
        }
    }
}

class FurhatGuiApp extends React.Component {
    constructor(props) {
        super(props)
        this.state = initState
    }

    componentDidMount() {
        this.initializeFurhat()
    }

    /**
     * Handle an action and use it to update the state.
     * If the "command" property of the state is set, then invoke it and then clean it.
     * @param action
     */
    updateHandler(action) {
        this.setState(
            (model) => update(model, action),
            () => {
                runCommand(this.state.command, this.updateHandler.bind(this))
                this.state.command = null
            }
        )
    }

    initializeFurhat() {
        FurhatGUI(furhat => {
            furhat.subscribe('ClearScreen', () => {
                this.updateHandler(new actions.ClearScreen())
            })

            furhat.subscribe('ShowScreenEvent', (event) => {
                console.log('ShowScreenEvent event', event)
                const {title, text} = event
                this.updateHandler(new actions.ShowOnScreen(title, text))
            })

            furhat.subscribe('ShowOptionsEvent', (event) => {
                console.log('ShowOptionsEvent event', event)
                const {options, prompt, append, delaySeconds, title} = event
                this.updateHandler(new actions.ShowOptions(options, prompt, append, delaySeconds, title))
            })

            furhat.subscribe('ShowResultsEvent', (event) => {
                console.log('ShowResultsEvent event', event)
                this.updateHandler(new actions.ShowResults({
                    isPositive: !!event.positive,
                    key: event.results,
                    score: event.score,
                }))
            })

            furhat.subscribe('AppendTextEvent', ({text}) => {
                this.updateHandler(new actions.AppendText(text))
            })

            furhat.subscribe('ToggleGUIText', () => {
                this.updateHandler(new actions.ToggleText())
            })

            furhat.subscribe('OptionSelectedEvent', ({option}) => {
                console.log(`User selected ${option} by NLU`)
                this.updateHandler(new actions.OptionSelected(option))
            })

            furhat.subscribe('ShowAboutFurhatEvent', () => {
                console.log('ShowABoutFurhatEvent')
                this.updateHandler(new actions.ShowFurhatModal(false))
            })

            furhat.subscribe('SetLanguageEvent', ({language}) => {
                console.log('Received SetLanguageEvent', language)
                this.updateHandler(new actions.SetLanguage(language))
            })

            furhat.subscribe('ClosedModalEvent', () => {
                console.log('ClosedModalEvent')
                this.updateHandler(new actions.CloseModal(false))
            })

            this.updateHandler(new actions.SetFurhatDispatcher(furhat.send.bind(furhat)))

            this.updateHandler(new actions.GetLanguage())
        })
    }

    render() {
        return <Screen
            title={this.state.title}
            text={this.state.text}
            options={this.state.options}
            showText={this.state.showText}
            optionsDelay={this.state.optionsDelay}
            results={this.state.results}
            selectedOption={this.state.selectedOption}
            buttonsDisabled={this.state.buttonsDisabled}
            menuShown={this.state.menuShown}
            modal={this.state.modal}
            lang={this.state.language}
            onUpdate={this.updateHandler.bind(this)}
        />
    }
}

ReactDOM.render(
    <FurhatGuiApp/>,
    document.getElementById('root')
)
