/*
Given an array nums containing n + 1 integers (1-n)
Assume that there is only one duplicate number, find the duplicate one

You must not modify the array
You must use only constant, O(1) extra space
There is only one duplicate number in the array, but it could be repeated more than once.
 */


/*
the array forms a graph, each node has one out,
node 0-n has 1 out
one of node 1-n has multiple in

Topology of the graph
0 -> -> Sp
Sp -> -> Sp, which forms a loop

Need to find the loop node
Fast & slow algorithm
 */
def findDuplicate(nums: Array[Int]): Int = {
  if (nums.length <= 1) return -1

  var slow = nums(0)
  var fast = nums(nums(0))

  while (slow != fast) {
    slow = nums(slow)
    fast = nums(nums(fast))
  }

  // now pointer inside the loop
  // start over from 0 one step a time
  // the first time they meet will be the start of the loop

  fast = 0
  while (fast != slow) {
    fast = nums(fast)
    slow = nums(slow)
  }
  slow

}

findDuplicate(Array(1,2,4,5,3,3))
findDuplicate(Array(1,2,4,5,3,3))