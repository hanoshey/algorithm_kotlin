package Chapter11

import java.util.Scanner

object Pack115q {
    var n = 0
    var m = 0

    //1부터 10까지의 무게를 담을 수 있는 배열
    val arr = IntArray(11)

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        for (i in 0 until n) {
            val x = sc.nextInt()
            arr[x] += 1
        }
        var result = 0
        //1부터 m까지의 각 무게에 대하여 처리
        for (i in 1..m) {
            n -= arr[i]//무게가 i인 볼링공의 개수(A가 선택할수 있는 개수)제외
            result += arr[i] * n//B가 선택하는 경우의 수와 곱해주기
        }
        println(result)
    }
}