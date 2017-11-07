package ch4.tech

import scala.collection.mutable

/* Largest rectangle in a histogram */

object Histogram {

  // the property of largest rectangle i,j
  // h(i-1) < H, h(j+1) < H
  // consider using h(i) as min height
  // L(i) is left border, first j to have h(j-1)<H(i)
  // R(i) is right border, first j to have h(j+1)<H(i)


  def solve(h: Array[Int]):Int = {
    val l = h.length

    val stack = mutable.Stack[Int]()

    val L = Array.fill(l)(0)
    val R = Array.fill(l)(l)

    for(i <- h.indices){
      while(stack.nonEmpty && h(stack.top) >= h(i)) stack.pop()
      if (stack.nonEmpty) L(i) =   stack.top+1
      stack.push(i)
    }

    stack.clear()

    for(i <- h.indices.reverse){
      while(stack.nonEmpty && h(stack.top) >= h(i)) stack.pop()
      if(stack.nonEmpty) R(i) =  stack.top
      stack.push(i)
    }

    println(L.toList)
    println(R.toList)
    h.indices.map(i=> h(i)*(R(i)-L(i)+1)).max

  }


  def main(args:Array[String])= {
    println(solve(Array(2,1,4,5,1,3,3)))
  }

}
