package furhatos.app.medicalscreener.i18n

import furhatos.app.medicalscreener.currentLang
import furhatos.app.medicalscreener.toConjugatedList

class I18nPhrases {
    val DIABETES_NAME = mapOf(
        en to "Diabetes",
        sv to "$SV_sayDiabetes ",
        zh to "糖尿病"
    )[currentLang]!!

// All the other translations are listed below:

    val GENERAL_MALE = mapOf(
        en to "Male",
        sv to "Man",
        zh to "男性"
    )[currentLang]!!


    val GENERAL_FEMALE = mapOf(
        en to "Female",
        sv to "Kvinna",
        zh to "女性"
    )[currentLang]!!

    val GENERAL_YES = mapOf(
        en to "Yes",
        sv to "Ja",
        zh to "是的"
    )[currentLang]!!

    val GENERAL_NO = mapOf(
        en to "No",
        sv to "Nej",
        zh to "没有"
    )[currentLang]!!

    val GENERAL_SELECT = mapOf(
        en to "Select",
        sv to "Välj",
        zh to "选择"
    )[currentLang]!!

    val GENERAL_ONCE = mapOf(
        en to "once",
        sv to "en gång",
        zh to "一次"
    )[currentLang]!!

    val GENERAL_SEVERAL_TIMES = mapOf(
        en to "several times",
        sv to "flera gånger",
        zh to "几次"
    )[currentLang]!!

    val GENERAL_ASK_IF_DONE = mapOf(
        en to "Are you done yet?",
        sv to "Är du klar?",
        zh to "您完成了吗？"
    )[currentLang]!!

    val GENERAL_OK_WAITING = mapOf(
        en to "Ok, i'll wait.",
        sv to "Okej, jag väntar.",
        zh to "好的, 我会等待."
    )[currentLang]!!


    val GENERAL_ESTIMATE = mapOf(
        en to "Just give me your best estimate.",
        sv to "Ge mig bara din bästa uppskattning.",
        zh to "请给我您最好的估计."
    )[currentLang]!!

