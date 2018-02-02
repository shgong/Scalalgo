// find how many friend circles

def findCircleNum(M: Array[Array[Int]]): Int = {

  val l = M.length
  val ufs = Array.fill(l)(0)
  for(i<-0 until l) ufs(i) = i

  def find(a:Int): Int = {
    var x = a
    while(ufs(x)!=x){
      ufs(x) = ufs(ufs(x))
      x = ufs(x)
    }
    x
  }

  def union(a:Int, b:Int) = {
    val aa = find(a)
    val bb = find(b)
    ufs(aa) = bb
  }

  for(i<-0 until l; j<-i+1 until l if M(i)(j)==1)
    union(i,j)

  (0 until l).count(i=> ufs(i)==i)
}

findCircleNum(
  Array(
    Array(1,1,0),
    Array(1,1,0),
    Array(0,0,1)
  )
)