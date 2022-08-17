import java.util.Scanner

object Pack612 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val k = sc.nextInt()
        val a = IntArray(n)
        for (i in 0 until n)
            a[i] = sc.nextInt()
        val b = IntArray(n)
        for (i in 0 until n)
            b[i] = sc.nextInt()
        a.sort()
        //배열 B는 내림차순 정렬 수행
        b.sortDescending()
        //첫번째 인덱스부터 확인하며, 두 배열의 원소를 최대 k번 비교
        for (i in 0 until k) {
            //A의 원소가 B의 원소보다 작은 경우
            if (a[i] < b[i]) {
                val temp = a[i]
                a[i] = b[i]
                b[i] = temp
            } else break
        }
        var result = 0L
        for (i in 0 until n)
            result += a[i]
        println(result)
    }
}