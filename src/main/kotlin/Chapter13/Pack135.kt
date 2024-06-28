package Chapter13

import java.util.Scanner
import kotlin.math.max
import kotlin.math.min

private object Pack135 {
    var n = 0

    //연산을 수행하고자 하는 수 리스트
    val arr = ArrayList<Int>()

    //더하기, 빼기, 곱하기, 나누기 연산자 개수
    var add = 0
    var sub = 0
    var mul = 0
    var div = 0

    //최솟값, 최댓값 초기화
    var minValue = 1e9.toInt()
    var maxValue = -1e9.toInt()

    //DFS 메서드
    fun dfs(i: Int, now: Int) {
        //모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트
        if (i == n) {
            minValue = min(minValue, now)
            maxValue = max(maxValue, now)
        } else {
            //각 연산자에 대하여 재귀적으로 수행
            if (add > 0) {
                add -= 1
                dfs(i + 1, now + arr[i])
                add += 1
            }
            if (sub > 0) {
                sub -= 1
                dfs(i + 1, now - arr[i])
                sub += 1
            }
            if (mul > 0) {
                mul -= 1
                dfs(i + 1, now * arr[i])
                mul += 1
            }
            if (div > 0) {
                div -= 1
                dfs(i + 1, now / arr[i])
                div += 1
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        for (i in 0 until n) {
            val x = sc.nextInt()
            arr.add(x)
        }
        add = sc.nextInt()
        sub = sc.nextInt()
        mul = sc.nextInt()
        div = sc.nextInt()
        //DFS 메서드 호출
        dfs(1, arr[0])
        //최댓값과 최솟값 차례대로 출력
        println(maxValue)
        println(minValue)
    }
}