package com.sercan.yigit.common.utils

fun String.titleCase() = replaceFirstChar(Char::titlecase)

fun isNumeric(toCheck: String): Boolean {
    val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    return toCheck.matches(regex)
}