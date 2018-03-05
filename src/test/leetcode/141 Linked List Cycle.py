# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        if head is None or head.next is None or head.next.next is None:
            return False

        slow = head.next
        fast = head.next.next
        while slow != fast:
            if fast.next is None or fast.next.next is None:
                return False
            slow = slow.next
            fast = fast.next.next

        return True

a = ListNode(1)
b = ListNode(2)
a.next = b

s = Solution()
print(s.hasCycle(a))

b.next = a
print(s.hasCycle(a))