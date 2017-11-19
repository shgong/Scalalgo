// 1 to n, some appear twice, some not appear

// A. use BitSet(n)
// time limit exceed
def find1(nums: Array[Int]): List[Int] = {
  val l = nums.length
  var k = collection.mutable.BitSet(1 to l:_*)
  for(i<-nums) k -= i
  k.toList
}


// B. without extra space, O(n)
// mark position in place, mod or abs
def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
  val l = nums.length
  for(i<-0 until l) nums((nums(i)-1) % l) += l
  val res = collection.mutable.ArrayBuffer[Int]()
  for(i<-0 until l if nums(i) <= l) res.append(i+1)
  res.toList
}

val q = Array(4,3,2,7,8,2,3,1)
findDisappearedNumbers(q)