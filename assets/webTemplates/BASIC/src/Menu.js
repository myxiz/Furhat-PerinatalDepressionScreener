import * as React from "react"
import * as PropTypes from "prop-types"
import {actions} from "./model"
import MenuIcon from "./assets/hamburger.svg"
import CloseIcon from "./assets/close-icon.svg"
import SVG from "react-inlinesvg"
import i18n from './i18nText/i18n'

class Menu extends React.PureComponent {

    render() {
        const {showText, isShown, onUpdate, lang} = this.props
        return (
            <div className="dropdown float-right">
                <button className="dropdown-toggle menu" onClick={() => onUpdate(new actions.ToggleMenuShown())}>
                    {isShown ? <SVG src={CloseIcon}/> : <SVG src={MenuIcon}/>}
                </button>
                <div className={"menu-backdrop " + (isShown ? "show" : "")}
                     onClick={() => onUpdate(new actions.ToggleMenuShown())}/>
                <div className={"dropdown-menu dropdown-menu-right " + (isShown ? "show" : "")}>
                    <button
                        className="btn dropdown-item"
                        onClick={() => onUpdate(new actions.ShowFurhatModal(true))}>
                        {i18n[lang].ABOUT_ME}
                    </button>
                    <button
                        className="btn dropdown-item"
                        onClick={() => onUpdate(new actions.ToggleText())}>
                        {showText ? i18n[lang].HIDE_TEXT : i18n[lang].SHOW_TEXT}
                    </button>
                    <button
                        onClick={() => onUpdate(new actions.UserClickedExit())}
                        className="btn dropdown-item">
                        {i18n[lang].HOME}
                    </button>

                    <button
                        onClick={() => onUpdate(new actions.Restart())}
                        className="btn dropdown-item">
                        {i18n[lang].RESTART}
                    </button>
                </div>
            </div>
        )
    }
}

Menu.propTypes = {
    isShown: PropTypes.bool.isRequired,
    onUpdate: PropTypes.func.isRequired,
    showText: PropTypes.bool.isRequired
}

export default Menu
