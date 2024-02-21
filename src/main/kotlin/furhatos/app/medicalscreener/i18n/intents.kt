package furhatos.app.medicalscreener.i18n

import furhatos.app.medicalscreener.currentLang
import furhatos.app.medicalscreener.nlu.CustomNumber
import furhatos.nlu.Intent
import furhatos.util.Language

class Yes : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "好的",
                "好的谢谢",
                "好的",
                "当然",
                "当然了",
                "我想是的",
                "是的",
                "是得我有",
                "是",
                "当然",
                "有",
                "要", // is a homophone, although it actually means "i want"
                "一定地",
                "我愿意",
                "经常",
                "的确如此",
                "好吧",
                "OK", "可以了",
                "接受"
            )
            Language.SWEDISH -> listOf(
                "Ja",
                "Jag",
                "Ja, tack",
                "Mhm",
                "Säkert",
                "Absolut",
                "Jag tror det",
                "Jag tycker det",
                "Ja, jag vill",
                "Ja, det vill jag",
                "Ja, det har jag",
                "Japp",
                "Absolut",
                "Definitivt",
                "Det gör jag",
                "Ofta",
                "Mycket gärna",
                "Gärna",
                "Med nöje",
                "OK", "Okej", "I ordning",
                "Bra",
                "yes",
                "yes please",
                "yeah",
            )
            else -> listOf(
                "yes",
                "yes please",
                "yeah",
                "sure",
                "absolutely",
                "I think so",
                "yes I do",
                "yes I have",
                "yep",
                "you bet",
                "sometimes",
                "definitely",
                "alright", "all right", // "alright", and homophones.
                "I do",
                "from time to time",
                "once in a while",
                "occasionally",
                "often",
                "very much so",
                "i would say so",
                "why not",
                "OK", "okay",
                "fine"
            )
        }
}

class No: Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "没有",
                "mail", // homphone for "mei you" above
                "不行",
                "没什么",
                "不",
                "不仅如此",
                "不是",
                "不是的",
                "不一定",
                "从不",
                "不需要了",
                "不要了",
                "没有什么",
                "拒绝",
                "一点也不",
                "可能不是",
                "我不这么认为",
                "肯定不是",
                "一定不是",
                "不像",
                "不用",
                "没有",
                "美优", "美柚",// homonym for the above one
                "从来没有"
            )
            Language.SWEDISH -> listOf(
                "Nej",
                "Inte alls",
                "Absolut inte",
                "Jag tror inte det",
                "Jag tycker inte det",
                "Nej, jag vill inte",
                "Nej, det vill jag inte",
                "Nej, det har jag inte",
                "Nix",
                "Inte på något sätt",
                "Definitivt inte",
                "Det gör jag inte",
                "Aldrig",
                "Inte gärna",
                "Inte direkt",
                "Nej tack",
                "Inte okej",
                "Dåligt",
                "Nein",
                "nee",
                "nicht",
                "nö",
                "nah",
                "Nej",
                "Nä",
                "Inte",
                "Nä",
                "Aldrig",
                "Ingenting",
                "Negativ",
                "Inte alls",
                "Troligen inte",
                "Jag tror inte det",
                "Jag tror inte",
                "Definitivt inte",
                "Absolut inte",
                "Nej tack",
                "Osannolikt",
                "Inte varit",
                "Det har jag inte"
            )
            else -> listOf(
                "nope",
                "nix",
                "not",
                "nay",
                "nah",
                "never",
                "nothing",
                "negative",
                "not at all",
                "probably not",
                "I don't think so",
                "definitely not",
                "absolutely not",
                "no",
                "unlikely",
                "haven't",
                "not been"
            )
        }
}

class Sometimes : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "有时", "有时候",
                "不时地",
                "偶尔", "偶尔地"
            )
            Language.SWEDISH -> listOf(
                "Ibland",
                "Då och då",
                "Någon gång",
                "Från tid till annan"
            )
            else -> listOf(
                "sometimes", "some times",
                "few times",
                "every so often",
                "once in a while"
            )
        }
}

class Maybe : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "可能",
                "也许",
                "偶然",
                "大概",
                "大约",
                "可以是",
                "可能是",
                "大概是",
                "可能地",
                "我猜"
            )
            Language.GERMAN -> listOf(
                "Vielleicht",
                "unter Umständen",
                "eventuell",
                "kann sein",
                "könnte sein",
                "möglich"
            )
            else -> listOf(
                "Maybe",
                "Perhaps",
                "Perchance",
                "Can be",
                "Could be",
                "Might be",
                "Possibly",
                "i guess", "guess so", "i guess so"
            )
        }
}

class DontKnow : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "我不知道",
                "不知道",
                "不确定",
                "谁能说呢？",
                "不清楚")
            Language.GERMAN -> listOf(
                "Ich weiß nicht",
                "weiß nicht",
                "nicht sicher",
                "wer weiß das schon?",
                "keine Ahnung",
                "Ich hab keine Ahnung",
                "Keinen blassen Schimmer",
                "Ich habe keinen blassen Schimmer"
            )
            else -> listOf(
                "I don't know",
                "don't know",
                "not sure",
                "who can say?",
                "dunno",
                "I dunno",
                "I have no idea")
        }
}

class YesYouCan : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf("可以")
            Language.GERMAN -> listOf("du kannst", "Sie können")
            else -> listOf("you can", "you may","if you like","if you want to")
        }
}

class Abort : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "关闭",
                "退出",
                "结束",
                "终止",
                "中止",
                "重启",
                "重新启动",
                "停止"
            )
            Language.GERMAN -> listOf(
                "Zurück",
                "Abbruch",
                "Stop",
                "Von vorne",
                "ende",
                "schluss",
                "exit"
            )
            else -> listOf(
                "exit",
                "quit",
                "end",
                "stop",
                "abort",
                "from the beginning"
            )
        }
}

