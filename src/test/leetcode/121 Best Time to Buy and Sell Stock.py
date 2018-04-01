class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        min = None
        profit = None

        for p in prices:
            if min is None or p<min:
                min = p
            gain = p - min
            if profit is None or gain > profit:
                profit = gain

        return profit
