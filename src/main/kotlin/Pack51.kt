import java.util.*

object Pack51 {
    @JvmStatic
    fun main(args: Array<String>) {
        val s = Stack<Int>()
        s.push(5)
        s.push(2)
        s.push(3)
        s.push(7)
        s.pop()
        s.push(1)
        s.push(4)
        s.pop()
        while (!s.empty()) {
            println(s.peek())
            s.pop()
        }

    }
}