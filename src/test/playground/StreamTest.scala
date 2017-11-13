object StreamTest {



  def main(args:Array[String])= {

    def from(init: => Stream[Int]):Stream[Int] = {
      lazy val x = init #::: from(init)
      x
    }
    lazy val stream = from(Stream(1,2,3))
    println(stream(1607))
  }

}