class AboutFurhat : Intent() {
    var furhat: FurhatEntity? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                // TODO @shobhan: check if "Furhat" is heard that way. Does priming the recogniser help?
                "你是谁？",
                "告诉我有关 @furhat 的信息",
                "告诉我有关机器人的信息",
                "说说你自己",
                "谁是 @furhat?",
                "@furhat 是谁?",
                "@furhat 是什么",
                "告诉我有关机器人的信息"
            )
            Language.GERMAN -> listOf(
                "Wer bist Du?",
                "Wer sind Sie?",
                "Was bist du?",
                "Was sollst du sein?",
                "Erzählen Sie mir mehr über @furhat",
                "Erzähle mir mehr über @furhat",
                "Erklären Sie mir @furhat",
                "Erkläre mir @furhat",
                "Erzähle mir mehr über Roboter",
                "Erkläre mir Roboter",
                "Erzähle mir von dir selbst",
                "Erzähl von dir",
                "Erzähl über dich",
                "Wer ist @furhat?",
                "Was ist @furhat?",
                "Wer ist hinter @furhat?",
                "Erzähle mir mehr über den Roboter",
                "Erzähle mir mehr über die Roboter",
                "Erkläre mir den Roboter"
            )
            else -> listOf(
                "+Who are +you?",
                "Tell me about @furhat",
                "Tell me +about +robot",
                "Tell me +about +yourself",
                "Who is @furhat?",
                "Who are @furhat?",
                "tell me +about +robots"
            )
        }
}





class EveryDay : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "每天", "每天都", "天天",
                "每天不止一次",
                "一天几次"
            )
            Language.GERMAN -> listOf(
                "jeden Tag",
                "mehr als einmal pro Tag",
                "Mehrmals täglich"
            )
            else -> listOf(
                "every day", "everyday", "daily",
                "more than once a day",
                "several times a day"
            )
        }
}
class YesMostOfTheTime : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "大部分时间都是", "大多数情况下是的",
                "通常情况下是",
                "绝大多数时间"
            )
            Language.GERMAN -> listOf(
                "ja, meistens",
                "ja, die meiste Zeit",
                "meist",
                "überwiegend ja"
            )
            Language.SWEDISH -> listOf(
                "ja, för det mesta",
                "ja, mestadels",
                "för det mesta ja",
                "i de flesta fall ja"
            )
            else -> listOf(
                "yes, most of the time", "yes, mostly", "mostly yes",
                "for the most part yes",
                "in most cases, yes"
            )
        }
}

class YesSometimes : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "有时候是", "偶尔",
                "有时",
                "偶尔是的"
            )
            Language.GERMAN -> listOf(
                "ja, manchmal",
                "gelegentlich",
                "ab und zu",
                "hin und wieder"
            )
            Language.SWEDISH -> listOf(
                "ja, ibland",
                "ibland",
                "då och då",
                "emellanåt"
            )
            else -> listOf(
                "yes, sometimes", "sometimes", "occasionally",
                "now and then",
                "from time to time"
            )
        }
}

class NoNotVeryOften : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "不，不太频繁", "不经常",
                "很少",
                "不，不是很经常"
            )
            Language.GERMAN -> listOf(
                "nein, nicht so oft",
                "selten",
                "nicht häufig",
                "nicht allzu oft"
            )
            Language.SWEDISH -> listOf(
                "nej, inte så ofta",
                "inte så ofta",
                "sällan",
                "inte ofta"
            )
            else -> listOf(
                "no, not very often", "not so often", "rarely",
                "not that often",
                "infrequently"
            )
        }
}

class NoNever : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "不，从不", "永不",
                "绝不",
                "从来没有"
            )
            Language.GERMAN -> listOf(
                "nein, nie",
                "niemals",
                "keinesfalls",
                "nie im Leben"
            )
            Language.SWEDISH -> listOf(
                "nej, aldrig",
                "aldrig",
                "absolut inte",
                "inte en enda gång"
            )
            else -> listOf(
                "no, never", "never", "absolutely not",
                "not once",
                "not at all"
            )
        }
}


//EPDS1 options

class AsMuchAsIAlwaysCould : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "跟以前一样多"
            )
            Language.SWEDISH -> listOf(
                "Lika bra som vanligt"
            )
            else -> listOf(
                "As much as I always could"
            )
        }
}

class NotQuiteSoMuchNow : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf("现在没那么多了")
        Language.SWEDISH -> listOf("Nästan lika bra som vanligt")
            else -> listOf("Not quite so much now")
        }
}

class DefinitelyNotSoMuchNow : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf("现在肯定没那么多了")
        Language.SWEDISH -> listOf("Mycket mindre än vanligt")
            else -> listOf("Definitely not so much now")
        }
}
class Q1_0_AsMuchAsIAlwaysCould : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("跟以前一样多", "一如既往地欢笑")
        Language.SWEDISH -> listOf("Lika bra som vanligt", "Som jag alltid kunnat")
        else -> listOf("As much as I always could", "Just like before")
    }
}

class Q1_1_NotQuiteSoMuchNow : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("现在没那么多了", "不如以前")
        Language.SWEDISH -> listOf("Nästan lika bra som vanligt", "Inte lika mycket nu")
        else -> listOf("Not quite so much now", "Less than before")
    }
}

class Q1_2_DefinitelyNotSoMuchNow : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("现在肯定没那么多了", "明显少了")
        Language.SWEDISH -> listOf("Mycket mindre än vanligt", "Definitivt mindre nu")
        else -> listOf("Definitely not so much now", "Much less now")
    }
}

class Q1_3_NotAtAll : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("根本没有",
            "没有",
            "mail", // homphone for "mei you" above ,
            "不",
            "不是",
            "不是的",
            "从不",
            "一点也不",
            "肯定不是",
            "一定不是",
            "没有",
            "美优", "美柚",// homonym for the above one
            "从来没有",
            "完全不笑")
        Language.SWEDISH -> listOf("Inte alls", "Inte ett skratt")
        else -> listOf("Not at all", "No laughter at all","No")
    }
}

//EPDS 2
class Q2_0_AsMuchAsIEverDid : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("跟我以前一样多", "一如既往地期待")
        Language.SWEDISH -> listOf("Lika mycket som vanligt", "Som jag alltid gjort")
        else -> listOf("As much as I ever did", "Just as excited as before")
    }
}

class Q2_1_RatherLessThanIUsedTo : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("比以前少多了", "不像以前那么期待了")
        Language.SWEDISH -> listOf("Något mindre än vanligt", "Inte riktigt som förut")
        else -> listOf("Rather less than I used to", "Less excited than before")
    }
}

class Q2_2_DefinitelyLessThanIUsedTo : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("肯定比以前少了", "明显地减少了兴趣")
        Language.SWEDISH -> listOf("Mycket mindre än vanligt", "Definitivt mindre intresserad")
        else -> listOf("Definitely less than I used to", "Significantly less excited")
    }
}

