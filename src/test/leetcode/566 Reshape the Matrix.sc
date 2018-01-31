def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
  val h = nums.length
  if(h==0) return nums
  val w = nums(0).length
  if(h*w != r*c) return nums

  val res = Array.fill(r)(Array.fill(c)(0))
  for(i<-0 until r;j<-0 until c){
    val x = i * c + j
    res(i)(j) = nums(x/w)(x%w)
  }

  res
}

val t = matrixReshape(Array(Array(1,2),Array(3,4)), 1, 4)
t.toList.map(_.toList)