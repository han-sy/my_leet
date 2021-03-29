package leetcode

import java.util.*


fun main(args: Array<String>) {
    println(TopKFrequent().topKFrequent2(intArrayOf(1, 1, 3, 2, 2,2, 1,4),
       1).forEach { v -> println(v) })
}

class TopKFrequent {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        val answer = mutableSetOf<Int>()
        for(num in nums) {
            map.compute(num) { k, v -> if (v == null) 1 else v + 1 }
        }

        val sortedMap = map.toList().sortedWith(compareByDescending { it.second }).toMap()


        var index = 0
        for(key in sortedMap.keys) {
            println("$key :  ${sortedMap[key]}")
            answer.add(key)

            if(++index == k) {
                break
            }
        }
        return answer.toIntArray()
    }

    fun topKFrequent2(nums: IntArray, k: Int): List<Int> {
        val bucket: Array<MutableList<Int>?> = arrayOfNulls<MutableList<Int>?>(nums.size + 1)
        val frequencyMap: MutableMap<Int, Int> = HashMap()

        for (n in nums) {
            frequencyMap[n] = frequencyMap.getOrDefault(n, 0) + 1
        }
        for (key in frequencyMap.keys) {
            val frequency = frequencyMap[key]!!
            if (bucket[frequency] == null) {
                bucket[frequency] = mutableListOf()
            }
            bucket[frequency]!!.add(key)
        }
        val res: MutableList<Int> = ArrayList()
        var pos = bucket.size - 1
        while (pos >= 0 && res.size < k) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]!!)
            }
            pos--
        }
        return res
    }
}