package furhatos.app.medicalscreener.i18n

import furhatos.app.medicalscreener.currentLang
import furhatos.app.medicalscreener.toConjugatedList

class I18nPhrases {
    val DIABETES_NAME = mapOf(
        en to "Diabetes",
        de to "$DE_sayDiabetes ",
        zh to "糖尿病"
    )[currentLang]!!


    // General

    val GENERAL_YES = mapOf(
        en to "Yes",
        de to "Ja",
        zh to "是的"
    )[currentLang]!!

    val GENERAL_NO = mapOf(
        en to "No",
        de to "Nein",
        zh to "没有"
    )[currentLang]!!

    val GENERAL_SELECT = mapOf(
        en to "Select",
        de to "Auswählen",
        zh to "选择"
    )[currentLang]!!

    val GENERAL_ONCE = mapOf(
        en to "once",
        de to "einmal",
        zh to "一次"
    )[currentLang]!!

    val GENERAL_SEVERAL_TIMES = mapOf(
        en to "several times",
        de to "mehrmals",
        zh to "几次"
    )[currentLang]!!

    val GENERAL_ASK_IF_DONE = mapOf(
        en to "Are you done yet?",
        de to "Sind Sie so weit?",
        zh to "您完成了吗？"
    )[currentLang]!!

    val GENERAL_OK_WAITING = mapOf(
        en to "Ok, i'll wait.",
        de to "Ok, ich kann warten.",
        zh to "好的, 我会等待."
    )[currentLang]!!

    val GENERAL_ESTIMATE = mapOf(
        en to "Just give me your best estimate.",
        de to "Geben Sie mir einfach Ihre beste Einschätzung.",
        zh to "请给我您最好的估计."
    )[currentLang]!!

