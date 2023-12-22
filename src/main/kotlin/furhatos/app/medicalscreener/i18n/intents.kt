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
            Language.GERMAN -> listOf(
                "Ja",
                "Ja Bitte",
                "mhm",
                "sicher",
                "absolut",
                "Ich glaube schon",
                "Ich denke schon",
                "Ja ich will",
                "ja will ich",
                "Ja habe ich",
                "Jep",
                "auf jeden fall",
                "definitiv",
                "mach ich",
                "oft",
                "sehr gerne",
                "gerne",
                "mit vergnügen",
                "OK", "okay", "in ordnung", "in ordung",
                "gut"
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
            Language.GERMAN -> listOf(
                "Nein",
                "nee",
                "nicht",
                "nö",
                "nah",
                "niemals",
                "nichts",
                "negativ",
                "überhaupt nicht",
                "wahrscheinlich nicht",
                "Ich denke nicht",
                "Ich glaube nicht",
                "definitiv nicht",
                "absolut nicht",
                "nein danke",
                "unwahrscheinlich",
                "nicht gewesen",
                "das habe ich nicht"
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
            Language.GERMAN -> listOf(
                "manchmal",
                "hin und wieder",
                "das eine oder andere Mal",
                "von Zeit zu Zeit"
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

class SpecifyAge : Intent() {
    var age: CustomNumber? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "@age",
                "我的 @age",
                "我 @age",
                "我 @age 岁",
                "@age 岁",
                "@age 大",
                "我才 @age 岁",
                "我已经 @age 岁了"
            )
            Language.GERMAN -> listOf(
                "@age",
                "Ich bin @age",
                "@age Jahre",
                "@age Jahre alt",
                "Ich bin @age Jahre alt"
            )
            else -> listOf(
                "@age",
                "I'm @age",
                "I am @age",
                "@age years",
                "@age years old",
                "I am @age years old"
            )
        }
}

class SpecifyAboveAge : Intent() {
    var age: CustomNumber? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "超过 @age",
                "超过 @age 多大",
                "高于 @age"
            )
            Language.GERMAN -> listOf(
                "über @age",
                "mehr als @age Jahre alt",
                "älter als @age"
            )
            else -> listOf(
                "over @age",
                "more than @age years old",
                "older than @age"
            )
        }
}

class SpecifyBelowAge : Intent() {
    var age: CustomNumber? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "小于 @age",
                "低于 @age",
                "不到 @age",
                "以下 @age"
            )
            Language.GERMAN -> listOf(
                "unter @age",
                "weniger als @age",
                "jünger als @age"
            )
            else -> listOf(
                "under @age",
                "below @age",
                "less than @age",
                "younger than @age"
            )
        }
}

class WeightExactlyIntent : Intent() {
    var weight: CustomNumber? = null
    var weightUnit: WeightUnitEntity? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "@weight",
                "@weight 千克",
                "@weight 公斤",
                "我重 @weight",
                "我是 @weight"
            )
            Language.GERMAN -> listOf(
                "@weight",
                "@weight Kilogramm",
                "@weight Kilos",
                "@weight kg",
                "Ich wiege @weight"
            )
            else -> listOf(
                "@weight",
                "@weight @weightUnit",
                "I weigh @weight",
                "I weigh @weight @weightUnit",
                "like @weight @weightUnit",
                "around @weight @weightUnit"
            )
        }
}

class WeightBelowIntent : Intent() {
    var weightBelow: CustomNumber? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "小于 @weightBelow",
                "比 @weightBelow 矮",
                "低于 @weightBelow",
                "的于 @weightBelow",
                "的于 @weightBelow",
                "我的于 @weightBelow"
            )
            Language.GERMAN -> listOf(
                "weniger als @weightBelow",
                "unter @weightBelow",
                "leichter als @weightBelow"
            )
            else -> listOf(
                "less than @weightBelow",
                "lower than @weightBelow",
                "under @weightBelow"
            )
        }
}

class WeightAboveIntent : Intent() {
    var weightAbove: CustomNumber? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "大于 @weightAbove",
                "比 @weightAbove 高",
                "超过 @weightAbove"
            )
            Language.GERMAN -> listOf(
                "größer als @weightAbove",
                "mehr als @weightAbove",
                "höher als @weightAbove",
                "schwerer als @weightAbove",
                "über @weightAbove"
            )
            else -> listOf(
                "more than @weightAbove",
                "higher than @weightAbove",
                "over @weightAbove"
            )
        }
}

class WeightBetweenIntent : Intent() {
    var weightBelow: CustomNumber? = null
    var weightAbove: CustomNumber? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "在 @weightBelow 到 @weightAbove 之间",
                "@weightBelow 到 @weightAbove",
                "大于 @weightBelow 小于 @weightAbove"
            )
            Language.GERMAN -> listOf(
                "zwischen @weightBelow und @weightAbove",
                "@weightBelow bis @weightAbove"
            )
            else -> listOf(
                "between @weightBelow and @weightAbove",
                "@weightBelow to @weightAbove"
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

class NotEveryDay : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "不是每天", "不是每天都",
                "不经常",
                "每隔一天"
            )
            Language.GERMAN -> listOf(
                "nicht jeden Tag",
                "nicht so oft",
                "jeden zweiten Tag"
            )
            else -> listOf(
                "not daily", "don't every day", "not every day", "don't everyday", "not everyday",
                "not that often",
                "every other day"
            )
        }
}

