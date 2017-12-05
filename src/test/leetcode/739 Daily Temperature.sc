/*

Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 */

// Typical stack, pop when larger, always keep decreasing

def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
  val s = collection.mutable.Stack[Int]()
  val ret = Array.fill(temperatures.length)(0)
  temperatures.indices.foreach { i =>
    while(s.nonEmpty && temperatures(i)>temperatures(s.top)) {
      val idx = s.pop()
      ret(idx) = i - idx
    }
    s.push(i)
  }
  ret
}

// STACK!

dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73)).deep