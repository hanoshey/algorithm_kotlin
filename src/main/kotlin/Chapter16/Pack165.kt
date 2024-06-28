package Chapter16

import java.util.*

private object Pack165 {
    var n = 0
    val ugly = IntArray(1000)//못생긴 수를 담기 위한 테이블

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        //2배, 3배, 5배를 위한 인덱스
        var i2 = 0
        var i3 = 0
        var i5 = 0
        // 처음에 곱셈 값을 초기화
        var next2 = 2
        var next3 = 3
        var next5 = 5
        ugly[0] = 1//첫 번째 못생긴 수는 1
        //1부터 n까지의 못생긴 수를 찾기
        for (l in 1 until n) {
            //가능한 곱셈 결과 중에서 가장 작은 수를 선택
            ugly[l] = minOf(next2, next3, next5)
            //인덱스에 따라서 곱셈 결과 증가
            if (ugly[l] == next2) {
                i2 += 1
                next2 = ugly[i2] * 2
            }
            if (ugly[l] == next3) {
                i3 += 1
                next3 = ugly[i3] * 3
            }
            if (ugly[l] == next5) {
                i5 += 1
                next5 = ugly[i5] * 5
            }
        }
        //n번째 못생긴 수를 출력
        println(ugly[n - 1])
    }
}