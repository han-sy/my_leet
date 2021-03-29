package leetcode

import java.util.concurrent.ThreadLocalRandom

class RandomizedSet {
    /** Initialize your data structure here. */
    val set = mutableSetOf<Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        return set.add(`val`)
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        return set.remove(`val`)
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        return set.random()
    }

}