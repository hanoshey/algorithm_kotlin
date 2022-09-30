import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.min

class Combination(private val n: Int, private val r: Int) {
    private val now = IntArray(r)// 현재 조합
    val result = ArrayList<ArrayList<Position1>>()
    fun combination(arr: ArrayList<Position1>, depth: Int, index: Int, target: Int) {
        if (depth == r) {
            val temp = ArrayList<Position1>()
            for (i in now.indices) temp.add(arr[now[i]])
            result.add(temp)
            return
        }
        if (target == n) return
        now[index] = target
        combination(arr, depth + 1, index + 1, target + 1)
        combination(arr, depth, index, target + 1)
    }
}

class Position1(val x: Int, val y: Int)
object Main {
    var n = 0
    var m = 0
    val arr = Array(50) { IntArray(50) }
    val chicken = ArrayList<Position1>()
    val house = ArrayList<Position1>()
    fun getSum(candidate: ArrayList<Position1>): Int {
        var result = 0
        //모든 집에 대하여
        for (i in house.indices) {
            val hx = house[i].x
            val hy = house[i].y
            //가장 가까운 치킨집을 찾기
            var temp = 1e9.toInt()
            for (j in candidate.indices) {
                val cx = candidate[j].x
                val cy = candidate[j].y
                //치킨 거리 계산
                temp = min(temp, abs(hx - cx) + abs(hy - cy))
            }
            //가장 가까운 치킨집까지의 거리를 더하기
            result += temp
        }
        //치킨 거리의 합 반환
        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        for (r in 0 until n) {
            for (c in 0 until n) {
                arr[r][c] = sc.nextInt()
                if (arr[r][c] == 1) house.add(Position1(r, c))//일반 집
                else if (arr[r][c] == 2) chicken.add(Position1(r, c))//치킨집
            }
        }
        // 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산
        val comb = Combination(chicken.size, m)
        comb.combination(chicken, 0, 0, 0)
        val chickenList = comb.result
        // 치킨 거리의 합의 최솟값을 찾아 출력
        var result = 1e9.toInt()
        for (i in chickenList.indices)
            result = min(result, getSum(chickenList[i]))
        println(result)
    }
}