/*
Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */

def sortColors(nums: Array[Int]): Unit = {
  val l = nums.length

  var red = 0
  var blue = l - 1

  while(red<l && nums(red)==0) red+=1
  while(blue>=0 && nums(blue)==2) blue-=1
  var i = red

  while(i<=blue){
    if(nums(i)==2){
      nums(i) = nums(blue)
      nums(blue) = 2
      while(blue>=0 && nums(blue)==2) blue-=1
    } else if (nums(i)==0){
      nums(i) = nums(red)
      nums(red) = 0
      while(red<l && nums(red)==0) red+=1
      i = i max red
    } else i += 1
  }

}


val k2 = Array(0,2,2,2,0,2,1,1)
sortColors(k2)
k2
