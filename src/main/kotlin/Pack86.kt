import java.util.*
import kotlin.math.max

object Pack86 {
    val d = IntArray(100)

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        //정수 n을 입력받기
        val n = sc.nextInt()
        //모든 식량 정보 입력받기
        val arr = IntArray(n)
        for (i in 0 until n) arr[i] = sc.nextInt()
        //다이나믹 프로그래밍 보텀업
        d[0] = arr[0]
        d[1] = max(arr[0], arr[1])
        for (i in 2 until n) d[i] = max(d[i - 1], d[i - 2] + arr[i])
        println(d[n - 1])
    }
}