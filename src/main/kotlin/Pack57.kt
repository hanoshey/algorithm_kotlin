class Node(val index: Int, val distance: Int) {
    fun show() {
        print("($index, $distance)")
    }
}

object Pack57 {
    val graph = ArrayList<ArrayList<Node>>()

    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 0 until 3)
            graph.add(ArrayList())
        graph[0].add(Node(1, 7))
        graph[0].add(Node(2, 5))
        graph[0].add(Node(0, 7))
        graph[0].add(Node(0, 5))
        for (i in 0 until 3) {
            for (j in 0 until graph.get(i).size)
                graph.get(i).get(j).show()
            println()
        }
    }
}