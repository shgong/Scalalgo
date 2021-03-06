# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        if head is None or head.next is None or head.next.next is None:
            return None

        slow = head.next
        fast = head.next.next
        while slow != fast:
            if fast.next is None or fast.next.next is None:
                return None
            slow = slow.next
            fast = fast.next.next

        fast = head
        while slow != fast:
            slow = slow.next
            fast = fast.next

        return slow