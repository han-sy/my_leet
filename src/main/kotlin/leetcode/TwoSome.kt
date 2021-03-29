package leetcode

fun main(args: Array<String>) {
    val answer = TwoSome().twoSum(intArrayOf(-1,-2,-3,-4,-5), -8)

    print("answer is ")
    answer.forEach { v -> print("$v,") }
}

class TwoSome {
    private lateinit var nums: IntArray
    private var target: Int = 0

    fun twoSum(nums: IntArray, target: Int): IntArray {
        this.nums = nums
        this.target = target

        return findAnswer(mutableListOf(0), 0)
    }

    private fun findAnswer(answer: MutableList<Int>, pivotIndex: Int, checkIndex: Int = pivotIndex + 1): IntArray {
        println("pivot $pivotIndex, check $checkIndex, sum ${sum(answer)}")
        for ((index, num) in nums.withIndex()) {
            if (index < checkIndex) {
                continue
            }

            if ((sum(answer) + num) == target) {
                answer.add(index)
                return answer.toIntArray()
            }
        }

//        return if (checkIndex + 1 <= nums.size - 1) {
//            answer.add(checkIndex)
//            findAnswer(answer, pivotIndex, checkIndex + 1)
//        } else {
            if (pivotIndex + 1 > nums.size - 1) {
                throw Exception("no answer")
            }
            return findAnswer(mutableListOf(pivotIndex + 1), pivotIndex + 1)
//        }


    }

    private fun sum(answer: List<Int>): Int {
        var sum = 0
        for (idx in answer) {
            sum += nums[idx]
        }

        return sum
    }
}