class Q2_3_HardlyAtAll : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("几乎没有", "几乎不期待")
        Language.SWEDISH -> listOf("Inte alls", "Nästan ingen förväntan")
        else -> listOf("Hardly at all", "Barely looking forward to anything")
    }
}

//EPDS3
class Q3_3_YesMostOfTheTime : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，大多数时候", "经常自责")
        Language.SWEDISH -> listOf("Ja, för det mesta", "Oftast ja")
        else -> listOf("Yes, most of the time", "Frequently blaming myself")
    }
}

class Q3_2_YesSomeOfTheTime : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，有时候", "偶尔自责")
        Language.SWEDISH -> listOf("Ja, ibland", "Stundtals")
        else -> listOf("Yes, some of the time", "Sometimes blaming myself")
    }
}

class Q3_1_NotVeryOften : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不是很经常", "很少自责")
        Language.SWEDISH -> listOf("Nej, inte så ofta", "Sällan")
        else -> listOf("Not very often", "Rarely blaming myself")
    }
}

class Q3_0_NoNever : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不，从不", "绝不自责")
        Language.SWEDISH -> listOf("Nej, aldrig", "Aldrig självkritik")
        else -> listOf("No, never", "Never blaming myself")
    }
}



//EPDS 4
class Q4_0_NoNotAtAll : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不，完全没有", "一点也不担心")
        Language.SWEDISH -> listOf("Nej, inte alls", "Inte orolig alls")
        else -> listOf("No, not at all", "Not worried at all")
    }
}

class Q4_1_HardlyEver : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("几乎没有", "很少担心")
        Language.SWEDISH -> listOf("Nej, knappast alls", "Sällan orolig")
        else -> listOf("Hardly ever", "Rarely worried")
    }
}

class Q4_2_YesSometimes : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，有时候", "偶尔焦虑")
        Language.SWEDISH -> listOf("Ja, ibland", "Stundom orolig")
        else -> listOf("Yes, sometimes", "Occasionally anxious")
    }
}

class Q4_3_YesVeryOften : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，很经常", "经常感到焦虑")
        Language.SWEDISH -> listOf("Ja, mycket ofta", "Ofta orolig")
        else -> listOf("Yes, very often", "Frequently anxious")
    }
}

//EPDS 5

class Q5_0_NoNotAtAll : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不，完全没有", "一点也不害怕")
        Language.SWEDISH -> listOf("Nej, inte alls", "Inte skrämd alls")
        else -> listOf("No, not at all", "Not scared at all")
    }
}

class Q5_1_NoNotMuch : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不，不多时候", "很少感到恐慌")
        Language.SWEDISH -> listOf("Nej, ganska sällan", "Sällan panikslagen")
        else -> listOf("No, not much", "Rarely panicky")
    }
}

class Q5_2_YesSometimes : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，有时候", "偶尔感到害怕")
        Language.SWEDISH -> listOf("Ja, ibland", "Ibland rädd")
        else -> listOf("Yes, sometimes", "Occasionally scared")
    }
}

class Q5_3_YesQuiteALot : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，很多时候", "经常感到恐慌")
        Language.SWEDISH -> listOf("Ja, mycket ofta", "Ofta panikslagen")
        else -> listOf("Yes, quite a lot", "Frequently panicky")
    }
}

//EPDS 6

class Q6_0_NoIHaveBeenCopingAsWellAsEver : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不，我和以前一样应对得好", "依然应对自如")
        Language.SWEDISH -> listOf("Nej, jag har kunnat ta itu med saker precis som vanligt", "Hanterar som alltid")
        else -> listOf("No, I have been coping as well as ever", "Handling things as usual")
    }
}

class Q6_1_NoMostOfTheTimeIHaveCopedQuiteWell : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不，大多数时候我应对得挺好", "大部分时间都处理得很好")
        Language.SWEDISH -> listOf("Nej, för det mesta har jag kunnat ta itu med saker ganska bra", "Mestadels hanterat väl")
        else -> listOf("No, most of the time I have coped quite well", "Mostly coping well")
    }
}

class Q6_2_YesSometimesIHaveNotBeenCopingAsWellAsUsual : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，有时候我不像平时应对得那么好", "偶尔难以应对")
        Language.SWEDISH -> listOf("Ja, ibland har jag inte kunnat ta itu med saker lika bra som vanligt", "Ibland inte hanterat som vanligt")
        else -> listOf("Yes, sometimes I haven't been coping as well as usual", "Sometimes struggling more than usual")
    }
}

class Q6_3_YesMostOfTheTimeIHaveNotBeenAbleToCopeAtAll : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，大多数时候我根本无法应对", "大部分时间都无法处理")
        Language.SWEDISH -> listOf("Ja, mest hela tiden har jag inte kunnat ta itu med något alls", "Oftast inte kunnat hantera")
        else -> listOf("Yes, most of the time I haven't been able to cope at all", "Mostly unable to cope")
    }
}

//EPDS 7

class Q7_0_NoNotAtAll : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不，根本不", "完全没有睡眠困难")
        Language.SWEDISH -> listOf("Nej, aldrig", "Inga sömnproblem alls")
        else -> listOf("No, not at all", "No difficulty sleeping")
    }
}

class Q7_1_NoNotVeryOften : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不是很经常", "偶尔睡眠有点困难")
        Language.SWEDISH -> listOf("Nej, sällan", "Sällan svårt att sova")
        else -> listOf("No, not very often", "Rarely have difficulty sleeping")
    }
}

class Q7_2_YesSometimes : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，有时候", "有时候睡得不好")
        Language.SWEDISH -> listOf("Ja, ibland", "Ibland svårt att sova")
        else -> listOf("Yes, sometimes", "Sometimes difficulty sleeping")
    }
}

class Q7_3_YesMostOfTheTime : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，大多数时候", "大多数时间都睡得不好")
        Language.SWEDISH -> listOf("Ja, för det mesta", "För det mesta svårt att sova")
        else -> listOf("Yes, most of the time", "Mostly have difficulty sleeping")
    }
}

//EPDS 8

class Q8_0_NoNotAtAll : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不，从不", "完全不感到悲伤")
        Language.SWEDISH -> listOf("Nej, aldrig", "Inte ledsen alls")
        else -> listOf("No, not at all", "Not feeling sad at all")
    }
}

