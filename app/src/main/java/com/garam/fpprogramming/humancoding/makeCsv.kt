package com.garam.fpprogramming.humancoding


import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.InputStream

//val file = File("Salary_Data.csv").inputStream()
fun main(args: Array<String>) {

}

data class Employee(
    val YearsExperience: Any ,
    val Age: Any,
    val Salary: Int,
)

data class Employee2(
    val experience : Float,
    val age : Float,
    val Salary: Float
)

fun Employee.toEmployee2() = Employee2(experience = YearsExperience.toString().toFloat(),age = Age.toString().toFloat(),Salary = Salary.toFloat())



 val EmployeeList: List<Employee> =listOf(Employee(1.1,21,39343),
    Employee(1.3,21.5,46205),
    Employee(1.5,21.7,37731),
    Employee(2,22,43525),
    Employee(2.2,22.2,39891),
    Employee(2.9,23,56642),
    Employee(3,23,60150),
    Employee(3.2,23.3,54445),
    Employee(3.2,23.3,64445),
    Employee(3.7,23.6,57189),
    Employee(3.9,23.9,63218),
    Employee(4,24,55794),
    Employee(4,24,56957),
    Employee(4.1,24,57081),
    Employee(4.5,25,61111),
    Employee(4.9,25,67938),
    Employee(5.1,26,66029),
    Employee(5.3,27,83088),
    Employee(5.9,28,81363),
    Employee(6,29,93940),
    Employee(6.8,30,91738),
    Employee(7.1,30,98273),
    Employee(7.9,31,101302),
    Employee(8.2,32,113812),
    Employee(8.7,33,109431),
Employee(9,34,105582),
Employee(9.5,35,116969),
Employee(9.6,36,112635),
Employee(10.3,37,122391),
Employee(10.5,38,121872))
