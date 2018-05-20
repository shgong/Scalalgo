/*
A rectangle is represented as a list [x1, y1, x2, y2],
where (x1, y1) are the coordinates of its bottom-left corner,
and (x2, y2) are the coordinates of its top-right corner.

Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false



 */

def isRectangleOverlap(rec1: Array[Int], rec2: Array[Int]): Boolean = {
  if(rec1(2) <= rec2(0) || rec2(2) <= rec1(0)) false
  else if (rec1(3) <= rec2(1) || rec2(3) <= rec1(1)) false
  else true
}

isRectangleOverlap(
  Array(0,0,2,2),
  Array(1,1,3,3)
)

isRectangleOverlap(
  Array(0,0,1,1),
  Array(1,0,2,1)
)

isRectangleOverlap(
  Array(5,15,8,18),
  Array(0,3,7,9)
)