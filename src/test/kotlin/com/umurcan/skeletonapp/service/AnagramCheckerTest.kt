package com.umurcan.skeletonapp.service

import org.junit.jupiter.api.Assertions.assertTrue
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
    }
}