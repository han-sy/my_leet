package leetcode

import java.util.concurrent.ThreadLocalRandom

fun main(args: Array<String>) {
    val shuffleArray = ShuffleArray(IntArray(3) { i -> i })

    println(shuffleArray.shuffle())
    println(shuffleArray.reset())
    println(shuffleArray.shuffle())
    println(shuffleArray.reset())
    println(shuffleArray.shuffle())
    println(shuffleArray.reset())
}

class ShuffleArray(private val nums: IntArray) {
    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        val copyOfNums = nums.copyOf()
        return shuffle(copyOfNums)
    }

    private fun shuffle(copyOfNums: IntArray): IntArray {
        val shuffled = IntArray(copyOfNums.size)
        var list = copyOfNums.toMutableList()
        var i = 0
        while (true) {
            if (list.size > 1) {
                val randomIndex = ThreadLocalRandom.current().nextInt(0, list.size)
                shuffled[i++] = list[randomIndex]

                list.removeAt(randomIndex)
            } else {
                shuffled[i] = list[0]
                break
            }

        }

        return shuffled
    }

}


class ShuffleArray2(private val nums: IntArray) {
    var usedIndex = mutableMapOf<Int, Boolean>()

    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        val copyOfNums = nums.copyOf()
        return shuffle(copyOfNums)
    }

    private fun shuffle(copyOfNums: IntArray): IntArray {
        usedIndex = mutableMapOf()
        val shuffled = IntArray(copyOfNums.size)
        var list = copyOfNums.toMutableList()
        var i = 0
        while (i < copyOfNums.size) {
            val randomIndex = getNextIndex(copyOfNums.size)
            println("randomIndex $randomIndex")
            shuffled[i++] = list[randomIndex]
        }

        return shuffled
    }

    private fun getNextIndex(bound: Int): Int {
        if (bound <= 1) {
            return bound
        }
        while (true) {
            val randomIndex = ThreadLocalRandom.current().nextInt(0, bound)

            if (usedIndex[randomIndex] == null) {
                usedIndex[randomIndex] = true
                return randomIndex
            }
        }
    }

}
