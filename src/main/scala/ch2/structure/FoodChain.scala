package ch2.structure

// N animal belong to ABC, A eat B eat C eat A
// Now we have following information like
//      x and y belong to ufs.same type
//      x eat y

//  T = 1 (ufs.same) 2 (eat)
// though they may be wrong, find how many

object FoodChain {

  /*
  create three element for each aninmal: i-A, i-B, i-C
  create union find sets for if they happen together
   */

  def solve(N: Int, T: Array[Int], X: Array[Int], Y: Array[Int]) = {
    // create UFS, x, x+N, x+2N for x-A, x-B, x-C
    var ans = 0
    val ufs = new UnionFindSet(3*N)

    T.indices.foreach { i =>
      val t = T(i)
      val x = X(i) - 1
      val y = Y(i) - 1

      if (x >= 0 && x < N && y >= 0 && y < N) {
        // x y are ufs.same group
        if (t == 1) {
          if (ufs.same(x, y + N) || ufs.same(x, y + 2 * N)) {
            ans += 1
          }
          else {
            ufs.unite(x, y)
            ufs.unite(x + N, y + N)
            ufs.unite(x + 2 * N, y + 2 * N)
          }
        }
        // x eat y
        else {
          if (ufs.same(x, y) || ufs.same(x, y + 2 * N)) {
            ans += 1
          }
          else {
            ufs.unite(x, y + N)
            ufs.unite(x + N, y + 2 * N)
            ufs.unite(x + 2 * N, y)
          }
        }

      }
      else ans += 1

    }

    ans
  }


}

class UnionFindSet(N:Int) {
  val parent = Array.range(0,3*N)
  val rank = Array.fill(3*N)(0)

  def find(x:Int):Int = {
    if(parent(x)==x) x
    else {
      val t = find(parent(x))
      parent(x) = t
      t
    }
  }

  def unite(x: Int, y: Int): Unit = {
    val px = find(x)
    val py = find(y)
    if(px!=py){
      if(rank(px)<rank(py)) parent(px) = py
      else {
        parent(py) = px
        if(rank(px)==rank(py)) rank(px) += 1
      }
    }
  }


  def same(x: Int, y: Int): Boolean = find(x) == find(y)
}
