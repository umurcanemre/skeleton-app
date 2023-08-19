package com.umurcan.skeletonapp.service

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class AnagramCheckerTest {
    private val target = AnagramChecker()

    @ParameterizedTest
    @MethodSource("anagrams")
    fun `should return true on anagrams`(word1: CharArray, word2: CharArray) {
        assertTrue(target.isAnagram(word1, word2))
    }

    @Test
    fun `should return true on empty words`() {
        assertTrue(target.isAnagram("      ".toCharArray(), "".toCharArray()))
        assertTrue(target.isAnagram("".toCharArray(), "".toCharArray()))
    }

    @ParameterizedTest
    @MethodSource("international_anagrams")
    fun `should return true on special character anagrams`(word1: CharArray, word2: CharArray) {
        assertTrue(target.isAnagram(word1, word2))
    }

    @ParameterizedTest
    @MethodSource("non-anagrams")
    fun `should return false on non-anagrams`(word1: CharArray, word2: CharArray) {
        assertFalse(target.isAnagram(word1, word2))
    }


    companion object {
        @JvmStatic
        fun anagrams() = listOf(
                Arguments.of("anagrams".toCharArray(), "Ars magna".toCharArray()),
                Arguments.of("New York Times".toCharArray(), "monkeys write".toCharArray()),
                Arguments.of("evil".toCharArray(), "vile".toCharArray()),
                Arguments.of("forty five".toCharArray(), "over fifty".toCharArray()),
                Arguments.of("William Shakespeare".toCharArray(), "I am a weakish speller".toCharArray()),
                Arguments.of("Tom Marvolo Riddle".toCharArray(), "I am Lord Voldemort".toCharArray()),
        )
        @JvmStatic
        fun international_anagrams() = listOf(
                Arguments.of("Fußgängerübergänge".toCharArray(), "berg F gerüÄnge ußgän".toCharArray()),
                Arguments.of("पैदल यात्री क्रॉसिंग".toCharArray(), "पैदल क्रॉसिंग   यात्री".toCharArray()),
                Arguments.of("人行横道".toCharArray(), "  人行道  横".toCharArray()),
                Arguments.of("横断歩道".toCharArray(), "横断 道 歩".toCharArray()),
                Arguments.of("çığ düşüyör".toCharArray(), "ığç üyör düş".toCharArray()),
        )
        @JvmStatic
        fun `non-anagrams`() = listOf(
                Arguments.of("anagrams".toCharArray(), "    ".toCharArray()),
                Arguments.of("New York Timess".toCharArray(), "monkeys write".toCharArray()),
                Arguments.of("evil".toCharArray(), "ville".toCharArray()),
                Arguments.of("forty    five".toCharArray(), "ower fifty".toCharArray()),
                Arguments.of("William Shakespeare".toCharArray(), "I am a strong speller".toCharArray()),
                Arguments.of("Tom Marvolo Riddle".toCharArray(), "I am Mord Voldemort".toCharArray()),
        )
    }
}