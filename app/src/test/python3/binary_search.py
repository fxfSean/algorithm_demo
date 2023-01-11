
def search_insert(nums, target):
    l = len(nums)
    ans = l
    left = 0
    right = l - 1
    while left <= right:
        mid = ((right - left) >> 1) + left
        if target < nums[mid]:
            ans = mid
            right = mid - 1
        else:
            left = mid + 1

    return ans


if __name__ == '__main__':
    nums = [1,5,7,10]
    t = search_insert(nums, 2)
    print(t)

