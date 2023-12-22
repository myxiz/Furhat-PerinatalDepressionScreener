import * as React from "react"
import * as PropTypes from "prop-types"
import EnglishFlagIcon from "./assets/english_flag.svg"
import SwedishFlagIcon from "./assets/sweden_flag.svg"
import ChineseFlagIcon from "./assets/chinese_flag.svg"
import SVG from "react-inlinesvg"
import {actions} from "./model";

class LanguageSelector extends React.PureComponent {
    render() {
        const {lang, onUpdate} = this.props

        console.log('language: ', lang)
        const enClasses = (lang === 'en') && 'language_button--selected';
        const seClasses = (lang === 'sv') && 'language_button--selected';
        const zhClasses = (lang === 'zh') && 'language_button--selected';

        const handleLanguageSelect = selected => (selected !== lang)
            ? onUpdate(new actions.SetLanguage(selected, true))
            : null;
        return (
            <div className={'float-right language_selector'}>
                <button
                    className={"language_button " + zhClasses}
                    onClick={() => handleLanguageSelect('zh')}>
                    <SVG alt="Chinese Flag" src={ChineseFlagIcon}/>
                </button>
                <button
                    className={"language_button " + seClasses}
                    onClick={() => handleLanguageSelect('sv')}>
                    <SVG alt="Swedish Flag" src={SwedishFlagIcon}/>
                </button>
                <button
                    className={"language_button " + enClasses}
                    onClick={() => handleLanguageSelect('en')}>
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

