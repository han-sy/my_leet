package leetcode
fun main(args:Array<String>) {
    println(MissingNumber().missingNumber(intArrayOf(3,0,1)))
}

/**
 * https://leetcode.com/problems/missing-number/
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        val array = arrayOfNulls<Int>(nums.size + 1)
        for(num in nums) {
            array[num] = 1
        }

        for((i, arr) in array.withIndex()) {
            if(arr == null) {
                return i
            }
        }

        return -1
    }
}