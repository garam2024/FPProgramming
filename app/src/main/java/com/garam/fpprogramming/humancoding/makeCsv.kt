package com.garam.fpprogramming.humancoding


import java.io.File
import java.io.InputStream

val file = File("Salary_Data.csv").inputStream()
fun main(args: Array<String>) {
    readCsv(file)
}

data class Employee(
    val YearsExperience: Float,
    val Age: Float,
    val Salary: Int
)

fun readCsv(inputStream: InputStream): List<Employee> {
    val reader = inputStream.bufferedReader()
    val header = reader.readLine()
    return reader.lineSequence().filter { it.isNotBlank() }.map {
        val (YearsExperience, Age, Salary) = it.split(',', ignoreCase = false, limit = 3)
        Employee(YearsExperience.toFloat(),Age.toFloat(),Salary.toInt())
    }.toList()
}

