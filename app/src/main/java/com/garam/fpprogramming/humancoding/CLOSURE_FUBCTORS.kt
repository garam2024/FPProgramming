package fp.humancoding


/*
CLOSURE, FUNCTORS & STDLIB FUNCTIONS

closure; let()
functor; map()
stdlib functions : run(), with(), apply(), also(), ...


 */



class StandardFunctions {


    init {
        this.letFunc()
        this.mapFunc()
        this.withFunc()
        this.applyFunc()
        this.runFunc()
        this.alsoFunc()
    }

    fun letFunc(): Unit {
        //확장함수 , 오브젝트 자체가 확장함수의 리시버 오브젝트처럼 it 으로 넘어 온다
        //람다식을 수행해서 평가한다음 마지막 람다식의 값을 리턴한다
        val obj = "ABCDE"
        var count = 0
        val result: Char = obj.let {
            println("[$count] in the let() function : ")
            count++
            println("this = $this") //this = fp.humancoding.StandardFunctions@3d8c7aca
            //여기서 this 는 Class 를 나타낸다
            println("this@StandardFunctions = ${this@StandardFunctions}")
            println("it = $it")
            it[0]
            //println("obj => $obj and count -> $count \n\n")
            //return@Map 'B'
            //return 'B
            //  'A'
        }
        println("result => $result and count -> $count and obj => $obj\n\n")
    }

    fun mapFunc(): Unit {
        val obj: List<Char> = "ABCDE".toList()
        var count = 0
        val result: List<Char> = obj.map {
            println("[$count] in the map() function : ")
            count++
            println("this = $this") //this = fp.humancoding.StandardFunctions@3d8c7aca
            //여기서 this 는 Class 를 나타낸다
            println("this@StandardFunctions = ${this@StandardFunctions}")
            println("it = $it")
            it.toLowerCase()
            //println("obj => $obj and count -> $count \n\n")
            //  'A'
        }
        println("result => $result and count -> $count and obj => $obj\n\n")
    }

    /*
    /**
 * Calls the specified function [block] with the given [receiver] as its receiver and returns its result.
 *
 * For detailed usage information see the documentation for [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#with).
 */
@kotlin.internal.InlineOnly
public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return receiver.block()
}
     */

    fun withFunc(): Unit {
        val obj: Toy = Toy("Gundam", 100, ToyType.DOLL)
        var count = 0
        val result: Char = with(obj) {
            println("[$count] in the with() function : ")
            count++
            println("this = $this") //this = fp.humancoding.StandardFunctions@3d8c7aca
            //여기서 this 는 Class 를 나타낸다
            println("this@StandardFunctions = ${this@StandardFunctions}")
            //println("it = $it") //error
            name += " NK-II"
            price = 10000
            category = ToyType.ROBOT
            'A'
        }
        println("result => $result and count -> $count and obj => $obj\n\n")
        //result => A and count -> 1 and obj => Toy(name=Gundam NK-II, price=10000, category=ROBOT)
    }

    fun applyFunc(): Unit {
        val obj: Toy = Toy("Princess")
            .apply {
                name += " Elsa"
                price = 2000
            }
            .apply { category = ToyType.DOLL }
        var count = 0
        val result: Toy = obj.apply {
            println("[$count] in the apply() function : ")
            count++
            println("this = $this") //this = fp.humancoding.StandardFunctions@3d8c7aca
            //여기서 this 는 Class 를 나타낸다
            println("this@StandardFunctions = ${this@StandardFunctions}")
            //println("it = $it") //error
            name += " Elsa"
            price = 2000
            category = ToyType.DOLL
            'A'
        }
        println("result => $result and count -> $count and obj => $obj \n\n")
    }
    /*
    /**
 * Calls the specified function [block] with `this` value as its receiver and returns its result.
 *
 * For detailed usage information see the documentation for [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#run).
 */
@kotlin.internal.InlineOnly
public inline fun <T, R> T.run(block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}
     */

    fun runFunc(): Unit {
        val obj: Toy = Toy("Telsa", 100, ToyType.SPACESHIP)
        var count = 0
        val result: Char = obj.run {
            println("[$count] in the run() function : ")
            count++
            println("this = $this") //this = fp.humancoding.StandardFunctions@3d8c7aca
            //여기서 this 는 Class 를 나타낸다
            println("this@StandardFunctions = ${this@StandardFunctions}")
            //println("it = $it") //error
            name += " model S"
            price = 10000
            category = ToyType.CAR
            'A'
        }
        println("result => $result and count -> $count and obj => $obj \n\n")
    }

    fun alsoFunc(): Unit {
        val obj: Toy = Toy("Apolo", 100, ToyType.BRICK)
        var count = 0
        val result: Toy = obj.also {
            println("[$count] in the also() function : ")
            count++
            println("this = $this") //this = fp.humancoding.StandardFunctions@3d8c7aca
            //여기서 this 는 Class 를 나타낸다
            println("this@StandardFunctions = ${this@StandardFunctions}")
            println("it = $it")
            //this.name += " XII" //error
            it.name += " XII"
            it.price = 999999
            it.category = ToyType.SPACESHIP
            'A'
        }
        println("result => $result and count -> $count and obj => $obj \n\n")
    }


}

data class Toy(var name: String, var price: Int = 0, var category: ToyType = ToyType.NONE)

enum class ToyType { NONE, ROBOT, DOLL, CAR, BRICK, SPACESHIP }

fun main(args: Array<String>) {
    // println("letFunc return : " + StandardFunctions().letFunc())//letFunc return : kotlin.Unit
    StandardFunctions()
}