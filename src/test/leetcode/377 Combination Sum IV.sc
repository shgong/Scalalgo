import scala.collection.mutable

/*
 find the number of possible combinations that add up to a positive integer target.

 Note that different sequences are counted as different combinations.
 */

// Stack
def combinationSum4s(nums: Array[Int], target: Int): Int = {
  val memo = collection.mutable.HashMap[Int,Int]()

  def find(target:Int): Int = {
    if(target<0) 0
    else if(memo.contains(target)) memo(target)
    else {
      memo(target) = nums.map{i=> if(target==i) 1 else find(target-i)}.sum
      memo(target)
    }
  }

  find(target)
}


// dp
def combinationSum4(nums: Array[Int], target: Int): Int = {
  val res = Array.fill(target+1)(0)

  for(i<-1 to target; num<-nums if num<=i) {
    if(num==i) res(i) += 1
    else res(i) += res(i-num)
  }

  res(target)
}


combinationSum4(Array(1,2,3),32)
combinationSum4(Array(1,2,3,4,5,6),7)