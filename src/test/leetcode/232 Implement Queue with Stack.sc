class MyQueue() {

  /** Initialize your data structure here. */
  val in:collection.mutable.Stack[Int] = collection.mutable.Stack[Int]()
  val out:collection.mutable.Stack[Int] = collection.mutable.Stack[Int]()
  /** Push element x to the back of queue. */
  def push(x: Int) {
    in.push(x)
  }

  /** Removes the element from in front of queue and returns that element. */
  def pop(): Int = {
    if(out.isEmpty){
      while(in.nonEmpty) {
        out.push(in.pop())
      }
    }
    out.pop()
  }

  /** Get the front element. */
  def peek(): Int = {
    if(out.isEmpty){
      while(in.nonEmpty) {
        out.push(in.pop())
      }
    }
    out.top

  }

  /** Returns whether the queue is empty. */
  def empty(): Boolean = {
    out.isEmpty && in.isEmpty
  }

}