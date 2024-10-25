package com.example.coroutinejob.playground
import kotlinx.coroutines.*

fun main() = runBlocking {
    doOneTwoThree()
}

//coroutineScope는 오히려 launch와 비슷하다. 중단하지 않고 일을 계속 시킨다.
//launch는 Job객체를 반환한다.
//launch 블록은 바로 수행되는게 아니라, 순서를 기다린다. 그래서 실행하면 println(4)가 먼저 호출된다.
suspend fun doOneTwoThree() = coroutineScope {
    val job = launch {
        println("launch1")
        delay(1000L)
        println("3")
    }
    job.join() // job이 끝날때 까지 기다리게 한다.

    launch {
        println("launch2")
        println("1")
    }

    launch {
        println("launch3")
        delay(500L)
        println("2")
    }

    println("4")
}