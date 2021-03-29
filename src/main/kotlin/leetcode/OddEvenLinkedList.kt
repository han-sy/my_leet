package leetcode

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 */
fun main(args: Array<String>) {
    var result = OddEvenLinkedList().oddEvenList(makeExample())

    printListNode(result)

    var result2 = OddEvenLinkedList2().oddEvenList(makeExample())

    printListNode(result2)
}

private fun printListNode(result: ListNode?) {
    var result1 = result
    println("===============================")
    while (result1 != null) {
        println(result1.`val`)
        result1 = result1.next
    }
}

fun makeExample(): ListNode? {
    var header = ListNode(1)
    var target = header
    var next = ListNode(2)
    var next2 = ListNode(3)

    target.next = next
    target = target.next!!
    target.next = next2
    return header
}

/**
 * 172 ms	35 MB
 *
 */
class OddEvenLinkedList {
    private var oddListHeader: ListNode = ListNode(0)
    private var oddList: ListNode = oddListHeader
    private var evenListHeader: ListNode = ListNode(0)
    private var evenList: ListNode = evenListHeader

    fun oddEvenList(head: ListNode?): ListNode? {
        if(head == null) {
            return null
        }
        var index = 0
        var target = head

        while (true) {
            println("target : ${target?.`val`}, next : ${target?.next?.`val`}")

            if (++index % 2 == 0) {
                evenList.next = target
                evenList = evenList.next!!
            } else {
                oddList.next = target
                oddList = oddList.next!!
            }

            target = target?.next

            if (target == null) {
                evenList.next = null
                oddList.next = null
                break
            }
        }

        printListNode(oddListHeader)
        printListNode(evenListHeader)
        oddList.next = evenListHeader.next

        return oddListHeader.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


/**
 * solution.
 * 속도와 memory 사용률은  1번과 동일함
 */
class OddEvenLinkedList2 {
    fun oddEvenList(head: ListNode?): ListNode? {
        if(head == null) {
            return null
        }
        var odd = head
        var even = odd.next
        var evenHead = even

        while(even != null && even.next != null) {
            odd?.next = even.next
            odd = odd?.next
            even.next = odd?.next
            even = even.next
        }
        odd?.next = evenHead
        return head
    }
}