class Q8_1_NotVeryOften : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不是很经常", "很少感到悲伤")
        Language.SWEDISH -> listOf("Nej, sällan", "Sällan miserabel")
        else -> listOf("Not very often", "Rarely feeling sad")
    }
}

class Q8_2_YesQuiteOften : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，很经常", "经常感到悲伤")
        Language.SWEDISH -> listOf("Ja, rätt ofta", "Ofta ledsen")
        else -> listOf("Yes, quite often", "Frequently feeling sad")
    }
}

class Q8_3_YesMostOfTheTime : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，大多数时候", "大部分时间都感到悲伤")
        Language.SWEDISH -> listOf("Ja, för det mesta", "Mestadels miserabel")
        else -> listOf("Yes, most of the time", "Mostly feeling sad")
    }
}

//EPDS 9

class Q9_0_NoNever : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("不，从不", "从不哭泣")
        Language.SWEDISH -> listOf("Nej, aldrig", "Aldrig gråtit")
        else -> listOf("No, never", "Never been crying")
    }
}

class Q9_1_OnlyOccasionally : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("仅仅偶尔", "偶尔哭泣")
        Language.SWEDISH -> listOf("Bara någon gång", "Endast tillfälligt gråtit")
        else -> listOf("Only occasionally", "Only cried occasionally")
    }
}

class Q9_2_YesQuiteOften : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，很经常", "经常哭泣")
        Language.SWEDISH -> listOf("Ja, ganska ofta", "Ofta gråter")
        else -> listOf("Yes, quite often", "Frequently crying")
    }
}

class Q9_3_YesMostOfTheTime : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，大多数时候", "大多数时间都在哭")
        Language.SWEDISH -> listOf("Ja, nästan jämt", "Nästan alltid gråtande")
        else -> listOf("Yes, most of the time", "Mostly been crying")
    }
}

//EPDS 10

class Q10_0_Never : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("从不", "从未有过自伤念头")
        Language.SWEDISH -> listOf("Aldrig", "Aldrig tänkt skada mig själv")
        else -> listOf("Never", "Never thought of harming myself")
    }
}

class Q10_1_HardlyEver : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("几乎没有", "几乎从不考虑")
        Language.SWEDISH -> listOf("Nästan aldrig", "Sällan tänkt på det")
        else -> listOf("Hardly ever", "Rarely thought of it")
    }
}

class Q10_2_Sometimes : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("有时候", "偶尔想到")
        Language.SWEDISH -> listOf("Ibland", "Tänker på det ibland")
        else -> listOf("Sometimes", "Occasionally thought about it")
    }
}

class Q10_3_YesQuiteOften : Intent() {
    override fun getExamples(lang: Language): List<String> = when (lang) {
        Language.MANDARIN -> listOf("是，很经常", "经常考虑自伤")
        Language.SWEDISH -> listOf("Ja, rätt så ofta", "Ofta tänker på det")
        else -> listOf("Yes, quite often", "Frequently thought of harming myself")
    }
}


