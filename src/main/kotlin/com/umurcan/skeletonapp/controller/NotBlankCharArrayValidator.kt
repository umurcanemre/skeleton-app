package com.umurcan.skeletonapp.controller

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class NotBlankCharArrayValidator : ConstraintValidator<NotBlank, CharArray> {
    override fun isValid(value: CharArray?, context: ConstraintValidatorContext?): Boolean {
        return value?.any { !it.isWhitespace() } ?: false
    }
}