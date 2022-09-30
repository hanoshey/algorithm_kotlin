import kotlin.math.min

class Solution2 {
    fun solution(s: String): Int {
        var answer = s.length
        for (steps in 1 until s.length / 2 + 1) {
            var compressed = ""
            var prev = s.substring(0, steps)//앞에서부터 step만큼의 문자열 추출
            var cnt = 1
            //단위(step)크기만큼 증가시키며 이전 문자열과 비교
            for (j in steps until s.length step steps) {
                //이전 상태와 동일하다면 압축 횟수(count) 증가
                var sub = ""
                for (k in j until j + steps)
                    if (k < s.length) sub += s[k]
                if (prev == sub) cnt += 1
                //다른 문자열이 나왔다면(더 이상 압축하지 못하는 경우라면
                else {
                    compressed += (if (cnt >= 2) cnt.toString() + prev else prev)
                    sub = ""
                    for (k in j until j + steps)
                        if (k < s.length) sub += s[k]
                    prev = sub
                    cnt = 1
                }
                //남아있는 문자열에 대해서 처리

            }
            compressed += if (cnt >= 2) cnt.toString() + prev else prev
            answer = min(answer, compressed.length)
        }
        return answer
    }
}
