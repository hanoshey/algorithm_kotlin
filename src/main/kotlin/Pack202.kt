import kotlin.math.sqrt

object Pack202 {
    val n = 10010//2부터 1000까지 모든 수에 대해 소수 판별
    val arr = BooleanArray(n + 1)

    @JvmStatic
    fun main(args: Array<String>) {
        arr.fill(true)//처음엔 모든 수가 소수(True)인 것으로 초기화
        //0과 1은 제외
        //에라토스테네스의 체 알고리즘 수행
        //2부터 n의 제곱근까지 모든 수를 확인하며
        for (i in 2..sqrt(n.toDouble()).toInt()) {
            //i가 소수인 경우(남은 수인 경우)
            if (arr[i]) {
//i를 제외한 i의 모든 배수를 지우기
                var j = 2
                while (i * j <= n) {
                    arr[i * j] = false
                    j += 1
                }
            }
        }
        //모든 소수 출력
        for (i in 2..n)
            if (arr[i]) print("$i ")
    }
}