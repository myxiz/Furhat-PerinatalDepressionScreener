import * as React from "react"
import * as PropTypes from 'prop-types'
import ReactCSSTransitionGroup from 'react-addons-css-transition-group';
import EnglishFlagIcon from "./assets/english_flag.svg"
// import GermanFlagIcon from "./assets/german_flag.svg"
import ChineseFlagIcon from "./assets/chinese_flag.svg"
import SwedishFlagIcon from "./assets/sweden_flag.svg"
import Face0Titan from "./assets/Face_0_Titan.png"
import Face5Alex from "./assets/Face_5_Alex.png"
import SVG from 'react-inlinesvg';
import {actions} from "./model";

let eventHandled = false;

class Question extends React.PureComponent {
    render() {
        let {showText, text, onOptionSelected, selectedOption, buttonsDisabled } = this.props
        let savedOptionEvent = localStorage.getItem('optionEvent');
        let {options, prompt, append, delaySeconds, title} = savedOptionEvent ? JSON.parse(savedOptionEvent) ?  JSON.parse(savedOptionEvent):this.props :this.props
        actions.ShowOptions(options, prompt, append, delaySeconds, title)
        // const {showText, title, text, options, onOptionSelected, selectedOption, buttonsDisabled } = this.props
        return (
            <div className="container-fluid question">
                <div className="row question-text-content">
                    <div className="col-10 offset-1">
                        <div className="title-box row">
                            <h2 className="col center">
                                {showText ? title : ""}
                            </h2>
                        </div>
                        <div className="row text-box center">
                            <div className="col">
                            {showText && text
                                ? text.split("\n").map(
                                    (line, index) => <p key={`text-line-${index}`}>{line}</p>)
                                : <p/>
                            }
                            </div>
                        </div>
                    </div>
                </div>
                <div className="row center button-row">
                    <div className="col-8 offset-2 center">
                            {options &&
                                options.map((option, index) => {
                                    const [value, title] = option.split(':')
                                    return (
                                    <ReactCSSTransitionGroup
                                        transitionName="fade"
                                        transitionAppear={true}
                                        transitionAppearTimeout={500}
                                        transitionEnterTimeout={500}
                                        transitionLeaveTimeout={1000}
                                        key={text + value}>
                                        { !buttonsDisabled &&
                                        <button
                                            key={text + value}
                                            type="button"
                                            disabled={buttonsDisabled}
                                            className={`reply btn btn-lg btn-svg fading-btn fading-btn-${index+1} ${Question.getActiveClass(selectedOption, value)}`}
                                            onClick={() => {
                                                if (!eventHandled) {
                                                    onOptionSelected(value);
                                                    eventHandled = true;
                                                    setTimeout(() => { eventHandled = false; }, 300);
                                                    // Optionally reset the flag here as well, if clicks are not followed by touchEnds
                                                }}}
                                            onTouchEnd = {() => {
                                                if (!eventHandled) {
                                                    setTimeout(() => {
                                                        // delay 500 ms onOptionSelected
                                                        onOptionSelected(value);
                                                    }, 1)
                                                    eventHandled = true;
                                                    // Reset the flag after a short delay to handle subsequent actions
                                                    setTimeout(() => { eventHandled = false; }, 300); // 300ms or adjust as needed
                                                }}}>
                                            {title || value}
                                            { value==="en" && <SVG alt="English Flag" src={EnglishFlagIcon}/> }
                                            { value==="zh" && <SVG alt="Chinese Flag" src={ChineseFlagIcon}/> }
                                            { value==="sv" && <SVG alt="Swedish Flag" src={SwedishFlagIcon}/> }
                                        </button>}
                                    </ReactCSSTransitionGroup>
                                    )
                                })
                            }
                    </div>
                </div>
            </div>
        )
    }

    static getActiveClass(selectedOption, value) {
        return selectedOption != null && value.toLowerCase() === selectedOption.toLowerCase() ? "active" : ""
    }
}



Question.propTypes = {
    text: PropTypes.string,
    title: PropTypes.string,
    options: PropTypes.arrayOf(PropTypes.string),
    optionsDelay: PropTypes.number,
    showText: PropTypes.bool.isRequired,
    onOptionSelected: PropTypes.func.isRequired,
    selectedOption: PropTypes.string,
    buttonsDisabled: PropTypes.bool.isRequired,
}

export default Question
