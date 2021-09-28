package com.fxf.leetcode

class BinarySearch {

    fun search(arr: IntArray, target: Int): Int{
        var left = 0
        var right = arr.size - 1
        while (left <= right){
            var mid = left + (right - left)/2
            if (arr[mid] == target){
                return mid
            } else if (arr[mid] > target){
                right = mid -1
            } else if (arr[mid] < target){
                left = mid + 1
            }
        }
        return -1
    }

    fun searchLeftBound(arr: IntArray,target: Int): Int {
        var left = 0
        var right = arr.size - 1
        while (left <= right){
            var mid = left + (right - left)/2
            if (arr[mid] == target){
                right = mid - 1
            } else if (arr[mid] > target){
                right = mid - 1
            } else if (arr[mid] < target){
                left = mid + 1
            }
        }
        if (left >= arr.size || arr[left] != target)return -1
        return left
    }

    fun searchRightBound(arr: IntArray,target: Int): Int {
        var left = 0
        var right= arr.size -1
        while (left <= right){
            var mid = left + (right - left)/2
            if (arr[mid] == target){
                left = mid+1
            } else if (arr[mid] > target){
                right = mid -1
            } else {
                left = mid+1
            }
        }
        if (right < 0 || arr[right] != target)return -1
        return right
    }
}