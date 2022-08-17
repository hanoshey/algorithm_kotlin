object Pack56 {
    const val INF = 999999999
    val graph = arrayOf(
        intArrayOf(0, 7, 5),
        intArrayOf(7, 0, INF),
        intArrayOf(5, INF, 0)
    )

    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 0 until 3) {
            for (j in 0 until 3)
                print("${graph[i][j]} ")
            println()
        }
    }
}