package fp.kotlin.example.chapter05.solution

import fp.kotlin.example.chapter05.FunStream
import fp.kotlin.example.chapter05.dropWhile
import fp.kotlin.example.chapter05.funStreamOf
import fp.kotlin.example.chapter05.getHead
import fp.kotlin.example.chapter05.getTail
import fp.kotlin.example.chapter05.toFunStream

/**
 *
 * 연습문제 5-20
 *
 * FunList에서 작성했던 filter 함수를 FunStream에도 추가하자.
 *
 * 힌트: 함수의 선언 타입은 아래와 같다.
 *
 */

fun main() {
    require(funStreamOf(1, 2, 3, 4, 5)
        .filter { it % 2 == 0 } == funStreamOf(2, 4))
    require(funStreamOf(1, 2, 3, 4, 5)
        .filter { it > 6 } == FunStream.Nil)
    require((1..100000000)
        .toFunStream()
        .filter { it > 100 }
        .getHead() == 101)
}

fun <T> FunStream<T>.filter(p: (T) -> Boolean): FunStream<T> = when (this) {
    FunStream.Nil -> FunStream.Nil
    is FunStream.Cons -> {
        val first = dropWhile(p)
        if (first != FunStream.Nil) {
            FunStream.Cons({ first.getHead() }, { first.getTail().filter(p) })
        } else {
            FunStream.Nil
        }
    }
}