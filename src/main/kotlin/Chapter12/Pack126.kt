package Chapter12

class Node6(var x: Int, var y: Int, var stuff: Int) : Comparable<Node6> {
    //정렬 기준 : 먼저 stuff를 기준으로 정렬하고, stuff가 같으면 x를 기준으로 정렬

    override fun compareTo(other: Node6): Int {
        if (x == other.x && y == other.y)
            return stuff.compareTo(other.stuff)
        if (x == other.x)
            return y.compareTo(other.y)
        return x.compareTo(other.x)
    }
}

class Solution6 {
    // 현재 설치된 구조물이 '가능한' 구조물인지 확인하는 함수
    fun possible(answer: ArrayList<ArrayList<Int>>): Boolean {
        for (i in answer.indices) {
            val x = answer[i][0]
            val y = answer[i][1]
            val stuff = answer[i][2]
            if (stuff == 0) { //설치된 것이 '기둥'인 경우
                var check = false
                //'바닥 위'라면 정상
                if (y == 0) check = true
                //'보의 한 쪽 끝 부분 위' 혹은 '다른 기둥 위'라면 정상
                for (j in answer.indices) {
                    if (x - 1 == answer[j][0] && y == answer[j][1] && answer[j][2] == 1)
                        check = true
                    if (x == answer[j][0] && y == answer[j][1] && answer[j][2] == 1)
                        check = true
                    if (x == answer[j][0] && y - 1 == answer[j][1] && answer[j][2] == 0)
                        check = true
                }
                if (!check) return false// 아니라면 거짓(False) 반환
            } else if (stuff == 1) {//설치된 것이 '보'일 경우
                var check = false
                var left = false
                var right = false
                //'한쪽 끝부분이 기둥 위' 혹은 '양쪽 끝부분이 다른 보와 동시에 연결'이라면 정상
                for (j in answer.indices) {
                    if (x == answer[j][0] && y - 1 == answer[j][1] && answer[j][2] == 0)
                        check = true
                    if (x + 1 == answer[j][0] && y - 1 == answer[j][1] && answer[j][2] == 0)
                        check = true
                    if (x - 1 == answer[j][0] && y == answer[j][1] && answer[j][2] == 1)
                        left = true
                    if (x + 1 == answer[j][0] && y == answer[j][1] && answer[j][2] == 1)
                        right = true
                }
                if (left && right) check = true
                if (!check) return false// 아니라면 거짓(False) 반환
            }
        }
        return true
    }

    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        val answer = ArrayList<ArrayList<Int>>()
        // 작업(frame) 개수는 최대 1,000개
        for (i in build_frame.indices) {
            val x = build_frame[i][0]
            val y = build_frame[i][1]
            val stuff = build_frame[i][2]
            val operate = build_frame[i][3]
            if (operate == 0) {//삭제하는 경우
                //일단 삭제를 해 본 뒤에
                var index = 0
                for (j in answer.indices) {
                    if (x == answer[j][0] && y == answer[j][1] && stuff == answer[j][2])
                        index = j
                }
                val erased = answer[index]
                answer.removeAt(index)
                if (!possible(answer)) //가능한 구조물인지 확인
                    answer.add(erased)//가능한 구조물이 아니라면 다시 설치

            }
            if (operate == 1) {//설치하는 경우
                //일단 설치를 해 본 뒤에
                val inserted = ArrayList<Int>()
                inserted.add(x)
                inserted.add(y)
                inserted.add(stuff)
                answer.add(inserted)
                if (!possible(answer))//가능한 구조물인지 확인
                    answer.removeAt(answer.size - 1)//가능한 구조물이 아니라면 다시 삭제
            }
        }
        //정렬 수행
        val ans = ArrayList<Node6>()
        for (i in answer.indices) {
            ans.add(Node6(answer[i][0], answer[i][1], answer[i][2]))
        }
        ans.sort()
        //배열로 바꾸어 반환
        val res = Array(ans.size) { IntArray(3) }
        for (i in ans.indices) {
            res[i][0] = ans[i].x
            res[i][1] = ans[i].y
            res[i][2] = ans[i].stuff
        }
        return res
    }
}
