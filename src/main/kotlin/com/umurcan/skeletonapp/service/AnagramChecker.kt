package com.umurcan.skeletonapp.service

class AnagramChecker {

    fun isAnagram(word1 : CharArray, word2 : CharArray) : Boolean {
        val charMap = mutableMapOf<Char, Int>()
        val sanitizeWord1 = sanitizeWord(word1)
        val sanitizeWord2 = sanitizeWord(word2)

        for (char in sanitizeWord1) {
            charMap[char] = charMap.getOrDefault(char, 0) + 1
        }
        for (char in sanitizeWord2) {
            if (!charMap.containsKey(char)){
                return false
            }
            if (charMap.getOrDefault(char, 0) <= 0){
                return false
            }
            charMap[char] = charMap.getOrDefault(char, 0) - 1
        }

        for (tuple in charMap) {
            if (tuple.value > 0) {
                return false
            }
        }

        return true
    }

    companion object {
        fun sanitizeWord(word : CharArray) : CharArray{
            return word.filter { it.isLetter() }.map { it.lowercaseChar() }.toCharArray()
        }
    }
}