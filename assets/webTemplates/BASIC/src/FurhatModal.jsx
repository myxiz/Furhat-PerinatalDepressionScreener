import Modal from "react-bootstrap/lib/Modal"
import {ModalState} from "./model"
import PropTypes from "prop-types"
import React from "react"
import LabLogo  from "./assets/logo_white.png"
import Face0Titan from "./assets/Face_0_Titan.png"
import Face1Jane from "./assets/Face_1_Jane.png"
import Face2Nazar from "./assets/Face_2_Nazar.png"
import Face3Isabel from "./assets/Face_3_Isabel.png"
import Face4 from "./assets/Face_4_Yumi.png"
import Face5Alex from "./assets/Face_5_Alex.png"
import Face6Samuel from "./assets/Face_6_Samuel.png"
import Face7Kinoe from "./assets/Face_7_Kione.png"
import i18n from './i18nText/i18n';

export function FurhatModal(props) {
    const { lang } = props

    return <Modal
        show={props.modal !== ModalState.NoModal}
        onHide={props.onHide}
        size="lg">
        <Modal.Header>
            {
                {  [ModalState.AboutFurhat]: <Modal.Title>
                        <img src={'dist' + LabLogo}
                             className={"logo"}
                        />
                    </Modal.Title>
                }[props.modal]
            }
        </Modal.Header>

        <Modal.Body>
            {{
                [ModalState.AboutFurhat]: (<div>
                        <p>{i18n[lang].ABOUT_PETRA}</p>
                        <p className="about-link">
                            https://usr-lab.github.io
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

FurhatModal.propTypes = {
    modal: PropTypes.any,
    onHide: PropTypes.func
}
