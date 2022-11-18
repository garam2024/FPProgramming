package fp.kotlin.example.chapter10.exercise

import fp.kotlin.example.chapter10.Monad

/**
 *
 * 연습문제 10-7
 *
 * 함수 합성 관점에서 리스트 모나드가 모나드 법칙 세 가지를 만족하는지 확인하라.
 *
 */

fun main() {

    val f = {x : Int -> Cons(x * 10, Nil) }
    val g = {x : Int -> Cons(x + 1, Nil) }
    val h = {x : Int -> Cons(x - 5, Nil) }
    val pure = { x : Int -> FunList.pure(x) }

    require((pure compose f)(10) == f(10))
    require((f compose pure)(10) == f(10))
    require(((f compose g) compose h)(10) == (f compose (g compose h))(10))
}

infix fun <F, G, R> ((F) -> Monad<R>).compose(g: (G) -> Monad<F>): (G) -> Monad<R> {
    return { gInput: G -> g(gInput) flatMap this }
}