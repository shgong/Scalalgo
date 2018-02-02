// Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
def countSegments(s: String): Int = {
  s.split(" ",-1).count(_!="")
}