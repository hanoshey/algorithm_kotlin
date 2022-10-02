class Node8(val stage: Int, private val fail: Double) : Comparable<Node8> {
    override fun compareTo(other: Node8): Int {
        if (this.fail == other.fail)
            return this.stage.compareTo(other.stage)
        return other.fail.compareTo(this.fail)
    }
}

class Solution7 {
    fun solution(N: Int, stages: IntArray):IntArray {
        val answer = IntArray(N)
        val arrayList = ArrayList<Node8>()
        var length = stages.size
        //스테이지 번호를 1부터 N까지 증가시키며
        for (i in 1..N) {
            //해당 스테이지에 머물러 있는 사람의 수 계산
            val cnt = stages.count { it == i }
            //실패율 계산
            val fail = if (length >= 1) cnt.toDouble() / length else 0.toDouble()
            //리스트에 (스테이지 번호, 실패율) 원소 삽입
            arrayList.add(Node8(i, fail))
            length -= cnt
        }
        //실패율을 기준으로 내림차순 정렬
        arrayList.sort()
        //정렬된 스테이지 번호 반환
        for (i in 0 until N)
            answer[i] = arrayList[i].stage
        return answer
    }
}