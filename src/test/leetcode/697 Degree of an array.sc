// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
// find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums

def findShortestSubArray(nums: Array[Int]): Int = {
  case class Num(var min:Int, var max:Int, var count:Int)
  val m = collection.mutable.HashMap[Int, Num]()

  for(i<-nums.indices){
    val v = nums(i)
    if(m contains v){
      m(v).max = i
      m(v).count += 1
    }
    else m(v) = Num(i,i,1)
  }

  val items = m.values.groupBy(_.count).maxBy(_._1)._2 // items with max count
  items.map(n=> n.max-n.min+1).min
}

findShortestSubArray(Array(1,2,2,3,1))