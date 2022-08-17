import java.util.Scanner

object Pack510 {
    var n = 0
    var m = 0
    var graph = Array(1000) { IntArray(1000) }
    private fun dfs(x: Int, y: Int): Boolean {
        if (x <= -1 || x >= n || y <= -1 || y >= m) return false
        if (graph[x][y] == 0) {
            //해당 노드 방문 처리
            graph[x][y] = 1
            dfs(x - 1, y)
            dfs(x, y - 1)
            dfs(x + 1, y)
            dfs(x, y + 1)
            return true
        }
        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        //N,M을 공백을 기준으로 구분하여 입력받기
        n = sc.nextInt()
        m = sc.nextInt()
        sc.nextLine()
        for (i in 0 until n) {
            val str = sc.nextLine()
            for (j in 0 until m) {
                graph[i][j] = str[j] - '0'
            }
        }
        //모든 노드(위치)에 대해 음료수 채우기
        var result = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (dfs(i, j)) result += 1
            }
        }
        println(result)
    }
}