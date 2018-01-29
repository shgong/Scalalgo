// whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.


def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
  nums.zipWithIndex.groupBy(_._1).toList.map(_._2.map(_._2)).
    exists{ ids =>
      ids.sliding(2).filter(_.length==2).map{case Array(a,b)=>b-a}.exists(_<=k)
    }
}

containsNearbyDuplicate(Array(1,0,2,3,1), 3)
containsNearbyDuplicate(Array(1,0,2,3,1), 4)