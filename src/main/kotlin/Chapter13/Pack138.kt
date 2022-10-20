package Chapter13

import java.util.*
import kotlin.collections.ArrayList

class Node7(
    val pos1x: Int, val pos1y: Int, val pos2x: Int, val pos2y: Int, val distance: Int
)

class Solution4 {
    fun getNextPos(pos: Node7, board: Array<IntArray>): ArrayList<Node7> {
        //반환 결과(이동 가능한 위치들)
        val nextPos = ArrayList<Node7>()
        // (상, 하, 좌, 우)로 이동하는 경우에 대해서 처리
        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)
        for (i in 0 until 4) {
            val pos1NextX = pos.pos1x + dx[i]
            val pos1NextY = pos.pos1y + dy[i]
            val pos2NextX = pos.pos2x + dx[i]
            val pos2NextY = pos.pos2y + dy[i]
            val distanceNext = pos.distance + 1
            //이동하고자 하는 두 칸이 모두 비어있다면
            if (board[pos1NextX][pos1NextY] == 0 && board[pos2NextX][pos2NextY] == 0)
                nextPos.add(Node7(pos1NextX, pos1NextY, pos2NextX, pos2NextY, distanceNext))

        }
        //현재 로봇이 가로로 놓여 있는 경우
        val hor = intArrayOf(-1, 1)
        if (pos.pos1x == pos.pos2x) {
            //위쪽으로 회전하거나, 아래쪽으로 회전
            //위쪽 또는 아래쪽 두 칸이 모두 비어 있다면
            for (i in 0 until 2)
                if (board[pos.pos1x + hor[i]][pos.pos1y] == 0 &&
                    board[pos.pos2x + hor[i]][pos.pos2y] == 0
                ) {
                    nextPos.add(Node7(pos.pos1x, pos.pos1y, pos.pos1x + hor[i], pos.pos1y, pos.distance + 1))
                    nextPos.add(Node7(pos.pos2x, pos.pos2y, pos.pos2x + hor[i], pos.pos2y, pos.distance + 1))
                }
        }
        //현재 로봇이 세로로 놓여 있을 경우
        val ver = intArrayOf(-1, 1)
        if (pos.pos1y == pos.pos2y) {
            for (i in 0 until 2)
            //왼쪽으로 회전하거나, 오른쪽으로 회전
            //왼쪽 또는 오른쪽 두 칸이 모두 비어 있다면
                if (board[pos.pos1x][pos.pos1y + ver[i]] == 0 &&
                    board[pos.pos2x][pos.pos2y + ver[i]] == 0
                ) {
                    nextPos.add(Node7(pos.pos1x, pos.pos1y, pos.pos1x, pos.pos1y + ver[i], pos.distance + 1))
                    nextPos.add(Node7(pos.pos2x, pos.pos2y, pos.pos2x, pos.pos2y + ver[i], pos.distance + 1))
                }
        }
        return nextPos
    }

    fun solution(board: Array<IntArray>): Int {
        //맵 외곽에 벽을 두는 형태로 맵 변형
        val n = board.size
        val newBoard = Array(n + 2) { IntArray(n + 2) }
        for (i in 0 until n + 2)
            for (j in 0 until n + 2)
                newBoard[i][j] = 1
        for (i in 0 until n)
            for (j in 0 until n)
                newBoard[i + 1][j + 1] = board[i][j]
        //너비 우선 탐색(BFS) 수행
        val q: Queue<Node7> = LinkedList()
        val visited = ArrayList<Node7>()
        val pos = Node7(1, 1, 1, 2, 0)//시작 위치 설정
        q.offer(pos)//큐에 삽입된 뒤에
        visited.add(pos)//방문 처리
        //큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            val pos = q.poll()
            // (n, n) 위치에 로봇이 도달했다면, 최단 거리이므로 반환
            if ((pos.pos1x == n && pos.pos1y == n) || (pos.pos2x == n && pos.pos2y == n))
                return pos.distance
            //현재 위치에서 이동할 수 있는 위치 확인
            val nextPos = getNextPos(pos, newBoard)
            for (i in nextPos.indices) {
                //아직 방문하지 않은 위치라면, 큐에 삽입하고 방문 처리
                var check=true
                for(j in visited.indices)
                    if(visited[j].pos1x==nextPos[i].pos1x&&visited[j].pos1y==nextPos[i].pos1y&&visited[j].pos2x==nextPos[i].pos2x&&visited[j].pos2y==nextPos[i].pos2y){
                        check=false
                        break
                    }
                if(check) {
                    q.offer(nextPos[i])
                    visited.add(nextPos[i])
                }
            }
        }
        return 0
    }
}