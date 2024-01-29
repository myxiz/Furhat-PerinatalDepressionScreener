import * as React from "react"
import * as PropTypes from "prop-types"
import EnglishFlagIcon from "./assets/english_flag.svg"
import SwedishFlagIcon from "./assets/sweden_flag.svg"
import ChineseFlagIcon from "./assets/chinese_flag.svg"
import SVG from "react-inlinesvg"
import {actions} from "./model";

class FaceSelector extends React.PureComponent {
    render() {
        const {face, onUpdate} = this.props

        console.log('face: ', face)
        const f0TitanClasses = (face === 'Face 0 Titan') && 'face_button--selected';
        const f1JaneClasses = (face === 'Face 1 Jane') && 'face_button--selected';
        const f2NazarClasses = (face === 'Face 2 Nazar') && 'face_button--selected';
        const f3IsabelClasses = (face === 'Face 3 Isabel') && 'face_button--selected';
        const f4YumiClasses = (face === 'Face 4 Yumi') && 'face_button--selected';
        const f5AlexClasses = (face === 'Face 5 Alex') && 'face_button--selected';
        const f6SamuelClasses = (face === 'Face 6 Samuel') && 'face_button--selected';
        const f7KioneClasses = (face === 'Face 7 Kione') && 'face_button--selected';


        const handFaceSelect = selected => (selected !== face)
            ? onUpdate(new actions.SetFace(selected, true))
            : null;
        return (
            //1 to do Set face need the function, 2 svg img need to be done. 3 Call faceselector
            <div className={'float-right language_selector'}>
                <button
                    className={"language_button " + zhClasses}
                    onClick={() => handFaceSelect('zh')}>
                    <SVG alt="Chinese Flag" src={ChineseFlagIcon}/>
                </button>
                <button
                    className={"language_button " + seClasses}
                    onClick={() => handFaceSelect('sv')}>
                    <SVG alt="Swedish Flag" src={SwedishFlagIcon}/>
                </button>
                <button
                    className={"language_button " + enClasses}
                    onClick={() => handFaceSelect('en')}>
                    <SVG alt="English Flag" src={EnglishFlagIcon}/>
                </button>
            </div>
        )
    }
}

LanguageSelector.propTypes = {
    lang: PropTypes.string
}

export default LanguageSelector

