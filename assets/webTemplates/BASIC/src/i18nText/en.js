import * as React from "react"

export default {
    // Buttons
    CONTINUE: `Continue`,
    CLOSE: `Close`,
    RESTART: `Restart`,
    HOME: `Home`,
    HIDE_TEXT: `Hide text`,
    SHOW_TEXT: `Show text`,
    ABOUT_ME: `About Me`,
    RESULTS: `Results`,

    // Main menu texts
    ABOUT_PETRA: `I am a robot for screening of perinatal depression. I have been designed by the social robotics laboratory at Uppsala University. I am still a first-generation prototype, and welcome to give any suggestions. Please say "Continue" when you want to go back.`,

    // Results page
    EPDS_LOW_RISK_INFO: <span>That means that you are not likely suffering from perinatal depression.</span>,
    EPDS_DEPRESSION_POSSIBLE_INFO: <span>That means it is possible that you are suffering from perinatal depression.</span>,
    EPDS_MODERATE_RISK_INFO:
        <span>That means the risk for you currently having a perinatal depression is fairly high. <br/>We will have a specialist follow up with your result and get back to you later.</span>,
    EPDS_HIGH_RISK_INFO: <span>That means you are in high risk of having a perinatal depression currently.<br/>You might need a further diagnosis. We will have a specialist follow up with your result and get back to you later.</span>,
    EPDS_VERY_HIGH_RISK_INFO: <span>That means you are in very high risk of having a perinatal depression currently.<br/>Our assistant will talk to you in a moment. We will also have a specialist follow up with your result and get back to you later.</span>,

    RESULTS_ABOUT_TEST: 'This screening and this risk assessment is based on the EPDS screening test designed by Professor John Cox at the Department of Psychiatry at the University of Edinburgh. It has been widely used in Sweden for perinatal depression screening.',
    RESULTS_MORE_ABOUT: 'More about perinatal depression and its symptoms',
    RESULTS_EXTRA_CONTENT: 'Perinatal depression arises when hormonal changes, physical changes, and the psychological adjustments to motherhood overwhelm a woman\'s ability to cope. These hormonal fluctuations can significantly affect a woman\'s mood and emotions, leading to feelings of sadness, anxiety, hopelessness, and in severe cases, thoughts of harming oneself or the baby.',
    YOUR_RISK_IS: 'Your risk is',
    THANKS_FOR_TEST: 'Thank you for doing the test! Please beware that I\'m not a medical doctor and these results are only indicators.',

    EPDS_RISK_LABELS: {
        'low': 'low',
        'depression_possible': 'depression possible',
        'fairly_high': 'fairly high',
        'high': 'high',
        'very_high': 'very high',
    },
}
