// Escape the ghost

def escapeGhosts(ghosts: Array[Array[Int]], target: Array[Int]): Boolean = {
  val xs = ghosts.map(_(0)) :+ 0 :+ target(0)
  val ys = ghosts.map(_(1)) :+ 0 :+ target(1)

  val minx = xs.min
  val maxx = xs.max
  val miny = ys.min
  val maxy = ys.max

  val nstart = (-minx, -miny)
  val nghosts = ghosts.map(a=> (a(0)-minx, a(1)-miny))
  val ntarget = (target(0)-minx, target(1)-miny)

  val w = maxx - minx
  val h = maxy - miny

  val m = Array.fill(w+1)(Array.fill(h+1)(-1))

  var bfs: Array[(Int,Int)] = nghosts
  for((x,y)<-bfs) m(x)(y) = 0

  //println(bfs.toList)

  while(bfs.nonEmpty){
    bfs =
      for {
        (x, y) <- bfs
        (u, v) <- List((x+1,y),(x-1,y),(x,y+1),(x,y-1))
        if u>=0 && u<=w && v>=0 && v<=h && m(u)(v)== -1
      } yield {
        m(u)(v) = m(x)(y) + 1
        (u,v)
      }
  }

  //println(m.toList.map(_.toList))

  // search start to target
  var step = 0
  var bfs2 = Set(nstart)
  if( m(nstart._1)(nstart._2) == step) return false

  while(bfs2.nonEmpty){
    bfs2 =
      bfs2.flatMap { case (x,y) =>
          if(x==ntarget._1 && y==ntarget._2 && m(x)(y)>step) return true
          var res1 =
            if(x<ntarget._1 && m(x+1)(y)>step+1) Set((x+1,y))
            else if (x>ntarget._1 && m(x-1)(y)>step+1) Set((x-1,y))
            else Set()

        var res2 =
          if(y<ntarget._2 &&
            m(x)(y+1)>step+1) Set((x,y+1))
          else if (y>ntarget._2 && m(x)(y-1)>step+1) Set((x,y-1))
          else Set()

        res1++res2
      }.toSet

    step += 1

  }
  return false
}

escapeGhosts(Array(Array(1,0),Array(0,3)), Array(0,1))
escapeGhosts(Array(Array(1,0)), Array(2,0))