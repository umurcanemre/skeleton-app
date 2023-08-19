package com.umurcan.skeletonapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SkeletonAppApplication

fun main(args: Array<String>) {
    runApplication<SkeletonAppApplication>(*args)
}
