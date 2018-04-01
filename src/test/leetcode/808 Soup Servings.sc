// 808. Soup Servings
/*
There are two types of soup: type A and type B. Initially we have N ml of each type of soup.
There are four kinds of operations:

Serve 100 ml of soup A and 0 ml of soup B
Serve 75 ml of soup A and 25 ml of soup B
Serve 50 ml of soup A and 50 ml of soup B
Serve 25 ml of soup A and 75 ml of soup B

When we serve some soup,
we give it to someone and we no longer have it.

Each turn, we will choose from the four operations
with equal probability 0.25.
If the remaining volume of soup is not enough to
complete the operation, we will serve as much as we can.

We stop once we no longer have some quantity of both types of soup.

Return the probability that soup A will be empty first,
plus half the probability that A and B become empty at the same time.
 */


// BFS, TLE
// a lot of state collision
def soupServingsBFS(N: Int): Double = {
  var init = List((0, 0, 1.0))

  var pa = 0.0
  var pb = 0.0

  while (init.nonEmpty) {
    init = init.flatMap { case (a, b, p) =>

      if (a >= N || b >= N) {
        if (a >= N && b >= N) pb += p
        else if (a >= N) pa += p

        List()
      } else List(
        (a + 100, b, 0.25 * p),
        (a + 75, b + 25, 0.25 * p),
        (a + 50, b + 50, 0.25 * p),
        (a + 25, b + 75, 0.25 * p)
      )
    }
  }
  pa + 0.5 * pb
}



// dfs is too slow
// return probability answer directly
//
// recursion with memo
// a lot of state collision
def soupServings(N: Int): Double = {

  val n = (N + 24) / 25 // 25 as a unit

  val maxN = 400
  val memo = Array.fill(maxN)(Array.fill(maxN)(0.0))
  val used = Array.fill(maxN)(Array.fill(maxN)(false))

  def solve(x: Int, y: Int): Double = {
    if (y <= 0 && x > 0) 0
    else if (x <= 0 && y > 0) 1
    else if (x <= 0 && y <= 0) 0.5
    else if (used(x)(y)) memo(x)(y)
    else {
      used(x)(y) = true
      val ans = 0.25 * (solve(x - 4, y) +
        solve(x - 3, y - 1) +
        solve(x - 2, y - 2) +
        solve(x - 1, y - 3))
      memo(x)(y) = ans
      ans
    }
  }

  if (n > maxN) return 1.0
  solve(n, n)
}

soupServings(50)
soupServings(800)
soupServings(8000)
soupServings(20000)