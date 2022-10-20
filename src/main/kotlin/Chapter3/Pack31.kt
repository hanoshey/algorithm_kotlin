package Chapter3

object Pack31 {
    @JvmStatic
    fun main(args: Array<String>) {
        var n = 1260
        var cnt = 0
        val coinTypes = intArrayOf(500, 100, 50, 10)
        for (e in coinTypes) {
            cnt += n / e
            n %= e
        }
        println(cnt)
    }
}