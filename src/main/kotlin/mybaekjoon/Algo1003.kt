package mybaekjoon

private val dp = IntArray(41)
fun fibonacci(n: Int): Int {
    if (n == 0) {
        dp[0] = 0
        return 0
    } else if (n == 1) {
        dp[1] = 1
        return 1
    }
    if (dp[n] != 0) return dp[n]
    dp[n] = fibonacci(n - 1) + fibonacci(n - 2)
    return dp[n]
}

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        fibonacci(n)
        if (n == 0) println("1 0")
        else println("${dp[n - 1]} ${dp[n]}")
    }
}
//피보나치 함수의 0과 1의 호출 횟수를 구하는 문제
//다이나믹 프로그래밍을 이용하여 풀었다.
//0의 호출 횟수는 n-1번째 피보나치 수와 같고, 1의 호출 횟수는 n번째 피보나치 수와 같다.
//따라서 n-1번째 피보나치 수와 n번째 피보나치 수를 구하면 된다.