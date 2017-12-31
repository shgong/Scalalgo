

// bfs, tle when -1000000
def reachNumber(target: Int): Int = {

  var set = Set(0)
  var cur = 1

  while (true) {
    set = set.flatMap {  x =>
      if (x + cur == target || x - cur == target) return cur
      Set(x + cur, x - cur)
    }
    cur += 1
  }
   -1
}

for(i<-1 to 10)  println(reachNumber(i))

// greedy


//4  1+2+3  (1)  target 4  sum 6 cur 4
//9  1+2+3  (3)  target 9  sum 10 cur 5
//8  1+2+3  (2)  target 8  sum 10 cur 5

def reach2(target:Int): Int = {
  val t = if(target<0) -target else target
  var sum = 0
  var cur = 1
  while(sum<t){
    sum += cur
    cur += 1
  }

  cur-=1
  if(t==sum) return cur
  sum -= cur

  //println(s"$t $sum $cur")
  // consider difference and next cur
  if((t-sum) % 2 == 0 && cur % 2 ==0) cur
  else if((t-sum) % 2 != 0 && cur % 2 !=0) cur
  else if((t-sum) % 2 != 0 && cur % 2 ==0) cur+1
  else cur+2
}

for(i<-1 to 10)  println(reach2(i))