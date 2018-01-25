def validIPAddress(IP: String): String = {
  val v4 = IP.split("\\.", -1)
  val v6 = IP.split(":", -1)

  val v6dict = ('0' to '9') ++ ('a' to 'f') ++ ('A' to 'F')
  val v4dict = ('0' to '9')

  if (v4.length == 4 && v4.forall(x =>
    x == "0" ||
      (!x.startsWith("0") &&
        x.forall(v4dict.contains) &&
        util.Try(x.toInt).isSuccess &&
        x.toInt <= 255 &&
        x.toInt >= 0)
  )) "IPv4"
  else if (v6.length == 8 && v6.forall(x =>
    x.length <= 4 &&
      x.length > 0 &&
      x.forall(v6dict.contains)
  )) "IPv6"
  else "Neither"
}


validIPAddress("172.16.254.1")
validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")
validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:")
validIPAddress("256.256.256.256")