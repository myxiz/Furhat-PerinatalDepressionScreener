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
    ABOUT_PETRA: `I'm Alice - a  health screening Robot. I was developed by Furhat robotics - a social robotics company located in Stockholm, Sweden. They produce robots like myself, who can interact with humans in a natural way in social situations. Furhat robots, just like me, are already being used around the world, to help people lead happier and more productive lives. For more information, please visit their website. Say "Continue" when you want to go back.`,

    // Results page
    DIABETES_LOW_RISK_INFO: <span>That means that within ten years, the risk for you to develop diabetes is estimated as 1 in 100.</span>,
    DIABETES_SLIGHTLY_ELEVATED_RISK_INFO: <span>That means that within ten years, the risk for you to develop diabetes is estimated as 1 in 25.</span>,
    DIABETES_MODERATE_RISK_INFO: <span>That means that within ten years, the risk for you to develop diabetes is estimated as 1 in 6. <br/>You are well advised to seriously consider your physical activity and eating habits and pay attention to you weight, to prevent yourself from developing diabetes. Contact a public-health nurse or your own doctor for further guidance.</span>,
    DIABETES_HIGH_RISK_INFO: <span>That means that within ten years, the risk for you to develop diabetes is estimated as 1 in 3.<br/>You should have your blood glucose measured to determine if you have diabetes without symptoms. Contact a public-health nurse or your own doctor for further guidance.</span>,
    DIABETES_VERY_HIGH_RISK_INFO: <span>That means that within ten years, the risk for you to develop diabetes is estimated as 1 in 2.<br/>You should have your blood glucose measured to determine if you have diabetes without symptoms. Contact a public-health nurse or your own doctor for further guidance.</span>,

    RESULTS_ABOUT_TEST: 'This screening and this risk assessment is based on the FINDRISK screening test designed by Professor Jaakko Tuomilehto at the department of Public Health, University of Helsinki and Jaana Lindström, MFS, National Public Health Institute. The screening might not be validated in your specific country. If you would like to know more, ask your doctor.',
    RESULTS_MORE_ABOUT: 'More about diabetes and its symptoms',
    RESULTS_EXTRA_CONTENT: 'Diabetes arises when the body cannot produce enough insulin (type 1 diabetes) or when the body produces insulin but cannot use it properly (type 2 diabetes). Insulin is a hormone produced by the pancreas that helps the body to process the sugars in food. When the body cannot use or produce insulin, the blood sugars build up to levels, which can arouse serious health issues. It mainly affects people in developed countries. While its causes are partly genetic, lifestyle factors – such as smoking, obesity, poor nutrition and lack of exercise – also play a major role.',
    YOUR_RISK_IS: 'Your risk is',
    THANKS_FOR_TEST: 'Thank you for doing the test! Please beware that I\'m not a medical doctor and these results are only indicators.',

    DIABETES_RISK_LABELS: {
        'low': 'low',
        'slightly_elevated': 'slightly elevated',
        'moderate': 'moderate',
        'high': 'high',
        'very_high': 'very high',
    },
}
