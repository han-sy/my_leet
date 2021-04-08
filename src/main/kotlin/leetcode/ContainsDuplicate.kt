package leetcode

/**
 * https://leetcode.com/problems/contains-duplicate/submissions/
 */
class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for(num in nums) {
            if(set.contains(num)) {
                return false
            } else {
                set.add(num)
            }
        }

        return true
    }
}