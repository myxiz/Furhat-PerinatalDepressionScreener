package furhatos.app.medicalscreener.nlu

import furhatos.nlu.GrammarEntity
import furhatos.nlu.Interpreter
import furhatos.nlu.InterpreterException
import furhatos.nlu.common.NumberGrammarEn
import furhatos.nlu.grammar.Grammar
import furhatos.nlu.kotlin.grammar
import furhatos.util.Language
import org.junit.Assert
import org.junit.Test

class CustomNumber(
    val value : Int? = null
) : GrammarEntity() {
    override fun getGrammar(lang: Language) : Grammar {
        return when (lang.main) {
            "de" -> NumberGrammarDe
            "en" -> NumberGrammarEn
            "zh" -> NumberGrammarZh
            else -> throw  InterpreterException("Language $lang is not supported for ${javaClass.name}")
        }
    }

    override fun getSpeechRecPhrases(lang: Language?): List<String> {
        when (lang) {
            Language.MANDARIN -> return listOf("\$ADDRESSNUM", "十", "点","米", "百") // characters for: ten, point, metre, hundred
            else -> return listOf("\$ADDRESSNUM") // This primes for all integers according to: https://cloud.google.com/speech-to-text/docs/context-strength
        }
    }
}

val NumberGrammarDe = grammar {
    rule(public = true) {
        regexp("[0-9]+") tag { it.group(0).toInt()}
        ruleref("number_1_99")
    }
    rule("number_1_99") {
        ruleref("number_1_9")
        ruleref("number_10_19")
        ruleref("number_20_90")
        group {
            ruleref("number_20_90")
            ruleref("number_1_9")
            tag {
                (ref["number_20_90"] as Int) + (ref["number_1_9"] as Int)
            }
        }
    }
    rule("number_1_9") {
        +"eins" tag { 1 }
        +"zwei" tag { 2 }
        +"drei" tag { 3 }
        +"vier" tag { 4 }
        +"fünf" tag { 5 }
        +"sechs" tag { 6 }
        +"sex" tag { 6 }
        +"sieben" tag { 7 }
        +"acht" tag { 8 }
        +"nein" tag { 9 }
    }
    rule("number_10_19") {
        +"zehn" tag { 10 }
        +"elf" tag { 11 }
        +"zwölf" tag { 12 }
        +"dreizehn" tag { 13 }
        +"vierzehn" tag { 14 }
        +"fünfzehn" tag { 15 }
        +"sechzehn" tag { 16 }
        +"siebzehn" tag { 17 }
        +"achtzehn" tag { 18 }
        +"neunzehn" tag { 19 }
    }
    rule("number_20_90") {
        +"zwanzig" tag { 20 }
        +"dreissig" tag { 30 }
        +"vierzig" tag { 40 }
        +"fünfzig" tag { 50 }
        +"sechzig" tag { 60 }
        +"siebzig" tag { 70 }
        +"achtzig" tag { 80 }
        +"neunzig" tag { 90 }
    }

}

val NumberGrammarZh =
    grammar {

        val ten = "十"

        rule(public = true) {
            ruleref("digits")
            ruleref("number_0_9")
            +ten tag { 10 }
            group {
                ruleref("part1", "number_0_9")
                -ten
                ruleref("part2", "number_0_9")
                tag {
                    ((ref["part1"] as Int) * 10) + (ref["part2"] as Int)
                }
            }
            group {
                ruleref("number_0_9")
                ruleref("hundred")
                tag {
                    (ref["number_0_9"] as Int) * 100
                }
            }
            group {
                ruleref("part1", "number_0_9")
                optional { ruleref("hundred") }
                ruleref("part2", "number_0_9")
                -ten
                ruleref("part3", "number_0_9")
                tag {
                    (ref["part1"] as Int) * 100 + (ref["part2"] as Int) * 10 + (ref["part3"] as Int)
                }
            }
            group {
                ruleref("part1", "number_0_9")
                ruleref("hundred")
                ruleref("part2", "number_0_9")
                -(ten / "零") // "ten" or "zero"
                tag {
                    (ref["part1"] as Int) * 100 + (ref["part2"] as Int) * 10
                }
            }
            group {
                ruleref("part1", "number_0_9")
                ruleref("hundred")
                ruleref("part2", "digits")
                tag {
                    (ref["part1"] as Int) * 100 + (ref["part2"] as Int)
                }
            }
        }

        rule("hundred") {
            +"点" // point
            +"米" // meter
            +"百" // hundred
        }

        rule("digits") {
            regexp("[1-9][0-9]+") tag { it.group(0).toInt() }
        }

        rule("number_0_9") {
            +"0" tag { 0 }
            +"零" tag { 0 }
            +"1" tag { 1 }
            +"一" tag { 1 }
            +"壹" tag { 1 }
            +"2" tag { 2 }
            +"二" tag { 2 }
            +"贰" tag { 2 }
            +"3" tag { 3 }
            +"三" tag { 3 }
            +"叁" tag { 3 }
            +"4" tag { 4 }
            +"四" tag { 4 }
            +"肆" tag { 4 }
            +"5" tag { 5 }
            +"五" tag { 5 }
            +"伍" tag { 5 }
            +"6" tag { 6 }
            +"六" tag { 6 }
            +"陆" tag { 6 }
            +"7" tag { 7 }
            +"七" tag { 7 }
            +"柒" tag { 7 }
            +"8" tag { 8 }
            +"八" tag { 8 }
            +"捌" tag { 8 }
            +"9" tag { 9 }
            +"九" tag { 9 }
            +"玖" tag { 9 }
        }
    }

class NumberZhTest() {

    val interp = Interpreter(Language.MANDARIN)

    @Test
    fun testGrammar() {
        testNumberExpression("75", 75)
        testNumberExpression("十", 10)
        testNumberExpression("贰", 2)
        testNumberExpression("壹百贰伍", 125) // one, hundred, two, five
        testNumberExpression("壹零伍", 105) // one, zero, five
        testNumberExpression("一米二十", 120) // one,metre,two,ten
        testNumberExpression("一米78", 178)
    }

    private fun testNumberExpression(text : String, expected: Int) {
        val number = interp.findFirst(CustomNumber(), text)
        Assert.assertEquals("Bad parse of: '$text'", expected, number?.value)
    }

}
