import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
private fun main() {
    val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
    repeat(3) {
        GlobalScope.launch {
            println("${Thread.currentThread()} has started")
            for (i in states) {
                println("${Thread.currentThread()} - $i")
            }
        }
    }
}
