object Pack55 {
    private fun factorialIterative(n: Int): Int {
        var result = 1
        for (i in 1..n)
            result *= i
        return result
    }

    private fun factorialRecursive(n: Int): Int {
        if (n <= 1) return 1
        return n * factorialRecursive(n - 1)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("반복적으로 구현: ${factorialIterative(5)}")
        println("재귀적으로 구현: ${factorialRecursive(5)}")
    }
}