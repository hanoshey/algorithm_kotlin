package Chapter16

import java.util.Scanner
import kotlin.math.max

object Pack163 {
    var n = 0//전체 상담 개수
    val t = IntArray(15)//각 상담을 완료하는데 걸리는 기간
    val p = IntArray(15)//각 상담을 완료했을 때 받을 수 있는 금액
    var dp = IntArray(16)//각 날짜에 받을 수 있는 최대 상담 금액
    var maxValue = 0

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        for (i in 0 until n) {
            t[i] = sc.nextInt()
            p[i] = sc.nextInt()
        }
        //배열을 뒤에서부터 거꾸로 확인
        for(i in n -1 downTo 0){
            //상담이 기간 안에 끝나는 경우
            val time= t[i]+i
            if(time<= n){
                //점화식에 맞게, 현재까지의 최고 이익 계산
                dp[i]=max(p[i]+ dp[time], maxValue)
                maxValue = dp[i]
            }
            //상담이 기간을 벗어나는 경우
            else dp[i]= maxValue
        }
        println(maxValue)
    }
}