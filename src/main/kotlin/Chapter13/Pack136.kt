package Chapter13

import java.util.Scanner

private class Combination1(val n: Int, private val r: Int) {
    private val now = IntArray(r)
    val result = ArrayList<ArrayList<Position2>>()
    fun combination(arr: ArrayList<Position2>, depth: Int, index: Int, target: Int) {
        if (depth == r) {
            val temp = ArrayList<Position2>()
            for (i in now.indices)
                temp.add(arr[now[i]])
            result.add(temp)
            return
        }
        if (target == n) return
        now[index] = target
        combination(arr, depth + 1, index + 1, target + 1)
        combination(arr, depth, index, target + 1)
    }
}

private class Position2(val x: Int, val y: Int)
private object Pack136 {
    var n = 0
    val board = Array(6) { CharArray(6) }//복도 정보
    val teachers = ArrayList<Position2>()//선생님의 위치 정보
    val spaces = ArrayList<Position2>()//빈 공간의 위치 정보

    //특정 방향으로 감시를 진행(학생 발견:true, 학생 미발견:false)
    fun watch(x: Int, y: Int, direction: Int): Boolean {
        //왼쪽 방향으로 감시
        var x = x
        var y = y
        if (direction == 0)
            while (y >= 0) {
                if (board[x][y] == 'S') return true//학생이 있는 경우
                if (board[x][y] == 'O') return false//장애물이 있는 경우
                y -= 1
            }
        //오른쪽 방향으로 감시
        if (direction == 1)
            while (y < n) {
                if (board[x][y] == 'S') return true//학생이 있는 경우
                if (board[x][y] == 'O') return false//장애물이 있는 경우
                y += 1
            }
        //위쪽 방향으로 감시
        if (direction == 2)
            while (x >= 0) {
                if (board[x][y] == 'S') return true//학생이 있는 경우
                if (board[x][y] == 'O') return false//장애물이 있는 경우
                x -= 1
            }
        //아래쪽 방향으로 감시
        if (direction == 3)
            while (x < n) {
                if (board[x][y] == 'S') return true//학생이 있는 경우
                if (board[x][y] == 'O') return false//장애물이 있는 경우
                x += 1
            }
        return false
    }

    //장애물 설치 이후에, 한 명이라도 학생이 감지되는지 검사
    fun process(): Boolean {
        for (i in teachers.indices) {
            //모든 선생의 위치를 하나씩 확인
            val x = teachers[i].x
            val y = teachers[i].y
            //4가지 방향으로 학생을 감지할 수 있는지 확인
            for (j in 0..3)
                if (watch(x, y, j)) return true
        }
        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        for (i in 0 until n)
            for (j in 0 until n) {
                board[i][j] = sc.next().toCharArray()[0]
                //선생님이 존재하는 위치 저장
                if (board[i][j] == 'T') teachers.add(Position2(i, j))
                //장애물을 설치할 수 있는 (빈 공간) 위치 지정
                if (board[i][j] == 'X') spaces.add(Position2(i, j))
            }
        //빈 공간에서 3개를 뽑는 모든 조합을 확인
        val comb = Combination1(spaces.size, 3)
        comb.combination(spaces, 0, 0, 0)
        val spaceList = comb.result
        //학생이 한 명도 감지되지 않도록 설치할 수 있는지의 여부
        var found = false
        for (i in spaceList.indices) {
            //장애물들을 설치해보기
            for (j in spaceList[i].indices) {
                val x = spaceList[i][j].x
                val y = spaceList[i][j].y
                board[x][y] = 'O'
            }
            //학생이 한 명도 감지되지 않는 경우
            if (!process()) {
                //원하는 경우를 발견한 것임
                found = true
                break
            }
            //설치된 장애물을 다시 없애기
            for (j in spaceList[i].indices) {
                val x = spaceList[i][j].x
                val y = spaceList[i][j].y
                board[x][y] = 'X'
            }
        }
        if (found) println("YES")
        else println("NO")
    }
}