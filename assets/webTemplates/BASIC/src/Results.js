import * as React from "react"
import PropTypes from "prop-types"
import {actions} from "./model"
import i18n from './i18nText/i18n';

const getEPDSRisk = score => {
    switch (true) {
        case score < 9:
            return "low";
        case score <= 10:
            return "depression_possible";
        case score <= 12:
            return "fairly_high";
        case score <= 30:
            return "high";
        default:
            return "very_high"
    }
};

const getEPDSResultInfo = (score, lang) => {
    console.log('score when fetching info: ', score)
    switch (true) {
        case score < 9:
            return i18n[lang].EPDS_LOW_RISK_INFO;
        case score <= 10:
            return i18n[lang].EPDS_DEPRESSION_POSSIBLE_INFO;
        case score <= 12:
            return i18n[lang].EPDS_MODERATE_RISK_INFO;
        case score <= 30:
            return i18n[lang].EPDS_HIGH_RISK_INFO;
        default:
            return i18n[lang].EPDS_VERY_HIGH_RISK_INFO
    }
};

class Results extends React.PureComponent {
    render() {
        let {results, lang, selectedOption} = this.props;
        return (
            <div className="container-fluid results-container">
                <div className="row">
                    <div className="col results">
                        <h2 className="title-box text-left">{i18n[lang].RESULTS}</h2>
                        <p>
                            <span>
                                {`${i18n[lang].YOUR_RISK_IS} ${i18n[lang].EPDS_RISK_LABELS[getEPDSRisk(results.score)]}.`}
                                <br/>
                                {getEPDSResultInfo(results.score, lang)}
                            </span>
                        </p>
                        <p>
                            {i18n[lang].RESULTS_ABOUT_TEST}
                            <br/>
                            {i18n[lang].THANKS_FOR_TEST}
                        </p>
                        <div className="row">
                            <div className="col">
                                <h2 className="title-box text-left">{i18n[lang].RESULTS_MORE_ABOUT}</h2>
                                <p className="" dangerouslySetInnerHTML={{__html: i18n[lang].RESULTS_EXTRA_CONTENT}}/>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="row continue-btn">
                    <div className="col btn-group-lg">
                        <button title="Continue"
                                className={`col-4 offset-3 btn btn-block btn-lg reply ${this.getButtonActive(selectedOption)}`}
                                onClick={() => this.props.onUpdate(new actions.SendUserResponse("Continue"))}>
                            {i18n[lang].CLOSE}
                        </button>
                    </div>
                </div>

            </div>
        );
    }

    getButtonActive(selectedOption) {
        return selectedOption != null && selectedOption.toLowerCase() === "continue" ? "active" : ""
    }
}

Results.propTypes = {
    results: PropTypes.shape({
        key: PropTypes.string.isRequired,
        score: PropTypes.number.isRequired,
        isPositive: PropTypes.bool.isRequired,
    }).isRequired,
    onUpdate: PropTypes.func.isRequired,
    selectedOption: PropTypes.string,
};

export default Results
