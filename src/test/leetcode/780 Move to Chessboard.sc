
// 780. Reaching Points
/*
A move consists of taking a point (x, y) and transforming it to
either (x, x+y) or (x+y, y).

Given a starting point (sx, sy) and a target point (tx, ty),
return
if a sequence of moves exists
transform the point (sx, sy) to (tx, ty).


5 10
5 15
5 20
25 20
 */

def reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean = {
  var x = tx
  var y = ty
  if (sx <= 0 || sy <= 0) return false
  while (x >= sx && y >= sy) {
    if (x == sx && y == sy) return true
    if (x == y) return false

    if (x > y) x = x - y
    else y = y - x
  }
  return false
}

reachingPoints(1,1,3,5)
reachingPoints(1,1,2,2)
reachingPoints(1,1,31,1)
reachingPoints(1,1,1,1)