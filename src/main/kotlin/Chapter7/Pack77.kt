package Chapter7

import java.util.Scanner

object Pack77 {
    //집합 자료형
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val s = HashSet<Int>()
        for (i in 0 until n) {
            val x = sc.nextInt()
            s.add(x)
        }
        //M(손님이 확인 요청한 부품 개수)
        val m = sc.nextInt()
        val targets = IntArray(n)
        for (i in 0 until m)
            targets[i] = sc.nextInt()
        //손님이 확인 요청한 부품 번호 하나씩 확인
        for (i in 0 until m) {
            if (s.contains(targets[i])) print("yes ")
            else print("no ")
        }
    }
}