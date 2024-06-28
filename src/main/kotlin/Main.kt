import kotlinx.coroutines.delay
//import kotlinx.coroutines.runBlocking
//import java.time.LocalTime
//import java.time.format.DateTimeFormatter
//
//val formatter = DateTimeFormatter.ISO_LOCAL_TIME
//val time = { formatter.format(LocalTime.now()) }
//suspend fun getValue(): Double {
//    println("entering getValue() at ${time()}")
//    delay(1000)
//    println("leaving getValue() at ${time()}")
//    return Math.random()
//}
//
//fun main() {
//    runBlocking {
//        val num1 = getValue()
//        val num2 = getValue()
//        println("result of num1 + num2 is ${num1 + num2}")
//    }
//}