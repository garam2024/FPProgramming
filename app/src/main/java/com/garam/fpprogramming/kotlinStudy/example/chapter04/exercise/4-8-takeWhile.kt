package fp.kotlin.example.chapter04.exercise

/**
 * 연습문제 4-8
 *
 * 연습문제 4-7에서 작성한 ``takeWhile``를 수정하여, 무한대를 입력받을 수 있는 ``takeWhile``을 tailrec으로 작성해보자.
 *
 * 힌트 : ``generateSequence(1) { it + 1 }`` 는 초깃값 1을 기준으로 값이 1씩 무한대로 증가하는 무한대의 리스트를 표현한다.
 */

fun main() {
    require(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9) == takeWhile({ p -> p < 10 }, generateSequence(1) { it + 1 }))
}

private tailrec fun <P> takeWhile(predicate: (P) -> Boolean, sequence: Sequence<P>, acc: List<P> = listOf()): List<P> = TODO()