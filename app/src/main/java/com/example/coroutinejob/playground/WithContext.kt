package com.example.coroutinejob.playground

import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    doOneTwoThree4()
}

//withContext(NonCancellable)은 취소가 되지 않는다.
suspend fun doOneTwoThree4() = coroutineScope {
    val job1 = launch {
        withContext(NonCancellable){
            println("launch1")
            delay(1000L)
            println("3")
        }
        delay(1000L)
        println("job1 is done")
    }

    val job2 = launch {
        withContext(NonCancellable){
            println("launch2")
            delay(1000L)
            println("1")
        }
        delay(1000L)
        println("job2 is done")
    }

    val job3 = launch {
        withContext(NonCancellable){
            println("launch3")
            delay(1000L)
            println("2")
        }
        delay(1000L)
        println("job3 is done")
    }

    delay(800L)
    job1.cancel()
    job2.cancel()
    job3.cancel()
    println("4")

}