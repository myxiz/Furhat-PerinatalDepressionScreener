package furhatos.app.medicalscreener.i18n

import furhatos.app.medicalscreener.currentLang
import furhatos.app.medicalscreener.toConjugatedList

class I18nPhrases {

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
        zh to "你好，我是一个健康筛查机器人。我由乌普萨拉社交机器人实验室开发"
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


    val GENERAL_START = mapOf(
        en to "Start",
        sv to "Starta",
        zh to "开始"
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
    val INTRODUCTION_GREETING_ON = mapOf(
        en to "Good day! I am now operational！",
        sv to "God dag! Jag är nu operativ！",
        zh to "你好！我已出舱，感觉良好！"
    )[currentLang]!!

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
    val PERSONALIZATION_VOICE_PROMT = mapOf(
        en to "Do you want to move on or change voice? ",
        sv to "Vill du gå vidare eller byta röst?",
        zh to "您想继续下一步或是改变语音？"
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
        zh to "我会笑并看到事情有趣的一面"
    )[currentLang]!!

    val EPDS_ONE_PROMPT = EPDS_ONE

    val EPDS_ONE_RESPONSES_0 = mapOf(
        en to "As much as I always could",
        sv to "Lika bra som vanligt",
        zh to "跟以前一样多"
    )[currentLang]!!

    val EPDS_ONE_RESPONSES_1 = mapOf(
        en to "Not quite so much now",
        sv to "Nästan lika bra som vanligt",
        zh to "现在没那么多了"
    )[currentLang]!!

    val EPDS_ONE_RESPONSES_2 = mapOf(
        en to "Definitely not so much now",
        sv to "Mycket mindre än vanligt",
        zh to "现在肯定没那么多了"
    )[currentLang]!!

    val EPDS_ONE_RESPONSES_3 = mapOf(
        en to "Not at all",
        sv to "Inte alls",
        zh to "根本没有"
    )[currentLang]!!

    val EPDS_TWO = mapOf(
        en to "I have looked forward with enjoyment to things",
        sv to "Jag har glatt mig åt saker som skall hända:",
        zh to "我盼望着能享受事物"
    )[currentLang]!!

    val EPDS_TWO_PROMPT = EPDS_TWO

    val EPDS_TWO_RESPONSES_0 = mapOf(
        en to "As much as I ever did",
        sv to "Lika mycket som vanligt",
        zh to "跟我以前一样多"
    )[currentLang]!!

    val EPDS_TWO_RESPONSES_1 = mapOf(
        en to "Rather less than I used to",
        sv to "Något mindre än vanligt",
        zh to "比以前少多了"
    )[currentLang]!!

    val EPDS_TWO_RESPONSES_2 = mapOf(
        en to "Definitely less than I used to",
        sv to "Mycket mindre än vanligt",
        zh to "肯定比以前少了"
    )[currentLang]!!

    val EPDS_TWO_RESPONSES_3 = mapOf(
        en to "Hardly at all",
        sv to "Inte alls",
        zh to "几乎没有"
    )[currentLang]!!

    val EPDS_THREE = mapOf(
        en to "I have blamed myself unnecessarily when things went wrong",
        sv to "Jag har lagt skulden på mig själv onödigt mycket när något har gått snett:",
        zh to "当事情不顺利时，我没必要地责备自己"
    )[currentLang]!!


    val EPDS_THREE_PROMPT = EPDS_THREE

    val EPDS_THREE_RESPONSES_3 = mapOf(
        en to "Yes, most of the time",
        sv to "Ja, för det mesta",
        zh to "是，大多数时候"
    )[currentLang]!!

    val EPDS_THREE_RESPONSES_2 = mapOf(
        en to "Yes, some of the time",
        sv to "Ja, ibland",
        zh to "是，有时候"
    )[currentLang]!!

    val EPDS_THREE_RESPONSES_1 = mapOf(
        en to "Not very often",
        sv to "Nej, inte så ofta",
        zh to "不是很经常"
    )[currentLang]!!

    val EPDS_THREE_RESPONSES_0 = mapOf(
        en to "No, never",
        sv to "Nej, aldrig",
        zh to "不，从不"
    )[currentLang]!!


    val EPDS_FOUR = mapOf(
        en to "I have been anxious or worried for no good reason",
        sv to "Jag har känt mig rädd och orolig utan egentlig anledning:",
        zh to "我没有什么原因就焦虑或担心"
    )[currentLang]!!

    val EPDS_FOUR_PROMPT = EPDS_FOUR

    val EPDS_FOUR_RESPONSES_0 = mapOf(
        en to "No, not at all",
        sv to "Nej, inte alls",
        zh to "不，完全没有"
    )[currentLang]!!

    val EPDS_FOUR_RESPONSES_1 = mapOf(
        en to "Hardly ever",
        sv to "Nej, knappast alls",
        zh to "几乎没有"
    )[currentLang]!!

    val EPDS_FOUR_RESPONSES_2 = mapOf(
        en to "Yes, sometimes",
        sv to "Ja, ibland",
        zh to "是，有时候"
    )[currentLang]!!

    val EPDS_FOUR_RESPONSES_3 = mapOf(
        en to "Yes, very often",
        sv to "Ja, mycket ofta",
        zh to "是，很经常"
    )[currentLang]!!



    val EPDS_FIVE = mapOf(
        en to "I have felt scared or panicky for no very good reason",
        sv to "Jag har känt mig skrämd eller panikslagen utan speciell anledning:",
        zh to "没什么理由我就觉得害怕或恐慌"
    )[currentLang]!!


    val EPDS_FIVE_PROMPT = EPDS_FIVE

    val EPDS_FIVE_RESPONSES_0 = mapOf(
        en to "No, not at all",
        sv to "Nej, inte alls",
        zh to "不，完全没有"
    )[currentLang]!!

    val EPDS_FIVE_RESPONSES_1 = mapOf(
        en to "No, not much",
        sv to "Nej, ganska sällan",
        zh to "不，不多时候"
    )[currentLang]!!

    val EPDS_FIVE_RESPONSES_2 = mapOf(
        en to "Yes, sometimes",
        sv to "Ja, ibland",
        zh to "是，有时候"
    )[currentLang]!!

    val EPDS_FIVE_RESPONSES_3 = mapOf(
        en to "Yes, quite a lot",
        sv to "Ja, mycket ofta",
        zh to "是，很多时候"
    )[currentLang]!!


    val EPDS_SIX = mapOf(
        en to "Things have been getting on top of me",
        sv to "Det har kört ihop sig för mig och blivit för mycket:",
        zh to "事情超出我的控制"
    )[currentLang]!!


    val EPDS_SIX_PROMPT = EPDS_SIX

    val EPDS_SIX_RESPONSES_3 = mapOf(
        en to "Yes, most of the time I haven't been able to cope at all",
        sv to "Ja, mest hela tiden har jag inte kunnat ta itu med något alls",
        zh to "是，大多数时候我根本无法应对"
    )[currentLang]!!

    val EPDS_SIX_RESPONSES_2 = mapOf(
        en to "Yes, sometimes I haven't been coping as well as usual",
        sv to "Ja, ibland har jag inte kunnat ta itu med saker lika bra som vanligt",
        zh to "是，有时候我不像平时应对得那么好"
    )[currentLang]!!

    val EPDS_SIX_RESPONSES_1 = mapOf(
        en to "No, most of the time I have coped quite well",
        sv to "Nej, för det mesta har jag kunnat ta itu med saker ganska bra",
        zh to "不，大多数时候我应对得挺好"
    )[currentLang]!!

    val EPDS_SIX_RESPONSES_0 = mapOf(
        en to "No, I have been coping as well as ever",
        sv to "Nej, jag har kunnat ta itu med saker precis som vanligt",
        zh to "不，我和以前一样应对得好"
    )[currentLang]!!


    val EPDS_SEVEN = mapOf(
        en to "I have been so unhappy that I have had difficulty sleeping",
        sv to "Jag har känt mig så ledsen och olycklig att jag har haft svårt att sova:",
        zh to "我非常不开心以至于睡眠困难"
    )[currentLang]!!


    val EPDS_SEVEN_PROMPT = EPDS_SEVEN

    val EPDS_SEVEN_RESPONSES_3 = mapOf(
        en to "Yes, most of the time",
        sv to "Ja, för det mesta",
        zh to "是，大多数时候"
    )[currentLang]!!

    val EPDS_SEVEN_RESPONSES_2 = mapOf(
        en to "Yes, sometimes",
        sv to "Ja, ibland",
        zh to "是，有时候"
    )[currentLang]!!

    val EPDS_SEVEN_RESPONSES_1 = mapOf(
        en to "No, not very often",
        sv to "Nej, sällan",
        zh to "不是很经常"
    )[currentLang]!!

    val EPDS_SEVEN_RESPONSES_0 = mapOf(
        en to "No, not at all",
        sv to "Nej, aldrig",
        zh to "不，根本不"
    )[currentLang]!!


    val EPDS_EIGHT = mapOf(
        en to "I have felt sad or miserable",
        sv to "Jag har känt mig ledsen och nere:",
        zh to "我觉得伤心或悲惨"
    )[currentLang]!!


    val EPDS_EIGHT_PROMPT = EPDS_EIGHT

    val EPDS_EIGHT_RESPONSES_0 = mapOf(
        en to "No, not at all",
        sv to "Nej, aldrig",
        zh to "不，从不"
    )[currentLang]!!

    val EPDS_EIGHT_RESPONSES_1 = mapOf(
        en to "Not very often",
        sv to "Nej, sällan",
        zh to "不是很经常"
    )[currentLang]!!

    val EPDS_EIGHT_RESPONSES_2 = mapOf(
        en to "Yes, quite often",
        sv to "Ja, rätt ofta",
        zh to "是，很经常"
    )[currentLang]!!

    val EPDS_EIGHT_RESPONSES_3 = mapOf(
        en to "Yes, most of the time",
        sv to "Ja, för det mesta",
        zh to "是，大多数时候"
    )[currentLang]!!

    val EPDS_NINE = mapOf(
        en to "I have been so unhappy that I have been crying",
        sv to "Jag har känt mig så olycklig att jag har gråtit:",
        zh to "我非常不开心以至于我一直哭"
    )[currentLang]!!


    val EPDS_NINE_PROMPT = EPDS_NINE

    val EPDS_NINE_RESPONSES_0 = mapOf(
        en to "No, never",
        sv to "Nej, aldrig",
        zh to "不，从不"
    )[currentLang]!!

    val EPDS_NINE_RESPONSES_1 = mapOf(
        en to "Only occasion_ally",
        sv to "Bara någon gång",
        zh to "仅仅偶尔"
    )[currentLang]!!

    val EPDS_NINE_RESPONSES_2 = mapOf(
        en to "Yes, quite often",
        sv to "Ja, ganska ofta",
        zh to "是，很经常"
    )[currentLang]!!

    val EPDS_NINE_RESPONSES_3 = mapOf(
        en to "Yes, most of the time",
        sv to "Ja, nästan jämt",
        zh to "是，大多数时候"
    )[currentLang]!!

    val EPDS_TEN = mapOf(
        en to "The thought of harming myself has occurred to me",
        sv to "Tankar på att göra mig själv illa har förekommit:",
        zh to "我曾经有过伤害自己的想法"
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
        zh to "几乎没有"
    )[currentLang]!!

    val EPDS_TEN_RESPONSES_2 = mapOf(
        en to "Sometimes",
        sv to "Ibland",
        zh to "有时候"
    )[currentLang]!!

    val EPDS_TEN_RESPONSES_3 = mapOf(
        en to "Yes, quite often",
        sv to "Ja, rätt så ofta",
        zh to "是，很经常"
    )[currentLang]!!


    val EPDS_READ_RESULTS_1 = mapOf(
        en to "That was the last question. See the screen for your results. And as I said in the beginning, I'm not a doctor so the results are only an indicator. Take your time, and we will have a specialist follow up with your result and get back to you later. Thank you for participating.",
        sv to "Det var den sista frågan. Se skärmen för dina resultat. Och som jag sa i början, jag är inte läkare så resultaten är endast en indikator. Ta din tid, och vi kommer att ha en specialist som följer upp ditt resultat och återkommer till dig senare. Tack för att du deltog.",
        zh to "那是最后一个问题。请查看屏幕上的结果。正如我刚开始所说的，我不是医生，所以结果仅供参考。别着急，我们将会有专家跟进您的结果，并稍后与您联系。谢谢您的参与。"
    )[currentLang]!!

    //MINI interview
    val MINIInterviewIntroduction = mapOf(
        en to "Now we will conduct a clinical interview that is more structured than usual, with very specific questions about psychological problems that only need to be answered with 'yes' or 'no'. Is that okay?",
        sv to "Nu ska vi göra en klinisk intervju som är mer strukturerad än vanligt, med mycket specifika frågor om psykologiska problem som bara behöver besvaras med 'ja' eller 'nej'. Är det ok?",
        zh to "现在我们将进行一次比平时更有结构的临床访谈，关于心理问题的非常具体的问题只需要用'是'或'否'回答。可以吗？"
    )[currentLang]!!

    val MINIInterviewIntroduction_PROMPT = MINIInterviewIntroduction

    val MINIQuestion_A1a_QUESTION = mapOf(
        en to "Have you ever felt depressed, down, or hopeless over a significant part of the day, nearly every day for two weeks?",
        sv to "Har du någonsin känt dig deprimerad, nere eller hopplös under större delen av dagen, nästan varje dag under två veckor?",
        zh to "您是否曾在两周内几乎每天的大部分时间感到沮丧、失落或绝望？"
    )[currentLang]!!

    val MINIQuestion_A1a_PROMPT = MINIQuestion_A1a_QUESTION

    // Question A1b
    val MINIQuestion_A1b_QUESTION = mapOf(
        en to "In the past 2 weeks, have you been feeling depressed, down, or sad, empty, or despairing for most of the day, nearly every day?",
        sv to "Under de senaste 2 veckorna, har du varit deprimerad eller nere, eller känt dig ledsen, tom eller uppgiven under större delen av dagen, nästan varje dag?",
        zh to "在过去两周内，您是否几乎每天大部分时间感到抑郁、沮丧或悲伤、空虚或绝望？"
    )[currentLang]!!
    val MINIQuestion_A1b_PROMPT = MINIQuestion_A1b_QUESTION


    // Question A2a
    val MINIQuestion_A2a_QUESTION = mapOf(
        en to "Have you ever lost most of your interest in things around you or not been able to enjoy things you usually like for most of the time over 2 weeks?",
        sv to "Har du någonsin tappat intresset för det mesta omkring dig eller inte kunnat ha riktigt nöje av sådant du brukar tycka om under den största delen av tiden under 2 veckor?",
        zh to "您是否曾在两周内每天大部分时间对周围的事物失去了兴趣，或无法享受您通常喜欢的事物？"
    )[currentLang]!!
    val MINIQuestion_A2a_PROMPT = MINIQuestion_A2a_QUESTION


    // Question A2b
    val MINIQuestion_A2b_QUESTION = mapOf(
        en to "During the most of the past 2 weeks, have you been much less interested in most things around you compared to others, or not been able to enjoy things you usually enjoy?",
        sv to "Har du under den största delen av tiden under de senaste 2 veckorna varit mycket mindre intresserad av det mesta omkring dig jämfört med andra, eller inte kunnat ha riktigt nöje av sådant du vanligen brukar tycka om?",
        zh to "在过去两周的大部分时间里，与其他人相比，您对周围的大多数事物的兴趣是否大大减少，或者无法享受您通常喜欢的事物？"
    )[currentLang]!!
    val MINIQuestion_A2b_PROMPT = MINIQuestion_A2b_QUESTION

    // Bridge to A3
    val MINITwoWeeksPeriodStatement = mapOf(
        en to "Now, I would like to ask a few more questions about your well-being over the last two weeks.",
        sv to "Nu vill jag ställa några fler frågor om ditt mående de senaste två veckorna.",
        zh to "现在，我想再问几个关于你过去两周内的健康状况的问题。"
    )[currentLang]!!


    // Question A3

    val MINIQuestion_A3a_QUESTION = mapOf(
        en to "Did you have decreased or increased appetite almost every day? Did you unintentionally lose or gain weight (i.e., ±5% of body weight, that is, ±3.5 kg for a person weighing 70 kg, within a month)?",
        sv to "Hade du minskad eller ökad aptit nästan varje dag? Minskade eller ökade du oavsiktligt i vikt (d.v.s. med ±5% av kroppsvikten, eller ±3,5 kg eller ±8 lb för en person som väger 70 kg, på en månad)?",
        zh to "您是否几乎每天都感到食欲减退或增加？是否在一个月内无意中减轻或增加了体重（即体重的±5%，对于一个重70公斤的人，大约3.5公斤）？"
    )[currentLang]!!
    val MINIQuestion_A3a_PROMPT = MINIQuestion_A3a_QUESTION

    val MINIQuestion_A3b_QUESTION = mapOf(
        en to "Did you have trouble sleeping almost every night (difficulty falling asleep, waking up in the middle of the night, waking up too early in the morning, or sleeping too much)?",
        sv to "Hade du problem med sömnen nästan varje natt (svårt att somna in, vaknade upp mitt i natten, vaknade alldeles för tidigt på morgonen eller sov alldeles för mycket)?",
        zh to "您是否几乎每个夜晚都有睡眠问题（入睡困难、半夜醒来、早晨醒得太早或睡眠过多）？"
    )[currentLang]!!
    val MINIQuestion_A3b_PROMPT = MINIQuestion_A3b_QUESTION

    val MINIQuestion_A3c_QUESTION = mapOf(
        en to "Did you talk or move more slowly than usual, or were you restless or had difficulty sitting still almost every day? Did anyone notice this?",
        sv to "Pratade eller rörde du dig långsammare än vanligt, eller var du rastlös eller hade svårt att sitta still nästan varje dag? Märkte någon detta?",
        zh to "您是否讲话或动作比平时慢，或者几乎每天都感到焦躁不安或难以静坐？有人注意到这一点吗？"
    )[currentLang]!!
    val MINIQuestion_A3c_PROMPT = MINIQuestion_A3c_QUESTION

    val MINIQuestion_A3d_QUESTION = mapOf(
        en to "Did you feel tired or had little energy almost every day?",
        sv to "Kände du dig trött eller orkeslös nästan varje dag?",
        zh to "您是否几乎每天都感到疲倦或缺乏活力？"
    )[currentLang]!!
    val MINIQuestion_A3d_PROMPT = MINIQuestion_A3d_QUESTION

    val MINIQuestion_A3e_QUESTION = mapOf(
        en to "Did you feel worthless or had excessive guilt almost every day?",
        sv to "Kände du dig värdelös eller hade skuldkänslor nästan varje dag?",
        zh to "您是否几乎每天都感觉自己一文不值或有过度的罪恶感？"
    )[currentLang]!!
    val MINIQuestion_A3e_PROMPT = MINIQuestion_A3e_QUESTION

    val MINIQuestion_A3f_QUESTION = mapOf(
        en to "Did you have trouble concentrating, thinking, or making decisions almost every day?",
        sv to "Hade du svårt att koncentrera dig, tänka eller fatta beslut nästan varje dag?",
        zh to "您是否几乎每天都难以集中注意力、思考或做决定？"
    )[currentLang]!!
    val MINIQuestion_A3f_PROMPT = MINIQuestion_A3f_QUESTION

    val MINIQuestion_A3g_QUESTION = mapOf(
        en to "Did you often think about death (not just fear of dying), have thoughts of killing yourself, or have plans or intentions to do so? Did you attempt to take your life?",
        sv to "Tänkte du ofta på döden (RÄDSLA FÖR ATT DÖ RÄKNAS INTE HÄR), eller hade tankar på att ta livet av dig, eller hade du avsikter eller planer på att ta ditt liv? Försökte du ta ditt liv?",
        zh to "您是否经常考虑到死亡（不仅仅是对死亡的恐惧）、有自杀的想法或计划和意图？您是否尝试过结束自己的生命？"
    )[currentLang]!!
    val MINIQuestion_A3g_PROMPT = MINIQuestion_A3g_QUESTION


    val MINIQuestion_A4_QUESTION = mapOf(
        en to "Did these problems cause significant distress or problems in your home, work, studies, social interactions, relationships, or any other important areas, and did they represent a change from how you were previously functioning?",
        sv to "Orsakade dessa symtom påtagliga besvär eller problem hemma, i arbetet, i dina studier, socialt, i relationer, eller på något annat viktigt sätt, och innebar de en förändring mot hur du fungerat tidigare?",
        zh to "这些问题是否在家庭、工作、学习、社交互动、人际关系或其他重要领域造成了显著的困扰或问题，并且它们是否代表了与您以前的功能相比的变化？"
    )[currentLang]!!

    val MINI_MOVE_TO_NEXT_SECTION = mapOf(
        en to "We will now move on to the next section.",
        sv to "Vi går nu vidare till nästa avsnitt.",
        zh to "我们现在将继续进行下一部分。"
    )[currentLang]!!


    val MINI_ASK_FOR_EXAMPLES = mapOf(
        en to "Can you give me some examples? It's important for us to understand specific situations or thoughts that you've experienced.",
        sv to "Kan du ge mig några exempel? Det är viktigt för oss att förstå specifika situationer eller tankar som du har upplevt.",
        zh to "您能给我一些例子吗？对我们来说，理解您经历过的具体情况或思想是非常重要的。"
    )[currentLang]!!


    val MINIQuestion_B1_QUESTION = mapOf(
        en to "Have you experienced an accident? This includes accidentally taking too many pills.",
        sv to "Har du varit med om en olyckshändelse? Detta inbegriper att råka ta för många tabletter.",
        zh to "你有没有经历过意外事故？这包括不小心吃了太多药片。"
    )[currentLang]!!

    val MINIQuestion_B1a_QUESTION = mapOf(
        en to "Did you plan or intend to harm yourself in any accident, either by not avoiding a risk or by intentionally causing the accident?",
        sv to "Planerade eller avsåg du att skada dig själv i någon olyckshändelse, antingen genom att inte undvika en risk eller att avsiktligt orsaka olyckan?",
        zh to "你是否有意图在任何事故中伤害自己，无论是通过不避免风险还是故意引起事故？"
    )[currentLang]!!

    val MINIQuestion_B1b_QUESTION = mapOf(
        en to "Did you intend to die as a result of any accident?",
        sv to "Avsåg du att dö som en följd av någon olyckshändelse?",
        zh to "你是否打算因任何事故而死亡？"
    )[currentLang]!!

    val MINIQuestion_B2_QUESTION = mapOf(
            en to "Have you (even for a moment) thought that it would be better if you were dead, or wished you were dead, or had to be dead?",
            sv to "Har du (om ens för ett ögonblick) tänkt att det vore bättre om du var död, eller önskat att du var död eller var tvungen att vara död?",
            zh to "你是否（即使是一瞬间）认为如果你死了会更好，或希望你已经死了，或必须死了？"
        )[currentLang]!!

    val MINIQuestion_B3_QUESTION = mapOf(
        en to "Have you (even for a moment) thought about harming or hurting yourself – with at least some intention or awareness that you could die as a result – or have you contemplated suicide (i.e., taking your own life)?",
        sv to "Har du (om ens för ett ögonblick) tänkt på att skada eller göra illa dig själv – med åtminstone en viss avsikt eller medvetenhet om att du kunde dö som följd – eller har du funderat på självmord (d.v.s. att ta ditt liv)?",
        zh to "你是否（即使是一瞬间）考虑过伤害自己或自残 — 至少有一些意图或意识到你可能因此而死 — 或者你是否考虑过自杀（即结束自己的生命）？"
    )[currentLang]!!


    val MINIQuestion_B4_QUESTION = mapOf(
        en to "Have you heard a voice or voices telling you to take your life, or have you had dreams in some way related to suicide?",
        sv to "Har du hört en röst eller röster som säger till dig att ta livet av dig, eller har du haft drömmar som på något sätt är relaterade till självmord?",
        zh to "你是否听到一个或多个声音告诉你去结束自己的生命，或者你是否做过以某种方式与自杀相关的梦？"
    )[currentLang]!!

    val MINIQuestion_B5_QUESTION = mapOf(
        en to "Have you figured out a way to take your life (i.e., how)?",
        sv to "Har du tänkt ut ett sätt att ta ditt liv (d.v.s. hur)?",
        zh to "你是否想出了结束自己生命的方法（即，如何）？"
    )[currentLang]!!


    val MINIQuestion_C1a_QUESTION = mapOf(
        en to "Have you ever experienced a period when you felt 'revved up,' 'high,' or 'hyper,' and so active or full of energy or so self-satisfied that you got into trouble, or that others thought you were not yourself? (Do not count times when you were under the influence of alcohol or drugs.)",
        sv to "Har du någonsin upplevt en period när du kände dig 'på tårna,' 'hög,' eller 'hyper,' och så aktiv eller full av energi eller så självbelåten att du hamnade i trubbel, eller att andra tyckte att du inte var dig själv? (Räkna inte tider när du var under påverkan av alkohol eller droger.)",
        zh to "你是否曾经经历过一个时期，你感觉到'飙升'，'高涨'或'亢奋'，以至于如此活跃或充满活力或如此自我满足以至于你惹了麻烦，或者别人认为你不是你自己？ （不要计算在酒精或药物影响下的时候。）"
    )[currentLang]!!

    val MINIQuestion_C1b_QUESTION = mapOf(
        en to "Do you currently feel 'revved up,' 'high,' 'hyper,' or full of energy?",
        sv to "Känner du för närvarande dig 'uppvarvad,' 'hög,' 'hyper,' eller full av energi?",
        zh to "您当前是否感到'飙升'，'高涨'，'亢奋'或充满活力？"
    )[currentLang]!!

    val MINIQuestion_C2a_QUESTION = mapOf(
        en to "Have you ever experienced recurrent irritability over several days such that you got into arguments or fights or shouted at people outside your own family? Have you or others noticed that you were more easily annoyed or overreacted, compared to others? This includes situations where you felt your reaction was justified.",
        sv to "Har du någonsin upplevt återkommande irritation under flera dagar så att du varit med i gräl eller slagsmål eller skrikit åt personer utanför din egen familj? Har du eller andra märkt att du varit mer lättretlig eller överreagerat, jämfört med andra? Detta gäller även situationer där du tyckte att din reaktion varit berättigad.",
        zh to "你是否曾经经历过几天的反复烦躁，以至于你与人争吵或打架，或向自己家人之外的人大喊大叫？ 您或其他人是否注意到您更容易生气或反应过度，与其他人相比？ 这包括您觉得您的反应是正当的情况。"
    )[currentLang]!!


    val MINIQuestion_C2b_QUESTION = mapOf(
        en to "Do you currently experience a recurring feeling of irritability?",
        sv to "Upplever du för närvarande en återkommande känsla av retlighet?",
        zh to "您当前是否经历反复出现的烦躁感？"
    )[currentLang]!!

    val MINIQuestion_C3_INTRO = mapOf(
        en to "During the past few days, including today, when you felt elated and full of energy or irritable:",
        sv to "Under de senaste dagarna, inklusive idag, när du kände dig upprymd och full av energi eller retlig:",
        zh to "在过去的几天，包括今天，当您感到兴奋、充满活力或易怒时："
    )[currentLang]!!


    val MINIQuestion_C3a_QUESTION = mapOf(
        en to "Did you feel that you could do things others couldn't, or that you were a particularly important person? If YES, ask for examples.",
        sv to "Upplevde du att du kunde göra saker som andra inte kunde, eller att du var en särskilt viktig person? Om JA, be om exempel.",
        zh to "您是否觉得自己能做别人做不到的事情，或者您是一个特别重要的人？如果是，请举例说明。"
    )[currentLang]!!

    val MINIQuestion_C3b_QUESTION = mapOf(
        en to "Did you need less sleep (e.g., feeling rested after only a few hours of sleep)?",
        sv to "Behövde du mindre sömn (t.ex. att du kände dig utvilad efter bara några timmars sömn)?",
        zh to "您是否需要较少的睡眠（例如，只睡几个小时就感觉精力充沛）？"
    )[currentLang]!!

    val MINIQuestion_C3c_QUESTION = mapOf(
        en to "Did you talk excessively without stopping, or feel compelled to continue talking?",
        sv to "Pratade du för mycket utan uppehåll, eller kände dig tvingad att fortsätta prata?",
        zh to "您是否不停地说话，或者感到被迫不停地说话？"
    )[currentLang]!!

    val MINIQuestion_C3d_QUESTION = mapOf(
        en to "Did you notice that your thoughts raced, jumped from one subject to another, or were very fast-paced?",
        sv to "Märkte du att dina tankar gick väldigt fort, löpte samman, rusade eller rörde sig väldigt snabbt från ett ämne till ett annat?",
        zh to "您是否注意到您的思维飞快，跳跃着从一个主题到另一个主题，或者非常快速？"
    )[currentLang]!!


    val MINIQuestion_C3e_QUESTION = mapOf(
        en to "Were you easily distracted, so that every little disturbance could make you lose track?",
        sv to "Blev du lätt distraherad så att varje liten störning kunde få dig att tappa tråden?",
        zh to "您是否容易分心，以至于每一个小干扰都会让您失去思维？"
    )[currentLang]!!

    val MINIQuestion_C3f_QUESTION = mapOf(
        en to "Did you experience a significant increase in interest or activity regarding work/studies, or socially or sexually, or did you become physically or mentally restless? This increase in activity can be with or without a purpose.",
        sv to "Fick du en påtaglig ökning av intresse eller aktivitet gällande arbete/studier, eller socialt eller sexuellt, eller blev du fysiskt eller psykiskt rastlös? Denna ökning av aktiviteten kan vara med eller utan något syfte.",
        zh to "您是否在工作/学习、社交或性方面经历了显着的兴趣或活动增加，或者您是否变得身体或精神不安定？ 这种活动的增加可以有或没有目的。"
    )[currentLang]!!

    val MINIQuestion_C3g_QUESTION = mapOf(
        en to "Were you so focused on enjoying life and having fun that you disregarded risks and consequences (e.g., excessive shopping, careless driving, or irresponsible sexual behavior)?",
        sv to "Var du så inriktad på att njuta av livet och ha roligt att du struntade i risker och konsekvenser (t.ex. överdriven shopping, vårdslös bilkörning eller ansvarslöst sexuellt beteende)?",
        zh to "您是否如此专注于享受生活和快乐，以至于您无视了风险和后果（例如，过度购物、粗心驾驶或不负责任的性行为）？"
    )[currentLang]!!


    val EPDS_RESTART_TEST_OPTIONS_NO = mapOf(
        en to "No",
        sv to "Nej",
        zh to "不用"
    )[currentLang]!!


    val CHANGE_TO_LANGUAGE_EN = "Change to English"
    val CHANGE_TO_LANGUAGE_SV = "Till svenska" // Changed to Swedish
    val CHANGE_TO_LANGUAGE_ZH = "切换成中文" //

}
