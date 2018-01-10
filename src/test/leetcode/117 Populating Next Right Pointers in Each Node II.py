
# @param root, a tree link node
# @return nothing# Definition for binary tree with next pointer.
class TreeLinkNode:
  def __init__(self, x):
    self.val = x
    self.left = None
    self.right = None
    self.next = None


class Solution:
  # @param root, a tree link node
  # @return nothing
  def connect(self, root):
      if root is None:
          return
      ls = [root]
      while ls:
          ls = [node for k in ls for node in [k.left, k.right] if node is not None ]
          #for i in range(0, len(ls)-1):
          #   ls[i].next = ls[i+1]