package com.garam.fpprogramming.kotlinStudy.example.chapter04

fun main() {
    val ints: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // 명령형 프로그래밍 예
    val over10Values: ArrayList<Int> = ArrayList()

    for (element in ints) {
        val twiceInt = element * 2
        if(twiceInt > 10){
            over10Values.add(twiceInt)
        }
    }

    println(over10Values)   // [12, 14, 16, 18, 20]

    // 고차함수를 사용한 예
    val result = ints
            .map { value -> value * 2 }
            .filter { value -> value > 10 }

    println(result)  // [12, 14, 16, 18, 20]

    // 코틀린 it 사용한 예
    val result2 = ints
            .map { it * 2 }
            .filter { it > 10 }

    println(result2)            // [12, 14, 16, 18, 20]
}
