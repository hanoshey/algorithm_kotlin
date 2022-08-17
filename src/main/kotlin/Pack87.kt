import java.util.*

object Pack87 {
    val d = IntArray(1001)

    //dp테이블 초기화
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        //정수 n 입력받기
        val n = sc.nextInt()
        //다이나믹 프로그래밍(보텀업)
        d[1] = 1
        d[2] = 3
        for (i in 3..n) d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796
        println(d[n])
    }
}