//
//
//class YesVeryOften : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("是的，很频繁", "经常", "总是这样", "很多次")
//            Language.GERMAN -> listOf("ja, ziemlich oft", "oft", "häufig", "sehr oft")
//            Language.SWEDISH -> listOf("ja, mycket ofta", "ofta", "mycket ofta", "väldigt ofta")
//            else -> listOf("yes, quite often", "quite often", "often", "very often")
//        }
//}
//
//class NoNotOften : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("不，不经常", "不太经常", "很少", "不常")
//            Language.GERMAN -> listOf("nein, nicht oft", "selten", "nicht so oft", "nicht häufig")
//            Language.SWEDISH -> listOf("nej, ganska sällan", "sällan", "inte ofta", "ganska sällan")
//            else -> listOf("no, not often", "not often", "rarely", "seldom")
//        }
//}
//
//class NoNotAtAll : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("不，完全没有", "一点也不", "根本没有", "完全不")
//            Language.GERMAN -> listOf("nein, überhaupt nicht", "überhaupt nicht", "gar nicht", "keineswegs")
//            Language.SWEDISH -> listOf("nej, inte alls", "inte alls", "absolut inte", "aldrig")
//            else -> listOf("no, not at all", "not at all", "absolutely not", "never")
//        }
//}
//
//class AsMuchAsUsual : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "和往常一样多", "像平时一样多",
//                "数量如既往",
//                "依旧保持相同数量"
//            )
//            Language.GERMAN -> listOf(
//                "so viel wie üblich",
//                "wie gewohnt gleich viel",
//                "gleichbleibende Menge",
//                "immer noch so viel"
//            )
//            Language.SWEDISH -> listOf(
//                "lika mycket som vanligt",
//                "som vanligt",
//                "samma mängd som alltid",
//                "fortfarande lika mycket"
//            )
//            else -> listOf(
//                "as much as usual", "the same amount as always", "still as much",
//                "consistently the same quantity",
//                "no change in amount"
//            )
//        }
//}
////EPDS2 O2
//class RatherLessThanUsual : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "比平时少一些", "稍微不如往常",
//                "略低于平时的量",
//                "有点少于平常"
//            )
//            Language.SWEDISH -> listOf(
//                "något mindre än vanligt",
//                "lite mindre än vanligt",
//                "inte riktigt som vanligt",
//                "en aning mindre än vanligt"
//            )
//            else -> listOf(
//                "Rather less than I used to",
//                "somewhat less than usual", "a bit less than always", "not quite as much",
//                "slightly below the usual amount",
//                "a little less than normal"
//            )
//        }
//}
//
//class AsWellAsUsual : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "像往常一样好", "和平时一样好",
//                "一如既往地好",
//                "依旧不错"
//            )
//            Language.SWEDISH -> listOf(
//                "lika bra som vanligt",
//                "som vanligt bra",
//                "fortfarande lika bra",
//                "alltid lika bra"
//            )
//            else -> listOf(
//                "As much as I always could",
//                "as well as usual", "just as good as always", "still as good",
//                "always as good",
//                "consistently good"
//            )
//        }
//}
//class AlmostAsWellAsUsual : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "几乎和往常一样好", "差不多像平时一样好",
//                "接近平时的水平",
//                "不错，但略逊平时"
//            )
//            Language.GERMAN -> listOf(
//                "fast wie üblich gut",
//                "nahezu so gut wie immer",
//                "beinahe gleichbleibend gut",
//                "fast nach wie vor gut"
//            )
//            Language.SWEDISH -> listOf(
//                "nästan lika bra som vanligt",
//                "nästan som vanligt",
//                "nära vanlig standard",
//                "inte riktigt som vanligt, men nästan"
//            )
//            else -> listOf(
//                "Not quite so much now",
//                "almost as well as usual", "nearly as good as always", "not quite as good, but close",
//                "close to the usual standard",
//                "almost consistently good"
//            )
//        }
//}
//
//
//class DefinitelyLessThanUsual : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "比平时少得多", "远不如往常",
//                "比往常差很多",
//                "远远低于标准"
//            )
//            Language.SWEDISH -> listOf(
//                "mycket mindre än vanligt",
//                "långt under det vanliga",
//                "betydligt mindre än normalt",
//                "väsentligt under standarden"
//            )
//            else -> listOf(
//                "Definitely less than I used to",
//                "Definitely not so much now",
//                "much less than usual", "far below usual", "significantly less than normal",
//                "well below the standard",
//                "considerably less than typical"
//            )
//        }
//}
////EPDS 2 O3
//
//
////class NotEveryDay : Intent() {
////    override fun getExamples(lang: Language): List<String> =
////        when (lang) {
////            Language.MANDARIN -> listOf(
////                "不是每天", "不是每天都",
////                "不经常",
////                "每隔一天"
////            )
////            Language.GERMAN -> listOf(
////                "nicht jeden Tag",
////                "nicht so oft",
////                "jeden zweiten Tag"
////            )
////            else -> listOf(
////                "not daily", "don't every day", "not every day", "don't everyday", "not everyday",
////                "not that often",
////                "every other day"
////            )
////        }
////}
//
////EPDS 6
//class YesMostTimeNotCopeAtAll : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("是的，大部分时间我都无法应对任何事情", "大多数时间我都处理不了", "几乎总是无法应对")
//            Language.GERMAN -> listOf("Ja, meistens konnte ich mich mit nichts auseinandersetzen", "Meistens konnte ich gar nichts bewältigen")
//            Language.SWEDISH -> listOf("ja, mest hela tiden har jag inte kunnat ta itu med något alls", "för det mesta kan jag inte hantera något alls", "nästan alltid oförmögen att hantera något")
//            else -> listOf("yes, most of the time I haven't been able to cope with anything at all", "mostly unable to deal with anything", "almost always unable to cope")
//        }
//}
//
//class YesSometimesNotCopeAsWell : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("是的，有时我无法像往常一样应对", "有时候处理不了", "偶尔无法像平时那样应对")
//            Language.GERMAN -> listOf("Ja, manchmal konnte ich nicht so gut zurechtkommen wie üblich", "Manchmal konnte ich die Dinge nicht so gut bewältigen")
//            Language.SWEDISH -> listOf("ja, ibland har jag inte kunnat ta itu med saker lika bra som vanligt", "ibland kan jag inte hantera saker som vanligt", "stundtals inte lika kapabel som vanligt")
//            else -> listOf("yes, sometimes I haven't been able to cope as well as usual", "sometimes unable to handle things as usual", "occasionally not as capable as usual")
//        }
//}
//
//class NoMostlyCopedWell : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("不，大部分时间我都处理得相当好", "大多数情况下我都能应对", "大部分时间我都做得不错")
//            Language.GERMAN -> listOf("Nein, meistens habe ich ziemlich gut zurechtkommen", "Für die meiste Zeit konnte ich die Dinge gut bewältigen")
//            Language.SWEDISH -> listOf("nej, för det mesta har jag kunnat ta itu med saker ganska bra", "mestadels har jag hanterat saker väl", "för det mesta klarar jag mig bra")
//            else -> listOf("no, for the most part, I have been able to cope quite well", "mostly I've managed things well", "for the most part, I've been coping well")
//        }
//}
//
//class NoCopedAsUsual : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "不，我能像往常一样处理事情",
//                "我能像平时一样应对",
//                "像往常一样管理一切"
//            )
//            Language.GERMAN -> listOf(
//                "Nein, ich konnte mit den Dingen wie gewohnt umgehen",
//                "Ich habe die Dinge wie üblich bewältigt",
//                "Wie gewohnt konnte ich alles handhaben"
//            )
//            Language.SWEDISH -> listOf(
//                "nej, jag har kunnat ta itu med saker precis som vanligt",
//                "jag har hanterat saker som vanligt",
//                "precis som vanligt har jag kunnat hantera allt"
//            )
//            else -> listOf(
//                "no, I have been able to cope with things just as usual",
//                "I have handled things as usual",
//                "just like always, I've been able to manage everything"
//            )
//        }
//}
//
//class NoRarely : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("不，很少", "很少不")
//            Language.GERMAN -> listOf("Nein, selten", "Selten nein")
//            Language.SWEDISH -> listOf("nej, sällan", "sällan nej", "sällan")
//            else -> listOf("no, rarely", "rarely no", "seldom")
//        }
//}
//
//
//
////EPDS 7
//
//
////EPDS 8
//class YesQuiteOften : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("是的，相当频繁", "很频繁")
//            Language.GERMAN -> listOf("Ja, ziemlich oft", "Recht oft")
//            Language.SWEDISH -> listOf("ja, rätt ofta", "rätt ofta")
//            else -> listOf("yes, quite often", "quite often")
//        }
//}
//
//
////EPDS 9
//
//class YesAlmostAlways : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("是的，几乎总是", "几乎总是")
//            Language.GERMAN -> listOf("Ja, fast immer", "Fast immer")
//            Language.SWEDISH -> listOf("ja, nästan jämt", "nästan jämt")
//            else -> listOf("yes, almost always", "almost always")
//        }
//}
//
//class YesQuiteOftenGanska : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("是的，相当频繁", "相当频繁")
//            Language.GERMAN -> listOf("Ja, ziemlich oft", "Ziemlich oft")
//            Language.SWEDISH -> listOf("ja, ganska ofta", "ganska ofta")
//            else -> listOf("yes, quite often", "quite often")
//        }
//}
//
//class JustOccasionally : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("只是偶尔", "偶尔")
//            Language.GERMAN -> listOf("Nur gelegentlich", "Gelegentlich")
//            Language.SWEDISH -> listOf("bara någon gång", "någon gång")
//            else -> listOf("just occasionally", "occasionally")
//        }
//}
////class NoNever : Intent() {
////    override fun getExamples(lang: Language): List<String> =
////        when (lang) {
////            Language.MANDARIN -> listOf("不，从不", "从不")
////            Language.GERMAN -> listOf("Nein, nie", "Nie")
////            Language.SWEDISH -> listOf("nej, aldrig", "aldrig")
////            else -> listOf("no, never", "never")
////        }
////}
////
//
//
////EPDS 10
//
//class YesQuiteOftenRattSa : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("是的，相当频繁", "相当频繁") // Official translation placeholder
//            Language.GERMAN -> listOf("Ja, recht oft", "Recht oft")
//            Language.SWEDISH -> listOf("ja, rätt så ofta", "rätt så ofta")
//            else -> listOf("yes, quite often", "quite often") // Official translation placeholder
//        }
//}
//
//class SometimesIbland : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("有时", "偶尔") // Official translation placeholder
//            Language.GERMAN -> listOf("Manchmal", "Gelegentlich")
//            Language.SWEDISH -> listOf("ibland", "emellanåt")
//            else -> listOf("sometimes", "occasionally") // Official translation placeholder
//        }
//}
//
//class HardlyEverNastanAldrig : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("几乎从不", "很少") // Official translation placeholder
//            Language.GERMAN -> listOf("Fast nie", "Kaum")
//            Language.SWEDISH -> listOf("nästan aldrig", "nästan inte alls")
//            else -> listOf("hardly ever", "almost never") // Official translation placeholder
//        }
//}
//
//
//
//
//
//
//
//
//
//class IEatEveryDay : Intent() {
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                // when asked "do you eat fruits every day", mandarin speakers often reply "eat" (in mandarin).
//                "吃", "薛", "持", "迟", "池", "持", "痴", // "吃"="eat", and the rest are homophones
//                "恩我天天吃", "是的我每天都吃", // "i eat every day"
//                "天天吃", "每天都吃" // "eat every day"
//            )
//            Language.GERMAN -> listOf()
//            else -> listOf("eat every day", "eat everyday")
//        } + EveryDay().getExamples(lang)
//}
//
////class IDontEatEveryDay : Intent() {
////    override fun getExamples(lang: Language): List<String> =
////        when (lang) {
////            Language.MANDARIN -> listOf(
////                "我没吃", "我不吃", "不吃", // "i dont eat"
////                "我 不是 每天都 吃" // "i dont everyday eat"
////            )
////            Language.GERMAN -> listOf()
////            else -> listOf("don't every day", "eat everyday")
////        } + NotEveryDay().getExamples(lang)
////}
//
////class RelativeIntent : Intent() {
////    var relative: RelativeEntity? = null;
////    override fun getExamples(lang: Language): List<String> =
////        when (lang) {
////            Language.MANDARIN -> listOf(
////                "@relative",
////                "是 @relative",
////                "我的 @relative",
////                "我 @relative",
////                "是的 我的 @relative",
////                "我的 @relative 有",
////                "我 @relative 有糖尿病",
////                "有的 我 @relative 有糖尿病",
////                "是的 我的 @relative 有糖尿病",
////                "我们是 @relative 关系",
////                "是我 @relative"
////            )
////            Language.GERMAN -> listOf(
////                "@relative",
////                "Mein @relative",
////                "Meine @relative",
////                "ja mein @relative",
////                "ja meine @relative",
////                "Mein @relative hat es",
////                "Meine @relative hat es",
////                "Mein @relative hat Diabetes",
////                "Meine @relative hat Diabetes",
////                "ja mein @relative hat Diabetes",
////                "ja meine @relative hat Diabetes",
////                "Wir sind @relative verwandt"
////            )
////            else -> listOf(
////                "@relative",
////                "My @relative",
////                "yes my @relative",
////                "My @relative has it",
////                "My @relative has diabetes",
////                "Yes my @relative has diabetes",
////                "We are @relative related"
////            )
////        }
////}
//
//class SpecifySex : Intent() {
//    var sex: Sex? = null
//
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("@sex", "我是一个 @sex", "我是 @sex")
//            Language.GERMAN -> listOf("@sex", "Ich bin eine @sex", "Ich bin ein @sex", "I bin @sex")
//            else -> listOf("@sex", "I'm a @sex", "I am @sex")
//        }
//
//    override fun getSpeechRecPhrases(lang: Language?): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf("男性", "男人", "女性", "女人")
//            Language.GERMAN -> listOf("männlich", "Mann", "weiblich", "Frau")
//            else -> listOf("male", "man", "female", "woman")
//        }
//}
//
//class HeightExactlyIntent : Intent() {
//    var height: CustomNumber? = null
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "@height",
//                "@height 厘米",
//                "我 @height",
//                "我的身高是 @height",
//                "我有 @height 厘米高"
//            )
//            Language.GERMAN -> listOf(
//                "@height",
//                "@height Zentimeter",
//                "@height cm",
//                "Ich bin @height",
//                "Meine Größe ist @height",
//                "Ich bin @height Zentimeter groß"
//            )
//            else -> listOf(
//                "@height",
//                "@height centimeters",
//                "@height cm",
//                "I'm @height",
//                "My height is @height",
//                "I'm @height centimeters tall"
//            )
//        }
//}
//
//class HeightBelowIntent : Intent() {
//    var heightBelow: CustomNumber? = null
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "小于 @heightBelow",
//                "比 @heightBelow 矮",
//                "低于 @heightBelow",
//                "的于 @heightBelow",
//                "我的于 @heightBelow"
//            )
//            Language.GERMAN -> listOf(
//                "weniger als @heightBelow",
//                "unter @heightBelow",
//                "kleiner als @heightBelow"
//            )
//            else -> listOf(
//                "less than @heightBelow",
//                "lower than @heightBelow",
//                "under @heightBelow"
//            )
//        }
//}
//
//class HeightAboveIntent : Intent() {
//    var heightAbove: CustomNumber? = null
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "大于 @heightAbove",
//                "比 @heightAbove 高",
//                "超过 @heightAbove"
//            )
//            Language.GERMAN -> listOf(
//                "größer als @heightAbove",
//                "mehr als @heightAbove",
//                "höher als @heightAbove",
//                "über @heightAbove"
//            )
//            else -> listOf(
//                "more than @heightAbove",
//                "higher than @heightAbove",
//                "over @heightAbove"
//            )
//        }
//}
//
//class HeightBetweenIntent : Intent() {
//    var heightBelow: CustomNumber? = null
//    var heightAbove: CustomNumber? = null
//    override fun getExamples(lang: Language): List<String> =
//        when (lang) {
//            Language.MANDARIN -> listOf(
//                "在 @heightBelow 到 @heightAbove 之间",
//                "@heightBelow 到 @heightAbove",
//                "大于 @heightBelow 小于 @heightAbove"
//            )
//            Language.GERMAN -> listOf(
//                "zwischen @heightBelow und @heightAbove",
//                "@heightBelow bis @heightAbove"
//            )
//            else -> listOf(
//                "between @heightBelow and @heightAbove",
//                "@heightBelow to @heightAbove"
//            )
//        }
//}

