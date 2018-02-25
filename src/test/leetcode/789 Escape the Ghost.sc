
def escapeGhosts(ghosts: Array[Array[Int]], target: Array[Int]): Boolean = {
 val d = math.abs(target(0)) +  math.abs(target(1))
  ghosts.forall { g =>
    math.abs(g(0)-target(0))+math.abs(g(1)-target(1))>d
  }
}