    val GENERAL_OK_NO_PROBLEM = mapOf(
        en to "Alright. No problem.",
        de to "In Ordung. Kein Problem",
        zh to "好的.没有问题."
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_REPLY_VAR1 = mapOf(
        en to "I couldn't hear your response.",
        de to "Ich habe Ihre Antwort nicht verstanden.",
        zh to "我听不到您的回应."
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_REPLY_VAR2 = mapOf(
        en to "Could you please speak louder?",
        de to "Würden Sie bitte etwas lauter sprechen?",
        zh to "您的声音可以再大一些吗？"
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_REPLY_VAR3 = mapOf(
        en to "Sorry, I couldn't hear you...",
        de to "Entschuldigen Sie, aber ich konnte sie nicht hören ...",
        zh to "抱歉, 我没办法听到您..."
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_REPLY_REPEAT_QUESTION_VAR1 = mapOf(
        en to "I Still can't hear your answer, I'll repeat:",
        de to "Ich kann Sie immer noch nicht hören, ich wiederhole:",
        zh to "我仍然听不到您的回答, 我将重复："
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_REPLY_REPEAT_QUESTION_VAR2 = mapOf(
        en to "I couldn't hear that, I'll repeat the question...",
        de to "Ich konnte das nicht richtig hören, ich werde die Frage wiederholen ...",
        zh to "我听不到, 我将重复这个问题..."
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_REPLY_REPEAT_QUESTION_VAR3 = mapOf(
        en to "Could you please speak louder?",
        de to "Könnten Sie bitte etwas lauter sprechen?",
        zh to "您能说大声一点吗？"
    )[currentLang]!!

    val GENERAL_REPEATING_QUESTION_VAR1 = mapOf(
        en to "I'll repeat the question,",
        de to "Ich werde die Frage wiederhohlen,",
        zh to "我将重复这个问题："
    )[currentLang]!!

    val GENERAL_REPEATING_QUESTION_VAR2 = mapOf(
        en to " ",
        de to " ",
        zh to " "
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_USE_SCREEN_VAR1 = mapOf(
        en to "I still can't hear you. You can use the screen to input your answer",
        de to "Ich kann Sie immer noch nicht hören. Sie können den Bildschirm zur Eingabe Ihrer Antwort benutzen.",
        zh to "我还是听不到您的声音.您可以在屏幕上输入您的回答"
    )[currentLang]!!

    val GENERAL_NO_RESPONSE_USE_SCREEN_VAR2 = mapOf(
        en to "I can't hear you clearly, try using the touch screen to answer me",
        de to "Ich kann Sie nicht richtig hören. Versuchen Sie den Touchscreen zu benutzen um mir zu antworten.",
        zh to "我听不清楚, 请尝试使用触摸屏回答我"
    )[currentLang]!!

    val GENERAL_ASK_USER_IS_STILL_THERE = mapOf(
        en to "Are you still here?",
        de to "Sind Sie noch da?",
        zh to "您还在这儿吗？"
    )[currentLang]!!

    val GENERAL_USER_NOT_RESPONDING_PROBABLY_GONE_REPLY = mapOf(
        en to "OK, then...",
        de to "Ok, in dem Fall ...",
        zh to "好的, 那么..."
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_REPLY_VAR1 = mapOf(
        en to "I did not understand, could you please repeat that?",
        de to "I konnte Sie nicht verstehen, könnten Sie das bitte wiederholen?",
        zh to "我不明白, 您能再说一遍吗？"
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_REPLY_VAR2 = mapOf(
        en to { text: String -> "I'm not sure I understand what \"$text\" means..." },
        de to { text: String -> "Ich bin mir nicht sicher was \"$text\" bedeutet..." },
        zh to { text: String -> "我不确定我理解\"$text\" 是什么意思..." }
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_REPLY_VAR3 = mapOf(
        en to "What did you say?",
        de to "Was haben Sie gesagt?",
        zh to "您说什么？"
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_REPLY_VAR4 = mapOf(
        en to "Sorry, I didn't get it. Could you please say that again?",
        de to "Entschuldigung, das habe ich nicht verstanden. Könnten Sie das wiederholen?",
        zh to "抱歉, 我没收到.您能再说一遍吗？"
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_ASK_TO_REPEAT_QUESTION = mapOf(
        en to "I still can't understand you. If you want to hear the question again, just say \"repeat\"",
        de to "Ich verstehe Sie immer noch nicht. Wenn Sie die Frage nochmal hören möchten, sagen Sie einfach \"wiederholen\"",
        zh to "我还是听不懂您.如果您希望再听一次, 请说\"重复\""
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_ASK_TO_REPHRASE_ANSWER = mapOf(
        en to "I still can't understand you. Can you please say it in another way?",
        de to "Ich verstehe Sie immer noch nicht. Können Sie es bitte anders ausdrücken?",
        zh to "我还是听不懂您.你能用另一种方式说吗？"
    )[currentLang]!!

    val GENERAL_CANNOT_UNDERSTAND_PLEASE_USE_SCREEN = mapOf(
        en to "I still can not understand your reply. Please use the touchscreen to answer.",
        de to "Ich kann Sie nicht richtig hören. Benutzen Sie den Touchscreen um zu antworten.",
        zh to "我仍然不明白您的答复.请使用触摸屏回答."
    )[currentLang]!!

    val GENERAL_REMIND_TO_MOVE_ON = mapOf(
        en to "Just let me know when you're finished and want to move on by saying \"continue\"",
        de to "Lassen Sie mich einfach wissen wann sie soweit sind indem Sie \"weiter\" sagen",
        zh to "请您结束后让我知道然后继续只需要说\"继续\""
    )[currentLang]!!

    val GENERAL_MOVE_ON_REPLY = mapOf(
        en to "Moving on",
        de to "Fahren wir fort",
        zh to "继续"
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_OK = mapOf(
        en to "OK,",
        de to "Ok,",
        zh to "好的, "
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_THANK_YOU = mapOf(
        en to "OK, Thank you.",
        de to "Ok, Danke.",
        zh to "好的.谢谢您."
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_GOT_IT = mapOf(
        en to "Got it,",
        de to "Verstanden,",
        zh to "明白, "
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_ALRIGHT = mapOf(
        en to "Alright,",
        de to "In Ordnung,",
        zh to "好的, "
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_I_SEE = mapOf(
        en to "I see...",
        de to "Achso",
        zh to "我知道了..."
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_UNDERSTOOD = mapOf(
        en to "Understood,",
        de to "Verstanden,",
        zh to "理解, "
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_AHA = mapOf(
        en to "Uh-huh,",
        de to "$DE_sayUhuh,",
        zh to "嗯, "
    )[currentLang]!!

    val GENERAL_ACKNOWLEDGE_I_UNDERSTAND = mapOf(
        en to "I understand,",
        de to "Ich Verstehe,",
        zh to "我理解了, "
    )[currentLang]!!

    val GENERAL_NEXT_QUESTION_VAR1 = mapOf(
        en to "next...",
        de to "weiter...",
        zh to "接下来..."
    )[currentLang]!!

    val GENERAL_NEXT_QUESTION_VAR2 = mapOf(
        en to "next question",
        de to "nächste Frage",
        zh to "下一个问题"
    )[currentLang]!!

    val GENERAL_NEXT_QUESTION_VAR3 = mapOf(
        en to "going on",
        de to "fahren wir fort",
        zh to "让我们继续"
    )[currentLang]!!

    val GENERAL_NEXT_QUESTION_VAR4 = mapOf(
        en to " ",
        de to " ",
        zh to " "
    )[currentLang]!!

    val GENERAL_POSITIVE_ACKNOWLEDGE_1 = mapOf(
        en to "Good,",
        de to "Gut,",
        zh to "好, "
    )[currentLang]!!

    val GENERAL_POSITIVE_ACKNOWLEDGE_2 = mapOf(
        en to "Great",
        de to "Wunderbar",
        zh to "很好"
    )[currentLang]!!

    val GENERAL_CONFIRM_ABORT = mapOf(
        en to "Do you want to stop this and do something else?",
        de to "Wollen Sie hiermit aufhören und etwas anderes tun?",
        zh to "您是否要停止此操作并做其他事情？"
    )[currentLang]!!

    val GENERAL_CONFIRM_GO_TO_HOME = mapOf(
        en to "Do you want to start the screening again?",
        de to "Möchten Sie die Untersuchung erneut starten?", // machine translation
        zh to "您是否想要重新开始测试？"
    )[currentLang]!!

    val GENERAL_OPTIONS_LIST = mapOf(
        en to { options: Iterable<String> -> "You can answer me with ${options.toConjugatedList(separator = ", ", conjugate = " or ")}. You can also say 'repeat', to ask me to repeat the question; 'stop' to go back; or 'goodbye' to let me know you're leaving." },
        de to { options: Iterable<String> -> "Sie können mir wie folgt antworten: ${options.toConjugatedList(separator = ", ", conjugate = " oder ")} . Sie können auch 'wiederholen' sagen, um mich zu bitten die Frage zu wiederholen; 'stop' um zurück zu gehen; oder 'Auf Widersehen' um mich wissen zu lassen dass sie gehen." },
        zh to { options: Iterable<String> -> "您可以回答我 ${options.toConjugatedList(separator = ", ", conjugate = " 或者 ")}.您同样可以说'重复', 让我重复这个问题; '终止' 来返回; 或者'再见' 来让我知道您离开了." }
    )[currentLang]!!

    val GENERAL_ABOUT_FURHAT = mapOf(
        en to "I'm Linda - a health screening Robot. I was developed by Furhat robotics - a social robotics company located in Stockholm, Sweden. They produce robots like myself, who can interact with humans in a natural way in social situations. Furhat robots, just like me, are already being used around the world, to help people lead happier and more productive lives. For more information, please visit their website. Say \"Continue\" when you want to go back.",
        de to "Ich bin Linda -  ein $DE_sayVoruntersuchungsroboter. Ich bin von $DE_sayFurhat robotics - einer Firma für soziale Robotertechnik aus Stockholm - entwickelt worden. Sie entwickeln $DE_sayRoboter wie mich, die mit Menschen in natürlichen sozialen Situationen interagieren können. $DE_sayFurhat $DE_sayRoboter wie ich werden bereits überall auf der Welt eingesetzt, um Menschen zu helfen gesündere und produktivere Leben zu führen. Für mehr Informationen besuchen Sie bitte unsere Webseite. Sagen Sie \"Weiter\" um zum Menü zurückzukehren.",
        zh to "我是 Linda， 我是一个医疗预检机器人.我是由Furhat 机器人公司开发的, 该公司是位于斯德哥尔摩的社交机器人公司.他们生产像我一样的机器人, 它们可以在社交场合中与人类自然互动.像我一样, Furhat 机器人已经在世界范围内使用, 以帮助人们过上更快乐, 更富有成效的生活.更多相关信息, 请访问其网站.要返回请说“继续”."
    )[currentLang]!!

    val GENERAL_USER_NOT_FAMILIAR_WITH_TERM = mapOf(
        en to "It’s ok if you don’t understand all of these medical terms, we’ll just move on to the next question.",
        de to "Es ist vollkommen in Ordnung falls Sie diese medizinischen Begriffe nicht verstehen, wir gehen einfach zur nächsten Frage über.",
        zh to "如果您不了解所有这些医学术语也没关系, 我们将继续进行下一个问题."
    )[currentLang]!!

    val GENERAL_USER_NOT_FAMILIAR_WITH_TERM_2 = mapOf(
        en to "If you're not sure about some word or symptom, that's fine, let's just go on.",
        de to "Kein Problem, falls Sie sich unsicher sind in hinsicht auf bestimmte Begriffe oder Symptome, lassen Sie uns einfach fort fahren.",
        zh to "如果您不确定某些字词或症状, 没关系, 让我们继续."
    )[currentLang]!!

    val GENERAL_LET_USER_KNOW_WHEN_TO_ANSWER = mapOf(
        en to "Sorry, I didn't hear you. Have you noticed that my lights turn up when I'm listening.",
        de to "Entschuldigung, ich konnte Sie nicht hören. Haben Sie bemerkt, dass meine Lichter aufleuchten wenn ich zuhöre?",
        zh to "抱歉, 我没有听到你的声音.您是否注意到我在聆听时灯亮了."
    )[currentLang]!!

    val GENERAL_ANSWER_NOT_ACCEPTED_REPEAT = mapOf(
        en to "I'm sorry, I don't think I understood you quite right. Can you repeat that?",
        de to "Es tut mir Leid, aber ich habe das nicht richtig verstanden. Können Sie das wiederholen?",
        zh to "抱歉, 我想我没能完全理解您. 您能重复一遍吗?"
    )[currentLang]!!

    val GENERAL_CONTINUE_ANYWAY = mapOf(
        en to "Would you like to continue anyway?",
        de to "Wollen Sie trotzdem fortfahren?",
        zh to "您想要继续吗?"
    )[currentLang]!!

    val GENERAL_RESTART = mapOf(
        en to "Restart",
        de to "Neustart",
        zh to "重启"
    )[currentLang]!!


    // Change Language

    val CHANGE_LANGUAGE_SUPPORT = mapOf(
        en to "No problem!",
        de to "Klar",
        zh to "当然！" // "no problem": 没问题 // "of-course": 当然
    )[currentLang]!!

    val CHANGE_LANGUAGE_NO_SUPPORT = mapOf(
        en to "I'm sorry, i dont support that language.",
        de to "Es tut mir leid, aber diese Sprache spreche ich nicht.",
        zh to "对不起, 我不支持该语言."
    )[currentLang]!!

    val CHANGE_LANGUAGE_SOUNDS_BETTER = mapOf(
        en to "I hope this sounds better!",
        de to "Ich hoffe das klingt besser!",
        zh to "我想这听起来很棒！"
    )[currentLang]!!

    val CHANGE_LANGUAGE_KOREAN = mapOf(
        en to "So far, I only speak mandarin, english and german.",
        de to "Bis jetzt spreche ich nur Chinesisch, Englisch und Deutsch.",
        zh to "目前为止,我只会说中文,英语和德语."
    )[currentLang]!!


    // Introduction

    val INTRODUCTION_WELCOME_TITLE = mapOf(
        en to "Welcome!",
        de to "Guten Tag!",
        zh to "欢迎！"
    )[currentLang]!!

    val INTRODUCTION_GREETING = mapOf(
        en to "Welcome, I'm Linda - a health screening Robot.",
        de to "Guten Tag, Ich bin Linda - ein $DE_sayVoruntersuchungsroboter.",
        zh to "我是 Linda， 我是一个医疗预检机器人"
    )[currentLang]!!

    val INTRODUCTION_ALL_DONE = mapOf(
        en to "You have completed the screening. Would you like to repeat it?",
        de to "Sie haben die Voruntersuchung abgeschlossen. Möchten Sie sie noch einmal durchführen?",
        zh to "您已经完成了检查.您想要再重复一遍吗？"
    )[currentLang]!!

    val INTRODUCTION_DIABETES = mapOf(
        en to "I’m here to help you check if you are at risk of developing diabetes. First, can I tell you a bit about why this is important?",
        de to "Ich bin hier, um Ihr $DE_sayDiabetesrisiko zu testen. Bevor wir beginnen, soll ich Ihnen ein wenig darüber erzählen warum dies wichtig ist?",
        zh to "我在这里帮助您检查您是否有患糖尿病的风险.首先, 我可以告诉您为什么这很重要吗？"
    )[currentLang]!!

    val INTRODUCTION_DIABETES_PROMPT = mapOf(
        en to INTRODUCTION_DIABETES,
        de to "Ich bin hier, um Ihr diabetesrisiko zu testen. Bevor wir beginnen, soll ich Ihnen ein wenig darüber erzählen warum dies wichtig ist?",
        zh to INTRODUCTION_DIABETES
    )[currentLang]!!

    val INTRODUCTION_USER_SAID_YES_BUT_NOT_SELECTED = mapOf(
        en to "Please tell me which screening you would like to take.",
        de to "Bitte teilen Sie mir mit welche Voruntersuchung Sie machen wollen.",
        zh to "请告诉我您想要进行哪种检查"
    )[currentLang]!!

    val INTRODUCTION_REPEAT_OPTIONS_VAR1 = mapOf(
        en to "Would you like to know more about Diabetes, before we start the screening?",
        de to "Möchten Sie mehr über $DE_sayDiabetes wissen, bevor wir mit dem Test beginnen?",
        zh to "在开始检查之前, 您想了解有关糖尿病的更多信息吗？"
    )[currentLang]!!

    val INTRODUCTION_REPEAT_OPTIONS_VAR2 = mapOf(
        en to "I can perform a screening for diabetes, would you like me to tell you more about Diabetes?",
        de to "Ich kann Sie auf $DE_sayDiabetes untersuchen. Soll ich damit fortfahren?",
        zh to "我可以进行糖尿病检查, 你想告诉我更多有关糖尿病的信息吗？"
    )[currentLang]!!

    val INTRODUCTION_INVALID_RESPONSE_VAR1 = mapOf(
        en to "I'm sorry, I can't help you with that.",
        de to "Es tut mir sehr Leid, aber damit kann ich Ihnen nicht helfen.",
        zh to "很抱歉, 我不能帮您."
    )[currentLang]!!

    val INTRODUCTION_INVALID_RESPONSE_VAR2 = mapOf(
        en to "I am not familiar with that.",
        de to "Damit bin ich nicht vertraut.",
        zh to "我不是很熟悉."
    )[currentLang]!!

    val INTRODUCTION_INVALID_RESPONSE_VAR3 = mapOf(
        en to "That's beyond my capabilities",
        de to "Das übersteigt meine Fähigkeiten.",
        zh to "这超出了我的能力."
    )[currentLang]!!

    val INTRODUCTION_OLD_SCREENING = mapOf(
        en to "I am sorry, but I don't do this anymore.",
        de to "Es tut mir sehr Leid, aber das mache ich nicht mehr.",
        zh to "很抱歉, 我不能再这样做了."
    )[currentLang]!!

    val INTRODUCTION_SAY_GOODBYE = mapOf(
        en to "Thank you for participating! Goodbye!",
        de to "Vielen dank für Ihre Teilnahme! Auf Wiedersehen!",
        zh to "感谢您的参与！再见！"
    )[currentLang]!!

    val INTRODUCTION_SAY_GOODBYE_PROMPT = INTRODUCTION_SAY_GOODBYE

    val INTRODUCTION_GOODBYE_TITLE_PROMPT = mapOf(
        en to "Goodbye!",
        de to "Auf Wiedersehen!",
        zh to "再见！"
    )[currentLang]!!

    val INTRODUCTION_DIABETES_DESCRIPTION = mapOf(
        en to "Diabetes is a group of diseases characterized by high blood sugar levels. There are two main types of diabetes. Type 1 and type 2. Early stages of type 2 diabetes seldom cause any symptoms. So it’s important to check yourself for the risk factors.",
        de to "$DE_sayDiabetes ist eine Gruppe von Krankheiten charakterisiert durch hohe Blutzuckerwerte. Es gibt zwei Haupttypen von $DE_sayDiabetes. Typ 1 und Typ 2. Im Frühstadium ruft Typ 2 $DE_sayDiabetes oft noch keine Symptome hervor. Daher ist es wichtig, die Risikofaktoren für $DE_sayDiabetes zu überprüfen.",
        zh to "糖尿病是一组以高血糖为特征的疾病.主要有两种糖尿病的类型.1型和2型.2型糖尿病早期很少引起任何症状.因此检查自己是否有糖尿病的危险因素是很重要的."
    )[currentLang]!!

    val INTRODUCTION_DIABETES_DESCRIPTION_PROMPT = mapOf(
        en to INTRODUCTION_DIABETES_DESCRIPTION,
        de to "Diabetes ist eine Gruppe von Krankheiten charakterisiert durch hohe Blutzuckerwerte. Es gibt zwei Haupttypen von Diabetes. Typ 1 und Typ 2. Im Frühstadium ruft Typ 2 Diabetes oft noch keine Symptome hervor. Daher ist es wichtig, die Risikofaktoren für Diabetes zu überprüfen.",
        zh to INTRODUCTION_DIABETES_DESCRIPTION
    )[currentLang]!!

    val INTRODUCTION_DIABETES_NO_DESCRIPTION = mapOf(
        en to "Ok. Then we will skip directly to the questions.",
        de to "Ok. Also gehen wir gleich zu den Fragen über.",
        zh to "好的.那我们将直接跳转到问题."
    )[currentLang]!!

    val INTRODUCTION_DESCRIPTION_OPTION_PROMPT = mapOf(
        en to "This screening and this risk assessment is based on the FINDRISK screening test designed by Professor Jaakko Tuomilehto at the department of Public Health, University of Helsinki and Jaana Lindström, MFS, National Public Health Institute. The screening might not be validated in your specific country. If you would like to know more, ask your doctor.",
        de to "Dieser Test beruht auf dem FINDRISK screening, das von Professor Jaakko Tuomilehto von der Universität von Helsinki und von Jaana Lindström, vom Institut für Volksgesundheit in Finnland entwickelt wurde. Das screening ist nicht für alle Länder weltweit validiert, bitte fragen Sie im Zweifel Ihren Arzt.",
        zh to "这项检查和风险评估是基于赫尔辛基大学公共卫生系Jaakko Tuomilehto 教授和国家公共卫生研究院MFS 的JaanaLindström 设计的FINDRISK 检查测试.该项检查可能未在参与者所在的国家/地区进行验证.如果您不确定，请咨询您的医生."
    )[currentLang]!!

    val INTRODUCTION_DESCRIPTION_OPTION_YES = mapOf(
        en to "Yes, tell me more",
        de to "Ja, erzähl mir mehr darüber",
        zh to "好的, 告诉我更多"
    )[currentLang]!!

    val INTRODUCTION_DESCRIPTION_OPTION_NO = mapOf(
        en to "No, start screening",
        de to "Nein, starte die Voruntersuchung",
        zh to "不用, 开始检查"
    )[currentLang]!!

    val INTRODUCTION_START_OVER = mapOf(
        en to "Would you like to do the screening again?",
        de to "Möchten Sie das Screening erneut durchführen?",
        zh to "您想要再次进行检查吗？"
    )[currentLang]!!

    val INTRODUCTION_START_OVER_PROMPT = INTRODUCTION_START_OVER

    val INTRODUCTION_START_OVER_CONFIRMED = mapOf(
        en to "Alright, then let's start over.",
        de to "Prima, dann nochmal von vorne.",
        zh to "好的, 那我们重新开始吧."
    )[currentLang]!!


    // Question / Scenes

    val DIABETES_GETTING_STARTED = mapOf(
        en to "Let's get started.",
        de to "Lassen Sie uns beginnen.",
        zh to "让我们开始吧."
    )[currentLang]!!

    val DIABETES_STARTING_SCREEN_TITLE = mapOf(
        en to "Diabetes Screening",
        de to "$DE_sayDiabetes Voruntersuchung",
        zh to "糖尿病检查."
    )[currentLang]!!

    val DIABETES_DISCLAIMER = mapOf(
        en to "In this screening I will ask you questions about your health and score you on the risk of developing type-2 diabetes. All your answers will be deleted right after the screening is finished. And remember - I'm not a doctor so the results will only be an indicator. Do you understand?",
        de to "In dieser Untersuchung werde ich Ihnen Fragen über Ihre Gesundheit stellen und Ihr Risiko Typ-2 $DE_sayDiabetes zu entwickeln bewerten. Alle Ihre Antworten werden nach dem Abschluss der Untersuchung sofort gelöscht. Bitte seien Sie sich bewusst, dass ich kein Arzt bin und die Resultate lediglich als Hinweise zu betrachten sind. Haben Sie mich verstanden?",
        zh to "在此次检查中我将会问与您健康有关的问题,并且对患2型糖尿病的风险进行评分.检查完成后您的所有答案都将被删除.请记住-我不是医生所以结果仅仅是一个参考.您理解了吗？"
    )[currentLang]!!

    val DIABETES_DISCLAIMER_PROMPT = mapOf(
        en to DIABETES_DISCLAIMER,
        de to "In dieser Untersuchung werde ich Ihnen Fragen über Ihre Gesundheit stellen und Ihr Risiko Typ-2 diabetes zu entwickeln bewerten. Alle Ihre Antworten werden nach dem Abschluss der Untersuchung sofort gelöscht. Bitte seien Sie sich bewusst, dass ich kein Arzt bin und die Resultate lediglich als Hinweise zu betrachten sind. Haben Sie mich verstanden?",
        zh to DIABETES_DISCLAIMER
    )[currentLang]!!

    val DIABETES_DISCLAIMER_REFUSED = mapOf(
        en to "Oh, ok... Then I can unfortunately not continue with the screening. Please talk to one of my human colleagues, they can answer any questions you might have. Then you could come back. It was nice to meet you, good bye.",
        de to "In Ordnung, kein Problem. Bitte sprechen Sie mit einem meiner menschlichen Kollegen, die Ihnen sicher alle Ihre Fragen beantworten können. Danach können wir gern wieder miteinander reden. Es war nett, Sie kennen zu lernen. Bis bald!",
        zh to "哦,好的…那我就不能再继续检查了.请与一位人类同事谈谈,他们可以回答您可能遇到的任何问题.然后您可以再回来.很高兴见到您,再见."
    )[currentLang]!!

    val DIABETES_DISCLAIMER_REFUSED_PROMPT = DIABETES_DISCLAIMER_REFUSED

    val DIABETES_DISCLAIMER_I_UNDERSTAND = mapOf(
        en to "I understand",
        de to "Ich verstehe",
        zh to "我理解"
    )[currentLang]!!

    val DIABETES_DISCLAIMER_HELP_OPTION_1 = mapOf(
        en to "Yes if you understand and agree",
        de to "Ja, falls Sie verstanden haben und zustimmen",
        zh to "是的, 如果您理解并同意"
    )[currentLang]!!

    val DIABETES_DISCLAIMER_HELP_OPTION_2 = mapOf(
        en to "No otherwise",
        de to "Nein falls nicht ",
        zh to "其他的没有"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_QUESTION_1 = mapOf(
        en to "Have you already been diagnosed with diabetes?",
        de to "Wurde bei Ihnen bereits $DE_sayDiabetes diagnostiziert?",
        zh to "您已经被诊断出患有糖尿病了吗？"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_QUESTION_1_PROMPT = mapOf(
        en to DIABETES_ALREADY_DIAGNOSED_QUESTION_1,
        de to "Wurde bei Ihnen bereits diabetes diagnostiziert?",
        zh to DIABETES_ALREADY_DIAGNOSED_QUESTION_1
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_QUESTION_2 = mapOf(
        en to "Ok. Then this will not be a reliable screening. Do you want to continue anyway?",
        de to "Okay. Dann ist dies keine zuverlässige Untersuchung. Möchten Sie trotzdem fortfahren?",
        zh to "好的.那么这将不是可靠的检查.您是否仍要继续呢？"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_QUESTION_2_PROMPT = DIABETES_ALREADY_DIAGNOSED_QUESTION_2

    val DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_1 = mapOf(
        en to "I have",
        de to "ich habe",
        zh to "我要"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_2 = mapOf(
        en to "I was",
        de to "wurde es",
        zh to "我是"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_3 = mapOf(
        en to "I do",
        de to "wurde ich",
        zh to "我做"
    )[currentLang]!!

    val DIABETES_ALREADY_DIAGNOSED_EXTRA_YES_4 = mapOf(
        en to "I want to",
        de to "ich war",
        zh to "我想要"
    )[currentLang]!!

    val SEX_QUESTION = mapOf(
        en to "Are you male or female?",
        de to "Sind Sie männlich oder weiblich?",
        zh to "您是男性还是女性?"
    )[currentLang]!!

    val SEX_QUESTION_PROMPT = SEX_QUESTION

    val SEX_QUESTION_MALE = mapOf(
        en to "Male",
        de to "Männlich",
        zh to "男性"
    )[currentLang]!!

    val SEX_QUESTION_FEMALE = mapOf(
        en to "Female",
        de to "Weiblich",
        zh to "女性"
    )[currentLang]!!

    val DIABETES_SEX_QUESTION_BIOLOGICAL_SEX = mapOf(
        en to "For medical purposes, please specify your biological sex.",
        de to "Für medizinische Zwecke, spezifizieren sie bitte ihr biologisches Geschlechtt.",
        zh to "出于医疗目的, 请表明您的生理性别."
    )[currentLang]!!

    val DIABETES_PREGNANT_QUESTION_1 = mapOf(
        en to "Are you currently pregnant?",
        de to "Sind Sie schwanger?",
        zh to "您现在怀孕了吗?"
    )[currentLang]!!

    val DIABETES_PREGNANT_QUESTION_1_PROMPT = DIABETES_PREGNANT_QUESTION_1

    val DIABETES_PREGNANT_QUESTION_2 = mapOf(
        en to "Ok. Then this will not be a reliable screening. Do you want to continue anyway?",
        de to "Okay. Dann ist dies keine zuverlässige Untersuchung. Möchten Sie trotzdem fortfahren?",
        zh to "好的，我们将没法得到一个精确的检验结果。请问你仍然希望继续吗?"
    )[currentLang]!!

    val DIABETES_PREGNANT_QUESTION_2_PROMPT = DIABETES_PREGNANT_QUESTION_2

    val DIABETES_PREGNANT_EXTRA_YES_1 = mapOf(
        en to "I am",
        de to "ja bin ich",
        zh to "是的"
    )[currentLang]!!

    val DIABETES_AGE_QUESTION = mapOf(
        en to "How old are you?",
        de to "Wie alt sind Sie in Jahren?",
        zh to "你多大了呢？"
    )[currentLang]!!

    val DIABETES_AGE_QUESTION_PROMT = mapOf(
        en to "your age in years",
        de to "Ihr Alter in Jahren",
        zh to "您的年龄"
    )[currentLang]!!

    val DIABETES_AGE_OPTION1 = mapOf(
        en to "Younger than 45",
        de to "Jünger als 45",
        zh to "小于45 岁"
    )[currentLang]!!

    val DIABETES_AGE_OPTION2 = mapOf(
        en to "45 or older but younger than 54",
        de to "45 oder älter, aber jünger als 54",
        zh to "大于45 岁但小于54 岁"
    )[currentLang]!!

    val DIABETES_AGE_OPTION3 = mapOf(
        en to "55 or older but younger than 64",
        de to "55 oder älter, aber jünger als 64",
        zh to "大于55 岁但小于64 岁"
    )[currentLang]!!

    val DIABETES_AGE_OPTION4 = mapOf(
        en to "65 or older",
        de to "65 oder älter",
        zh to "65 岁以上"
    )[currentLang]!!

    val DIABETES_AGE_INVALID_ANSWER_1 = mapOf(
        en to "Your age must be a positive number!",
        de to "Ihr Alter muss eine positive Zahl sein!",
        zh to "您的年龄必须是正数！"
    )[currentLang]!!

    val DIABETES_AGE_INVALID_ANSWER_2 = mapOf(
        en to "You must be at least 18 or older to continue this test.",
        de to "Sie müssen mindestens 18 oder älter sein um diesen Test fortzusetzen.",
        zh to "您必须年满18 岁或以上才能继续此检查."
    )[currentLang]!!

    val DIABETES_AGE_INVALID_ANSWER_3 = mapOf(
        en to "Good one! you're probably not that old, try again",
        de to "Guter Witz! Sie sind höchst wahrscheinlich nicht ganz so alt. Versuchen Sie es noch einmal",
        zh to "好的！您可能还不够大, 请重试"
    )[currentLang]!!

    val DIABETES_AGE_INVALID_ANSWER_4 = mapOf(
        en to "I couldn't get it",
        de to "Wie bitte?",
        zh to "我不明白"
    )[currentLang]!!

    val DIABETES_AGE_ESTIMATE = mapOf(
        en to "If you're not sure what your age is, please estimate",
        de to "Falls Sie nicht genau wissen, wie alt Sie sind, schätzen sie bitte.",
        zh to "如果不确定自己的年龄, 请估算一下"
    )[currentLang]!!

    val DIABETES_HEIGHT_QUESTION = mapOf(
        en to "So, how tall are you in centimeters?",
        de to "Also, wie groß sind Sie in Zentimetern?",
        zh to "那么，您的身高是多少厘米？"
    )[currentLang]!!

    val DIABETES_HEIGHT_QUESTION_PROMT = mapOf(
        en to "How tall are you in centimeters?",
        de to "Wie groß sind Sie in Zentimetern?",
        zh to "您的身高是多少厘米?"
    )[currentLang]!!

    val DIABETES_HEIGHT_ALTERNATIVE_1 = mapOf(
        en to "Less than 160 cm",
        de to "Weniger als 160 cm",
        zh to "低于160 厘米"
    )[currentLang]!!

    val DIABETES_HEIGHT_ALTERNATIVE_2 = mapOf(
        en to "160-180 cm",
        de to "160-180 cm",
        zh to "160 到180 厘米"
    )[currentLang]!!

    val DIABETES_HEIGHT_ALTERNATIVE_3 = mapOf(
        en to "180-200 cm",
        de to "180-200 cm",
        zh to "180 到200 厘米"
    )[currentLang]!!

    val DIABETES_HEIGHT_ALTERNATIVE_4 = mapOf(
        en to "More than 200 cm",
        de to "Mehr als 200 cm",
        zh to "高于200 厘米"
    )[currentLang]!!

    val DIABETES_WEIGHT_QUESTION = mapOf(
        en to "How much do you weigh, in kilos?",
        de to "Wie viel wiegen Sie in Kilogramm?",
        zh to "您的体重是多少公斤？"
    )[currentLang]!!

    val DIABETES_WEIGHT_QUESTION_PROMT = mapOf(
        en to "How much do you weigh?",
        de to "Wie viel wiegen Sie?",
        zh to "您有多重呢？"
    )[currentLang]!!

    val DIABETES_WEIGHT_ALTERNATIVE_1 = mapOf(
        en to "Less than 60 kg",
        de to "Weniger als 60 kg",
        zh to "低于60 公斤"
    )[currentLang]!!

    val DIABETES_WEIGHT_ALTERNATIVE_2 = mapOf(
        en to "60-80 kg",
        de to "60-80 kg",
        zh to "60 到80 公斤"
    )[currentLang]!!

    val DIABETES_WEIGHT_ALTERNATIVE_3 = mapOf(
        en to "80-100 kg",
        de to "80-100 kg",
        zh to "80 到100 公斤"
    )[currentLang]!!

    val DIABETES_WEIGHT_ALTERNATIVE_4 = mapOf(
        en to "More than 100 kg",
        de to "Mehr als 100 kg",
        zh to "高于100 公斤"
    )[currentLang]!!

    val DIABETES_WEIGHT_EXCEEDED = mapOf(
        en to "I'm sorry, This screening is only reliable for weights up to 200 kilos.",
        de to "Es tut mir Leid, aber diese Voruntersuchung ist nur für ein Körpergewicht bis zu 200 kg ausgelegt.",
        zh to "我很抱歉, 这项检查仅适用于200公斤以下的重量."
    )[currentLang]!!

    val DIABETES_PHYSICAL_ACTIVITY_QUESTION = mapOf(
        en to "Would you say you get, at least, 30 minutes of physical activity per day?",
        de to "Würden Sie sagen dass Sie mindestens 30 Minuten Bewegung pro Tag haben?",
        zh to "您是否每天至少要进行30分钟的运动？"

    )[currentLang]!!

    val DIABETES_PHYSICAL_ACTIVITY_QUESTION_PROMPT = DIABETES_PHYSICAL_ACTIVITY_QUESTION

    val DIABETES_PHYSICAL_ACTIVITY_EXPLAIN = mapOf(
        en to "A daily physical activity is something when you are activating your body and not sitting still. Do you get at least 30 minutes of physical activity daily? ",
        de to "Mit Bewegung meine ich alle Arten der körperlichen Anstrengung, also nicht still sitzen. Haben Sie davon mindestens 30 Minuten am Tag?",
        zh to "日常体育锻炼就是当您活动自己的身体而不是坐着不动.您每天至少进行30分钟的体育锻炼吗?"
    )[currentLang]!!

    val DIABETES_FAMILY_HISTORY_QUESTION_1 = mapOf(
        en to "Has a relative of yours been diagnosed with diabetes?",
        de to "Wurde einer ihrer Verwandten mit $DE_sayDiabetes diagnostiziert?",
        zh to "您是否有亲戚被诊断出患有糖尿病呢？"
    )[currentLang]!!

    val DIABETES_FAMILY_HISTORY_QUESTION_2 = mapOf(
        en to "And how are you related?",
        de to "Wie sind Sie verwandt miteinander?",
        zh to "那他跟您是什么关系？"
    )[currentLang]!!

    val DIABETES_FAMILY_HISTORY_QUESTION_PROMT = mapOf(
        en to "Do you have a relative diagnosed with diabetes?",
        de to "Haben Sie Verwandte mit diabetes?",
        zh to "您有亲戚被诊断患有糖尿病吗？"
    )[currentLang]!!

    val DIABETES_FAMILY_HISTORY_ALTERNATIVE_1 = mapOf(
        en to "Yes, Close Relative",
        de to "Ja, nahe Verwandte",
        zh to "有的, 近亲"
    )[currentLang]!!

    val DIABETES_FAMILY_HISTORY_ALTERNATIVE_2 = mapOf(
        en to "Yes, Distant Relative",
        de to "Ja, entfernte Verwandte",
        zh to "有的, 远亲"
    )[currentLang]!!

    val DIABETES_VEGETABLES_QUESTION = mapOf(
        en to "Do you eat fruit, vegetables or berries every day?",
        de to "Essen Sie täglich Obst, Gemüse oder Beeren?",
        zh to "您每天吃水果, 蔬菜或浆果吗？"
    )[currentLang]!!

    val DIABETES_VEGETABLES_QUESTION_PROMPT = DIABETES_VEGETABLES_QUESTION

    val DIABETES_BLOOD_PRESSURE_MEDICATION_QUESTION = mapOf(
        en to "Have you ever taken medication for high blood pressure on a regular basis?",
        de to "Haben Sie jemals regelmäßig Medikamente gegen erhöhten Blutdruck genommen?",
        zh to "您是否曾经定期服用过高血压药物？"
    )[currentLang]!!

    val DIABETES_BLOOD_GLUCOSE_QUESTION_1 = mapOf(
        en to "Have you ever been tested for high blood glucose",
        de to "Sind Sie jemals auf erhöhten Blutzucker getestet worden?",
        zh to "您是否接受过高血糖测试?"
    )[currentLang]!!

    val DIABETES_BLOOD_GLUCOSE_QUESTION_2 = mapOf(
        en to "Did you have high blood glucose?",
        de to "Hatten Sie erhöhten Blutzucker?",
        zh to "您的血糖高吗？"
    )[currentLang]!!

    val DIABETES_BLOOD_GLUCOSE_QUESTION_PROMT = mapOf(
        en to "Have you been tested for high blood glucose?",
        de to "Sind Sie für erhöhten Blutzucker getestet worden?",
        zh to "您是否接受过高血糖测试？"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_MALE_QUESTION = mapOf(
        en to "For the next question I need you to measure your waist circumference. Pull the measuring strap around your waist and measure how many centimeters you get. Take your time.",
        de to "Für die nächste Frage müssen Sie den Umfang Ihrer Taille messen. Ziehen Sie das $DE_sayMasband um Ihre Taille und messen Sie wie viele Zentimeter Taillenumfang Sie haben. Nehmen Sie sich Zeit",
        zh to "对于下一个问题, 我需要您测量您的腰围.请将测量带拉到您的腰部, 并测量您的腰围是多少厘米.慢慢来."
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_FEMALE_QUESTION = DIABETES_WAIST_CIRCUMFERENCE_MALE_QUESTION

    val DIABETES_WAIST_CIRCUMFERENCE_MALE_OPTION1 = mapOf(
        en to "Less than 94 cm",
        de to "Weniger als 94 cm",
        zh to "小于94 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_MALE_OPTION2 = mapOf(
        en to "94-102 cm",
        de to "94-102 cm",
        zh to "94 到102 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_MALE_OPTION3 = mapOf(
        en to "More than 102 cm",
        de to "Mehr als 102 cm",
        zh to "大于102 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_FEMALE_OPTION1 = mapOf(
        en to "Less than 80 cm",
        de to "Weniger als 80 cm",
        zh to "小于80 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_FEMALE_OPTION2 = mapOf(
        en to "80-88 cm",
        de to "80-88 cm",
        zh to "80 到88 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_FEMALE_OPTION3 = mapOf(
        en to "More than 88 cm",
        de to "Mehr als 88 cm",
        zh to "大于88 厘米"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_2 = mapOf(
        en to "How many centimeters did you measure?",
        de to "Wie viele Zentimeter haben Sie gemessen?",
        zh to "您测量出多少厘米？"
    )[currentLang]!!

    val DIABETES_WAIST_CIRCUMFERENCE_PROMPT = mapOf(
        en to "What is your waist circumference?",
        de to "Was ist Ihr Taillenumfang?",
        zh to "您的腰围是多少？"
    )[currentLang]!!

    val DIABETES_READ_RESULTS_1 = mapOf(
        en to "That was the last question. See the screen for your result. And as I said in the beginning, I'm not a doctor so the results are only an indicator. Take your time, and if you are concerned about your result from this screening, please contact your doctor for a more accurate assessment of your health. Thank you for participating.",
        de to "Dies war die letzte Frage. Schauen Sie auf den Bildschirm um Ihr Resultat zu sehen. Wie schon gesagt, ich bin kein Arzt und das Resultat ist nur als Hinweis zu verstehen. Nehmen Sie sich Zeit, und falls Sie sich wegen ihres Ergebnisses Sorgen machen, kontaktieren Sie bitte Ihren Arzt oder Ihre Ärztin für eine genauere Beurteilung Ihres Gesundheitszustandes. Vielen Dank für Ihre Teilnahme.",
        zh to "那是最后一个问题.查看屏幕上的结果.正如我刚开始所说的, 我不是医生, 所以结果仅供参考.别着急, 如果您担心此检查的结果, 请与您的医生联系, 以更准确地评估您的健康状况.感谢您的参与."
    )[currentLang]!!

    val DIABETES_READ_RESULTS_2 = mapOf(
        en to "You can see the results, and more information about diabetes on the screen below. If you would like a more accurate assessment of your health, you should contact your doctor. Take your time, and let me known if you want to continue.",
        de to "Sie können Ihr Voruntersuchungsresultat und mehr Informationen über $DE_sayDiabetes auf den Bildschirm unter mir ablesen. Falls Sie eine genauere Beurteilung ihres Gesundheitszustandes wünschen, sollten Sie Ihren Arzt oder Ihre Ärztin kontaktieren.",
        zh to "您可以在下面的屏幕上查看结果以及有关糖尿病的更多信息.如果您想更准确地评估自己的健康状况, 应该联系医生.别着急, 如果您想继续, 请告诉我."
    )[currentLang]!!

    val DIABETES_RESTART_TEST_OPTIONS_NO = mapOf(
        en to "No",
        de to "Nein",
        zh to "不用"
    )[currentLang]!!


    // Explanation questions / answeres

    val QUESTION_DIABETES = mapOf(
        en to "diabetes",
        de to "$DE_sayDiabetes ",
        zh to "糖尿病"
    )[currentLang]!!

    val QUESTION_PHYSICAL_ACTIVITY = mapOf(
        en to "physical activity",
        de to "Bewegung",
        zh to "体育活动"
    )[currentLang]!!

    val QUESTION_HIGH_BLOOD_PRESSURE = mapOf(
        en to "high blood pressure",
        de to "hoher Blutdruck",
        zh to "高血压"
    )[currentLang]!!

    val QUESTION_NAME = mapOf(
        en to "name",
        de to "Name",
        zh to "姓名"
    )[currentLang]!!

    val QUESTION_YOUR_QUEST = mapOf(
        en to "your quest",
        de to "Ihre Suche",
        zh to "您的问卷"
    )[currentLang]!!

    val EXPLANATION_DIABETES = mapOf(
        en to "diabetes is a disease in which the body’s ability to produce or respond to the hormone insulin is impaired, ",
        de to "$DE_sayDiabetes ist eine Krankheit, bei der die Fähigkeit des Körpers Insulin herzustellen oder es zu nutzen zu reagieren eingeschränkt ist.",
        zh to "糖尿病是一种人体产生或响应激素胰岛素的能力受损的疾病,  "
    )[currentLang]!!

    val EXPLANATION_PHYSICAL_ACTIVITY = mapOf(
        en to "Physical activity simply means movement of the body that uses energy. Walking, gardening, briskly pushing a baby stroller, climbing the stairs, playing soccer, or dancing the night away are all good examples of being active.",
        de to "Bewegung bedeutet, in diesem Kontext, körperliche Bewegung die Energie benötigt. Spazierengehen, den Garten bestellen, das flotte Schieben eines Kinderwagens, Treppensteigen, Fussballspielen oder durch die Nacht zu tanzen sind gute Beispiele.",
        zh to "体育活动只是意味着身体消耗能量的运动.散步, 园艺, 轻快地推婴儿车, 爬楼梯, 踢足球或在夜晚跳舞都属于这个范畴."
    )[currentLang]!!

    val EXPLANATION_HIGH_BLOOD_PRESSURE = mapOf(
        en to "You probably have high blood pressure if your blood pressure readings are consistently 140 over 90, or higher, over a number of weeks.",
        de to "Sie haben vermutlich erhöhten Blutdruck, falls ihre Blutdruckmessungen über mehrere Wochen regelmäßig 140 über 90, oder mehr ergeben.",
        zh to "如果您的血压读数在几周内始终保持在90 以上或更高的140 上, 则可能患有高血压."
    )[currentLang]!!

    val EXPLANATION_NAME = mapOf(
        en to "My name is Petra",
        de to "Mein Name ist Petra",
        zh to "我的名字是Petra"
    )[currentLang]!!

    val EXPLANATION_YOUR_QUEST = mapOf(
        en to "I provide a pre-screening experience for diabetes",
        de to "Ich biete eine Voruntersuchung für $DE_sayDiabetes an",
        zh to "我提供糖尿病的预检查"
    )[currentLang]!!

    val CHANGE_TO_LANGUAGE_EN = "Change to English"
    val CHANGE_TO_LANGUAGE_DE = "Wechsle zu Deutsch" // #TODO review - google translated
    val CHANGE_TO_LANGUAGE_ZH = "改成中文" // #TODO review - google translated
}

/* improve pronunciations */
// to maintain how the company name sounds, and reduce the effect of accent/localisation:
val DE_sayFurhat = "<phoneme alphabet=\"ipa\" ph=\"f'ɜʀ.ha:tt\">Furhat</phoneme>"
// to make it sound reasonably okay:
val DE_sayUhuh = "<phoneme alphabet=\"ipa\" ph=\"ʌ'ɦʌ\">uh-huh</phoneme>"
// to make it sound like a german speaker would say it:
val DE_sayDiabetes = "<phoneme alphabet=\"ipa\" ph=\"diaˈbeːtɛs\">Diabetes</phoneme>"
val DE_sayDiabetesrisiko = "<phoneme alphabet=\"ipa\" ph=\"diaˈbeːtɛs.risiko\">diabetesrisiko</phoneme>"
val DE_sayRoboter = "<phoneme alphabet=\"ipa\" ph=\"ˈʁɔbɔtɐ\">roboter</phoneme>"
val DE_sayVoruntersuchungsroboter = "<phoneme alphabet=\"ipa\" ph=\"Voruntersuchungsˈʁɔbɔtɐ\">voruntersuchungsroboter</phoneme>"
val DE_sayMasband = "<phoneme alphabet=\"ipa\" ph=\"ˈmaːsbant\">maßband</phoneme>"
// to make it sound like an english-speaker would say it:
val DE_sayPerformance = "<phoneme alphabet=\"ipa\" ph=\"pə.ˈfɔː.məns\">performance</phoneme>"
val DE_sayMaterials = "<phoneme alphabet=\"ipa\" ph=\"mɐ̯'t'i:i:i:ʀiəlz\">materials</phoneme>"
val DE_sayHealthcare = "<phoneme alphabet=\"ipa\" ph=\"hɛlθ.kɛə\">Healthcare</phoneme>"
val DE_sayLife = "<phoneme alphabet=\"ipa\" ph=\"laɪf\">Life</phoneme>"