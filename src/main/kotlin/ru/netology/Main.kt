package ru.netology

import com.ibm.icu.text.PluralRules
import java.util.*

fun main() {
    val locale = Locale("RU")
    val plurals = PluralRules.forLocale(locale)
    repeat(62) { likeCount ->
        val likes = getLikes(likeCount, plurals)
        println(likes)
    }
}

private fun getLikes(likes: Int, plurals: PluralRules): String {
    if (likes == 0) {
        return "Нет лайков"
    }

    val plural = plurals.select(likes.toDouble())
    return when (plural) {
        PluralRules.KEYWORD_ONE -> "%d человеку"
        PluralRules.KEYWORD_FEW -> "%d людям"
        else -> "%d людям"
    }.format(likes)
}