data class I18nIntent(
    val examples: List<String> = listOf(),
    val speechRecPhrases: List<String> = listOf()
)

class I18nIntents {

    val ChangeBack = mapOf(
        en to I18nIntent(examples = listOf(
            "change back",
            "go back",
            "revert",
            "undo",
            "return to previous"
        )),
        sv to I18nIntent(examples = listOf(
            "ändra tillbaka",
            "gå tillbaka",
            "återgå",
            "ångra",
            "återvänd till tidigare",
            "ursprungliga rösten",
            "rösten",
            "change back",
            "go back",
            "revert",
            "undo",
            "return to previous"
        )),
        zh to I18nIntent(examples = listOf(
            "改回去",
            "返回",
            "撤销",
            "回到之前"
        ))
    )[currentLang]!!

    val GoHome = mapOf(
        en to I18nIntent(examples = listOf(
            "go home",
            "start over",
            "from the start",
            "to start",
            "to introduction",
            "go to intro",
            "restart"
            )),
        sv to I18nIntent(examples = listOf(
            "gå hem",
            "börja om från början",
            "från början",
            "till start",
            "till introduktion",
            "till inledning",
            "gå till inledning",
            "gå till introduktion",
            "omstart"
        )),
        zh to I18nIntent(examples = listOf(
            "主页面",
            "重新开始",
            "从头开始",
            "开始",
            "简介页",
            "转到简介"
        ))
    )[currentLang]!!

