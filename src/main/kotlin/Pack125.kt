import java.util.*
import kotlin.collections.ArrayDeque

class Node5(var time: Int, var direction: Char)
class Position(var x: Int, var y: Int)
object Pack125 {
    var n = 0
    var k = 0
    var l = 0
    var array = Array(101) { IntArray(101) }//맵 정보
    var info = ArrayDeque<Node5>()//방향 회전 정보

    //처음에는 오른쪽을 보고 있으므로(동, 남, 서, 북)
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    fun turn(direction: Int, c: Char): Int {
        var direction = direction
        if (c == 'L') direction = if (direction == 0) 3 else direction - 1
        else direction = (direction + 1) % 4
        return direction
    }

    fun simulate(): Int {
        var x = 1//뱀의 머리 위치
        var y = 1
        array[x][y] = 2//뱀이 존재하는 위치는 2로 표시
        var direction = 0//처음에는 동쪽을 보고 있음
        var time = 0//시작한 뒤에 지난 '초' 시간
        var index = 0//다음에 회전할 정보
        //뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)
        val q = ArrayDeque<Position>()
        q.add(Position(x, y))
        while (true) {
            //다음 위치
            var nx = x + dx[direction]
            var ny = y + dy[direction]
            //맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면
            if (nx in 1..n && ny in 1..n && array[nx][ny] != 2) {
                //사과가 없다면 이동 후에 꼬리 제거
                if (array[nx][ny] == 0) {
                    array[nx][ny] = 2
                    q.add(Position(nx, ny))
                    val prev = q.removeFirst()
                    array[prev.x][prev.y] = 0
                }
                //사과가 있다면 이동 후에 꼬리 그대로 두기
                if (array[nx][ny] == 1) {
                    array[nx][ny] = 2
                    q.add(Position(nx, ny))
                }
            }
            //벽이나 뱀의 몸통과 부딪혔다면
            else {
                time += 1
                break
            }
            //다음 위치로 머리를 이동
            x = nx
            y = ny
            time += 1
            if (index < l && time == info[index].time) {//회전할 시간인 경우 회전
                direction = turn(direction, info[index].direction)
                index += 1
            }
        }
        return time
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        k = sc.nextInt()
        //맵 정보(사과 있는 곳은 1로 표시)
        for (i in 0 until k) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            array[a][b] = 1
        }
        //방향 회전 정보 입력
        l = sc.nextInt()
        for (i in 0 until l) {
            val x = sc.nextInt()
            val c = sc.next()[0]
            info.add(Node5(x, c))
        }
        println(simulate())
    }
}
