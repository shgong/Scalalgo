/*

Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

length and integer number < 1000
 */

import collection.Searching._
def triangleNumber(nums: Array[Int]): Int = {

  val num = nums.filter(_!=0).sorted
  var count = 0
  for(i<-num.indices; j<-i+1 until num.length) {
    val k = num.search(num(i)+num(j)).insertionPoint // can improve w/ hashmap
    count += k - 1 - j
  }
  count
}

triangleNumber(Array(2,2,3,4))