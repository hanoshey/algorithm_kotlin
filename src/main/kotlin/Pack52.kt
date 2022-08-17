import java.util.LinkedList

object Pack52 {
    @JvmStatic
    fun main(args: Array<String>) {
        val q = LinkedList<Int>()
        q.offer(5)
        q.offer(2)
        q.offer(3)
        q.offer(7)
        q.poll()
        q.offer(1)
        q.offer(4)
        q.poll()
        while (!q.isEmpty())
            println(q.poll())
    }
}