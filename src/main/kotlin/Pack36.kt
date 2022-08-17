import java.util.*

object Pack36 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        var n = sc.nextInt()
        val k = sc.nextInt()
        var result = 0
        while (true) {
            var target = (n / k) * k
            result += (n - target)
            n = target
            //n이 k보다 작을 때(더 이상 나눌 수 없을 때)
            if (n < k) break
            result += 1
            n /= k
        }
        //마지막으로 남은 수에 대해 1씩 빼기

        result += (n - 1)
        println(result)
    }
}