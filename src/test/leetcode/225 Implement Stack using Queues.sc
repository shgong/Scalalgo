class MyStack() {

  /** Initialize your data structure here. */
  val que: collection.mutable.Queue[Int] = collection.mutable.Queue[Int]()

  /** Push element x onto stack. */
  def push(x: Int) {
    que.enqueue(x)
    for(i<-1 until que.size) que.enqueue(que.dequeue())
  }

  /** Removes the element on top of the stack and returns that element. */
  def pop(): Int = {
    que.dequeue()
  }

  /** Get the top element. */
  def top(): Int = {
    que.front
  }

  /** Returns whether the stack is empty. */
  def empty(): Boolean = {
    que.isEmpty
  }

}