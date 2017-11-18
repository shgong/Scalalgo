def lengthLongestPath(input: String): Int = {
  // preprocessing
  val lines: Array[(Int, String)] = input.split('\n').map { s =>
    var line = s
    var level = 0
    while (line.startsWith("\t")) {
      line = line.drop(1)
      level += 1
    }
    (level, line)
  }

  val stack = collection.mutable.ArrayBuffer[(Int, String)]()
  var len = 0
  var word = ""

  // typical stack problem
  for ((l, s) <- lines) {
    while (stack.nonEmpty && stack(0)._1 >= l) stack.remove(0)
    stack.insert(0, (l, s))

    // only analyze file
    if (s.contains('.')) {
      var total = stack.map(_._2).reverse.mkString("\\")
      if (total.length > len) {
        len = total.length
        word = total
      }
    }
  }
  println(word)
  len
}

val s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
lengthLongestPath(s)

