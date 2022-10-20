package Chapter12

class Solution3 {
    //2차원 리스트 90도 회전하기
    fun rotateMatrixBy90Degree(a: Array<IntArray>): Array<IntArray> {
        val n = a.size
        val m = a[0].size
        val result = Array(m) { IntArray(n) }
        for (i in 0 until n)
            for (j in 0 until m)
                result[j][n - i - 1] = a[i][j]
        return result
    }

    //자물쇠의 중간 부분이 모두 1인지 확인
    fun check(newLock: Array<IntArray>): Boolean {
        val lockLength = newLock.size / 3
        for (i in lockLength until lockLength * 2)
            for (j in lockLength until lockLength * 2)
                if (newLock[i][j] != 1)
                    return false
        return true
    }

    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val n = lock.size
        val m = key.size
        var key = key
        //자물쇠의 크기를 기존의 3배로 변환
        val newLock = Array(n * 3) { IntArray(n * 3) }
        //새로운 자물쇠 중앙 부분에 기존 자물쇠 넣기
        for (i in 0 until n)
            for (j in 0 until n)
                newLock[i + n][j + n] = lock[i][j]
        //4가지 방향에 대해서 확인
        for (rotation in 0 until 4) {
            key = rotateMatrixBy90Degree(key)//열쇠 회전
            for (x in 0 until n * 2)
                for (y in 0 until n * 2) {
                    //자물쇠에 열쇠 끼워 넣기
                    for (i in 0 until m)
                        for (j in 0 until m)
                            newLock[x + i][y + j] += key[i][j]
                    //새로운 자물쇠에 열쇠가 정확히 들어 맞는지 검사
                    if (check(newLock)) return true
                    //자물쇠에서 열쇠를 다시 빼기
                    for (i in 0 until m)
                        for (j in 0 until m)
                            newLock[x + i][y + j] -= key[i][j]
                }
        }
        return false
    }
}