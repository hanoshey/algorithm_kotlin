import java.util.Scanner
import kotlin.math.max

class Fish1(var number: Int, var direction: Int)
object Pack192 {
    var result = 0
    var count=0
    //8가지 방향에 대한 정의
    val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
    val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)

    //현재 위치에서 왼쪽으로 회전된 결과 반환
    private fun turnLeft(dir: Int) = (dir + 1) % 8

    //현재 배열에서 특정한 번호의 물고기 위치 찾기
    private fun findFish(array: Array<Array<Fish1>>, index: Int): Pair<Int, Int> {
        for (i in 0 until 4)
            for (j in 0 until 4)
                if (array[i][j].number == index)
                    return Pair(i, j)
        return Pair(-1, -1)
    }

    //모든 물고기를 회전 및 이동시키는 함수
    private fun moveAllFishes(array: Array<Array<Fish1>>, nowX: Int, nowY: Int) {
        //1번부터 16번까지의 물고기를 차례대로(낮은 번호부터) 확인
        for (i in 1 until 17) {
            //해당 물고기의 위치를 찾기
            val position = findFish(array, i)
            if (position != Pair(-1, -1)) {
                val (x, y) = position
                var direction = array[x][y].direction
                //해당 물고기의 방향을 왼쪽으로 계속 회전시키며 이동이 가능한지 확인
                for (j in 0 until 8) {
                    val nx = x + dx[direction]
                    val ny = y + dy[direction]
                    //해당 방향으로 이동이 가능하다면 이동 시키기
                    if (nx in 0 until 4 && ny in 0 until 4)
                        if (!(nx == nowX && ny == nowY)) {
                            array[x][y].direction = direction
                            array[x][y] = array[nx][ny].also { array[nx][ny] = array[x][y] }
                            break
                        }
                    println("TURN! $direction")
                    direction = turnLeft(direction)
                }
            }
        }
    }

    private fun getPossiblePositions(array: Array<Array<Fish1>>, nowX: Int, nowY: Int)
            : ArrayList<Pair<Int, Int>> {
        var nowX = nowX
        var nowY = nowY
        val positions = ArrayList<Pair<Int, Int>>()
        val direction = array[nowX][nowY].direction
        for (i in 0 until 4) {
            nowX += dx[direction]
            nowY += dy[direction]
            if (nowX in 0 until 4 && nowY in 0 until 4)
                if (array[nowX][nowY].number != -1){
                    count++
                    positions.add(Pair(nowX, nowY))
                    println(count)
                }
        }
        return positions
    }

    private fun dfs(inputArray: Array<Array<Fish1>>, nowX: Int, nowY: Int, total: Int) {
        var total = total
        val array = Array(4) { Array(4) { Fish1(0, 0) } }
        for (i in 0 until 4)
            for (j in 0 until 4)
                array[i][j] = inputArray[i][j]
        total += array[nowX][nowY].number//현재 위치의 물고기 먹기
        array[nowX][nowY].number = -1//물고기를 먹었으므로 번호 값을 -1로 변환
        moveAllFishes(array, nowX, nowY)//모든 물고기 이동시키기
        //이제 다시 상어가 이동할 차례이므로, 이동 가능한 위치 찾기
        val positions = getPossiblePositions(array, nowX, nowY)
        //이동할 수 있는 위치가 하나도 없다면 종료
        println(positions)
        println("result: $result, total: $total")
        if (positions.isEmpty()) {
            result = max(result, total)
            return
        }
        for (i in positions)
            dfs(array, i.first, i.second, total)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val array = Array(4) { Array(4) { Fish1(0, 0) } }
        val sc = Scanner(System.`in`)
        for (i in 0 until 4)
            for (j in 0 until 4) {
                val num = sc.nextInt()
                val dir = sc.nextInt() - 1
                array[i][j] = Fish1(num, dir)
            }
        dfs(array, 0, 0, 0)
        println(result)
    }
}