package Chapter8

object Pack82 {
    //한 번 계산한 결과를 메모이제이션 하기 위한 배열 초기화
    val d = LongArray(100)
    private fun fibo(x: Int): Long {
        // 종료 조건(1 혹은 2일 때 1을 반환)
        if (x == 1 || x == 2) return 1
        // 이미 계산한 적 있는 문제라면 그대로 반환
        if (d[x] != 0L) return d[x]
        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        d[x] = fibo(x - 1) + fibo(x - 2)
        return d[x]
    }

    @JvmStatic
    fun main(args: Array<String>) = println(fibo(99))
}