import * as React from "react"
import * as PropTypes from 'prop-types'
import ReactCSSTransitionGroup from 'react-addons-css-transition-group';
import EnglishFlagIcon from "./assets/english_flag.svg"
// import GermanFlagIcon from "./assets/german_flag.svg"
import ChineseFlagIcon from "./assets/chinese_flag.svg"
import SwedishFlagIcon from "./assets/sweden_flag.svg"
import Face0Titan from "./assets/Face_0_Titan.png"
import Face1Jane from "./assets/Face_1_Jane.png"
import Face2Nazar from "./assets/Face_2_Nazar.png"
import Face3Isabel from "./assets/Face_3_Isabel.png"
import Face4Yumi from "./assets/Face_4_Yumi.png"
import Face5Alex from "./assets/Face_5_Alex.png"
import Face6Samuel from "./assets/Face_6_Samuel.png"
import Face7Kione from "./assets/Face_7_Kione.png"
import SVG from 'react-inlinesvg';

class FaceOptions extends React.PureComponent {
    render() {
        const {isShown, onOptionSelected, buttonsDisabled } = this.props
        return (isShown == "none" ? null :

                <div className="gallery-container">
                    <div className="gallery-container">
                        <div className="responsive">
                            <div className="gallery">
                                <ReactCSSTransitionGroup
                                    transitionName="fade"
                                    transitionAppear={true}
                                    transitionAppearTimeout={500}
                                    transitionEnterTimeout={500}
                                    transitionLeaveTimeout={1000}>
                                    {!buttonsDisabled &&
                                        <a style={{borderRadius: "50%"}} key={"Titan"}
                                           onClick={() => onOptionSelected("Titan")}>
                                            <img src={'dist' + Face0Titan}
                                                 style={{width: 200, height: 200}}
                                            />
                                            <div className="desc" key={"Titan"}>Face 0</div>
                                        </a>}
                                </ReactCSSTransitionGroup>
                            </div>
                        </div>
                        <div className="responsive">
                            <div className="gallery">
                                <ReactCSSTransitionGroup
                                    transitionName="fade"
                                    transitionAppear={true}
                                    transitionAppearTimeout={500}
                                    transitionEnterTimeout={500}
                                    transitionLeaveTimeout={1000}>
                                    {!buttonsDisabled &&
                                        <a style={{borderRadius: "50%"}} key={"Jane"}
                                           onClick={() => onOptionSelected("Jane")}>
                                            <img src={'dist' + Face1Jane}
                                                 style={{width: 200, height: 200}}
                                            />
                                            <div className="desc">Face 1</div>
                                        </a>}

                                </ReactCSSTransitionGroup>
                            </div>
                        </div>
                        <div className="responsive">
                            <div className="gallery">
                                <ReactCSSTransitionGroup
                                    transitionName="fade"
                                    transitionAppear={true}
                                    transitionAppearTimeout={500}
                                    transitionEnterTimeout={500}
                                    transitionLeaveTimeout={1000}>
                                    {!buttonsDisabled &&
                                        <a style={{borderRadius: "50%"}} key={"Nazar"}
                                           onClick={() => onOptionSelected("Nazar")}>
                                            <img src={'dist' + Face2Nazar}
                                                 style={{width: 200, height: 200}}
                                            />
                                            <div className="desc">Face 2</div>
                                        </a>}
                                </ReactCSSTransitionGroup>
                            </div>
                        </div>
                        <div className="responsive">
                            <div className="gallery">
                                <ReactCSSTransitionGroup
                                    transitionName="fade"
                                    transitionAppear={true}
                                    transitionAppearTimeout={500}
                                    transitionEnterTimeout={500}
                                    transitionLeaveTimeout={1000}>
                                    {!buttonsDisabled &&
                                        <a style={{borderRadius: "50%"}} key={"Isabel"}
                                           onClick={() => onOptionSelected("Isabel")}>
                                            <img src={'dist' + Face3Isabel}
                                                 style={{width: 200, height: 200}}
                                            />
                                            <div className="desc">Face 3</div>
                                        </a>}
                                </ReactCSSTransitionGroup>
                            </div>
                        </div>
                        <div className="responsive">
                            <div className="gallery">
                                <ReactCSSTransitionGroup
                                    transitionName="fade"
                                    transitionAppear={true}
                                    transitionAppearTimeout={500}
                                    transitionEnterTimeout={500}
                                    transitionLeaveTimeout={1000}>
                                    {!buttonsDisabled &&
                                        <a style={{borderRadius: "50%"}} key={"Yumi"}
                                           onClick={() => onOptionSelected("Yumi")}>
                                            <img src={'dist' + Face4Yumi}
                                                 style={{width: 200, height: 200}}
                                            />
                                            <div className="desc">Face 4</div>
                                        </a>}
                                </ReactCSSTransitionGroup>
                            </div>
                        </div>
                        <div className="responsive">
                            <div className="gallery">
                                <ReactCSSTransitionGroup
                                    transitionName="fade"
                                    transitionAppear={true}
                                    transitionAppearTimeout={500}
                                    transitionEnterTimeout={500}
                                    transitionLeaveTimeout={1000}>
                                    {!buttonsDisabled &&
                                        <a style={{borderRadius: "50%"}} key={"Alex"}
                                           onClick={() => onOptionSelected("Alex")}>
                                            <img src={'dist' + Face5Alex}
                                                 style={{width: 200, height: 200}}
                                            />
                                            <div className="desc">Face 5</div>
                                        </a>}
                                </ReactCSSTransitionGroup>
                            </div>
                        </div>
                        <div className="responsive">
                            <div className="gallery">
                                <ReactCSSTransitionGroup
                                    transitionName="fade"
                                    transitionAppear={true}
                                    transitionAppearTimeout={500}
                                    transitionEnterTimeout={500}
                                    transitionLeaveTimeout={1000}>
                                    {!buttonsDisabled &&
                                        <a style={{borderRadius: "50%"}} key={"Samuel"}
                                           onClick={() => onOptionSelected("Samuel")}>
                                            <img src={'dist' + Face6Samuel}
                                                 style={{width: 200, height: 200}}
                                            />
                                            <div className="desc">Face 6</div>
                                        </a>}
                                </ReactCSSTransitionGroup>
                            </div>
                        </div>
                        <div className="responsive">
                            <div className="gallery">
                                <ReactCSSTransitionGroup
                                    transitionName="fade"
                                    transitionAppear={true}
                                    transitionAppearTimeout={500}
                                    transitionEnterTimeout={500}
                                    transitionLeaveTimeout={1000}>
                                    {!buttonsDisabled &&
                                        <a style={{borderRadius: "50%"}} key={"Kione"}
                                           onClick={() => onOptionSelected("Kione")}>
                                            <img src={'dist' + Face7Kione}
                                                 style={{width: 200, height: 200}}
                                            />
                                            <div className="desc">Face 7</div>
                                        </a>}
                                </ReactCSSTransitionGroup>
                            </div>
                        </div>
                        <div className="clearfix"></div>
                    </div>

                </div>

        )
    }

    static getActiveClass(selectedOption, value) {
        return selectedOption != null && value.toLowerCase() === selectedOption.toLowerCase() ? "active" : ""
    }
}

FaceOptions.propTypes = {
    isShown: PropTypes.string,
    onOptionSelected: PropTypes.func.isRequired,
    selectedOption: PropTypes.string,
    buttonsDisabled: PropTypes.bool.isRequired,
}
export default FaceOptions

