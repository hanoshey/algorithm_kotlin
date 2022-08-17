import java.util.Scanner

object Pack42 {
    private fun check(h: Int, m: Int, s: Int): Boolean {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) {
            return true
        }
        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val h = sc.nextInt()
        var cnt = 0
        for (i in 0..h) {
            for (j in 0 until 60) {
                for (k in 0 until 60) {
                    if (check(i, j, k)) cnt++
                }
            }
        }
        println(cnt)
    }
}