    val GENERAL_OK_NO_PROBLEM = mapOf(
        en to "Alright. No problem.",
        sv to "Okej. Inga problem.",
        zh to "好的.没有问题."
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_REPLY_VAR1 = mapOf(
        en to "I couldn't hear your response.",
        sv to "Jag kunde inte höra ditt svar.",
        zh to "我听不到您的回应."
    )[currentLang]!!


    val GENERAL_NO_RESPONSE_REPLY_VAR2 = mapOf(
        en to "Could you please speak louder?",
        sv to "Kan du prata lite högre?",
        zh to "您的声音可以再大一些吗？"
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_REPLY_VAR3 = mapOf(
        en to "Sorry, I couldn't hear you...",
        sv to "Ursäkta, jag kunde inte höra dig...",
        zh to "抱歉，我没办法听到您..."
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_REPLY_REPEAT_QUESTION_VAR1 = mapOf(
        en to "I Still can't hear your answer, I'll repeat:",
        sv to "Jag kan fortfarande inte höra ditt svar, jag ska upprepa:",
        zh to "我仍然听不到您的回答, 我将重复："
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_REPLY_REPEAT_QUESTION_VAR2 = mapOf(
        en to "I couldn't hear that, I'll repeat the question...",
        sv to "Jag kunde inte höra det, jag ska upprepa frågan...",
        zh to "我听不到, 我将重复这个问题..."
    )[currentLang]!!


    val GENERAL_NO_RESPONSE_REPLY_REPEAT_QUESTION_VAR3 = mapOf(
        en to "Could you please speak louder?",
        sv to "Kan du prata lite högre?",
        zh to "您能说大声一点吗？"
    )[currentLang]!!

    val GENERAL_REPEATING_QUESTION_VAR1 = mapOf(
        en to "I'll repeat the question,",
        sv to "Jag ska upprepa frågan,",
        zh to "我将重复这个问题："
    )[currentLang]!!

    val GENERAL_REPEATING_QUESTION_VAR2 = mapOf(
        en to " ",
        sv to " ",
        zh to " "
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_USE_SCREEN_VAR1 = mapOf(
        en to "I still can't hear you. You can use the screen to input your answer",
        sv to "Jag kan fortfarande inte höra dig. Du kan använda skärmen för att svara.",
        zh to "我还是听不到您的声音.您可以在屏幕上输入您的回答"
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_USE_SCREEN_VAR2 = mapOf(
        en to "I can't hear you clearly, try using the touch screen to answer me",
        sv to "Jag kan inte höra dig tydligt, försök använda pekskärmen för att svara mig",
        zh to "我听不清楚, 请尝试使用触摸屏回答我"
    )[currentLang]!!

    val GENERAL_ASK_USER_IS_STILL_THERE = mapOf(
        en to "Are you still here?",
        sv to "Är du fortfarande här?",
        zh to "您还在这儿吗？"
    )[currentLang]!!

    val GENERAL_USER_NOT_RESPONDING_PROBABLY_GONE_REPLY = mapOf(
        en to "OK, then...",
        sv to "Okej, då...",
        zh to "好的，那么..."
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_REPLY_VAR1 = mapOf(
        en to "I did not understand, could you please repeat that?",
        sv to "Jag förstod inte, kan du upprepa det?",
        zh to "我不明白, 您能再说一遍吗？"
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_REPLY_VAR2 = mapOf(
        en to { text: String -> "I'm not sure I understand what \"$text\" means..." },
        sv to { text: String -> "Jag är inte säker på vad \"$text\" betyder..." },
        zh to { text: String -> "我不确定我理解\"$text\" 是什么意思..." }
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_REPLY_VAR3 = mapOf(
        en to "What did you say?",
        sv to "Vad sa du?",
        zh to "您说什么？"
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_REPLY_VAR4 = mapOf(
        en to "Sorry, I didn't get it. Could you please say that again?",
        sv to "Ursäkta, jag förstod inte. Kan du säga det igen?",
        zh to "抱歉, 我没收到.您能再说一遍吗？"
    )[currentLang]!!


    val GENERAL_CANNOT_UNDERSTAND_ASK_TO_REPEAT_QUESTION = mapOf(
        en to "I still can't understand you. If you want to hear the question again, just say \"repeat\"",
        sv to "Jag förstår fortfarande inte. Om du vill höra frågan igen, säg bara \"upprepa\"",
        zh to "我仍然听不懂您的回答, 如果您想再听一次, 请说\"重复\""
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_ASK_TO_REPHRASE_ANSWER = mapOf(
        en to "I still can't understand you. Can you please say it in another way?",
        sv to "Jag förstår fortfarande inte. Kan du säga det på ett annat sätt?",
        zh to "我还是听不懂您.你能用另一种方式说吗？"
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_PLEASE_USE_SCREEN = mapOf(
        en to "I still can not understand your reply. Please use the touchscreen to answer.",
        sv to "Jag kan fortfarande inte förstå ditt svar. Använd pekskärmen för att svara.",
        zh to "我仍然不明白您的答复.请使用触摸屏回答."
    )[currentLang]!!

    val GENERAL_REMIND_TO_MOVE_ON = mapOf(
        en to "Just let me know when you're finished and want to move on by saying \"continue\"",
        sv to "Berätta bara när du är klar och vill fortsätta genom att säga \"fortsätt\"",
        zh to "请您结束后让我知道然后继续只需要说\"继续\""
    )[currentLang]!!

    val GENERAL_MOVE_ON_REPLY = mapOf(
        en to "Moving on",
        sv to "Fortsätter",
        zh to "继续"
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_OK = mapOf(
        en to "OK,",
        sv to "Okej,",
        zh to "好的, "
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_THANK_YOU = mapOf(
        en to "OK, Thank you.",
        sv to "Okej, Tack.",
        zh to "好的.谢谢您."
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_GOT_IT = mapOf(
        en to "Got it,",
        sv to "Förstår,",
        zh to "明白, "
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_ALRIGHT = mapOf(
        en to "Alright,",
        sv to "Bra,",
        zh to "好的, "
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_I_SEE = mapOf(
        en to "I see...",
        sv to "Jag ser...",
        zh to "我知道了..."
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_UNDERSTOOD = mapOf(
        en to "Understood,",
        sv to "Förstått,",
        zh to "理解, "
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_AHA = mapOf(
        en to "Uh-huh,",
        sv to "Mm-hmm,",
        zh to "嗯, "
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_I_UNDERSTAND = mapOf(
        en to "I understand,",
        sv to "Jag förstår,",
        zh to "我理解了, "
    )[currentLang]!!

    val GENERAL_NEXT_QUESTION_VAR1 = mapOf(
        en to "next...",
        sv to "nästa...",
        zh to "接下来..."
    )[currentLang]!!

    val GENERAL_NEXT_QUESTION_VAR2 = mapOf(
        en to "next question",
        sv to "nästa fråga",
        zh to "下一个问题"
    )[currentLang]!!

    val GENERAL_NEXT_QUESTION_VAR3 = mapOf(
        en to "going on",
        sv to "fortsätter",
        zh to "让我们继续"
    )[currentLang]!!

    val GENERAL_NEXT_QUESTION_VAR4 = mapOf(
        en to " ",
        sv to " ",
        zh to " "
    )[currentLang]!!

    val GENERAL_POSITIVE_ACKNOWLEDGE_GOOD = mapOf(
        en to "Good,",
        sv to "Bra,",
        zh to "好, "
    )[currentLang]!!

    val GENERAL_POSITIVE_ACKNOWLEDGE_1 = mapOf(
        en to "Of course",
        sv to "Absolut",
        zh to "当然",
    )[currentLang]!!

    val GENERAL_POSITIVE_ACKNOWLEDGE_2 = mapOf(
        en to "Sure",
        sv to "Säkert,",
        zh to "好的",
    )[currentLang]!!

    val GENERAL_CONFIRM_ABORT = mapOf(
        en to "Do you want to stop this and do something else?",
        sv to "Vill du avbryta detta och göra något annat?",
        zh to "您是否要停止此操作并做其他事情？"
    )[currentLang]!!

    val GENERAL_CONFIRM_GO_TO_HOME = mapOf(
        en to "Do you want to start the screening again?",
        sv to "Vill du börja screeningen igen?",
        zh to "您是否想要重新开始测试？"
    )[currentLang]!!

    val GENERAL_OPTIONS_LIST = mapOf(
        en to { options: Iterable<String> -> "You can answer me with ${options.toConjugatedList(separator = ", ", conjugate = " or ")}. You can also say 'repeat', to ask me to repeat the question; 'stop' to go back; or 'goodbye' to let me know you're leaving." },
        sv to { options: Iterable<String> -> "Du kan svara mig med ${options.toConjugatedList(separator = ", ", conjugate = " eller ")}. Du kan också säga 'repeat', för att be mig upprepa frågan; 'stop' för att gå tillbaka; eller 'goodbye' för att låta mig veta att du lämnar." },
        zh to { options: Iterable<String> -> "您可以回答我 ${options.toConjugatedList(separator = ", ", conjugate = " 或者 ")}.您同样可以说'重复', 让我重复这个问题; '终止' 来返回; 或者'再见' 来让我知道您离开了." }
    )[currentLang]!!

//    val GENERAL_OPTIONS_LIST = mapOf(
//        en to { options: Iterable<String> -> "You can answer me with ${options.toConjugatedList(separator = ", ", conjugate = " or ")}. You can also say 'repeat', to ask me to repeat the question; 'stop' to go back; or 'goodbye' to let me know you're leaving." },
//        sv to { options: Iterable<String> -> "Sie können mir wie folgt antworten: ${options.toConjugatedList(separator = ", ", conjugate = " oder ")} . Sie können auch 'wiederholen' sagen, um mich zu bitten die Frage zu wiederholen; 'stop' um zurück zu gehen; oder 'Auf Widersehen' um mich wissen zu lassen dass sie gehen." },
//        zh to { options: Iterable<String> -> "您可以回答我 ${options.toConjugatedList(separator = ", ", conjugate = " 或者 ")}.您同样可以说'重复', 让我重复这个问题; '终止' 来返回; 或者'再见' 来让我知道您离开了." }
//    )[currentLang]!!

    val GENERAL_ABOUT_FURHAT = mapOf(
        en to "Welcome, I'm a health screening Robot designed by Uppsala Social Robotics Lab to help you with interviews about your mental health.",
        sv to "Jag är en robot som är designad av Uppsala Social Robotics Lab för att hjälpa till med intervjuer som bedömer mental hälsa. " +
                "Vi ser att du har fått högt resultat på EPDS-screeningen. Det skulle vara fördelaktigt att kontrollera hur din mentala välbefinnande är.",
        zh to "我是 Linda， 我是一个健康筛查机器人。我由乌普萨拉社交机器人实验室开发"
    )[currentLang]!!

    val GENERAL_USER_NOT_FAMILIAR_WITH_TERM = mapOf(
        en to "It’s ok if you don’t understand all of these medical terms, we’ll just move on to the next question.",
        sv to "Det är okej om du inte förstår alla dessa medicinska termer, vi går bara vidare till nästa fråga.",
        zh to "如果您不了解所有这些医学术语也没关系, 我们将继续进行下一个问题."
    )[currentLang]!!

    val GENERAL_USER_NOT_FAMILIAR_WITH_TERM_2 = mapOf(
        en to "If you're not sure about some word or symptom, that's fine, let's just go on.",
        sv to "Om du är osäker på något ord eller symptom, är det okej, låt oss bara fortsätta.",
        zh to "如果您不确定某些字词或症状, 没关系, 让我们继续."
    )[currentLang]!!

    val GENERAL_LET_USER_KNOW_WHEN_TO_ANSWER = mapOf(
        en to "Sorry, I didn't hear you. Have you noticed that my lights turn up when I'm listening.",
        sv to "Ursäkta, jag hörde dig inte. Har du märkt att mina ljus tänds när jag lyssnar?",
        zh to "抱歉, 我没有听到你的声音.您是否注意到我在聆听时灯亮了."
    )[currentLang]!!

    val GENERAL_ANSWER_NOT_ACCEPTED_REPEAT = mapOf(
        en to "I'm sorry, I don't think I understood you quite right. Can you repeat that?",
        sv to "Ursäkta, jag tror inte att jag förstod dig helt rätt. Kan du upprepa det?",
        zh to "抱歉, 我想我没能完全理解您. 您能重复一遍吗?"
    )[currentLang]!!

    val GENERAL_CONTINUE_ANYWAY = mapOf(
        en to "Would you like to continue anyway?",
        sv to "Vill du fortsätta ändå?",
        zh to "您想要继续吗?"
    )[currentLang]!!

    val GENERAL_RESTART = mapOf(
        en to "Restart",
        sv to "Starta om",
        zh to "重启"
    )[currentLang]!!

    val GENERAL_CONTINUE = mapOf(
        en to "Continue",
        sv to "Fortsätt",
        zh to "继续"
    )[currentLang]!!

    val GENERAL_RESELECT = mapOf(
        en to "Re-select",
        sv to "Välj igen",
        zh to "重新选择"
    )[currentLang]!!



    // Change Language

    val CHANGE_LANGUAGE_SUPPORT = mapOf(
        en to "No problem!",
        sv to "Inga problem!",
        zh to "当然！" // Corrected to match "No problem!"
    )[currentLang]!!

    val CHANGE_LANGUAGE_NO_SUPPORT = mapOf(
        en to "I'm sorry, I don't support that language.",
        sv to "Tyvärr, jag stödjer inte det språket.",
        zh to "对不起, 我不支持该语言."
    )[currentLang]!!

    val CHANGE_LANGUAGE_SOUNDS_BETTER = mapOf(
        en to "I hope this sounds better!",
        sv to "Jag hoppas detta låter bättre!",
        zh to "我希望我听起来还不错！"
    )[currentLang]!!



    // Introduction
    val INTRODUCTION_GREETING = mapOf(
        en to "Welcome! Nice to meet you.",
        sv to "Hej. Trevligt att träffa dig.",
        zh to "欢迎！"
    )[currentLang]!!

    val INTRODUCTION_ROBOTINTRO = mapOf(
        //en does not need to match the swedish
        en to "I am a robot designed to assist you with interviews for assessing mental health. We notice that you have scored high on the EPDS screening. It would be beneficial to check on your mental well-being.",
        sv to "Jag är en robot designad för att hjälpa dig med intervjuer för bedömning av mental hälsa. " +
                "Vi ser att du har fått högt resultat på EPDS-screeningen. Det skulle vara fördelaktigt att kontrollera hur din mentala välbefinnande är.",
        zh to "我是一个为了帮助您进行心理健康评估访谈而设计的机器人。我们注意到您在EPDS筛查中得分较高。检查一下您的心理健康状况将会是有益的。"
    )[currentLang]!!



    val INTRODUCTION_THANSFORTURST = mapOf(
        en to "Thanks for trusting me!",
        sv to "Bra, tack för att du litar på mig.",
        zh to "谢谢您的信任。"
    )[currentLang]!!

    val INTRODUCTION_ALL_DONE = mapOf(
        en to "You have completed the screening. Would you like to repeat it?",
        sv to "Sie haben die Voruntersuchung abgeschlossen. Möchten Sie sie noch einmal durchführen?",
        zh to "您已经完成了检查.您想要再重复一遍吗？"
    )[currentLang]!!

    val INTRODUCTION_PND_PROMPT = mapOf(
        en to "Would you like to know more about perinatal depression, before we start the screening?",
        sv to "Vill du veta mer om perinatal depression innan vi börjar screeningen?",
        zh to "在开始检查之前, 您想了解有关围产期抑郁症的更多信息吗？"
    )[currentLang]!!

    val INTRODUCTION_REPEAT_OPTIONS_VAR1  = mapOf(
        en to "First, can I tell you a bit about why this is important?",
        sv to "Först, kan jag berätta lite om varför detta är viktigt?",
        zh to "首先，我可以告诉您为什么这很重要吗？"
    )[currentLang]!!

    val INTRODUCTION_REPEAT_OPTIONS_VAR2 = mapOf(
        en to "Would you like me to tell you more about perinatal depression?",
        sv to "Vill du berättar mer om perinatal depression?",
        zh to "你想我告诉你更多有关围产期抑郁症的信息吗？"
    )[currentLang]!!

    val INTRODUCTION_INVALID_RESPONSE_VAR1 = mapOf(
        en to "I'm sorry, I can't help you with that.",
        sv to "Es tut mir sehr Leid, aber damit kann ich Ihnen nicht helfen.",
        zh to "很抱歉, 我不能帮您."
    )[currentLang]!!

    val INTRODUCTION_INVALID_RESPONSE_VAR2 = mapOf(
        en to "I am not familiar with that.",
        sv to "Jag är inte bekant med det.",
        zh to "我不是很熟悉这个."
    )[currentLang]!!

    val INTRODUCTION_INVALID_RESPONSE_VAR3 = mapOf(
        en to "That's beyond my capabilities",
        sv to "Det överstiger mina förmågor.",
        zh to "这超出了我的能力."
    )[currentLang]!!

    val INTRODUCTION_SAY_GOODBYE = mapOf(
        en to "Thank you for participating! Goodbye!",
        sv to "Tack så mycket för ditt deltagande! Hejdå!",
        zh to "感谢您的参与！再见！"
    )[currentLang]!!


    val INTRODUCTION_SAY_GOODBYE_PROMPT = INTRODUCTION_SAY_GOODBYE

    val INTRODUCTION_GOODBYE_TITLE_PROMPT = mapOf(
        en to "Goodbye!",
        sv to "Hejdå!",
        zh to "再见！"
    )[currentLang]!!

    val INTRODUCTION_PND_DESCRIPTION = mapOf(
        en to "Perinatal depression is a form of clinical depression that can occur in women during pregnancy and after childbirth. It involves intense feelings of sadness, anxiety, and fatigue that can interfere with a woman's ability to care for herself and her baby, extending beyond the typical \"baby blues.\"",
        sv to "Perinatal depression är en form av klinisk depression som kan drabba kvinnor under graviditeten och efter förlossningen. Den innefattar intensiva känslor av sorg, ångest och trötthet som kan störa en kvinnas förmåga att ta hand om sig själv och sitt barn, vilket går utöver de typiska \"babybluesen\".",
        zh to "围产期抑郁症是一种可以在怀孕期间和分娩后影响女性的临床抑郁症。它涉及到强烈的悲伤、焦虑和疲劳感，这些感觉可能会干扰女性照顾自己和婴儿的能力，超出了典型的“产后忧郁”范畴。"
    )[currentLang]!!


    val INTRODUCTION_EPDS_NO_DESCRIPTION = mapOf(
        en to "Ok. Then we will skip directly to the questions.",
        sv to "Okej. Då hoppar vi direkt till frågorna.",
        zh to "好的。然后我们将直接跳转到问题。"
    )[currentLang]!!

    val INTRODUCTION_EPDS_DESCRIPTION = mapOf(
        en to "This screening and this risk assessment is based on the Edinburgh Postnatal Depression Scale (EPDS) screening test designed by Professor John Cox. Since 2010, the National Board of Health and Welfare has recommended general screening of all new mothers for depression.",
        sv to "Denna screening och riskbedömning är baserad på Edinburghs skala för efterfödseldepression (EPDS), ett screeningtest som utformats av professor John Cox. Sedan 2010 har Socialstyrelsen rekommenderat generell screening av alla nyblivna mammor för depression.",
        zh to "该筛查和风险评估是基于由约翰·考克斯教授设计的爱丁堡产后抑郁量表（EPDS）筛查测试。自2010年起，瑞典国家卫生和福利委员会推荐对所有新妈妈进行抑郁症的普遍筛查。"
    )[currentLang]!!

    val INTRODUCTION_DESCRIPTION_OPTION_YES = mapOf(
        en to "Yes, tell me more",
        sv to "Ja, berätta mer för mig",
        zh to "好的，告诉我更多"
    )[currentLang]!!

    val INTRODUCTION_DESCRIPTION_OPTION_NO = mapOf(
        en to "No, start screening",
        sv to "Nej, starta screeningen",
        zh to "不用，开始检查"
    )[currentLang]!!

    val INTRODUCTION_START_OVER = mapOf(
        en to "Would you like to do the screening again?",
        sv to "Vill du göra screeningen igen?",
        zh to "您想要再次进行检查吗？"
    )[currentLang]!!

    val INTRODUCTION_START_OVER_PROMPT = INTRODUCTION_START_OVER

    val INTRODUCTION_START_OVER_CONFIRMED = mapOf(
        en to "Alright, then let's start over.",
        sv to "Bra, låt oss börja om.",
        zh to "好的，那我们重新开始吧。"
    )[currentLang]!!



    // Question / Scenes

    // Scene - Personalization

    val PERSONALIZATION_GENDER_MATTERS = mapOf(
        en to "A few set up before we start. Would you prefer to interact with a robot with a particular gender?",
        sv to "Några inställningar innan vi börjar. Föredrar du att interagera med en robot av ett specifikt kön?",
        zh to "在我们开始之前先进行一些设置。您是否更喜欢与特定性别的机器人互动？"
    )[currentLang]!!

    val PERSONALIZATION_GENDER_MATTERS_PROMPT = mapOf(
        en to " Would you prefer to interact with a robot with a particular gender?",
        sv to " Föredrar du att interagera med en robot av ett specifikt kön?",
        zh to "您是否更喜欢与特定性别的机器人互动?"
    )[currentLang]!!

    val PERSONALIZATION_GENDER_PREFERENCE = mapOf(
        en to "Which gender do you prefer?",
        sv to "Vilket kön föredrar du?",
        zh to "您更希望与哪种性别交互？"
    )[currentLang]!!

    val PERSONALIZATION_VOICE_OPTION_MALE = mapOf(
        en to "male",
        sv to "manlig",
        zh to "男性"
    )[currentLang]!!

    val PERSONALIZATION_VOICE_OPTION_FEMALE = mapOf(
        en to "female",
        sv to "kvinnlig",
        zh to "女性"
    )[currentLang]!!

    val PERSONALIZATION_VOICE_OPTION_ORIGINAL = mapOf(
        en to "original voice",
        sv to "ursprungliga rösten",
        zh to "原始语音"
    )[currentLang]!!

    val PERSONALIZATION_MALE_VOICE = mapOf(
        en to "Sure. We now changed to male voice for you. You can still change to female, or the original voice.",
        sv to "Självklart. Vi har nu bytt till en manlig röst åt dig. " +
                "Du kan fortfarande byta till en kvinnlig eller till den ursprungliga rösten.",
        zh to "好的。已经帮您切换到男性化的语音。你仍然可以切换到女性语音或切回原始语音。"
    )[currentLang]!!

    val PERSONALIZATION_FEMALE_VOICE = mapOf(
        en to "Of course. We have now switched to a female voice for you. " +
                "You can still switch to a male voice or back to the original voice.",
        sv to "Absolut. Vi har nu bytt till en kvinnlig röst åt dig. " +
                "Du kan fortfarande byta till en manlig eller till den ursprungliga rösten.",
        zh to "没问题。已经帮您切换到女性化的语音。你仍然可以切换到男性语音或切回原始语音。"
    )[currentLang]!!


    val PERSONALIZATION_ORIGINAL_VOICE = mapOf(
        en to "Got it. We now change to the original voice for you. Do you want to move on? ",
        sv to "Förstått. Vi byter nu till den ursprungliga rösten åt dig. Vill du gå vidare?",
        zh to "明白了。我们现在为您切换到原始语音。您想进行下一步吗？"
    )[currentLang]!!

    val PERSONALIZATION_FACE_CHOOSE = mapOf(
        en to "There are 8 options. Touch to apply it on the robot.",
        sv to "Det finns 8 alternativ. Tryck för att tillämpa det på roboten.",
        zh to "请触摸选择的8个选项其中之一。"
    )[currentLang]!!

    val PERSONALIZATION_REMEMBER_CHOICE = mapOf(
        en to "Do you want me to remember your personalization setting for the next time you visit?",
        sv to "Vill du att jag ska komma ihåg dina anpassningsinställningar till nästa gång du besöker?",
        zh to "您希望在您下次访问时记住您的个性化设置吗？"
    )[currentLang]!!

    val PERSONALIZATION_CONFIRMATION = mapOf(
        en to "Hi, do you want me to conduct the interview with you?",
        sv to "Hej, vill du att jag ska genomföra intervjun med dig?",
        zh to "你好，你希望由我来进行这次访问吗？"
    )[currentLang]!!

    val PERSONALIZATION_RESELECT_PROMPT = mapOf(
        en to "Touch to apply on the robot",
        sv to "Tryck för att tillämpa det på roboten",
        zh to "请触摸以应用到机器人上。"
    )[currentLang]!!

    val PERSONALIZATION_REMEMBER_OPTION_YES = mapOf(
        en to "Yes, please remember",
        sv to "Ja, snälla kom ihåg.",
        zh to "是的，请记住"
    )[currentLang]!!

    val PERSONALIZATION_REMEMBER_OPTION_NO = mapOf(
        en to "No, please don't remember",
        sv to "Nej, kom inte ihåg.",
        zh to "不，请不要记住"
    )[currentLang]!!

    val PERSONALIZATION_REMEMBER_YES_RESPONSE = mapOf(
        en to "Ok, I'll remember it.",
        sv to "Okej, jag kommer ihåg det.",
        zh to "好的，我会为您记住的。"
    )[currentLang]!!



    // Scene - EPDS
//    val EPDS_GETTING_STARTED = mapOf(
//        en to "Let's get started.",
//        sv to "Låt oss börja.",
//        zh to "让我们开始吧."
//    )[currentLang]!!

    val INTRODUCTION_EPDS_CONSENT = mapOf(
        en to "I will help you to go through EPDS questionnaire again. Would you like to do it with me?",
        sv to "Jag hjälper dig att gå igenom EPDS-frågeformuläret igen. Vill du göra det tillsammans med mig?",
        zh to "我将协助您再次填写EPDS问卷。您想由我来进行检查吗？"
    )[currentLang]!!

    val EPDS_GETTING_STARTED  = mapOf(
        en to "Now I will ask you a few questions. It might take around 10 minutes."
            + "Please chose the response that best reflects how you have been feeling over the last 7 days, not just how you are feeling today.",
        sv to "Nu ska jag ställa några frågor. Det kan ta cirka 10 minuter."
            + "Var god välj det svar som bäst återspeglar hur du har känt dig under de senaste 7 dagarna, inte bara hur du mår idag.",
        zh to ""
    )[currentLang]!!

    val EPDS_ONE = mapOf(
        en to "I have been able to laugh and see the funny side of things",
        sv to "Jag har kunnat se tillvaron från den ljusa sidan:",
        zh to "我能够笑看事物的有趣之处"  // This is a commonly used translation for reference purposes. Please verify against the official EPDS documentation.
    )[currentLang]!!

    val EPDS_ONE_PROMPT = EPDS_ONE

    val EPDS_ONE_RESPONSES_0 = mapOf(
        en to "I have been able to laugh and see the funny side of things as much as I always could",
        sv to "Lika bra som vanligt",
        zh to "我能像往常一样笑和看到事情的有趣之处"
    )[currentLang]!!

    val EPDS_ONE_RESPONSES_1 = mapOf(
        en to "I have not been able to laugh and see the funny side of things as much as I used to",
        sv to "Nästan lika bra som vanligt",
        zh to "我无法像以前那样笑和看到事情的有趣之处"
    )[currentLang]!!

    val EPDS_ONE_RESPONSES_2 = mapOf(
        en to "I have felt sad or miserable",
        sv to "Mycket mindre än vanligt",
        zh to "我感到悲伤或痛苦"
    )[currentLang]!!

    val EPDS_ONE_RESPONSES_3 = mapOf(
        en to "I have been so unhappy that I have had difficulty sleeping",
        sv to "Inte alls",
        zh to "我一直很不开心，以至于难以入睡"
    )[currentLang]!!

    val EPDS_TWO = mapOf(
        en to "I have looked forward with enjoyment to things",
        sv to "Jag har glatt mig åt saker som skall hända:",
        zh to "我期待着以愉悦的心情去面对将要发生的事情"  // This is a commonly used translation for reference purposes. Please verify against the official EPDS documentation.
    )[currentLang]!!

    val EPDS_TWO_PROMPT = EPDS_TWO

    val EPDS_TWO_RESPONSES_0 = mapOf(
        en to "As much as I always could",
        sv to "Lika mycket som vanligt",
        zh to "像往常一样期待"
    )[currentLang]!!

    val EPDS_TWO_RESPONSES_1 = mapOf(
        en to "Rather less than I used to",
        sv to "Något mindre än vanligt",
        zh to "比以前稍微少一些"
    )[currentLang]!!

    val EPDS_TWO_RESPONSES_2 = mapOf(
        en to "Definitely less than I used to",
        sv to "Mycket mindre än vanligt",
        zh to "肯定比以前少"
    )[currentLang]!!

    val EPDS_TWO_RESPONSES_3 = mapOf(
        en to "Hardly at all",
        sv to "Inte alls",
        zh to "几乎没有"
    )[currentLang]!!

    val EPDS_THREE = mapOf(
        en to "I have blamed myself unnecessarily when things went wrong",
        sv to "Jag har lagt skulden på mig själv onödigt mycket när något har gått snett:",
        zh to "当事情进展不顺时，我会不必要地责怪自己"  // This is provided for reference purposes. Please verify against the official EPDS documentation.
    )[currentLang]!!


    val EPDS_THREE_PROMPT = EPDS_THREE

    val EPDS_THREE_RESPONSES_3 = mapOf(
        en to "Yes, most of the time",
        sv to "Ja, för det mesta",
        zh to "是的，大多数时间"
    )[currentLang]!!

    val EPDS_THREE_RESPONSES_2 = mapOf(
        en to "Yes, sometimes",
        sv to "Ja, ibland",
        zh to "是的，有时候"
    )[currentLang]!!

    val EPDS_THREE_RESPONSES_1 = mapOf(
        en to "No, not very often",
        sv to "Nej, inte så ofta",
        zh to "不，不太经常"
    )[currentLang]!!

    val EPDS_THREE_RESPONSES_0 = mapOf(
        en to "No, never",
        sv to "Nej, aldrig",
        zh to "不，从不"
    )[currentLang]!!


    val EPDS_FOUR = mapOf(
        en to "I have been anxious or worried for no good reason",
        sv to "Jag har känt mig rädd och orolig utan egentlig anledning:",
        zh to "我无缘无故地感到焦虑或担心"  // This is provided for reference purposes. Please verify against the official EPDS documentation.
    )[currentLang]!!

    val EPDS_FOUR_PROMPT = EPDS_FOUR

    val EPDS_FOUR_RESPONSES_0 = mapOf(
        en to "No, not at all",
        sv to "Nej, inte alls",
        zh to "不，完全没有"
    )[currentLang]!!

    val EPDS_FOUR_RESPONSES_1 = mapOf(
        en to "No, hardly ever",
        sv to "Nej, knappast alls",
        zh to "不，几乎没有"
    )[currentLang]!!

    val EPDS_FOUR_RESPONSES_2 = mapOf(
        en to "Yes, sometimes",
        sv to "Ja, ibland",
        zh to "是的，有时候"
    )[currentLang]!!

    val EPDS_FOUR_RESPONSES_3 = mapOf(
        en to "Yes, quite often",
        sv to "Ja, mycket ofta",
        zh to "是的，相当频繁"
    )[currentLang]!!



    val EPDS_FIVE = mapOf(
        en to "I have felt scared or panicky for no very good reason",
        sv to "Jag har känt mig skrämd eller panikslagen utan speciell anledning:",
        zh to "我无明显理由感到害怕或惊慌失措"  // Provided for reference purposes. Please verify against the official EPDS documentation.
    )[currentLang]!!


    val EPDS_FIVE_PROMPT = EPDS_FIVE

    val EPDS_FIVE_RESPONSES_0 = mapOf(
        en to "No, not at all",
        sv to "Nej, inte alls",
        zh to "不，完全没有"
    )[currentLang]!!

    val EPDS_FIVE_RESPONSES_1 = mapOf(
        en to "No, not often",
        sv to "Nej, ganska sällan",
        zh to "不，不经常"
    )[currentLang]!!

    val EPDS_FIVE_RESPONSES_2 = mapOf(
        en to "Yes, sometimes",
        sv to "Ja, ibland",
        zh to "是的，有时候"
    )[currentLang]!!

    val EPDS_FIVE_RESPONSES_3 = mapOf(
        en to "Yes, quite often",
        sv to "Ja, mycket ofta",
        zh to "是的，相当频繁"
    )[currentLang]!!


    val EPDS_SIX = mapOf(
        en to "Things have been getting on top of me",
        sv to "Det har kört ihop sig för mig och blivit för mycket:",
        zh to "事情变得我无法应对"  // Provided for reference purposes. Please verify against the official EPDS documentation.
    )[currentLang]!!


    val EPDS_SIX_PROMPT = EPDS_SIX

    val EPDS_SIX_RESPONSES_3 = mapOf(
        en to "Yes, most of the time I haven't been able to cope at all",
        sv to "Ja, mest hela tiden har jag inte kunnat ta itu med något alls",
        zh to "是的，大部分时间我完全无法应对"
    )[currentLang]!!

    val EPDS_SIX_RESPONSES_2 = mapOf(
        en to "Yes, sometimes I haven't been able to cope as well as usual",
        sv to "Ja, ibland har jag inte kunnat ta itu med saker lika bra som vanligt",
        zh to "是的，有时我无法像往常一样好地应对"
    )[currentLang]!!

    val EPDS_SIX_RESPONSES_1 = mapOf(
        en to "No, most of the time I have coped quite well",
        sv to "Nej, för det mesta har jag kunnat ta itu med saker ganska bra",
        zh to "不，大部分时间我都应对得相当好"
    )[currentLang]!!

    val EPDS_SIX_RESPONSES_0 = mapOf(
        en to "No, I have been coping as well as ever",
        sv to "Nej, jag har kunnat ta itu med saker precis som vanligt",
        zh to "不，我一如既往地应对得很好"
    )[currentLang]!!


    val EPDS_SEVEN = mapOf(
        en to "I have been so unhappy that I have had trouble sleeping",
        sv to "Jag har känt mig så ledsen och olycklig att jag har haft svårt att sova:",
        zh to "我一直不开心到难以入睡"  // For illustrative purposes, please verify against the official EPDS documentation.
    )[currentLang]!!


    val EPDS_SEVEN_PROMPT = EPDS_SEVEN

    val EPDS_SEVEN_RESPONSES_3 = mapOf(
        en to "Yes, most of the time",
        sv to "Ja, för det mesta",
        zh to "是的，大多数时间"
    )[currentLang]!!

    val EPDS_SEVEN_RESPONSES_2 = mapOf(
        en to "Yes, sometimes",
        sv to "Ja, ibland",
        zh to "是的，有时候"
    )[currentLang]!!

    val EPDS_SEVEN_RESPONSES_1 = mapOf(
        en to "No, not often",
        sv to "Nej, sällan",
        zh to "不，不经常"
    )[currentLang]!!

    val EPDS_SEVEN_RESPONSES_0 = mapOf(
        en to "No, never",
        sv to "Nej, aldrig",
        zh to "不，从不"
    )[currentLang]!!


    val EPDS_EIGHT = mapOf(
        en to "I have felt sad or miserable",
        sv to "Jag har känt mig ledsen och nere:",
        zh to "我感到悲伤或痛苦"  // For illustrative purposes, please verify against the official EPDS documentation.
    )[currentLang]!!


    val EPDS_EIGHT_PROMPT = EPDS_EIGHT

    val EPDS_EIGHT_RESPONSES_0 = mapOf(
        en to "No, never",
        sv to "Nej, aldrig",
        zh to "不，从不"
    )[currentLang]!!

    val EPDS_EIGHT_RESPONSES_1 = mapOf(
        en to "No, not often",
        sv to "Nej, sällan",
        zh to "不，不经常"
    )[currentLang]!!

    val EPDS_EIGHT_RESPONSES_2 = mapOf(
        en to "Yes, quite often",
        sv to "Ja, rätt ofta",
        zh to "是的，相当频繁"
    )[currentLang]!!

    val EPDS_EIGHT_RESPONSES_3 = mapOf(
        en to "Yes, most of the time",
        sv to "Ja, för det mesta",
        zh to "是的，大多数时间"
    )[currentLang]!!

    val EPDS_NINE = mapOf(
        en to "I have been so unhappy that I have been crying",
        sv to "Jag har känt mig så olycklig att jag har gråtit:",
        zh to "我不开心到哭泣"  // For illustrative purposes, please verify against the official EPDS documentation.
    )[currentLang]!!


    val EPDS_NINE_PROMPT = EPDS_NINE
    val EPDS_NINE_RESPONSES_0 = mapOf(
        en to "No, never",
        sv to "Nej, aldrig",
        zh to "不，从不"
    )[currentLang]!!

    val EPDS_NINE_RESPONSES_1 = mapOf(
        en to "Only occasionally",
        sv to "Bara någon gång",
        zh to "只是偶尔"
    )[currentLang]!!

    val EPDS_NINE_RESPONSES_2 = mapOf(
        en to "Yes, quite often",
        sv to "Ja, ganska ofta",
        zh to "是的，相当频繁"
    )[currentLang]!!

    val EPDS_NINE_RESPONSES_3 = mapOf(
        en to "Yes, most of the time",
        sv to "Ja, nästan jämt",
        zh to "是的，大部分时间"
    )[currentLang]!!

    val EPDS_TEN = mapOf(
        en to "The thought of harming myself has occurred to me",
        sv to "Tankar på att göra mig själv illa har förekommit:",
        zh to "我曾想过伤害自己"  // For illustrative purposes, please verify against the official EPDS documentation.
    )[currentLang]!!

    val EPDS_TEN_PROMPT = EPDS_TEN

    val EPDS_TEN_RESPONSES_0 = mapOf(
        en to "Never",
        sv to "Aldrig",
        zh to "从不"
    )[currentLang]!!

    val EPDS_TEN_RESPONSES_1 = mapOf(
        en to "Hardly ever",
        sv to "Nästan aldrig",
        zh to "几乎从不"
    )[currentLang]!!

    val EPDS_TEN_RESPONSES_2 = mapOf(
        en to "Sometimes",
        sv to "Ibland",
        zh to "有时"
    )[currentLang]!!

    val EPDS_TEN_RESPONSES_3 = mapOf(
        en to "Yes, quite often",
        sv to "Ja, rätt så ofta",
        zh to "是的，相当频繁"
    )[currentLang]!!



    val DIABETES_STARTING_SCREEN_TITLE = mapOf(
        en to "Diabetes Screening",
        sv to "Diabetes screening",
        zh to "糖尿病检查."
    )[currentLang]!!

    val DIABETES_DISCLAIMER = mapOf(
        en to "In this screening I will ask you questions about your health and score you on the risk of developing type-2 diabetes. All your answers will be deleted right after the screening is finished. And remember - I'm not a doctor so the results will only be an indicator. Do you understand?",
        sv to "I den här undersökningen kommer jag att ställa frågor om din hälsa och bedöma din risk att utveckla typ-2 diabetes. Alla dina svar kommer att raderas direkt efter att undersökningen är avslutad. Och kom ihåg - jag är inte en läkare så resultaten kommer bara vara en indikator. Förstår du?",
        zh to "在此次检查中我将会问与您健康有关的问题,并且对患2型糖尿病的风险进行评分.检查完成后您的所有答案都将被删除.请记住-我不是医生所以结果仅仅是一个参考.您理解了吗？"
    )[currentLang]!!

    val DIABETES_DISCLAIMER_PROMPT = mapOf(
        en to DIABETES_DISCLAIMER,
        sv to DIABETES_DISCLAIMER,
        zh to DIABETES_DISCLAIMER
    )[currentLang]!!

    val DIABETES_DISCLAIMER_REFUSED = mapOf(
        en to "Oh, ok... Then I can unfortunately not continue with the screening. Please talk to one of my human colleagues, they can answer any questions you might have. Then you could come back. It was nice to meet you, good bye.",
        sv to "Åh, okej... Då kan jag tyvärr inte fortsätta med undersökningen. Prata gärna med någon av mina mänskliga kollegor, de kan svara på alla frågor du kan ha. Sedan kan du komma tillbaka. Trevligt att träffa dig, hejdå.",
        zh to "哦,好的…那我就不能再继续检查了.请与一位人类同事谈谈,他们可以回答您可能遇到的任何问题.然后您可以再回来.很高兴见到您,再见."
    )[currentLang]!!

    val DIABETES_DISCLAIMER_REFUSED_PROMPT = DIABETES_DISCLAIMER_REFUSED

    val DIABETES_DISCLAIMER_I_UNDERSTAND = mapOf(
        en to "I understand",
        sv to "Jag förstår",
        zh to "我理解"
    )[currentLang]!!

    val DIABETES_DISCLAIMER_HELP_OPTION_1 = mapOf(
        en to "Yes if you understand and agree",
        sv to "Ja om du förstår och samtycker",
        zh to "是的, 如果您理解并同意"
    )[currentLang]!!

    val DIABETES_DISCLAIMER_HELP_OPTION_2 = mapOf(
        en to "No otherwise",
        sv to "Nej annars",
        zh to "其他的没有"
    )[currentLang]!!

//to add questions

    val DIABETES_ALREADY_DIAGNOSED_QUESTION_1 = mapOf(
        en to "Have you already been diagnosed with diabetes?",
        sv to "Wurde bei Ihnen bereits $SV_sayDiabetes diagnostiziert?",
        zh to "您已经被诊断出患有糖尿病了吗？"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_QUESTION_1_PROMPT = mapOf(
        en to DIABETES_ALREADY_DIAGNOSED_QUESTION_1,
        sv to "Wurde bei Ihnen bereits diabetes diagnostiziert?",
        zh to DIABETES_ALREADY_DIAGNOSED_QUESTION_1
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_QUESTION_2 = mapOf(
        en to "Ok. Then this will not be a reliable screening. Do you want to continue anyway?",
        sv to "Okay. Dann ist dies keine zuverlässige Untersuchung. Möchten Sie trotzdem fortfahren?",
        zh to "好的.那么这将不是可靠的检查.您是否仍要继续呢？"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_QUESTION_2_PROMPT = DIABETES_ALREADY_DIAGNOSED_QUESTION_2

    val DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_1 = mapOf(
        en to "I have",
        sv to "ich habe",
        zh to "我要"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_2 = mapOf(
        en to "I was",
        sv to "wurde es",
        zh to "我是"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_3 = mapOf(
        en to "I do",
        sv to "wurde ich",
        zh to "我做"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_4 = mapOf(
        en to "I want to",
        sv to "ich war",
        zh to "我想要"
    )[currentLang]!!

    val SEX_QUESTION = mapOf(
        en to "Are you male or female?",
        sv to "Sind Sie männlich oder weiblich?",
        zh to "您是男性还是女性?"
    )[currentLang]!!

    val SEX_QUESTION_PROMPT = SEX_QUESTION

    val SEX_QUESTION_MALE = mapOf(
        en to "Male",
        sv to "Männlich",
        zh to "男性"
    )[currentLang]!!

    val SEX_QUESTION_FEMALE = mapOf(
        en to "Female",
        sv to "Weiblich",
        zh to "女性"
    )[currentLang]!!

    val EPDS_1 = mapOf(
        en to "For medical purposes, please specify your biological sex.",
        sv to "Jag har kunnat se tillvaron från den ljusa sidan",
        zh to "出于医疗目的, 请表明您的生理性别."
    )[currentLang]!!


    val DIABETES_SEX_QUESTION_BIOLOGICAL_SEX = mapOf(
        en to "For medical purposes, please specify your biological sex.",
        sv to "Für medizinische Zwecke, spezifizieren sie bitte ihr biologisches Geschlechtt.",
        zh to "出于医疗目的, 请表明您的生理性别."
    )[currentLang]!!

    val DIABETES_PREGNANT_QUESTION_1 = mapOf(
        en to "Are you currently pregnant?",
        sv to "Sind Sie schwanger?",
        zh to "您现在怀孕了吗?"
    )[currentLang]!!

    val DIABETES_PREGNANT_QUESTION_1_PROMPT = DIABETES_PREGNANT_QUESTION_1

    val DIABETES_PREGNANT_QUESTION_2 = mapOf(
        en to "Ok. Then this will not be a reliable screening. Do you want to continue anyway?",
        sv to "Okay. Dann ist dies keine zuverlässige Untersuchung. Möchten Sie trotzdem fortfahren?",
        zh to "好的，我们将没法得到一个精确的检验结果。请问你仍然希望继续吗?"
    )[currentLang]!!

    val DIABETES_PREGNANT_QUESTION_2_PROMPT = DIABETES_PREGNANT_QUESTION_2

    val DIABETES_PREGNANT_EXTRA_YES_1 = mapOf(
        en to "I am",
        sv to "ja bin ich",
        zh to "是的"
    )[currentLang]!!

    val DIABETES_AGE_QUESTION = mapOf(
        en to "How old are you?",
        sv to "Wie alt sind Sie in Jahren?",
        zh to "你多大了呢？"
    )[currentLang]!!

    val DIABETES_AGE_QUESTION_PROMT = mapOf(
        en to "your age in years",
        sv to "Ihr Alter in Jahren",
        zh to "您的年龄"
    )[currentLang]!!

    val DIABETES_AGE_OPTION1 = mapOf(
        en to "Younger than 45",
        sv to "Jünger als 45",
        zh to "小于45 岁"
    )[currentLang]!!

    val DIABETES_AGE_OPTION2 = mapOf(
        en to "45 or older but younger than 54",
        sv to "45 oder älter, aber jünger als 54",
        zh to "大于45 岁但小于54 岁"
    )[currentLang]!!

    val DIABETES_AGE_OPTION3 = mapOf(
        en to "55 or older but younger than 64",
        sv to "55 oder älter, aber jünger als 64",
        zh to "大于55 岁但小于64 岁"
    )[currentLang]!!

    val DIABETES_AGE_OPTION4 = mapOf(
        en to "65 or older",
        sv to "65 oder älter",
        zh to "65 岁以上"
    )[currentLang]!!

    val DIABETES_AGE_INVALID_ANSWER_1 = mapOf(
        en to "Your age must be a positive number!",
        sv to "Ihr Alter muss eine positive Zahl sein!",
        zh to "您的年龄必须是正数！"
    )[currentLang]!!

    val DIABETES_AGE_INVALID_ANSWER_2 = mapOf(
        en to "You must be at least 18 or older to continue this test.",
        sv to "Sie müssen mindestens 18 oder älter sein um diesen Test fortzusetzen.",
        zh to "您必须年满18 岁或以上才能继续此检查."
    )[currentLang]!!

    val DIABETES_AGE_INVALID_ANSWER_3 = mapOf(
        en to "Good one! you're probably not that old, try again",
        sv to "Guter Witz! Sie sind höchst wahrscheinlich nicht ganz so alt. Versuchen Sie es noch einmal",
        zh to "好的！您可能还不够大, 请重试"
    )[currentLang]!!

    val DIABETES_AGE_INVALID_ANSWER_4 = mapOf(
        en to "I couldn't get it",
        sv to "Wie bitte?",
        zh to "我不明白"
    )[currentLang]!!

    val DIABETES_AGE_ESTIMATE = mapOf(
        en to "If you're not sure what your age is, please estimate",
        sv to "Falls Sie nicht genau wissen, wie alt Sie sind, schätzen sie bitte.",
        zh to "如果不确定自己的年龄, 请估算一下"
    )[currentLang]!!

    val DIABETES_HEIGHT_QUESTION = mapOf(
        en to "So, how tall are you in centimeters?",
        sv to "Also, wie groß sind Sie in Zentimetern?",
        zh to "那么，您的身高是多少厘米？"
    )[currentLang]!!

    val DIABETES_HEIGHT_QUESTION_PROMT = mapOf(
        en to "How tall are you in centimeters?",
        sv to "Wie groß sind Sie in Zentimetern?",
        zh to "您的身高是多少厘米?"
    )[currentLang]!!

    val DIABETES_HEIGHT_ALTERNATIVE_1 = mapOf(
        en to "Less than 160 cm",
        sv to "Weniger als 160 cm",
        zh to "低于160 厘米"
    )[currentLang]!!

    val DIABETES_HEIGHT_ALTERNATIVE_2 = mapOf(
        en to "160-180 cm",
        sv to "160-180 cm",
        zh to "160 到180 厘米"
    )[currentLang]!!

    val DIABETES_HEIGHT_ALTERNATIVE_3 = mapOf(
        en to "180-200 cm",
        sv to "180-200 cm",
        zh to "180 到200 厘米"
    )[currentLang]!!

    val DIABETES_HEIGHT_ALTERNATIVE_4 = mapOf(
        en to "More than 200 cm",
        sv to "Mehr als 200 cm",
        zh to "高于200 厘米"
    )[currentLang]!!

    val DIABETES_WEIGHT_QUESTION = mapOf(
        en to "How much do you weigh, in kilos?",
        sv to "Wie viel wiegen Sie in Kilogramm?",
        zh to "您的体重是多少公斤？"
    )[currentLang]!!

    val DIABETES_WEIGHT_QUESTION_PROMT = mapOf(
        en to "How much do you weigh?",
        sv to "Wie viel wiegen Sie?",
        zh to "您有多重呢？"
    )[currentLang]!!

    val DIABETES_WEIGHT_ALTERNATIVE_1 = mapOf(
        en to "Less than 60 kg",
        sv to "Weniger als 60 kg",
        zh to "低于60 公斤"
    )[currentLang]!!

    val DIABETES_WEIGHT_ALTERNATIVE_2 = mapOf(
        en to "60-80 kg",
        sv to "60-80 kg",
        zh to "60 到80 公斤"
    )[currentLang]!!

    val DIABETES_WEIGHT_ALTERNATIVE_3 = mapOf(
        en to "80-100 kg",
        sv to "80-100 kg",
        zh to "80 到100 公斤"
    )[currentLang]!!

    val DIABETES_WEIGHT_ALTERNATIVE_4 = mapOf(
        en to "More than 100 kg",
        sv to "Mehr als 100 kg",
        zh to "高于100 公斤"
    )[currentLang]!!

    val DIABETES_WEIGHT_EXCEEDED = mapOf(
        en to "I'm sorry, This screening is only reliable for weights up to 200 kilos.",
        sv to "Es tut mir Leid, aber diese Voruntersuchung ist nur für ein Körpergewicht bis zu 200 kg ausgelegt.",
        zh to "我很抱歉, 这项检查仅适用于200公斤以下的重量."
    )[currentLang]!!

    val DIABETES_PHYSICAL_ACTIVITY_QUESTION = mapOf(
        en to "Would you say you get, at least, 30 minutes of physical activity per day?",
        sv to "Würden Sie sagen dass Sie mindestens 30 Minuten Bewegung pro Tag haben?",
        zh to "您是否每天至少要进行30分钟的运动？"

    )[currentLang]!!

    val DIABETES_PHYSICAL_ACTIVITY_QUESTION_PROMPT = DIABETES_PHYSICAL_ACTIVITY_QUESTION

    val DIABETES_PHYSICAL_ACTIVITY_EXPLAIN = mapOf(
        en to "A daily physical activity is something when you are activating your body and not sitting still. Do you get at least 30 minutes of physical activity daily? ",
        sv to "Mit Bewegung meine ich alle Arten der körperlichen Anstrengung, also nicht still sitzen. Haben Sie davon mindestens 30 Minuten am Tag?",
        zh to "日常体育锻炼就是当您活动自己的身体而不是坐着不动.您每天至少进行30分钟的体育锻炼吗?"
    )[currentLang]!!

    val DIABETES_FAMILY_HISTORY_QUESTION_1 = mapOf(
        en to "Has a relative of yours been diagnosed with diabetes?",
        sv to "Wurde einer ihrer Verwandten mit $SV_sayDiabetes diagnostiziert?",
        zh to "您是否有亲戚被诊断出患有糖尿病呢？"
    )[currentLang]!!

    val DIABETES_FAMILY_HISTORY_QUESTION_2 = mapOf(
        en to "And how are you related?",
        sv to "Wie sind Sie verwandt miteinander?",
        zh to "那他跟您是什么关系？"
    )[currentLang]!!

    val DIABETES_FAMILY_HISTORY_QUESTION_PROMT = mapOf(
        en to "Do you have a relative diagnosed with diabetes?",
        sv to "Haben Sie Verwandte mit diabetes?",
        zh to "您有亲戚被诊断患有糖尿病吗？"
    )[currentLang]!!

    val DIABETES_FAMILY_HISTORY_ALTERNATIVE_1 = mapOf(
        en to "Yes, Close Relative",
        sv to "Ja, nahe Verwandte",
        zh to "有的, 近亲"
    )[currentLang]!!

    val DIABETES_FAMILY_HISTORY_ALTERNATIVE_2 = mapOf(
        en to "Yes, Distant Relative",
        sv to "Ja, entfernte Verwandte",
        zh to "有的, 远亲"
    )[currentLang]!!

    val DIABETES_VEGETABLES_QUESTION = mapOf(
        en to "Do you eat fruit, vegetables or berries every day?",
        sv to "Essen Sie täglich Obst, Gemüse oder Beeren?",
        zh to "您每天吃水果, 蔬菜或浆果吗？"
    )[currentLang]!!

    val DIABETES_VEGETABLES_QUESTION_PROMPT = DIABETES_VEGETABLES_QUESTION

    val DIABETES_BLOOD_PRESSURE_MEDICATION_QUESTION = mapOf(
        en to "Have you ever taken medication for high blood pressure on a regular basis?",
        sv to "Haben Sie jemals regelmäßig Medikamente gegen erhöhten Blutdruck genommen?",
        zh to "您是否曾经定期服用过高血压药物？"
    )[currentLang]!!

    val DIABETES_BLOOD_GLUCOSE_QUESTION_1 = mapOf(
        en to "Have you ever been tested for high blood glucose",
        sv to "Sind Sie jemals auf erhöhten Blutzucker getestet worden?",
        zh to "您是否接受过高血糖测试?"
    )[currentLang]!!

    val DIABETES_BLOOD_GLUCOSE_QUESTION_2 = mapOf(
        en to "Did you have high blood glucose?",
        sv to "Hatten Sie erhöhten Blutzucker?",
        zh to "您的血糖高吗？"
    )[currentLang]!!

    val DIABETES_BLOOD_GLUCOSE_QUESTION_PROMT = mapOf(
        en to "Have you been tested for high blood glucose?",
        sv to "Sind Sie für erhöhten Blutzucker getestet worden?",
        zh to "您是否接受过高血糖测试？"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_MALE_QUESTION = mapOf(
        en to "For the next question I need you to measure your waist circumference. Pull the measuring strap around your waist and measure how many centimeters you get. Take your time.",
        sv to "Für die nächste Frage müssen Sie den Umfang Ihrer Taille messen. Ziehen Sie das $SV_sayMasband um Ihre Taille und messen Sie wie viele Zentimeter Taillenumfang Sie haben. Nehmen Sie sich Zeit",
        zh to "对于下一个问题, 我需要您测量您的腰围.请将测量带拉到您的腰部, 并测量您的腰围是多少厘米.慢慢来."
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_FEMALE_QUESTION = DIABETES_WAIST_CIRCUMFERENCE_MALE_QUESTION

    val DIABETES_WAIST_CIRCUMFERENCE_MALE_OPTION1 = mapOf(
        en to "Less than 94 cm",
        sv to "Weniger als 94 cm",
        zh to "小于94 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_MALE_OPTION2 = mapOf(
        en to "94-102 cm",
        sv to "94-102 cm",
        zh to "94 到102 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_MALE_OPTION3 = mapOf(
        en to "More than 102 cm",
        sv to "Mehr als 102 cm",
        zh to "大于102 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_FEMALE_OPTION1 = mapOf(
        en to "Less than 80 cm",
        sv to "Weniger als 80 cm",
        zh to "小于80 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_FEMALE_OPTION2 = mapOf(
        en to "80-88 cm",
        sv to "80-88 cm",
        zh to "80 到88 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_FEMALE_OPTION3 = mapOf(
        en to "More than 88 cm",
        sv to "Mehr als 88 cm",
        zh to "大于88 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_2 = mapOf(
        en to "How many centimeters did you measure?",
        sv to "Wie viele Zentimeter haben Sie gemessen?",
        zh to "您测量出多少厘米？"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_PROMPT = mapOf(
        en to "What is your waist circumference?",
        sv to "Was ist Ihr Taillenumfang?",
        zh to "您的腰围是多少？"
    )[currentLang]!!

    val EPDS_READ_RESULTS_1 = mapOf(
        en to "That was the last question. See the screen for your results. And as I said in the beginning, I'm not a doctor so the results are only an indicator. Take your time, and we will have a specialist follow up with your result and get back to you later. Thank you for participating.",
        sv to "Det var den sista frågan. Se skärmen för dina resultat. Och som jag sa i början, jag är inte läkare så resultaten är endast en indikator. Ta din tid, och vi kommer att ha en specialist som följer upp ditt resultat och återkommer till dig senare. Tack för att du deltog.",
        zh to "那是最后一个问题。请查看屏幕上的结果。正如我刚开始所说的，我不是医生，所以结果仅供参考。别着急，我们将会有专家跟进您的结果，并稍后与您联系。谢谢您的参与。"
    )[currentLang]!!

    val DIABETES_READ_RESULTS_1 = mapOf(
        en to "That was the last question. See the screen for your result. And as I said in the beginning, I'm not a doctor so the results are only an indicator. Take your time, and if you are concerned about your result from this screening, please contact your doctor for a more accurate assessment of your health. Thank you for participating.",
        sv to "Dies war die letzte Frage. Schauen Sie auf den Bildschirm um Ihr Resultat zu sehen. Wie schon gesagt, ich bin kein Arzt und das Resultat ist nur als Hinweis zu verstehen. Nehmen Sie sich Zeit, und falls Sie sich wegen ihres Ergebnisses Sorgen machen, kontaktieren Sie bitte Ihren Arzt oder Ihre Ärztin für eine genauere Beurteilung Ihres Gesundheitszustandes. Vielen Dank für Ihre Teilnahme.",
        zh to "那是最后一个问题.查看屏幕上的结果.正如我刚开始所说的, 我不是医生, 所以结果仅供参考.别着急, 如果您担心此检查的结果, 请与您的医生联系, 以更准确地评估您的健康状况.感谢您的参与."
    )[currentLang]!!

    val DIABETES_READ_RESULTS_2 = mapOf(
        en to "You can see the results, and more information about diabetes on the screen below. If you would like a more accurate assessment of your health, you should contact your doctor. Take your time, and let me known if you want to continue.",
        sv to "Sie können Ihr Voruntersuchungsresultat und mehr Informationen über $SV_sayDiabetes auf den Bildschirm unter mir ablesen. Falls Sie eine genauere Beurteilung ihres Gesundheitszustandes wünschen, sollten Sie Ihren Arzt oder Ihre Ärztin kontaktieren.",
        zh to "您可以在下面的屏幕上查看结果以及有关糖尿病的更多信息.如果您想更准确地评估自己的健康状况, 应该联系医生.别着急, 如果您想继续, 请告诉我."
    )[currentLang]!!

    val DIABETES_RESTART_TEST_OPTIONS_NO = mapOf(
        en to "No",
        sv to "Nein",
        zh to "不用"
    )[currentLang]!!


    // Explanation questions / answeres

    val QUESTION_DIABETES = mapOf(
        en to "diabetes",
        sv to "$SV_sayDiabetes ",
        zh to "糖尿病"
    )[currentLang]!!

    val QUESTION_PHYSICAL_ACTIVITY = mapOf(
        en to "physical activity",
        sv to "Bewegung",
        zh to "体育活动"
    )[currentLang]!!

    val QUESTION_HIGH_BLOOD_PRESSURE = mapOf(
        en to "high blood pressure",
        sv to "hoher Blutdruck",
        zh to "高血压"
    )[currentLang]!!

    val QUESTION_NAME = mapOf(
        en to "name",
        sv to "Name",
        zh to "姓名"
    )[currentLang]!!

    val QUESTION_YOUR_QUEST = mapOf(
        en to "your quest",
        sv to "Ihre Suche",
        zh to "您的问卷"
    )[currentLang]!!

    val EXPLANATION_DIABETES = mapOf(
        en to "diabetes is a disease in which the body’s ability to produce or respond to the hormone insulin is impaired, ",
        sv to "$SV_sayDiabetes ist eine Krankheit, bei der die Fähigkeit des Körpers Insulin herzustellen oder es zu nutzen zu reagieren eingeschränkt ist.",
        zh to "糖尿病是一种人体产生或响应激素胰岛素的能力受损的疾病,  "
    )[currentLang]!!

    val EXPLANATION_PHYSICAL_ACTIVITY = mapOf(
        en to "Physical activity simply means movement of the body that uses energy. Walking, gardening, briskly pushing a baby stroller, climbing the stairs, playing soccer, or dancing the night away are all good examples of being active.",
        sv to "Bewegung bedeutet, in diesem Kontext, körperliche Bewegung die Energie benötigt. Spazierengehen, den Garten bestellen, das flotte Schieben eines Kinderwagens, Treppensteigen, Fussballspielen oder durch die Nacht zu tanzen sind gute Beispiele.",
        zh to "体育活动只是意味着身体消耗能量的运动.散步, 园艺, 轻快地推婴儿车, 爬楼梯, 踢足球或在夜晚跳舞都属于这个范畴."
    )[currentLang]!!

    val EXPLANATION_HIGH_BLOOD_PRESSURE = mapOf(
        en to "You probably have high blood pressure if your blood pressure readings are consistently 140 over 90, or higher, over a number of weeks.",
        sv to "Sie haben vermutlich erhöhten Blutdruck, falls ihre Blutdruckmessungen über mehrere Wochen regelmäßig 140 über 90, oder mehr ergeben.",
        zh to "如果您的血压读数在几周内始终保持在90 以上或更高的140 上, 则可能患有高血压."
    )[currentLang]!!

    val EXPLANATION_NAME = mapOf(
        en to "My name is Petra",
        sv to "Mein Name ist Petra",
        zh to "我的名字是Petra"
    )[currentLang]!!

    val EXPLANATION_YOUR_QUEST = mapOf(
        en to "I provide a pre-screening experience for diabetes",
        sv to "Ich biete eine Voruntersuchung für $SV_sayDiabetes an",
        zh to "我提供糖尿病的预检查"
    )[currentLang]!!

    val CHANGE_TO_LANGUAGE_EN = "Change to English"
    val CHANGE_TO_LANGUAGE_SV = "Till svenska" // Changed to Swedish
    val CHANGE_TO_LANGUAGE_ZH = "切换成中文" //

}

/* improve pronunciations */
// to maintain how the company name sounds, and reduce the effect of accent/localisation:
//val SV_sayFurhat = "<phoneme alphabet=\"ipa\" ph=\"f'ɜʀ.ha:tt\">Furhat</phoneme>"
//// to make it sound reasonably okay:
//val SV_sayUhuh = "<phoneme alphabet=\"ipa\" ph=\"ʌ'ɦʌ\">uh-huh</phoneme>"
//// to make it sound like a german speaker would say it:
//val SV_sayDiabetes = "<phoneme alphabet=\"ipa\" ph=\"diaˈbeːtɛs\">Diabetes</phoneme>"
//val SV_sayDiabetesrisiko = "<phoneme alphabet=\"ipa\" ph=\"diaˈbeːtɛs.risiko\">diabetesrisiko</phoneme>"
//val SV_sayRoboter = "<phoneme alphabet=\"ipa\" ph=\"ˈʁɔbɔtɐ\">roboter</phoneme>"
//val SV_sayVoruntersuchungsroboter = "<phoneme alphabet=\"ipa\" ph=\"Voruntersuchungsˈʁɔbɔtɐ\">voruntersuchungsroboter</phoneme>"
//val SV_sayMasband = "<phoneme alphabet=\"ipa\" ph=\"ˈmaːsbant\">maßband</phoneme>"
//// to make it sound like an english-speaker would say it:
//val SV_sayPerformance = "<phoneme alphabet=\"ipa\" ph=\"pə.ˈfɔː.məns\">performance</phoneme>"
//val SV_sayMaterials = "<phoneme alphabet=\"ipa\" ph=\"mɐ̯'t'i:i:i:ʀiəlz\">materials</phoneme>"
//val SV_sayHealthcare = "<phoneme alphabet=\"ipa\" ph=\"hɛlθ.kɛə\">Healthcare</phoneme>"
//val SV_sayLife = "<phoneme alphabet=\"ipa\" ph=\"laɪf\">Life</phoneme>"

val SV_sayFurhat = "<phoneme alphabet=\"ipa\" ph=\"f'ʉːr.hɑːt\">Furhat</phoneme>"
val SV_sayUhuh = "<phoneme alphabet=\"ipa\" ph=\"'ʉːhʉː\">uh-huh</phoneme>"
val SV_sayDiabetes = "<phoneme alphabet=\"ipa\" ph=\"di.aˈbeːtɛs\">Diabetes</phoneme>"
val SV_sayDiabetesrisiko = "<phoneme alphabet=\"ipa\" ph=\"di.aˈbeːtɛs.rɪs'iːkɔ\">diabetesrisiko</phoneme>"
val SV_sayRoboter = "<phoneme alphabet=\"ipa\" ph=\"rʊˈbuːtɛr\">roboter</phoneme>"
val SV_sayVoruntersuchungsroboter = "<phoneme alphabet=\"ipa\" ph=\"vɔr.ʉnˈtɛrsʉxʉŋs.rʊˈbuːtɛr\">voruntersuchungsroboter</phoneme>"
val SV_sayMasband = "<phoneme alphabet=\"ipa\" ph=\"ˈmɔːsbɑnd\">måttband</phoneme>"
val SV_sayPerformance = "<phoneme alphabet=\"ipa\" ph=\"pɛr.fɔrˈmɑns\">performance</phoneme>"
val SV_sayMaterials = "<phoneme alphabet=\"ipa\" ph=\"mɑtɛrɪ'ɑːl\">materials</phoneme>"
val SV_sayHealthcare = "<phoneme alphabet=\"ipa\" ph=\"hɛltsɑːr\">Healthcare</phoneme>"
val SV_sayLife = "<phoneme alphabet=\"ipa\" ph=\"laɪf\">Life</phoneme>"
