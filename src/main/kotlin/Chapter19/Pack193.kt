package Chapter19

import java.util.*
import kotlin.collections.ArrayList
private object Pack193 {
    var n = 0
    var m = 0
    var k = 0
    var array = Array(20) { IntArray(20) }
    val directions = ArrayList<Int>()
    val smell = Array(20) { Array(20) { Pair(0, 0) } }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val priorities = Array(400) { Array(4) { IntArray(4) } }
    var time = 0
    fun updateSmell() {
        for (i in 0 until n)
            for (j in 0 until n) {
                //냄새가 존재하는 경우, 시간을 1만큼 감소시키기
                if (smell[i][j].first > 0)
                    smell[i][j] = Pair(smell[i][j].first - 1, smell[i][j].second)
                //상어가 존재하는 해당 위치의 냄새를 k로 설정
                if (array[i][j] != 0)
                    smell[i][j] = Pair(k, array[i][j])
            }
    }

    fun move(): Array<IntArray> {
        val newArray = Array(20) { IntArray(20) }
        for (x in 0 until n)
            for (y in 0 until n) {
                //상어가 존재하는 경우
                if (array[x][y] != 0) {
                    val direction = directions[array[x][y] - 1]
                    var found = false
                    //일단 냄새가 존재하지 않는 곳이 있는지 확인
                    for (index in 0 until 4) {
                        val nx = x + dx[priorities[array[x][y] - 1][direction - 1][index] - 1]
                        val ny = y + dy[priorities[array[x][y] - 1][direction - 1][index] - 1]
                        if (nx in 0 until n && ny in 0 until n) {
                            if (smell[nx][ny].first == 0) {//냄새가 존재하지 않는 곳이면
                                //해당 상어의 방향 이동시키기
                                directions[array[x][y] - 1] = priorities[array[x][y] - 1][direction - 1][index]
                                //상어 이동시키기 (만약 이미 다른 상어가 있다면 번호가 낮은 것이 들어가도록)
                                if (newArray[nx][ny] == 0)
                                    newArray[nx][ny] = array[x][y]
                                else
                                    newArray[nx][ny] = minOf(newArray[nx][ny], array[x][y])
                                found = true
                                break
                            }
                        }
                    }
                    if (found) continue
                    //주변에 모두 냄새가 남아 있다면, 자신의 냄새가 있는 곳으로 이동
                    for (index in 0 until 4) {
                        val nx = x + dx[priorities[array[x][y] - 1][direction - 1][index] - 1]
                        val ny = y + dy[priorities[array[x][y] - 1][direction - 1][index] - 1]
                        if (nx in 0 until n && ny in 0 until n) {
                            if (smell[nx][ny].second == array[x][y]) {//자신의 냄새가 있는 곳이면
                                //해당 상어의 방향 이동시키기
                                directions[array[x][y] - 1] = priorities[array[x][y] - 1][direction - 1][index]
                                //상어 이동시키기
                                newArray[nx][ny] = array[x][y]
                                break
                            }
                        }
                    }
                }
            }
        return newArray
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        k = sc.nextInt()
        for (i in 0 until n)
            for (j in 0 until n)
                array[i][j] = sc.nextInt()
        for (i in 0 until m)
            directions.add(sc.nextInt())
        for (i in 0 until m)
            for (j in 0 until 4)
                priorities[i][j] = intArrayOf(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt())
        while (true) {
            updateSmell()
            val newArray = move()
            array = newArray
            time++//시간 증가
            //1번 상어만 남았는지 체크
            var check = true
            for (i in 0 until n)
                for (j in 0 until n)
                    if (array[i][j] != 0 && array[i][j] != 1)
                        check = false
            if (check) {
                println(time)
                break
            }
            if (time >= 1000) {
                println(-1)
                break
            }
        }
    }
}