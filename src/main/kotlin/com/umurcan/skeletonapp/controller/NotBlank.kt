package com.umurcan.skeletonapp.controller

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [NotBlankCharArrayValidator::class])
annotation class NotBlank(
        val message: String = "Text field must not be blank",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = []
)
