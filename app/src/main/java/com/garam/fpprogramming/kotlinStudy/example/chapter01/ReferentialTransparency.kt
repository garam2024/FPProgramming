package com.garam.fpprogramming.kotlinStudy.example.chapter01

fun main() {
    val result = transparent("Joe")
    print(result)
}

fun transparent(name: String): String {
    return "Hello $name"
}

fun print(helloStr: String) {
    println(helloStr)
}

var someName: String = "Joe"

fun hello1() {
    println("Hello $someName")
}

fun hello2(name: String) {
    println("Hello $name")
}

