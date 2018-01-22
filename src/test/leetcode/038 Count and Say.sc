def countAndSay(n: Int): String = {
  var str = "1"

  for (i <- 1 until n) {

    var last = str(0)
    var lastCount = 1
    var res = ""
    for (c <- str.drop(1)) {
      if (c == last) lastCount += 1
      else {
        res += s"$lastCount$last"
        last = c
        lastCount = 1
      }
    }
    res += s"$lastCount$last"
    str = res
  }
  str
}

for(i<-1 until 10) println(countAndSay(i))
/*
1
11
21
1211
111221
312211
13112221
1113213211
 */