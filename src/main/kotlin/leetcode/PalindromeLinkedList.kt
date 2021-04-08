package leetcode

import java.util.*


class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        if(head == null) {
            return true
        }

        var array = mutableListOf<Int>()
        var pointer = head

        do {
            array.add(pointer!!.`val`)
            pointer = pointer.next
        } while (pointer != null)

        if(array.size % 2 != 0) {
            return false
        }

        var i = 0
        var j = array.size -1

        while(i < j) {
            if(array[i++] !== array [j--]) {
                return false
            }
        }


        return true

    }
}