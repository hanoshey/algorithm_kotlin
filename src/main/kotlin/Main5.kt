import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

private fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            println(getWeatherReport())
            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

private suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

private suspend fun getTemperature(): String {
    delay(1000)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}

private suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    delay(200)
    temperature.cancel()
    forecast.await()
}