package timer

/**
  * Created by bgong001c on 2/21/2017.
  */
object Timer {

  def timek(code: => Unit) = {
    val start = System.currentTimeMillis()
    (1 to 1000) foreach (_ => code)
    val end = System.currentTimeMillis()
    println(end-start+"ms")
  }

  def time[X](code1: => X)(code2:X=>Unit) = {
    val x = code1
    val start = System.currentTimeMillis()
    (1 to 10000) foreach (_ => code2(x))
    val end = System.currentTimeMillis()
    println(end-start+"ms")
  }
}
