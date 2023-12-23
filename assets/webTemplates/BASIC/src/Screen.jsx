import React from "react"
import {actions} from "./model"
import PropTypes from "prop-types"
import Results from "./Results"
import Question from "./Question"
import Menu from "./Menu"
import LanguageSelector from "./LanguageSelector"
import {AboutModal} from "./AboutModal"

export class Screen extends React.PureComponent {
    respond(value) {
        this.props.onUpdate(new actions.SendUserResponse(value))
        this.props.onUpdate(new actions.SetButtonsClickable(false))
    }
    render() {
        const { menuShown, text, options, title, showText, onUpdate, optionsDelay, results, selectedOption, modal, buttonsDisabled, lang } = this.props
        return(
            <div>
                <AboutModal modal={modal} lang={lang} onHide={() => onUpdate(new actions.CloseModal(true))}/>
                <div className="header row no-gutters">
                    <div className="col">
                        <Menu isShown={menuShown} onUpdate={onUpdate} showText={showText} lang={lang}/>
                        <LanguageSelector onUpdate={onUpdate} lang={lang} />
                        <h1>Mental Health Screener</h1>
                    </div>
                </div>
                <div className="content row">
                    <div className="col-10 offset-1">
                        {results == null ?
                            <Question
                                options={options}
                                onOptionSelected={this.respond.bind(this)}
                                optionsDelay={optionsDelay}
                                text={text}
                                title={title}
                                selectedOption={selectedOption}
                                buttonsDisabled={buttonsDisabled}
                                showText={showText}/> :
                            <Results
                                results={results}
                                onUpdate={onUpdate}
                                selectedOption={selectedOption}
                                lang={lang}/>
                        }
                    </div>
                </div>
            </div>
        )
    }
}

Screen.propTypes = {
    menuShown: PropTypes.bool.isRequired,
    text: PropTypes.string,
    title: PropTypes.string,
    options: PropTypes.arrayOf(PropTypes.string),
    optionsDelay: PropTypes.number,
    showText: PropTypes.bool.isRequired,
    onUpdate: PropTypes.func.isRequired,
    results: PropTypes.shape({
        key: PropTypes.string.isRequired,
        score: PropTypes.number.isRequired,
        isPositive: PropTypes.bool.isRequired
    }),
    selectedOption: PropTypes.string,
    buttonsDisabled: PropTypes.bool.isRequired,
    modal: PropTypes.number.isRequired
}
