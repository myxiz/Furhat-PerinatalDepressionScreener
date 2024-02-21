import * as React from "react"

export default {
    // Knappar
    CONTINUE: `Fortsätt`,
    CLOSE: `Stäng`,
    RESTART: `Starta om`,
    HOME: `Hem`,
    HIDE_TEXT: `Dölj text`,
    SHOW_TEXT: `Visa text`,
    ABOUT_ME: `Om mig`,
    RESULTS: `Resultat`,

    // Texter för huvudmenyn
    ABOUT_PETRA: `Jag är en robot för screening av perinatal depression. Jag har designats av det sociala robotlaboratoriet vid Uppsala universitet. Jag är fortfarande en första generationens prototyp, och jag välkomnar alla förslag till förbättringar. Vänligen säg "Fortsätt" för att återgå till menyn.`,

// Results page
    EPDS_LOW_RISK_INFO: <span>Det betyder att du sannolikt inte lider av perinatal depression.</span>,
    EPDS_DEPRESSION_POSSIBLE_INFO: <span>Det betyder att det är möjligt att du lider av perinatal depression.</span>,
    EPDS_MODERATE_RISK_INFO: <span>Det innebär att risken för att du för närvarande har en perinatal depression är ganska hög. <br />En specialist kommer att följa upp ditt resultat och återkomma till dig senare.</span>,
    EPDS_HIGH_RISK_INFO: <span>Det innebär att du har en hög risk för att för närvarande ha en perinatal depression.<br />Du kan behöva en ytterligare diagnos. En specialist kommer att följa upp ditt resultat och återkomma till dig senare.</span>,
    EPDS_VERY_HIGH_RISK_INFO: <span>Det innebär att du har en mycket hög risk för att för närvarande ha en perinatal depression.<br />Vår sjuksköterska kommer att prata med dig om en stund. Vi kommer också att ha en specialist som följer upp ditt resultat och återkommer till dig senare.</span>,

    RESULTS_ABOUT_TEST: 'Denna screening och denna riskbedömning baseras på EPDS-screeningtestet designat av professor John Cox vid institutionen för psykiatri vid Edinburghs universitet. Det har använts flitigt i Sverige för screening av perinatal depression.',
    RESULTS_MORE_ABOUT: 'Mer om perinatal depression och dess symtom',
    RESULTS_EXTRA_CONTENT: 'Perinatal depression uppstår när hormonella förändringar, fysiska förändringar och den psykologiska anpassningen till moderskapet överväldigar en kvinnas förmåga att hantera. Dessa hormonella fluktuationer kan påverka en kvinnas humör och känslor avsevärt, vilket leder till känslor av sorgsenhet, ångest, hopplöshet och i svåra fall, tankar på att skada sig själv eller barnet.',
    YOUR_RISK_IS: 'Din risk är',
    THANKS_FOR_TEST: 'Tack för att du gjorde testet! Observera att jag inte är en läkare och dessa resultat är endast indikatorer.',


    EPDS_RISK_LABELS: {
        'low': 'låg',
        'depression_possible': 'depression möjlig',
        'fairly_high': 'ganska hög',
        'high': 'hög',
        'very_high': 'mycket hög',
    },
}
