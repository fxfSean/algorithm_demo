package com.fxf.leetcode.structure

class LRULinked(val cap: Int) {
    private val map = LinkedHashMap<Int,Int>()

    fun get(key: Int): Int{
        if (!map.containsKey(key)){
            return -1
        }
        makeRecently(key)
        return map[key]!!
    }

    fun put(key: Int,value: Int){
        if (map.containsKey(key)){
            map.put(key,value)
            makeRecently(key)
            return
        }
        if (cap == map.size){
            val next = map.keys.iterator().next()
            map.remove(next)
        }
        map.put(key,value)
    }

    fun makeRecently(key: Int){
        val remove = map.remove(key) as Int
        map[key] = remove
    }
}