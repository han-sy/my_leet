package leetcode

import common.printList

fun main(array: Array<String>) {
    WiggleSort2().wiggleSort(intArrayOf(1,5,1,1,6,4))
    println("===========================================")
    WiggleSort2().wiggleSort(intArrayOf(1,3,2,2,3,1))

}

class WiggleSort2 {
    fun wiggleSort(nums: IntArray): Unit {
        nums.sort()
        val clone = nums.clone()
        var mid = nums.size / 2 - 1
        var mid2 = mid + 1

        var i = 0
        var j = nums.size - 1
        while (i <= j) {
            println("$i $j $mid $mid2")
            if( i % 2 == 0) {
                nums[i] = clone[mid2]
                nums[j] = clone[mid]
            }
            printList(nums)


            i++
            j--
            mid--
            mid2++
        }


        printList(nums)
    }
}