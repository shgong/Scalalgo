package ch4.tech

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

// find sliding minimum of array a, width k

object SlidingMin {

  // RMQ, nlogn
  // with k constraint, can use dequeue in O(n)

  // queue is kind of sorted, q_i < q_i+1 < q_i+2
  // if new insert smaller than prev, remove prev

  def solve(a:Array[Int], k: Int): List[Int] = {
    val n = a.length
    val result = ArrayBuffer[Int]()
    var que = Vector[Int]()

    a.indices.foreach { i =>
      while(que.nonEmpty && a(que.last) >= a(i)) que = que.dropRight(1)
      que = que :+ i

      if(i+1>=k) {
        result.append(a(que.head))
        if(que.head == i-k+1) que = que.drop(1)  // if out of sliding window
      }
    }

    result.toList
  }

  def main(args:Array[String]) = {
    val res = solve(Array(1,3,5,4,2), 3)
    println(res)
  }

}
