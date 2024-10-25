package com.example.coroutinejob.playground

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking {
//    withTimeout(500L){
//        doCount2()
//    }

    val result = withTimeoutOrNull(500L){
        doCount2()
        true
    } ?: false
    println(result)
}

//withTimeout은 일정 시간 후에 종료된다.
//withTimeoutOrNull은 일정 시간 후에 종료되거나 null을 반환한다.
suspend fun doCount2() = coroutineScope {
    val job1 = launch (Dispatchers.Default){
        var i = 1
        var nextTime = System.currentTimeMillis() + 100L

        while (i <= 10 && isActive) {
            val currentTime = System.currentTimeMillis()
            if (currentTime >= nextTime) {
                println(i)
                nextTime = currentTime + 100L
                i++
            }
        }
    }
}