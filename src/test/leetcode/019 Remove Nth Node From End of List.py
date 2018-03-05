class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """

        start = ListNode(-1)
        start.next = head

        tail = head
        for _ in range(n):
            tail = tail.next

        head = start

        while tail is not None:
            head = head.next
            tail = tail.next

        head.next = head.next.next

        return start.next


a = ListNode(1)
b = ListNode(2)
c = ListNode(3)
a.next = b
b.next = c
r = Solution().removeNthFromEnd(a, 2)
print(r.val, r.next.val)