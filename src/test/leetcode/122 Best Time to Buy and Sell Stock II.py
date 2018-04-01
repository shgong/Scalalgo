class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """

        lastmin = None

        for p in prices:
            if lastmin is None or p<lastmin:
                lastmin = p
