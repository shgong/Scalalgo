def readBinaryWatch(num: Int): List[String] = {
  (for (h <- 0 until 12; m <- 0 until 60
        if Integer.bitCount(h * 64 + m) == num)
    yield f"$h%d:$m%02d"
    ).toList
}

readBinaryWatch(1)
