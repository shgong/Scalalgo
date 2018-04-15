/*
816. Ambiguous Coordinates
We had some 2-dimensional coordinates,
like "(1, 3)" or "(2, 0.5)".

Then, we removed all commas,
decimal points,
and spaces,
and ended up with the string S.

Return a list of strings representing all possibilities
for what our original coordinates could have been.

Our original representation never had extraneous zeroes,
so we never started with numbers like
"00", "0.0", "0.00",
"1.0", "001", "00.01",
or any other number that can be represented with less digits.

Also, a decimal point within a number never occurs
without at least one digit occuring before it,
so we never started with numbers like ".1".

The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)
 */

def findDigits(num:String):List[String] = {
  val k = num.length
  var list = List[String]()

  for(i<-1 to k){
    val left = num.take(i)
    val right = num.drop(i)

    if((left.length == 1 || left(0)!='0') &&
      (right.length == 0 || right.last != '0')){
     if(right.isEmpty) list ::= left
     else list ::= left + "." + right
    }
  }

  list
}


def ambiguousCoordinates(S: String): List[String] = {
  var res = List[String]()

  val s = S.drop(1).dropRight(1)
  val l = s.length // 4  "0123"

  (for {
    comma <- 1 until l
    lefts = findDigits(s.take(comma))
    rights = findDigits(s.drop(comma))
    l <- lefts
    r <- rights
  } yield s"($l, $r)").toList

}

ambiguousCoordinates("(0123)")
ambiguousCoordinates("(100)")
ambiguousCoordinates("(123)")
ambiguousCoordinates("(00011)")