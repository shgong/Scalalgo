import math

class Solution:
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        if len(nums) == 0:
            return -1

        lo,hi,s = 0, len(nums)-1, nums[0]

        while lo + 1 < hi:
            mid = math.floor((lo + hi) / 2)
            if nums[mid] > s:
                lo = mid
            else:
                hi = mid

        if target < s:
            lo,hi = hi, len(nums)-1
        elif target == s:
            return 0
        else:
            lo,hi = 0, lo


        print(lo,hi)

        while lo + 1 < hi:
            mid = math.floor((lo + hi) / 2)
            if nums[mid] >= target:
                hi = mid
            else:
                lo = mid

        if nums[hi] == target:
            return hi
        elif nums[lo] == target:
            return lo
        else:
            return -1


r = Solution().search([1,3], 3)
print(r)