package com.umurcan.skeletonapp.controller

import com.umurcan.skeletonapp.controller.AnagramController.Companion.API_PATH
import com.umurcan.skeletonapp.service.AnagramChecker
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping(
        value = [API_PATH],
        produces = [MediaType.APPLICATION_JSON_VALUE]
)
class AnagramController {
    @Autowired
    lateinit var anagramChecker: AnagramChecker

    @PostMapping
    fun checkTextsForAnagram(@Valid @RequestBody request: AnagramRequest) : AnagramResponse{
        val isAnagram = anagramChecker.isAnagram(request.text1, request.text2)
        return AnagramResponse(isAnagram)
    }
    data class AnagramRequest(@field:NotBlank(message = "text1 cannot be blank") val text1: CharArray,
                              @field:NotBlank(message = "text2 cannot be blank") val text2: CharArray)
    data class AnagramResponse(val isAnagram : Boolean)

    companion object{
        const val API_PATH = "api/v1/anagram"
    }
}