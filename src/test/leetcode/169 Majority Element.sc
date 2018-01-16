/*
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 */

def majorityElement(nums: Array[Int]): Int = {
  nums.groupBy(identity).mapValues(_.length).maxBy(_._2)._1
}

majorityElement(Array(1,2,2,2,4,3))