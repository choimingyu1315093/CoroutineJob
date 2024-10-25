package com.example.coroutinejob.playground

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doOneTwoThree2()
}

//job.cancel()은 취소. 단, 취소 불가능한 job도 있다.
suspend fun doOneTwoThree2() = coroutineScope {
    val job1 = launch {
        println("launch1")
        delay(1000L)
        println("3")
    }

    val job2 = launch {
        println("launch2")
        println("1")
    }

    val job3 = launch {
        println("launch3")
        delay(500L)
        println("2")
    }

    delay(800L)
    job1.cancel()
    job2.cancel()
    job3.cancel()
    println("4")
}