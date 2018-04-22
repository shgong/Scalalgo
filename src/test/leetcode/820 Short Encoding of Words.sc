/*
820. Short Encoding of Words

Given a list of words,
we may encode it by
reference string S and a list of indexes A.

["time", "me", "bell"],
S = "time#bell#" and indexes = [0, 2, 5].

What is the length of the shortest reference string S possible that encodes the given words?
 */

def minimumLengthEncoding(words: Array[String]): Int = {
  case class Trie(m:collection.mutable.HashMap[Char, Trie] = collection.mutable.HashMap())

  val root = Trie()

  def add(w:String, node:Trie):Unit = {
    if(w.isEmpty) return
    if(!node.m.contains(w.last)){
      node.m(w.last) = Trie()
    }
    add(w.init, node.m(w.last))
  }

  for(word <- words) add(word, root)

  println(root)

  var len = 0
  def traverse(node:Trie, depth:Int): Unit = {
    if(node.m.isEmpty){
      len += depth + 1
    } else for((c,t)<- node.m){
      println(c)
      traverse(t, depth+1)
    }
  }

  traverse(root, 0)

  len
}
minimumLengthEncoding(Array("time","me","bell"))