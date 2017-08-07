package ch3.tech

/*
n balls with radius R in a container with height H
release a ball after each second
find their position(above earth) after T seconds
N=1 H=10 R=10 T=100
 */

object PhysicsCollision {

  val g = 9.8

  def solve(T: Int, N: Int, H: Int, R: Int): Unit = {

    // position of ball when T
    def calc(T: Int): Double = {
      if (T < 0) H
      else {
        val t = math.sqrt(2 * H / g)
        val k = (T / t).toInt
        val d = if (k % 2 == 0) T - k * t
          else k * t + t - T

        H - g * d * d / 2
      }
    }

    (0 until N).toArray
      .map(i => calc(T - i))
      .sorted
      .zipWithIndex
      .map { case (y, i) => y + 2 * R * i }
  }


}

