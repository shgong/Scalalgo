/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
 */

def canJump(nums: Array[Int]): Boolean = {
  var max = 0
  var i = 0
  while(i<=max){
    if(max>=nums.length-1) return true
    max = max max (i + nums(i))
    i += 1
  }
  false
}

canJump(Array(2,3,1,1,4))
canJump(Array(3,2,1,0,4))