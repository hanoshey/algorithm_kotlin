package Chapter13

import java.util.*
import kotlin.math.max

private object Pack132 {
    var n = 0
    var m = 0
    var result = 0
    val arr = Array(8) { IntArray(8) }
    val temp = Array(8) { IntArray(8) }

    //4가지 이동 방향에 대한 배열
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    //DFS을 이용해 각 바이러스가 사방으로 퍼지도록 하기
    private fun virus(x: Int, y: Int) {
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            //상,하,좌,우 중에서 바이러스가 퍼질 수 있는 경우
            if (nx in 0 until n && ny in 0 until m) {
                if (temp[nx][ny] == 0) {
                    //해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                    temp[nx][ny] = 2
                    virus(nx, ny)
                }
            }
        }
    }

    //현재 맵에서 안전 영역의 크기 계산하는 메서드
    private fun getScore(): Int {
        var score = 0
        for (i in 0 until n)
            for (j in 0 until m)
                if (temp[i][j] == 0)
                    score += 1
        return score
    }

    //DFS를 이용해 울타리를 설치하면서, 매번 안전 영역의 크기 계산
    private fun dfs(count: Int) {
        var count = count
        if (count == 3) {
            for (i in 0 until n)
                for (j in 0 until m)
                    temp[i][j] = arr[i][j]
            //각 바이러스의 위치에서 전파 진행
            for (i in 0 until n)
                for (j in 0 until m)
                    if (temp[i][j] == 2)
                        virus(i, j)
            //안전 영역의 최대값 계산
            result = max(result, getScore())
            return
        }
        //빈 공간에 울타리를 설치
        for (i in 0 until n)
            for (j in 0 until m)
                if (arr[i][j] == 0) {
                    arr[i][j] = 1
                    count += 1
                    dfs(count)
                    arr[i][j] = 0
                    count -= 1
                }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        for (i in 0 until n)
            for (j in 0 until m)
                arr[i][j] = sc.nextInt()
        dfs(0)
        println(result)
    }
}