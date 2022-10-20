package Chapter14

import java.util.Scanner

object Pack142 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val arrayList = ArrayList<Int>()
        for (i in 0 until n)
            arrayList.add(sc.nextInt())
        arrayList.sort()
        //중간값(median)을 출력
        println(arrayList[(n - 1) / 2])
    }
}