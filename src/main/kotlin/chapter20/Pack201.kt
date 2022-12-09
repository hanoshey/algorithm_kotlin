package chapter20

import kotlin.math.sqrt

object Pack201 {
    //소수 판별 함수(2 이상의 자연수에 대해)
    private fun isPrimeNumber(x: Int): Boolean {
        //2부터 x의 제곱근까지의 모든 수를 확인하며
        for (i in 2..sqrt(x.toDouble()).toInt())
            if (x % i == 0) return false
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(isPrimeNumber(4))
        println(isPrimeNumber(7))
    }
}