package Chapter3

import java.util.*

object Pack34 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)

        // N, M을 공백을 기준으로 구분하여 입력 받기
        val n = sc.nextInt()
        val m = sc.nextInt()
        var result = 0

        // 한 줄씩 입력 받아 확인하기
        for (i in 0 until n) {
            // 현재 줄에서 '가장 작은 수' 찾기
            var min_value = 10001
            for (j in 0 until m) {
                val x = sc.nextInt()
                min_value = Math.min(min_value, x)
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value)
        }
        println(result) // 최종 답안 출력
    }
}