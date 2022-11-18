package fp.kotlin.example.chapter03

fun main() {
    println(fiboRecursion(6))   // 8
    println(fiboMemoization(6)) // 8
    println(fiboFP(6))  // 8
}

private fun fiboRecursion(n: Int): Int {
    println("fiboRecursion($n)")
    return when (n) {
        0 -> 0
        1 -> 1
        else -> fiboRecursion(n - 2) + fiboRecursion(n - 1)
    }
}

private var memo = Array(100) { -1 }

private fun fiboMemoization(n: Int): Int = when {
    n == 0 -> 0
    n == 1 -> 1
    memo[n] != -1 -> memo[n]
    else -> {
        println("fiboMemoization($n)")
        memo[n] = fiboMemoization(n - 2) + fiboMemoization(n - 1)
        memo[n]
    }
}

private fun fiboFP(n: Int): Int = fiboFP(n, 0, 1)

private tailrec fun fiboFP(n: Int, first: Int, second: Int): Int = when (n) {
    0 -> first
    1 -> second
    else -> fiboFP(n - 1, second, first + second)
}