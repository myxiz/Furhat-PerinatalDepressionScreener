export const ModalState = {
    'NoModal': 0,
    'AboutFurhat': 1
}

export const initState = {
    menuShown: false,
    title: null,
    text: null,
    options: null,
    optionsDelay: null,
    showText: false,
    dispatcher: null,
    results: null,
    selectedOption: null,
    buttonsDisabled: false,
    command: null,
    modal: ModalState.NoModal,
    language: 'zh'
}

function ClearScreen() {
}

function ShowOnScreen(title, text) {
    Object.assign(this, {title, text})
}

function ToggleText() {
}

function SetLanguage(language, calledFromGui = false) {
    Object.assign(this, {language, calledFromGui})
}


function ShowOptions(options, prompt, shouldAppend, delay, title) {
    Object.assign(this, {options, prompt, shouldAppend, delay, title})
}

function AppendText(text) {
    Object.assign(this, {text})
}

function SetFurhatDispatcher(dispatcher) {
    Object.assign(this, {dispatcher})
}

function SendUserResponse(response) {
    Object.assign(this, {response})
}

function ShowResults(results) {
    Object.assign(this, {results})
}

function OptionSelected(option) {
    Object.assign(this, {option})
}

function ToggleMenuShown() {
}

function ShowFurhatModal(calledFromGui) {
    Object.assign(this, {calledFromGui})
}

function ShowScreenerModal(calledFromGui) {
    Object.assign(this, {calledFromGui})
}

function CloseModal(calledFromGui) {
    Object.assign(this, {calledFromGui})
}

function SetButtonsClickable(value) {
    Object.assign(this, {value})
}

function UserClickedExit() { }

function Restart() {}

function GetLanguage(value) {
    Object.assign(this, {value})
}

export const actions = {
    ClearScreen,
    ShowOnScreen,
    ToggleText,
    ShowOptions,
    AppendText,
    SetFurhatDispatcher,
    SendUserResponse,
    ShowResults,
    OptionSelected,
    ToggleMenuShown,
    ShowFurhatModal,
    ShowScreenerModal,
    CloseModal,
    UserClickedExit,
    Restart,
    SetButtonsClickable,
    SetLanguage,
    GetLanguage
}

