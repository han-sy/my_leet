package leetcode

import java.util.*

fun main(args: Array<String>) {
    println(ValidAnagram().isAnagram2("anagram", "nagaram"))
}

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Int>()
        for (s1 in s) {
            map.compute(s1) { _: Char, i: Int? ->
                if (i == null) 1 else i + 1
            }
        }
         for (t1 in t) {
            var value = map[t1]
             when (value) {
                 null -> {
                     return false
                 }
                 1 -> {
                     map.remove(t1)
                 }
                 else -> {
                     map[t1] = value - 1
                 }
             }

        }
        println(map)
        return map.isEmpty()
    }

    fun isAnagram2(s: String, t: String): Boolean {
        if (s.length !== t.length) {
            return false
        }
        val table = IntArray(26)
        for (element in s) {
            table[element - 'a']++
        }
        for (i in t.indices) {
            table[t[i] - 'a']--
            if (table[t[i] - 'a'] < 0) {
                return false
            }
        }
        return true
    }


}

fun isAnagram(s: String, t: String): Boolean {

    var list = mutableListOf<Char>()
    for (s1 in s) {
        list.add(s1)
    }

    for (t1 in t) {
        if (!list.remove(t1)) {
            return false
        }
    }

    return list.isEmpty()
}