class IEatEveryDay : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                // when asked "do you eat fruits every day", mandarin speakers often reply "eat" (in mandarin).
                "吃", "薛", "持", "迟", "池", "持", "痴", // "吃"="eat", and the rest are homophones
                "恩我天天吃", "是的我每天都吃", // "i eat every day"
                "天天吃", "每天都吃" // "eat every day"
            )
            Language.GERMAN -> listOf()
            else -> listOf("eat every day", "eat everyday")
        } + EveryDay().getExamples(lang)
}

class IDontEatEveryDay : Intent() {
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "我没吃", "我不吃", "不吃", // "i dont eat"
                "我 不是 每天都 吃" // "i dont everyday eat"
            )
            Language.GERMAN -> listOf()
            else -> listOf("don't every day", "eat everyday")
        } + NotEveryDay().getExamples(lang)
}

class RelativeIntent : Intent() {
    var relative: RelativeEntity? = null;
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "@relative",
                "是 @relative",
                "我的 @relative",
                "我 @relative",
                "是的 我的 @relative",
                "我的 @relative 有",
                "我 @relative 有糖尿病",
                "有的 我 @relative 有糖尿病",
                "是的 我的 @relative 有糖尿病",
                "我们是 @relative 关系",
                "是我 @relative"
            )
            Language.GERMAN -> listOf(
                "@relative",
                "Mein @relative",
                "Meine @relative",
                "ja mein @relative",
                "ja meine @relative",
                "Mein @relative hat es",
                "Meine @relative hat es",
                "Mein @relative hat Diabetes",
                "Meine @relative hat Diabetes",
                "ja mein @relative hat Diabetes",
                "ja meine @relative hat Diabetes",
                "Wir sind @relative verwandt"
            )
            else -> listOf(
                "@relative",
                "My @relative",
                "yes my @relative",
                "My @relative has it",
                "My @relative has diabetes",
                "Yes my @relative has diabetes",
                "We are @relative related"
            )
        }
}

class SpecifySex : Intent() {
    var sex: Sex? = null

    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf("@sex", "我是一个 @sex", "我是 @sex")
            Language.GERMAN -> listOf("@sex", "Ich bin eine @sex", "Ich bin ein @sex", "I bin @sex")
            else -> listOf("@sex", "I'm a @sex", "I am @sex")
        }

    override fun getSpeechRecPhrases(lang: Language?): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf("男性", "男人", "女性", "女人")
            Language.GERMAN -> listOf("männlich", "Mann", "weiblich", "Frau")
            else -> listOf("male", "man", "female", "woman")
        }
}

class HeightExactlyIntent : Intent() {
    var height: CustomNumber? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "@height",
                "@height 厘米",
                "我 @height",
                "我的身高是 @height",
                "我有 @height 厘米高"
            )
            Language.GERMAN -> listOf(
                "@height",
                "@height Zentimeter",
                "@height cm",
                "Ich bin @height",
                "Meine Größe ist @height",
                "Ich bin @height Zentimeter groß"
            )
            else -> listOf(
                "@height",
                "@height centimeters",
                "@height cm",
                "I'm @height",
                "My height is @height",
                "I'm @height centimeters tall"
            )
        }
}

class HeightBelowIntent : Intent() {
    var heightBelow: CustomNumber? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "小于 @heightBelow",
                "比 @heightBelow 矮",
                "低于 @heightBelow",
                "的于 @heightBelow",
                "我的于 @heightBelow"
            )
            Language.GERMAN -> listOf(
                "weniger als @heightBelow",
                "unter @heightBelow",
                "kleiner als @heightBelow"
            )
            else -> listOf(
                "less than @heightBelow",
                "lower than @heightBelow",
                "under @heightBelow"
            )
        }
}

class HeightAboveIntent : Intent() {
    var heightAbove: CustomNumber? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "大于 @heightAbove",
                "比 @heightAbove 高",
                "超过 @heightAbove"
            )
            Language.GERMAN -> listOf(
                "größer als @heightAbove",
                "mehr als @heightAbove",
                "höher als @heightAbove",
                "über @heightAbove"
            )
            else -> listOf(
                "more than @heightAbove",
                "higher than @heightAbove",
                "over @heightAbove"
            )
        }
}

class HeightBetweenIntent : Intent() {
    var heightBelow: CustomNumber? = null
    var heightAbove: CustomNumber? = null
    override fun getExamples(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "在 @heightBelow 到 @heightAbove 之间",
                "@heightBelow 到 @heightAbove",
                "大于 @heightBelow 小于 @heightAbove"
            )
            Language.GERMAN -> listOf(
                "zwischen @heightBelow und @heightAbove",
                "@heightBelow bis @heightAbove"
            )
            else -> listOf(
                "between @heightBelow and @heightAbove",
                "@heightBelow to @heightAbove"
            )
        }
}

data class I18nIntent(
    val examples: List<String> = listOf(),
    val speechRecPhrases: List<String> = listOf()
)

class I18nIntents {

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
            "go back"
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
            "fortsätt",
            "fortsätt så",
            "mer",
            "förstått",
            "tillbaka"
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
        sv to I18nIntent(examples = listOf("jag är redo", "fortsätt")),
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
        sv to I18nIntent(examples = listOf("Adjö", "Hej då", "Farväl", "Hejdå")),
        zh to I18nIntent(examples = listOf("再见", "拜拜", "再会"))
    )[currentLang]!!
}

