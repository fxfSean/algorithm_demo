package com.fxf.leetcode.structure

import org.w3c.dom.Node



class LRUCache(var cap: Int) {
    private val map = HashMap<Int,Node>()
    private val cache = DoubleList()

    fun makeRecently(key: Int){
        cache.remove(map[key]!!)
        cache.addLast(map[key]!!)
    }

    fun addRecently(key: Int,value: Int){
        val node = Node(key,value)
        cache.addLast(node)
        map[key] = node
    }

    fun deleteKey(key: Int){
        cache.remove(map[key]!!)
        map.remove(key)
    }

    fun removeLeastRecently(){
        val removeFirst = cache.removeFirst()
        removeFirst?.apply {
            map.remove(x)
        }
    }

    /**
     * 伪代码
     * fun put (key: Int, value: Int) {
     *  if (map.containsKey(key) {
     *      删除列表key
     *      插入到尾节点
     *  } else {
     *      if (size == capacity) {
     *          删除末尾节点
     *          插入到尾节点
     *      }
     *  }
     * }
     */

    public fun put(key: Int,value: Int){
        if (map.containsKey(key)){
            deleteKey(key)
            addRecently(key, value)
        } else if (cap == cache.size()){
            removeLeastRecently()
            addRecently(key,value)
        }
    }

    /**
     * get 伪代码
     * fun get (key: Int) {
     *  if (!map.containsKey(key) {
     *      return null
     *  }
     *  删除列表key
     *  添加到尾节点
     * }
     */

    public fun get(key: Int): Node?{
        if (!map.containsKey(key)){
            return null
        }
        makeRecently(key)
        return map[key]
    }

    class DoubleList{
        private var head: Node
        private var tail: Node
        private var size: Int = 0

        init {
            head = Node(0,0)
            tail = Node(0,0)
            tail.pre = head
            head.next = tail
        }

        /**
         * 添加到尾节点伪代码
         * fun addLast(node: Node) {
         *  尾节点前驱节点的next指向node
         *  node的pre指向tail的pre
         *  node的next指向tail
         *  tail的pre指向node
         *  size++
         * }
         */

        fun addLast(node: Node){
            tail.pre!!.next = node
            node.pre = tail.pre
            node.next = tail
            tail.pre = node
            size++
        }

        fun remove(node:Node){
            node.pre!!.next = node.next
            node.next!!.pre = node.pre
            size--
        }

        fun removeFirst(): Node?{
            if (head.next == tail){
                return null
            }
            val first = head.next
            remove(first!!)
            return first
        }

        fun size(): Int{
            return size
        }
    }

    class Node(var x: Int,var value: Int) {
        var pre: Node? = null
        var next: Node? = null
    }
}