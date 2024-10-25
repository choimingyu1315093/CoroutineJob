package com.example.coroutinejob.playground

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doCount()
}

//job.cancel()한다고 다 종료되는게 아니라서, 확실히 종료하려면 isActive 조건문 넣어서 종료하는게 좋다
//isActive 코루틴이 활성화 중인가?
suspend fun doCount() = coroutineScope {
    val job1 = launch (Dispatchers.Default){
        var i = 1
        var nextTime = System.currentTimeMillis() + 100L
        while (i <= 10 && isActive){
            val currentTime = System.currentTimeMillis()
            if (currentTime >= nextTime) {
                println(i)
                nextTime = currentTime + 100L
                i++
            }
        }
    }

    delay(200L)
    job1.cancel()
    job1.join()
    //또는 job1.cancelAndJoin()
    println("doCount Done")
}