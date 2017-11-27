// find nth ugly number

def nthUglyNumber(n: Int): Int = {
  if(n==1) return 1
  val a = new Array[Int](n+1)
  var (t2,t3,t5) = (0,0,0) // multiply pointer
  a(0) = 1

  for(i <- 1 until n){
    a(i) = List(a(t2)*2,a(t3)*3,a(t5)*5).min
    if(a(i)== a(t2)*2) t2+=1
    if(a(i)== a(t3)*3) t3+=1
    if(a(i)== a(t5)*5) t5+=1
  }
  a(n-1)
}

nthUglyNumber(10)