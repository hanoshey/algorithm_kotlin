package Chapter6

object Pack67 {
    @JvmStatic
    fun main(args: Array<String>) {
        val n = 10
        val arr = intArrayOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)
        arr.sort()
        for (i in 0 until n)
            print("${arr[i]} ")
    }
}