package fp.kotlin.example.chapter11.logging

import fp.kotlin.example.chapter10.solution.FunStream
import fp.kotlin.example.chapter10.solution.flatMap
import fp.kotlin.example.chapter10.solution.fmap
import fp.kotlin.example.chapter10.solution.funStreamOf
import fp.kotlin.example.chapter10.solution.mappend
import fp.kotlin.example.chapter10.solution.printFunStream

fun main() {
    val result = functionalSolution3(funStreamOf(1, 2, 3))
    printFunStream(result.fmap { it.first })   // [false, false, true]
    printFunStream(
        result.flatMap { it.second } as FunStream<*>)   // [1 + 5, 6 * 6, 36 > 50, 2 + 5, 7 * 7, 49 > 50, 3 + 5, 8 * 8, 64 > 50]
}

private fun functionalSolution3(list: FunStream<Int>) = list
    .fmap { Pair(addFive(it), funStreamOf("$it + 5")) }
    .fmap { it.applyLog { x -> Pair(square(x), funStreamOf("$x * $x")) } }
    .fmap { it.applyLog { x -> Pair(isGreaterThan50(x), funStreamOf("$x > 50")) } }

private fun addFive(it: Int) = it + 5

private fun square(it: Int) = it * it

private fun isGreaterThan50(it: Int) = it > 50

private fun <T, R> Pair<T, FunStream<String>>.applyLog(
    f: (T) -> Pair<R, FunStream<String>>): Pair<R, FunStream<String>> {
    val applied = f(this.first)
    return Pair(applied.first, this.second mappend applied.second)
}