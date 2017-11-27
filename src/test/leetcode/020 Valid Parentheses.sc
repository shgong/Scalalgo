def isValid(s: String): Boolean = {
  val matches = List(
    ('(',')'),
    ('[',']'),
    ('{','}')
  )
  val (lefts, rights) = matches.unzip
  val st = collection.mutable.Stack[Char]()

  for(i<-s){
    if(lefts.contains(i)) st.push(i)
    else if(rights.contains(i)){
      if(st.isEmpty) return false
      val last = st.pop()
      if(!matches.contains((last, i))) return false
    }
  }
  st.isEmpty
}

isValid("()()()()")

isValid("()()()()")

isValid("([)]")