package Chapter12

import kotlin.math.min

class Permutation(private val n: Int, private val r: Int) {
    private val now = IntArray(r)//현재 순열
    val result = ArrayList<ArrayList<Int>>() //모든 순열
    fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    fun permutation(arr: IntArray, depth: Int) {
        //현재 순열의 길이가 r일 때 결과 저장
        if (depth == r) {
            val temp = ArrayList<Int>(r)
            for (i in now.indices) temp.add(arr[now[i]])
            result.add(temp)
            return
        }
        for (i in depth until n) {
            swap(arr, i, depth)
            now[depth] = arr[depth]
            permutation(arr, depth + 1)
            swap(arr, i, depth)
        }
    }
}

class Solution5 {
    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        //길이를 2배로 늘려서 '원형'을 일자 형태로 변경
        val weakList = ArrayList<Int>()
        for (i in weak.indices) weakList.add(weak[i])
        for (i in weak.indices) weakList.add(weak[i] + n)
        //투입할 친구 수의 최솟값을 찾아야 하므로 len(dist) + 1로 초기화
        var answer = dist.size + 1
        // 친구 정보를 이용해 모든 순열 계산
        val perm = Permutation(dist.size, dist.size)
        perm.permutation(dist, 0)
        val distList = perm.result
        //0부터 length -1 까지의 위치를 각각 시작점으로 설정
        for (start in weak.indices) {
            // 친구를 나열하는 모든 경우 각각에 대하여 확인
            for (i in distList.indices) {
                var cnt = 1
                //해당 친구가 점검할 수 있는 마지막 위치
                var position = weak[start] + distList[i][cnt - 1]
                //시작점부터 모든 취약 지점을 확인
                for (index in start until start + weak.size) {
                    //점검할 수 있는 위치를 벗어나는 경우
                    if (position < weakList[index]) {
                        cnt += 1//새로운 친구를 투입
                        if (cnt > dist.size) break//더 투입이 불가능하다면 종료
                        position = weakList[index] + distList[i][cnt - 1]
                    }
                }
                answer = min(answer, cnt)//최솟값 계산
            }
        }
        if (answer > dist.size) return -1
        return answer
    }
}