    val Help = mapOf(
        en to I18nIntent(examples = listOf(
            "help",
            "options",
            "what are my options?",
            "what?",
            "what to do",
            "what am I doing?"
        )),
        sv to I18nIntent(examples = listOf(
            "Hjälp",
            "Alternativ",
            "Vad är mina alternativ?",
            "Vad är mina möjligheter?",
            "Vad?",
            "Vad kan jag göra?",
            "Vad kan jag göra?",
            "Vad kan man göra?",
            "Vad kan man göra?",
            "Vad gör jag?, Vad gör jag?"
        )),
        zh to I18nIntent(examples = listOf(
            "帮助",
            "选项",
            "我的选择是什么？",
            "什么？",
            "做什么",
            "我在做什么？"
        ))
    )[currentLang]!!

    val IUnderstand = mapOf(
        en to I18nIntent(examples = listOf(
            "I understand",
            "I comprehend",
            "Understood",
            "Got it",
            "I concur",
            "I agree"
        )),
        sv to I18nIntent(examples = listOf(
            "Jag förstår",
            "Förstått",
            "Aha",
            "OK",
            "Jag håller med",
            "Klart",
            "Klart det",
            "Kristallklart"
        )),
        zh to I18nIntent(examples = listOf(
            "我明白",
            "我理解",
            "理解",
            "明白",
            "我同意",
            "我赞成",
            "理解了", //
            "一家了" // homophone of "理解了"
        ))
    )[currentLang]!!

    val MoveOnIntent = mapOf(
        en to I18nIntent(examples = listOf(
            "move on",
            "ready",
            "next",
            "go on",
            "exit",
            "continue",
            "carry on",
            "advance",
            "got it",
        )),
        sv to I18nIntent(examples = listOf(
            "fortsätt",
            "klar",
            "nästa",
            "näst",
            "näste",
            "fortsätt",
            "avsluta",
            "avslut",
            "fortsättar",
            "fortsätt så",
            "mer",
            "första",
            "förståta",
            "tillbaka",
            "move on",
            "ready",
            "next",
            "go on",
            "exit",
            "continue",
            "carry on",
            "advance",
            "got it",
        )),
        zh to I18nIntent(examples = listOf(
            "继续",
            "准备好",
            "接下来",
            "继续",
            "接着",
            "继续",
            "继续",
            "前进",
            "明白",
            "返回"
        ))
    )[currentLang]!!

    val NoneOfTheAbove = mapOf(
        en to I18nIntent(examples = listOf(
            "neither",
            "none",
            "none of the above",
            "not a single one",
            "i don't want to say"
        )),
        sv to I18nIntent(examples = listOf(
            "inget",
            "ingen",
            "inget av listade",
            "inget av dem",
            "inte ett enda",
            "inte säga"
        )),
        zh to I18nIntent(examples = listOf(
            "都不",
            "没有",
            "以上都不是",
            "一个也没有"
        ))
    )[currentLang]!!

    val RepeatQuestion = mapOf(
        en to I18nIntent(examples = listOf(
            "Repeat",
            "Please repeat",
            "please repeat the question",
            "I didn't hear that",
            "couldn't hear you",
            "say again?",
            "Seguin",  /* google sometimes returns "Seguin" when we say "say it again" to it. */
            "say it again",
            "again",
            "you didn't ask me a question",
            "what's the question",
            "what did you say?",
            "sorry",
            "excuse me"
        )),
        sv to I18nIntent(examples = listOf(
            "Upprepa",
            "Snälla upprepa",
            "snälla upprepa frågan",
            "Jag hörde inte det",
            "kunde inte höra dig",
            "säg igen?",
            "Seguin",
            "säg det igen",
            "igen",
            "du har inte frågat mig",
            "vad är frågan",
            "vad sa du?",
            "ursäkta",
            "ursäkta mig"
        )),
        zh to I18nIntent(examples = listOf(
            "重复",
            "请重复",
            "请重复这问题",
            "我听不到",
            "听不到你说的",
            "再说一遍？",
            "再说一次",
            "再来",
            "你没有问我问题",
            "问题是什么",
            "你说什么？",
            "抱歉",
            "打扰一下",
            "我没听懂"
        ))
    )[currentLang]!!

