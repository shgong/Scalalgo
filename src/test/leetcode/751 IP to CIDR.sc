// IP to CIDR
def ipToCIDR(ip: String, range: Int): List[String] = {
  var x  = 0L
  ip.split('.').map(_.toInt).foreach { i => x = (x << 8) | i}
  val list = collection.mutable.ArrayBuffer[String]()
  var target = range

  while(target>0){
    // match trailing zero like BIT algorithm
    var len = if(x==0) 1 else x & -x

    // propogate when target allows
    while(len > target) len /= 2

    // trailing zeroes
    var zeroes = 0
    var lenz = len
    while((lenz&1)==0){lenz>>=1; zeroes+=1}

    // add to ip list
    list.append(ipstr(x) + "/" + (32-zeroes))
    target -= len.toInt
    x += len
  }

  list.toList
}


def ipstr(x:Long): String = {
  var ip = x
  (0 until 4).map { i =>
    val digit = ip & 255
    ip >>= 8
    digit
  }.reverse.mkString(".")
}


ipToCIDR("255.0.0.7",10)

