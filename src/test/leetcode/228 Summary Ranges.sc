def summaryRanges(nums: Array[Int]): List[String] = {
  var res: List[String] = Nil
  if(nums.length == 0) return Nil

  var start = nums.head
  var end = nums.head

  for(n <- nums.drop(1)){
    if(n == end+1) end = n
    else {
      res ::= (if(start==end) start.toString else s"$start->$end")
      start = n
      end = n
    }
  }
  res ::= (if(start==end) start.toString else s"$start->$end")

  res.reverse
}

summaryRanges(Array(0,2,3,4,6,8,9))