package Chapter8

import java.util.Scanner
import kotlin.math.min

object Pack88 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        //정수 N,M 입력받기
        val n = sc.nextInt()
        val m = sc.nextInt()
        //n개의 화폐 단위 정보 입력 받기
        val arr = IntArray(n)
        for (i in 0 until n) arr[i] = sc.nextInt()
        //DP테이블 초기화
        val d = IntArray(m + 1) { 10001 }
        //DP진행(보텀업)
        d[0] = 0
        for (i in 0 until n)
            for (j in arr[i]..m)
            //(i-k)원을 만드는 방법이 존재하는 경우
                if (d[j - arr[i]] != 10001)
                    d[j] = min(d[j], d[j - arr[i]] + 1)
        //계산된 결과 출력
        if (d[m] == 10001) println(-1)//최종적으로 M원을 만드는 방법이 없는 경우
        else println(d[m])
    }
}