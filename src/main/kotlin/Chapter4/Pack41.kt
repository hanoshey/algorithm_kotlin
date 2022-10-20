package Chapter4

import java.util.*

object Pack41 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        //N을 입력받기
        val n = sc.nextInt()
        sc.nextLine()//버퍼 비우기
        val plans = sc.nextLine().split(" ")
        var x = 1
        var y = 1
        // L, R, U, D에 따른 이동 방향
        val dx = intArrayOf(0, 0, -1, 1)
        val dy = intArrayOf(-1, 1, 0, 0)
        val moveTypes = charArrayOf('L', 'R', 'U', 'D')
        for (i in plans.indices) {
            val plan = plans[i][0]
            //이동 후 좌표 구하기
            var nx = -1
            var ny = -1
            for (j in 0 until 4) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j]
                    ny = y + dy[j]
                }
            }
            //공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue
            x = nx
            y = ny
        }
        println("$x $y")
    }
}