    val Start = mapOf(
        en to I18nIntent(examples = listOf(
            "start",
            "begin",
            "commence",
            "let's start",
            "let's go",
            "go ahead",
            "screen me"
        )),
        sv to I18nIntent(examples = listOf(
            "starta",
            "börja",
            "inleda",
            "ska vi börja",
            "ska vi gå",
            "kör på",
            "screna mig"
        )),
        zh to I18nIntent(examples = listOf(
            "开始",
            "开始吧",
            "启动",
            "让我们开始",
            "走吧",
            "继续",
            "对我进行筛查"
        )),
        )[currentLang]!!

    val Female = mapOf(
        en to I18nIntent(examples = listOf(
            "woman",
            "women",
            "female",
            "girl",
            "lady",
            "she"
        )),
        sv to I18nIntent(examples = listOf(
            "kvinna",
            "kvinnlig",
            "flicka",
            "dam",
            "hon",
            "woman",
            "women",
            "female",
            "girl",
            "lady",
            "she"
        )),
        zh to I18nIntent(examples = listOf(
            "女性",
            "女人",
            "女孩",
            "女士",
            "女"
        ))
    )[currentLang]!!


    val Male = mapOf(
        en to I18nIntent(examples = listOf(
            "male",
            "man",
            "boy",
            "gentleman",
            "he"
        )),
        sv to I18nIntent(examples = listOf(
            "man",
            "pojke",
            "herr",
            "han",
            "manlig",
            "male",
            "men",
            "boy",
            "gentleman",
            "he",
            "him"
        )),
        zh to I18nIntent(examples = listOf(
            "男性",
            "男人",
            "男孩",
            "绅士",
            "男"
        ))
    )[currentLang]!!

    val WaistCircumferenceIntent = mapOf(
        en to I18nIntent(examples = listOf(
            "@cm",
            "@cm centimeters",
            "@cm cm",
            "It's @cm",
            "My circumference is @cm",
            "I'm @cm centimeters",
            "My waist is @cm centimeters"
        )),
        sv to I18nIntent(
            examples = listOf(
                "@cm",
                "@cm Centimeter",
                "@cm cm",
                "Det är @cm",
                "Min omkrets är @cm",
                "Min midja är @cm",
                "Jag mäter @cm centimeter",
                "Min midja är @cm centimeter",
                "Min midja är @cm centimeter",
                "Min midja är @cm centimeter"
            )
        ),
        zh to I18nIntent(examples = listOf(
            "是 @cm",
            "@cm",
            "@cm 厘米", "@cm 公分", // cm has two different terms in mandarin: 厘米 and 公分
            "我的腰围是 @cm",
            "我的周长是 @cm"
        ))
    )[currentLang]!!

    val WhatIs = mapOf(
        en to I18nIntent(examples = listOf(
            "what is",
            "and what is ",
            "I don't know what is ",
            "Not sure I know what  means",
            "I'm not sure what's ",
            "what does it mean?",
            "what does  mean?",
            "what's ",
            "define ",
            "explain "
        )),
        sv to I18nIntent(examples = listOf(
            "vad är",
            "och vad är",
            "Jag vet inte vad det är",
            "Osäker på vad det betyder",
            "Jag vet inte vad det betyder",
            "vad betyder det här?",
            "vad betyder det?",
            "vad är",
            "definiera",
            "förklara"
        )),
        zh to I18nIntent(examples = listOf(
            "什么是",
            "那么什么是",
            "我不知道什么是",
            "不确定我知道什么是",
            "我不确定什么是",
            "这是什么意思？",
            "什么意思？",
            "什么",
            "定义",
            "解释"
        ))
    )[currentLang]!!


    val PsysicalActivityExplain = mapOf(
            en to I18nIntent(
                examples = listOf(
                    "What does movement mean in this context?",
                    "What do you mean by that?",
                    "What do you mean?",
                    "What does that mean?",
                    "Depends on what counts as movement.",
                    "It depends.",
                    "What counts?"
                )
            ),
            sv to I18nIntent(
                examples = listOf(
                    "Vad innebär rörelse i detta sammanhang?",
                    "Vad menar du med det?",
                    "Vad menar du?",
                    "Vad betyder det?",
                    "Beror på vad som räknas som rörelse.",
                    "Det beror på.",
                    "Vad räknas?"
                )
            ),
            zh to I18nIntent(
                examples = listOf(
                    "这个情境中的运动是什么意思？",
                    "你指的是什么？",
                    "您是指什么？",
                    "那是什么意思？",
                    "取决于什么算作运动。",
                    "这要看情况。",
                    "算什么？"
                )
            )
    )[currentLang]!!

    val ImDone = mapOf(
        en to I18nIntent(examples = listOf("I'm done", "Done")),
        sv to I18nIntent(examples = listOf("Jag är klar", "Klar")),
        zh to I18nIntent(examples = listOf("我完成了", "完成", "结束了"))
    )[currentLang]!!

    val ImReady = mapOf(
        en to I18nIntent(examples = listOf("ready", "Continue")),
        sv to I18nIntent(examples = listOf("ready", "Continue","jag är redo", "fortsätt","Gå vidare","Fortsätter")),
        zh to I18nIntent(examples = listOf("准备好了", "可以了", "好了"))
    )[currentLang]!!

    val LetsProceed = mapOf(
        en to I18nIntent(examples = listOf("go ahead", "go on", "proceed")),
        sv to I18nIntent(examples = listOf("gå vidare", "fortsätt")),
        zh to I18nIntent(examples = listOf("继续", "让我们继续", "我们继续", "下一步", "下一个程序是"))
    )[currentLang]!!

    val ThankYou = mapOf(
        en to I18nIntent(examples = listOf("Thank You", "Thanks", "Bless you", "Cheers")),
        sv to I18nIntent(examples = listOf("Tack", "Tack så mycket", "Tackar", "Tack så mycket", "Hjärtligt tack", "Bästa tack")),
        zh to I18nIntent(examples = listOf("谢谢", "谢谢你", "多+谢", "非常感谢", "￿+谢了"))
    )[currentLang]!!

    val Goodbye = mapOf(
        en to I18nIntent(examples = listOf("Goodbye", "Bye", "Good bye", "Farewell", "ciao", "good-bye", "good by")),
        sv to I18nIntent(examples = listOf("Adjö", "Hej då", "Farväl", "Hejdå","Goodbye", "Bye", "Good bye", "Farewell", "ciao", "good-bye", "good by","Stop")),
        zh to I18nIntent(examples = listOf("再见", "拜拜", "再会"))
    )[currentLang]!!
}

