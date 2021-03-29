package leetcode

fun main(args: Array<String>) {
    println(IntersectionOfTwoArraysII().intersect3(intArrayOf(1, 2, 2, 1),
        intArrayOf(2)).forEach { v -> println(v) })
}

class IntersectionOfTwoArraysII {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        loop@ for (num1 in nums1) {
            for ((idx, num2) in nums2.withIndex()) {
                if (num1 == num2) {
                    answer.add(num1)
                    nums2[idx] = -1
                    continue@loop
                }
            }
        }
        return answer.toIntArray()
    }

    fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.size > nums2.size) {
            return intersect2(nums2, nums1)
        }

        val answer = mutableListOf<Int>()
        loop@ for (num1 in nums1) {
            for ((idx, num2) in nums2.withIndex()) {
                if (num1 == num2) {
                    answer.add(num1)
                    nums2[idx] = -1
                    continue@loop
                }
            }
        }
        return answer.toIntArray()
    }

    fun intersect3(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()

        var cloneOfNums2 = nums2.clone()
        val answer = mutableListOf<Int>()
        loop@ for (num1 in nums1) {
            println("====================$num1=================")

            if(cloneOfNums2.isEmpty()) {
                break
            }

            val index = indexOf(num1, cloneOfNums2, cloneOfNums2.size / 2, 0, cloneOfNums2.size)
            if (index >= 0) {
                answer.add(num1)
                cloneOfNums2 = remove(cloneOfNums2, index)
            }
        }
        return answer.toIntArray()
    }

    private fun indexOf(num1: Int, nums2: IntArray, pivot: Int, min: Int, max: Int): Int {
        println("pivot : $pivot, min : $min, max : $max")
        if (num1 == nums2[pivot]) {
            return pivot
        }

        if (pivot == min || pivot == max) {
            return -1
        }

        return if (num1 < nums2[pivot]) {
            indexOf(num1, nums2, (min + pivot) / 2, min, pivot)
        } else {
            indexOf(num1, nums2, (pivot + max) / 2, pivot, max)
        }
    }

    fun remove(arr: IntArray, index: Int): IntArray {
        if (index < 0 || index >= arr.size) {
            return arr
        }
        val result = arr.toMutableList()
        result.removeAt(index)
        return result.toIntArray()
    }
}