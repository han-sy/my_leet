package leetcode

import java.lang.Exception


interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int?

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>?
}


class NestedIterator(private val nestedList: List<NestedInteger>) {
    var index = 0

    var current: Any? =
        if (nestedList.isEmpty())
            null
        else if(nestedList[0].isInteger())
            nestedList[0].getInteger()!!
        else
            NestedIterator(nestedList[0].getList()!!)

    fun hasNext(): Boolean {
        if(nestedList.isEmpty()) {
            return false
        }
        println("hasNext $index : ${nestedList.size} : $current")

        val nextValue = getNextValue()
        return nextValue != null
    }
    fun getNextValue() : Int {
        println("next $index : $current")
        val result = when (current) {
            is Int -> {
                return current as Int
            }
            is NestedIterator -> {
                val nestedIterator = current as NestedIterator
                return if (nestedIterator.hasNext()) {
                    println("nestedIterator.next()")

                    val nextValue = nestedIterator.next()

                    println("nestedIterator.next(): ${nextValue}")

                    if(nextValue == 4) {
                        println("=======================================")
                    }

                    if(nestedIterator.hasNext() == false) {
                        moveCurrent()
                    }
                    nextValue
                } else {
                    println("nestedIterator done. moveNext")
                    moveCurrent()
                    this.next()
                }
            }
            else -> {
                println("error!!!")
                throw Exception()
            }
        }

        return result
    }
    fun next(): Int {
        println("next $index : $current")
        val result = when (current) {
            is Int -> {
                val nextValue = current as Int
                println("int. value : $nextValue")
                moveCurrent()
                nextValue
            }
            is NestedIterator -> {
                val nestedIterator = current as NestedIterator
                return if (nestedIterator.hasNext()) {
                    println("nestedIterator.next()")

                    val nextValue = nestedIterator.next()

                    println("nestedIterator.next(): ${nextValue}")

                    if(nextValue == 4) {
                        println("=======================================")
                    }

                    if(nestedIterator.hasNext() == false) {
                        moveCurrent()
                    }
                    nextValue
                } else {
                    println("nestedIterator done. moveNext")
                    moveCurrent()
                    this.next()
                }
            }
            else -> {
                println("error!!!")
                throw Exception()
            }
        }

        return result
    }

    private fun moveCurrent() {
        index++
        println("moveCurrent : $index")
        if(index < nestedList.size)
            current =
                if (nestedList[index].isInteger())
                    nestedList[index].getInteger()!!
                else NestedIterator(nestedList[index].getList()!!)

    }


}