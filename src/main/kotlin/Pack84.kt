object Pack84 {
    val d = LongArray(100)

    @JvmStatic
    fun main(args: Array<String>) {
        //첫 번째 피보나치 수와 두번째.. 수는 1
        d[1] = 1
        d[2] = 1
        val n = 50//50번째 피보나치 수
        //보텀업 다이나믹 프로그래밍
        for (i in 3..n)
            d[i] = d[i - 1] + d[i - 2]
        println(d[n])
    }
}