val s = "cbbd"
val l = s.length

var max = 0
var maxres = ""

for (i <- 0 until l) {
  var j = 0
  val limit = math.min(i, l - 1 - i)
  while (j <= limit && s(i - j) == s(i + j)) j += 1
  if (2 * j - 1 > max) {
    max = 2 * j - 1
    maxres = s.slice(i - j + 1, i + j)
  }
}

println(maxres)


for (i <- 0 until l - 1) {
  var j = 0
  val limit = math.min(i, l - 2 - i)
  while (j <= limit && s(i - j) == s(i + 1 + j)) j += 1
  if (2 * j > max) {
    max = 2 * j
    maxres = s.slice(i - j + 1, i + j + 1)
  }
}


println(maxres)
