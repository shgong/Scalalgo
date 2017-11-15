# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num):

class Solution(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        (smin, smax) = (1, n+1)

        while True:
            mid = (smax + smin) / 2
            result = guess(mid)
            if result == -1:
                smax = mid
            elif result == 1:
                smin = mid
            else:
                return mid
