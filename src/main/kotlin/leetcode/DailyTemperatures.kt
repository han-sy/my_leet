package leetcode

import common.printList
import java.util.*


/**
 * https://leetcode.com/problems/daily-temperatures/
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */

fun main(args: Array<String>) {
    printList(DailyTemperatures().dailyTemperatures3(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)))
}
class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        var result = mutableListOf<Int>()

        for((i, temp) in temperatures.withIndex()) {
            result.add(findNextWarmDay(temp, temperatures.slice(i + 1 until temperatures.size)))
        }
        return result.toIntArray()
    }

    private fun findNextWarmDay( prevTemp: Int, temperatures: List<Int>): Int {
        var count = 1
        for((i, temp) in temperatures.withIndex()) {
            if(temp > prevTemp) {
                return count
            }
            count++
        }

        return 0
    }

    fun dailyTemperatures2(temperatures: IntArray): IntArray {
        var result = mutableListOf<Int>()
        var queue = PriorityQueue<Int>()
        var target : Int?= null
        for(temp in temperatures) {
            if(queue.isEmpty()) {
                queue.add(temp)
                continue
            }
            queue.add(temp)
            val top = queue.peek()

            if(top < temp) {
                queue.remove()
                result.add(queue.size)
            }
        }
        var idx = 0
        queue.add(temperatures[idx])
        do {
            idx++
            var top = queue.poll()

            if(queue.isNotEmpty()) {
                findNextInQueue()
            } else {
                if(top < temperatures[idx]) {
                    queue.remove()
                    result.add(queue.size)
                }
            }
        } while(queue.isNotEmpty())




        return result.toIntArray()
    }

    private fun findNextInQueue() {


    }

    fun dailyTemperatures3(T: IntArray): IntArray {
        val ans = IntArray(T.size)
        val stack: Stack<Int?> = Stack<Int?>()
        for (i in T.indices.reversed()) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek() as Int]) {
                stack.pop()
            }

            ans[i] = if (stack.isEmpty()) 0 else stack.peek()!! - i
            stack.push(i)
        }
        return ans
    }
}