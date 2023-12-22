import Modal from "react-bootstrap/lib/Modal"
import {ModalState} from "./model"
import PropTypes from "prop-types"
import React from "react"
import FurhatLogo from "./assets/furhat-logo-white.png"
import i18n from './copy/i18n';

export function AboutModal(props) {
    const { lang } = props

    return <Modal
        show={props.modal !== ModalState.NoModal}
        onHide={props.onHide}
        size="lg">
        <Modal.Header>
            {
                {  [ModalState.AboutFurhat]: <Modal.Title>
                        <img src={'dist' + FurhatLogo} className="logo"/>
                    </Modal.Title>
                }[props.modal]
            }
        </Modal.Header>

        <Modal.Body>
            {{
                [ModalState.AboutFurhat]: (<div>
                        <p>{i18n[lang].ABOUT_PETRA}</p>
                        <p className="about-link">
                            www.furhatrobotics.com
                        </p>
                    </div>
                )
            }[props.modal]}
        </Modal.Body>

        <Modal.Footer>
            <button title={i18n[lang].CONTINUE}
                    className={`col-6 offset-3 btn btn-block btn-lg reply`}
                    onClick={props.onHide}>
                {i18n[lang].CONTINUE}
            </button>
        </Modal.Footer>
    </Modal>
}

AboutModal.propTypes = {
    modal: PropTypes.any,
    onHide: PropTypes.func
}
