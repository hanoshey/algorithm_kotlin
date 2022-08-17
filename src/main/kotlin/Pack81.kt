object Pack81 {
    private fun fibo(x: Int): Int {
        if (x == 1 || x == 2) return 1
        return fibo(x - 1) + fibo(x - 2)
    }

    @JvmStatic
    fun main(args: Array<String>) = println(fibo(50))
}