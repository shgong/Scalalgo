
val nums = Array(10, 3, 8, 9, 4)


def findRelativeRanks(nums: Array[Int]): Array[String] = {

  nums.zipWithIndex.sortBy(x => -x._1) // num,id sorted order
    .map(_._2).zipWithIndex // id, rank
    .sortBy(_._1) // id, rank  original order
    .map(_._2 + 1) // rank
    .map {
    case 1 => "Gold Medal"
    case 2 => "Silver Medal"
    case 3 => "Bronze Medal"
    case x => x.toString
  }
}


// replace second sort with put with id