// Open the Lock

def openLock(deadends: Array[String], target: String): Int = {
  if (deadends.contains("0000")) return -1
  val ends = collection.mutable.HashSet(deadends: _*)
  val visited = collection.mutable.HashSet("0000")
  var level = List("0000")
  var step = 0

  // find shortest path, bfs
  while (level.nonEmpty) {
    step += 1
    level = for {
      cur <- level
      i <- 0 until 4
      up = if (cur(i) == '9') '0' else (cur(i) + 1).toChar
      down = if (cur(i) == '0') '9' else (cur(i) - 1).toChar
      rep <- List(up, down)
      next = cur.take(i) ++ String.valueOf(rep) ++ cur.drop(i + 1)
      if !ends.contains(next) && !visited.contains(next)
    } yield {
      if (next == target) return step
      visited += next
      next
    }
  }
  -1
}

openLock(Array("0201", "0101", "0102", "1212", "2002"), "0202")

/*
            newLevel = []
            for curr in level:
                for i in range(4):
                    for j in [(int(curr[i]) - 1) % 10, (int(curr[i]) + 1) % 10]:
                        candidate = curr[:i] + str(j) + curr[i + 1:]
                        if candidate not in visited and candidate not in deadends:
                            newLevel.append(candidate)
                            visited.add(candidate)
                        if candidate == target:
                            return nLevel
            level = newLevel
 */
