package Chapter11

import java.util.*
import kotlin.math.min

object Pack113q {
    var str = ""
    var count0 = 0//전부 0으로 바꾸는 경우
    var count1 = 0//전부 1로 바꾸는 경우

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        str = sc.next()
        //첫 번째 원소에 대해 처리
        if (str[0] == '1') count0 += 1
        else count1 += 1
        //두 번째 원소부터 모든 원소를 확인하며
        for (i in 0 until str.length - 1) {
            if (str[i] != str[i + 1]) {
                //다음 수에서 1로 바뀌는 경우
                if (str[i + 1] == '1') count0 += 1
                else count1 += 1
            }
        }
        println(min(count0, count1))
    }
}