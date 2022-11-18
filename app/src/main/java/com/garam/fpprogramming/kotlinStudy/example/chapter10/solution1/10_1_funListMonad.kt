package fp.kotlin.example.chapter10.solution

import fp.kotlin.example.chapter10.Monad
import java.lang.ClassCastException

/**
 *
 * 연습문제 10-1
 *
 * ``Monad`` 타입클래스의 인스턴스인 ``FunList``를 작성하여 리스트 모나드를 만들어보자.
 *
 * 힌트 : mappend 함수를 사용하자.
 */

fun main() {
    val funList = FunList.Cons(1, FunList.Cons(2, FunList.Cons(3, FunList.Nil)))
    val result = funList.flatMap { FunList.Cons(it, FunList.Cons(it * 2, FunList.Cons(it * 3, FunList.Nil))) }

    require(result == FunList.Cons(1, FunList.Cons(2, FunList.Cons(3, FunList.Cons(2,
        FunList.Cons(4, FunList.Cons(6, FunList.Cons(3, FunList.Cons(6, FunList.Cons(9, FunList.Nil))))))))))

    val nilList = FunList.Nil
    val nilResult = nilList.flatMap { x: Int -> FunList.Cons(x, FunList.Cons(x * 2, FunList.Cons(x * 3, FunList.Nil))) }

    require(nilResult == FunList.Nil)
}

sealed class FunList<out A> : Monad<A> {

    data class Cons<out A>(val head: A, val tail: FunList<A>) : FunList<A>()

    object Nil : FunList<Nothing>()

    companion object {
        infix fun <V> pure(value: V): FunList<V> = Cons(0, Nil).pure(value)
    }

    override infix fun <V> pure(value: V): FunList<V> = when (this) {
        Nil -> Nil
        is Cons -> Cons(value, Nil)
    }

    override infix fun <B> flatMap(f: (A) -> Monad<B>): FunList<B> = when (this) {
        Nil -> Nil
        is Cons -> try {
            f(head) as FunList<B> mappend tail.flatMap(f)
        } catch (e: ClassCastException) {
            Nil
        }
    }

    infix fun <A> FunList<A>.mappend(other: FunList<A>): FunList<A> = when (this) {
        Nil -> other
        is Cons -> when (other) {
            Nil -> this
            is Cons -> Cons(this.head, this.tail.mappend(other))
        }
    }

    infix fun <B> leadTo(m: FunList<B>): FunList<B> = flatMap { m }
}

infix fun <A, B> FunList<(A) -> B>.apply(f: FunList<A>): FunList<B> = when (this) {
    is FunList.Nil -> FunList.Nil
    is FunList.Cons -> f.fmap(head) as FunList<B> mappend tail.apply(f)
}