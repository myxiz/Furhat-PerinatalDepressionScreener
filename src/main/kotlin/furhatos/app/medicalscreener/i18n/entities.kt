package furhatos.app.medicalscreener.i18n

import furhatos.nlu.ComplexEnumEntity
import furhatos.nlu.EnumEntity
import furhatos.util.Language

class FurhatEntity : EnumEntity(speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> =
        when (lang) {
            // TODO
            Language.MANDARIN -> listOf("furhat")
            Language.SWEDISH -> listOf("furhat")
            else -> listOf("furhat")
        }
}

class WeightUnitEntity : EnumEntity() {
    override fun getEnum(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "kilo:kilo, kilos, kgs, kg, kilogramme, kilogrammes, 公斤, 千克, 号今", // 公斤 and 千克 mean "kg", but the others are homophones
                "pound: pound, pounds, lb, lbs", // lbs is not used by mandarin-speakers
                "jin: 斤,今,金,因,集" // 斤 is the only correct symbol, but google-asr returns the other symbols if you say 'jin' without any numbers (i.e., no context), so they are included here.
            )
            Language.SWEDISH -> listOf(
                "kilo:kilo, kilos, kgs, kg, Kilogramm, Kilogramme",
                "pound: pound, pounds, lb, lbs" // lbs is not used by german-speakers
            )
            else -> listOf(
                "kilo:kilo, kilos, kgs, kg, kilogramme, kilogrammes, kilogram, kilograms",
                "pound: pound, pounds, lb, lbs"
            )
        }
}

class RelativeEntity : EnumEntity(speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "distant:祖父母,奶奶,姥姥,爷爷,姥爷,祖母,祖父,阿姨,叔叔,表兄弟,堂哥,堂弟,堂姐,表,表叔,表哥,表弟,表姐,表妹,远亲,远亲的,舅舅,舅妈,姑姑,google,伯伯,大伯,姨娘,小姨, 愿清,新,眼睛,圆心",
                "close:母亲,妈妈,妈,父亲,爸爸,爸,兄弟姐妹,哥哥,弟弟,姐姐,妹妹,女儿,儿子,父母,近亲,近亲的"
            )
            Language.GERMAN -> listOf(
                "distant:Großeltern,Großmutter,Großvater,Oma,Opa,Tante,Onkel,Cousin,Cousine,Großtante,Großonkel,Großcousin,Großcousine,entfernt",
                "close:Mutter,Mama,Mami,Vater,Papa,Papi,Geschwister,Bruder,Schwester,Tochter,Sohn,Elternteil,nah,direkt"
            )
            else -> listOf(
                "distant:grandparent,grandma,grandpa,grandmother,grandfather,aunt,uncle,cousin,distant,distantly",
                "close:mother,mama,mom,father,papa,pa,sibling,brother,sister,daughter,son,parent,close,closely"
            )
        }
}

class Sex : EnumEntity() {
    override fun getEnum(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "male:男性,男人,男孩,男的",
                "female:女性,女人,女孩,女的",
                "other:其他,不用说, 不具体说明,中性人,不是中性人,变性人,无性别,雌雄同体")
            Language.GERMAN -> listOf(
                "male:männlich,Mann,Junge,Zunge,Lunge,nämlich,ähnlich,man,kann,Bann,bun",
                "female:weiblich,Frau,Mädchen,Pfädchen,Sau,Pfau,Schau,Trau,Mau",
                "other:anderes,bevorzuge nicht zu nennen,bevorzuge nicht zu sagen,bevorzuge nicht zu spezifizieren,non-binary,none binary,transgender,a-gender,intersexuel,transsexuel"
            )
            else -> listOf(
                "male:male,man,boy,mail,mabel,imail",
                "female:female,woman,girl,email,Gmail",
                "other:other,rather not say, rather not specify,non-binary,none binary,transgender,a-gender,intersex"
            )
        }
}

class WhatIsX(val x: String? = null) : ComplexEnumEntity() {
    override fun getEnum(lang: Language): List<String> =
        when (lang) {
            Language.MANDARIN -> listOf(
                "什么是 @x",
                "是什么 @x",
                "那什么是 @x",
                "我不知道什么是 @x",
                "我不确定我知道什么 @x means",
                "我不确定我知道什么是 @x",
                "我不知道是什么 @x is",
                "这是什么意思?",
                "这是什么 @x 意思?",
                "什么 @x",
                "是什么 @x",
                "定义 @x",
                "解释 @x",
                "我不理解 @x")
            Language.GERMAN -> listOf(
                "was ist @x",
                "was ist der @x",
                "was ist die @x",
                "was ist das @x",
                "was ist ein @x",
                "was ist eine @x",
                "und was ist @x",
                "und was ist der @x",
                "und was ist die @x",
                "und was ist das @x",
                "und was ist ein @x",
                "und was ist eine @x",
                "ich weiß nicht was ein @x ist",
                "ich weiß nicht was eine @x ist",
                "ich weiß nicht was der @x ist",
                "ich weiß nicht was die @x ist",
                "ich weiß nicht was das @x ist",
                "ich bin mir nicht sicher was @x bedeutet",
                "keine Ahnung was @x bedeutet",
                "keine Ahnung was @x ist",
                "ich bin mir unsicher was @x bedeutet",
                "ich bin mir unsicher was @x ist",
                "Was bedeutet das?",
                "was bedeutet @x ?",
                "Was is @x", "Was ist @x",
                "Was ist @x",
                "Was is @x",
                "Was ist der @x",
                "Was ist das @x",
                "Was ist die @x",
                "Was ist ein @x",
                "Was ist eine @x",
                "definire @x",
                "explain @x",
                "ich verstehe @x nicht")
            else -> listOf(
                "what is @x",
                "what is the @x",
                "and what is @x",
                "I don't know what is @x",
                "Not sure I know what @x means",
                "I'm not sure what's @x",
                "I'm not sure what @x is",
                "what does it mean?",
                "what does @x mean?",
                "what's @x",
                "what's the @x",
                "define @x",
                "explain @x",
                "I don't understand @x")
        }

    fun getDefinition(response: String?): String? {
        val responseText = response ?: text
        return when {
            responseText.contains(i18n.phrases.QUESTION_DIABETES) -> i18n.phrases.EXPLANATION_DIABETES
            responseText.contains(i18n.phrases.QUESTION_PHYSICAL_ACTIVITY) -> i18n.phrases.EXPLANATION_PHYSICAL_ACTIVITY
            responseText.contains(i18n.phrases.QUESTION_HIGH_BLOOD_PRESSURE) -> i18n.phrases.EXPLANATION_HIGH_BLOOD_PRESSURE
            responseText.contains(i18n.phrases.QUESTION_NAME) -> i18n.phrases.EXPLANATION_NAME
            responseText.contains(i18n.phrases.QUESTION_YOUR_QUEST) -> i18n.phrases.EXPLANATION_YOUR_QUEST
            else -> null
        }
    }
}



