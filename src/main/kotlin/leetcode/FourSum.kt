package leetcode

import java.util.*


fun main(args: Array<String>) {
    val answer = Solution().fourSumCount(
        arrayOf(1, 2).toIntArray(),
        arrayOf(1, 1).toIntArray(),
        arrayOf(-1, 0).toIntArray(),
        arrayOf(-1, 2).toIntArray())

    println("answer is $answer")
}

class Solution {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        val map: MutableMap<Int, Int> = HashMap()
        for (a in A) for (b in B) {
            val s = a + b
            map[s] = map.getOrDefault(s, 0) + 1
        }
        var result = 0
        for (c in C) for (d in D) {
            val s = -c - d
            result += map.getOrDefault(s, 0)
        }
        return result
    }
}