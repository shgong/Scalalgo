// 818. Race Car
/*
Your car starts at position 0 and speed +1 on an infinite number line.
(Your car can go into negative positions.)

Your car drives automatically according to a sequence of instructions
A (accelerate) and R (reverse).

- "A": position += speed, speed *= 2.
- "R", if your speed is positive then speed = -1 , otherwise speed = 1.  (Your position stays the same.)

after commands "AAR", your car goes to positions 0->1->3->3,
and your speed goes to 1->2->4->-1.

Now for some target position,
say the length of the shortest sequence of instructions to get there.
 */

def racecar(target: Int): Int = {

  var cur = collection.mutable.Set((0, 1))
  val all = collection.mutable.Set((0, 1))

  var step = 0

  // bfs with memo (x,v state)
  while (cur.nonEmpty) {
    step += 1

    val next = collection.mutable.Set((0, 1))
    def addState(x:(Int,Int)): Unit = {
      if (!all.contains(x)) {
        all.add(x)
        next.add(x)
      }
    }

    for ((x, v) <- cur) {
      if (x + v == target) return step
      // don't try acc when too large
      if (math.abs(x+v) <= target * 3) addState((x+v,v*2))
      addState((x, if(v>0) -1 else 1))
    }

    cur = next
  }

  -1
}

racecar(3)
racecar(4)
racecar(6)
racecar(5363)