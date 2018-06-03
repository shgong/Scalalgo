/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 */

def backspaceCompare(S: String, T: String): Boolean = {

  val s1 = collection.mutable.Stack[Char]()
  val t1 = collection.mutable.Stack[Char]()
  for(c<-S)  if(c=='#') {if( s1.nonEmpty) s1.pop()} else s1.push(c)
  for(c<-T)  if(c=='#') {if( t1.nonEmpty) t1.pop()} else t1.push(c)
  s1.mkString == t1.mkString
}

backspaceCompare("a##c","#a#c")
backspaceCompare("ab#c","ad#c")
backspaceCompare("y#fo##f", "y#f#o##f")