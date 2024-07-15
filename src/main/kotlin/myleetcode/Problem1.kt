package myleetcode

//class Solution:
//    def twoSum(self, nums: list[int], target: int) -> list[int]:
//for i in range(len(nums)):
//for j in range(i + 1, len(nums)):
//if nums[i] + nums[j] == target:
//return [i, j]
// 브루트 포스
private fun twoSum(nums: IntArray, target: Int): IntArray {
//    for (i in nums.indices) {
//        for (j in i + 1 until nums.size) {
//            if (nums[i] + nums[j] == target) return intArrayOf(i, j)
//        }
//    }
//    return intArrayOf()
    // time complexity o(n^2)
//    for ((index, value) in nums.withIndex()) {
//        val complement = target - value
//        if (complement in nums.sliceArray(index + 1 until nums.size)) {
//            return intArrayOf(
//                nums.indexOf(value),
//                nums.sliceArray(index + 1 until nums.size).indexOf(complement)
//                        + (index + 1)
//            )
//        }
//    }
//    return intArrayOf()
//    nums_map={}
//    키와 값을 바꿔서 딕셔너리로 저장
//    for i, num in enumerate(nums):
//    nums_map[num]=i
//    # 타겟에서 첫 번째 수를 뺀 결과를 키로 조회
//            for i , num in enumerate(nums):
//    if target-num in nums_map and i!=nums_map[target-num]:
//    return [i,nums_map[target-num]]
    val numsToIndex = mutableMapOf<Int, Int>()
    // 타겟에서 첫 번째 수를 뺀 결과를 키로 조회
    for ((index, value) in nums.withIndex()) {
        if (numsToIndex.containsKey(target - value)) {
            return intArrayOf(numsToIndex[target - value]!!, index)
        }
        // 키와 값을 바꿔서 딕셔너리로 저장
        numsToIndex[value] = index
    }
    return intArrayOf()
}

private fun main() {
    twoSum(intArrayOf(2, 7, 11, 15), 4).forEach {
        print("$it ")
    }
}