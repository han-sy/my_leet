package leetcode

fun main(args: Array<String>) {
    ReverseString().reverseString(charArrayOf('h', 'e', 'l', 'l'))
}

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        for ((idx, ch) in s.withIndex()) {
            if (idx > (s.size - 1) / 2) {
                break
            }

            swap(s, idx, s.size - 1 - idx)
        }

        println(s)
    }

    private fun swap(answer: CharArray, p: Int, q: Int) {
        val temp = answer[p]
        answer[p] = answer[q]
        answer[q] = temp
    }
}