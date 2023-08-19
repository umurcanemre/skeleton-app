package com.umurcan.skeletonapp.controller

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class NotBlankCharArrayValidatorTest {
    val target = NotBlankCharArrayValidator()
    @Test
    fun `null or empty char array should fail`() {
        assertFalse(target.isValid("".toCharArray(), null))
        assertFalse(target.isValid("    ".toCharArray(), null))
        assertFalse(target.isValid(null, null))
    }

    @Test
    fun `text with chars and empty space should pass`() {
        assertTrue(target.isValid("test test".toCharArray(), null))
    }
}