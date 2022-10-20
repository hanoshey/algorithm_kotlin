package Chapter5

object Pack58 {
    val visited = Array(9) { false }
    val graph = ArrayList<ArrayList<Int>>()

    //dfs 함수 정의
    fun dfs(x: Int) {
        visited[x] = true
        print("$x ")
        for (i in 0 until graph[x].size) {
            val y = graph[x][i]
            if (!visited[y]) dfs(y)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 0 until 9)
            graph.add(ArrayList())
        graph[1].add(2)
        graph[1].add(3)
        graph[1].add(8)
        graph[2].add(1)
        graph[2].add(7)
        graph[3].add(1)
        graph[3].add(4)
        graph[3].add(5)
        graph[4].add(3)
        graph[4].add(5)
        graph[5].add(3)
        graph[5].add(4)
        graph[6].add(7)
        graph[7].add(2)
        graph[7].add(6)
        graph[7].add(8)
        graph[8].add(1)
        graph[8].add(7)
        dfs(1)
    }
}