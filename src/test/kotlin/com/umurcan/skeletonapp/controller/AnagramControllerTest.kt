package com.umurcan.skeletonapp.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class AnagramControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `test valid request`() {
        val requestJson = """
            {
                "text1": "Tom Marvolo Riddle", 
                "text2": "I am Lord Voldemort"
            }
        """.trimIndent()

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/anagram")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.isAnagram").value("true"))
                .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `test request with blank fields`() {
        val requestJson = """
            {
                "text1": "  ",
                "text2": "some text"
            }
        """.trimIndent()

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/anagram")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isBadRequest)
    }

    @Test
    fun `test request with null fields`() {
        val requestJson = """
            {
                "text2": "some text"
            }
        """.trimIndent()

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/anagram")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isBadRequest)
    }
}