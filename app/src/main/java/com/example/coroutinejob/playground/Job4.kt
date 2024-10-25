package com.example.coroutinejob.playground

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doOneTwoThree3()
}

//앱이 종료될 때 Socket 연결을 끊어주는 것 처럼, 종료되었을 때 작업이 필요한 코드는 try catch, finally에 작업한다.
suspend fun doOneTwoThree3() = coroutineScope {
    val job1 = launch {
        try {
            println("launch1")
            delay(1000L)
            println("3")
        }finally {
            println("job1 is finishing")
        }
    }

    val job2 = launch {
        try {
            println("launch2")
            delay(1000L)
            println("1")
        }finally {
            println("job2 is finishing")
        }
    }

    val job3 = launch {
        try {
            println("launch3")
            delay(1000L)
            println("2")
        }finally {
            println("job3 is finishing")
        }
    }

    delay(800L)
    job1.cancel()
    job2.cancel()
    job3.cancel()
    println("4")

}