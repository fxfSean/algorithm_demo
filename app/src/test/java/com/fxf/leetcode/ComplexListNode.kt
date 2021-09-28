package com.fxf.leetcode

public class ComplexListNode {
    public var value = 0
    public var next: ComplexListNode? = null
    var sibling: ComplexListNode? = null

    fun clone(head: ComplexListNode){

    }

    fun cloneNodes(head: ComplexListNode?) {
// 如果链表不空，进行复制操作
        var head = head
        while (head != null) {
// 创建一个新的结点
            val tmp = ComplexListNode()
            // 将被复制结点的值传给复制结点
            tmp.value = head.value
            // 复制结点的next指向下一个要被复制的结点
            tmp.next = head.next
            // 被复制结点的next指向复制结点
            head.next = tmp
            // 到些处就已经完成了一个结点的复制并且插入到被复制结点的后面 // heed指向下一个被复制结点的位置
            head = tmp.next
        }
    }
}