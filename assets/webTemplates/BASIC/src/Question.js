import * as React from "react"
import * as PropTypes from 'prop-types'
import ReactCSSTransitionGroup from 'react-addons-css-transition-group';
import EnglishFlagIcon from "./assets/english_flag.svg"
import GermanFlagIcon from "./assets/german_flag.svg"
import ChineseFlagIcon from "./assets/chinese_flag.svg"
import SVG from 'react-inlinesvg';

class Question extends React.PureComponent {
    render() {
        const {showText, title, text, options, onOptionSelected, selectedOption, buttonsDisabled } = this.props
        return (
            <div className="container-fluid question">
                <div className="row question-text-content">
                    <div className="col-10 offset-1">
                        <div className="title-box row">
                            <h1 className="col center">
                                {showText ? title : ""}
                            </h1>
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
                                            onClick={() => onOptionSelected(value)}>
                                            {title || value}
                                            { value==="en" && <SVG alt="English Flag" src={EnglishFlagIcon}/> }
                                            { value==="zh" && <SVG alt="Chinese Flag" src={ChineseFlagIcon}/> }
                                            { value==="de" && <SVG alt="German Flag" src={GermanFlagIcon}/> }
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