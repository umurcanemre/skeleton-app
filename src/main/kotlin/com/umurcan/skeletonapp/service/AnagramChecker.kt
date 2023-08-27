package com.umurcan.skeletonapp.service

import org.springframework.stereotype.Component

@Component
class AnagramChecker {

    fun isAnagram(text1: CharArray, text2: CharArray): Boolean {
        val charMap = mutableMapOf<Char, Int>()
        val sanitizedText1 = sanitizeWord(text1)
        val sanitizedText2 = sanitizeWord(text2)

        for (char in sanitizedText1) {
            charMap[char] = charMap.getOrDefault(char, 0) + 1
        }
        for (char in sanitizedText2) {
            if (!charMap.containsKey(char)) {
                return false
            }
            if (charMap.getOrDefault(char, 0) <= 0) {
                return false
            }
            charMap[char] = charMap.getOrDefault(char, 0) - 1
        }
        for (tuple in charMap) {
            if (tuple.value != 0) {
                return false
            }
        }

        return true
    }

    companion object {
        fun sanitizeWord(text: CharArray): CharArray {
            return text.filter { it.isLetter() }.map { it.lowercaseChar() }.toCharArray()
        }
    }
}