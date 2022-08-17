import java.util.*

data class Fruit(val name: String, val score: Int)

object Pack69 {
    @JvmStatic
    fun main(args: Array<String>) {
        val fruits: MutableList<Fruit> = ArrayList()
        fruits.apply {
            add(Fruit("바나나", 2))
            add(Fruit("사과", 5))
            add(Fruit("당근", 3))
        }
        fruits.sortBy { it.score }
        for (i in fruits.indices)
            print("(${fruits[i].name}, ${fruits[i].score})")
    }
}