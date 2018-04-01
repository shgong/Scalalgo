'''
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
'''

class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        x = [1, 2]
        for i in range(2, n):
            x.append(x[i-1] + x[i-2])
        return x[n-1]


Solution().climbStairs(10)
