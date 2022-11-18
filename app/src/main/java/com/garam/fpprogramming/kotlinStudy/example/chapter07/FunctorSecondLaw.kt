package com.garam.fpprogramming.kotlinStudy.example.chapter07

//import com.garam.fpprogramming.kotlinStudy.example.chapter04.compose
//import fp.kotlin.example.chapter07.*
//import fp.kotlin.example.chapter07.Nothing
//
//fun main() {
//    val f = { a: Int -> a + 1 }
//    val g = { b: Int -> b * 2 }
//
//    // Maybe 2 laws
//    val nothingLeft = Nothing.fmap(f compose g)
//    // compile error
//    // val nothingRight = Nothing.fmap(f) compose Nothing.fmap(g)
//    val nothingRight = Nothing.fmap(g).fmap(f)
//    println(nothingLeft == nothingRight)  // true
//
//    val justLeft = Just(5).fmap(f compose g)
//    // compile error
//    // val justRight = Just(5).fmap(f) compose Just(0).fmap(g)
//    val justRight = Just(5).fmap(g).fmap(f)
//    println(justLeft == justRight)  // true
//
//    // Tree 2 laws
//    val tree = Node(1, Node(2, EmptyTree, EmptyTree), Node(3, EmptyTree, EmptyTree))
//
//    println(EmptyTree.fmap(f compose g) == EmptyTree.fmap(g).fmap(f))  // true
//    println(tree.fmap(f compose g) == tree.fmap(g).fmap(f))  // true
//
//    // Either 2 laws
//    println(Left("error").fmap(f compose g) == Left("error").fmap(g).fmap(f))  // true
//    println(Right(5).fmap(f compose g) == Right(5).fmap(g).fmap(f))  // true
//}

