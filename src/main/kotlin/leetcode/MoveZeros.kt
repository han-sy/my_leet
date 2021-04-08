package leetcode

import common.printList

/**
 * https://leetcode.com/problems/move-zeroes/
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
 */

fun main(args:Array<String>) {
    MoveZeros().moveZeroes(intArrayOf(0, 1, 0, 3, 12))
}
class MoveZeros {
    fun moveZeroes(nums: IntArray): Unit {
        for (i in (nums.size - 1) downTo 0) {
            if (nums[i] == 0) {
                move0ToEnd(i, nums)
            }
        }
        printList(nums)
    }

    private fun move0ToEnd(idx: Int, nums: IntArray) {
        for (i in idx + 1 until nums.size) {
            if(nums[i] == 0) {
                break
            }
            swap(i -1, i, nums)
        }
    }

    private fun swap(i1: Int, i: Int, nums: IntArray) {
        val temp = nums[i1]
        nums[i1] = nums[i]
        nums[i] = temp
    }
}