package com.fxf.leetcode

import org.junit.Test
import java.util.*

class SortsSet {

    @Test
    fun t0(){
        val a = intArrayOf(5, 2, 1, 3, 6, 3, 8, 7)
//        bubble(a)
        insertSort(a)
        for (i in a) {
            print(i)
        }
    }

    /** 改进版冒泡
     * 空间复杂度
    假设数组的元素个数是 n，由于在整个排序的过程中，我们是直接在给定的数组里面进行元素的两两交换，所以空间复杂度是 O(1)。
    时间复杂度
    1. 给定的数组按照顺序已经排好
    在这种情况下，我们只需要进行 n−1 次的比较，两两交换次数为 0，时间复杂度是 O(n)。这是最好的情况。
    2. 给定的数组按照逆序排列
    在这种情况下，我们需要进行 n(n-1)/2 次比较，时间复杂度是 O(n2)。这是最坏的情况。
    3. 给定的数组杂乱无章
    在这种情况下，平均时间复杂度是 O(n2)。
    由此可见，冒泡排序的时间复杂度是 O(n2)。它是一种稳定的排序算法。（稳定是指如果数组里两个相等的数，那么排序前后这两个相等的数的相对位置保持不变。）
     * */
    private fun bubble(a: IntArray) {
        var hasChange = true
        var i=0
        while (i < a.size && hasChange){
            hasChange = false
            for(j in 0 until  a.size - i - 1){
                if (a[j] > a[j + 1]){
                    swap(a,j,j+1)
                    hasChange = true
                }
            }
            i++
        }
    }

    /**
     * 空间复杂度
     * 假设数组的元素个数是 n，由于在整个排序的过程中，是直接在给定的数组里面进行元素的两两交换，空间复杂度是 O(1)。
     * 时间复杂度
     * 1. 给定的数组按照顺序已经排好
     * 只需要进行 n-1 次的比较，两两交换次数为 0，时间复杂度是 O(n)。这是最好的情况。
     * 2. 给定的数组按照逆序排列
     * 在这种情况下，我们需要进行 n(n-1)/2 次比较，时间复杂度是 O(n2)。这是最坏的情况。
     * 3. 给定的数组杂乱无章
     * 在这种情况下，平均时间复杂度是 O(n2)。
    由此可见，和冒泡排序一样，插入排序的时间复杂度是 O(n2)，并且它也是一种稳定的排序算法
     */
    fun insertSort(nums: IntArray){
        var i = 1
        var j: Int
        var current: Int
        while (i < nums.size){
            current = nums[i]
            j = i -1
            while (j >= 0 && nums[j] > current){
                nums[j+1] = nums[j]
                j--
            }
            nums[j+1] = current
            i++

        }
    }

    @Test
    fun t2(){
        val a = intArrayOf(2, 1, 7, 9, 5, 8)
        mergeSort(a,0,a.size - 1)
    }

    fun mergeSort(A: IntArray,lo: Int,hi: Int){
        if (lo >= hi)return
        val mid = lo + (hi - lo) shr 1
        println("111 lo:$lo mid:$mid hi: $hi")
        mergeSort(A,lo,mid)
        println("112 lo:$lo mid:$mid hi: $hi")

        mergeSort(A,mid + 1,hi)
        println("113 lo:$lo mid:$mid hi: $hi")
        merge(A,lo,mid,hi)
        for (it in A){
            print(it)
        }
        println()
    }

    @Test
    fun t3(){
        val a = intArrayOf(5, 2, 1, 3, 6, 3, 8, 7)
        mergeSort(a)
    }

    fun mergeSort(arr: IntArray) {
        sort2(arr, 0, arr.size - 1)
    }

    fun sort2(arr: IntArray, L: Int, R: Int) {
        if (L == R) {
            return
        }
        val mid = L + (R - L shr 1)
        sort2(arr, L, mid)
        sort2(arr, mid + 1, R)
        merge2(arr, L, mid, R)
    }

    fun merge3(arr: IntArray,L: Int,mid: Int,R: Int){
        val temp = IntArray(R - L + 1)
        var i = 0
        var pl = L
        var pr = mid + 1
        while (pl <= mid && pr <= R){
            temp[i++] = if (arr[pl] < arr[pr]) arr[pl++] else arr[pr++]
        }
        while (pl <= mid){
            temp[i++] = arr[pl++]
        }
        while (pr <= R){
            temp[i++] = arr[pr++]
        }
        i=0
        while (i<temp.size){
            arr[i] = temp[i]
            i++
        }

    }

    fun merge2(arr: IntArray, L: Int, mid: Int, R: Int) {
        val temp = IntArray(R - L + 1)
        var i = 0
        var p1 = L
        var p2 = mid + 1
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= R) {
            temp[i++] = if (arr[p1] < arr[p2]) arr[p1++] else arr[p2++]
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = arr[p1++]
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++]
        }
        // 把最终的排序的结果复制给原数组
        i = 0
        while (i < temp.size) {
            arr[L + i] = temp[i]
            i++
        }
    }

    fun merge(nums:IntArray,lo:Int,mid:Int,hi:Int){
        println("lo: $lo mid: $mid hi: $hi")
        val copy = nums.clone()
        var k = lo
        var i = lo
        var j = mid + 1
        while (k <= hi){
            if (i > mid){
                nums[k++] = copy[j++]
            } else if (j > hi){
                nums[k++] = copy[i++]
            } else if (copy[j] < copy[i]){
                nums[k++] = copy[j++]
            } else {
                nums[k++] = copy[i++]
            }
        }

    }

    fun topK(arr: IntArray,k: Int): IntArray{
        val res = IntArray(k)
        val queue = PriorityQueue<Int>()
        for (i in 0 until queue.size){
            if (i < k){
                queue.add(res[i])
            } else if (res[i] > queue.peek()){
                queue.poll()
                queue.add(res[i])
            }
        }
        var i = 0
        while (queue.isNotEmpty()){
            res[i++] = queue.poll()
        }
        return res
    }

    /**
     * 快排
     */
    fun quickSort(arr: IntArray,low: Int,high: Int){
        if(low>= high)return
        val partition = partition(arr,low,high)
        quickSort(arr,0,partition-1)
        quickSort(arr,partition+1,high)
    }

    private fun partition(arr: IntArray,low: Int,high: Int): Int {
        var pivot = low
        var index = low+1
        for (i in index until high){
            if (arr[i] < arr[pivot]){
                swap(arr,index,i)
                index++
            }
        }
        swap(arr,low,index-1)
        return index -1
    }

    private fun swap(a:IntArray,i:Int,j: Int){
        val temo = a[i]
        a[i] = a[j]
        a[j] = temo
    }
}