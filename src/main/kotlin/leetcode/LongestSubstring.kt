package leetcode

fun main(args : Array<String>) {
    val answer = LongestSubstring().longestSubstring("aaabbc", 2)
    println("answer is $answer")
}
class LongestSubstring {
    fun longestSubstring(s: String, k: Int): Int {
        var map = mutableMapOf<String, Int>()
        for(char in s.toCharArray()) {
            val alphabet = char.toString()
            val repeatCount =  map[alphabet] ?: 0

            map[alphabet] = repeatCount + 1
        }

        var count = 0
        for(key in map.keys) {
            println("$key : ${map[key]}")

            if(map[key]!! >= k) {
                count += map[key]!!
            }
        }

        return count
    }
}