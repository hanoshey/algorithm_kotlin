import java.util.*

object Pack610 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val arr = IntArray(n)
        for (i in arr.indices)
            arr[i] = sc.nextInt()
        arr.sortDescending()
        for (i in arr.indices)
            print("${arr[i]} ")
    }
}