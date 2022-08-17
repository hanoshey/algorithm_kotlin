import java.util.Scanner
import kotlin.math.min

object Pack85 {
    val d = IntArray(30001)

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val x = sc.nextInt()
        //다이나믹 프로그래밍 보텀업
        for (i in 2..x) {
            //현재의 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1
            //2로 나누어 떨어지는 경우
            if (i % 2 == 0) d[i] = min(d[i], d[i / 2] + 1)
            //3으로 나누어 떨어지는 경우
            if (i % 3 == 0) d[i] = min(d[i], d[i / 3] + 1)
            //5로 나누어 떨어지는 경우
            if (i % 5 == 0) d[i] = min(d[i], d[i / 5] + 1)
        }
        println(d[x])
    }
}