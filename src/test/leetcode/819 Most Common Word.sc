/*
819. Most Common Word

Given a paragraph and a list of banned words,
return the most frequent word that is not in the list of banned words.

It is guaranteed there is at least one word that isn't banned,
and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.
Words in the paragraph are not case sensitive.
The answer is in lowercase.
 */

def mostCommonWord(paragraph: String, banned: Array[String]): String = {
  val words = paragraph.toLowerCase().split(" ", -1).map(_.filter(_.isLetter))
  val res = words.groupBy(identity).filter{x => !banned.contains(x._1)}
    res.maxBy(_._2.length)._1
}


mostCommonWord(
  "Bob hit a ball, the hit BALL flew far after it was hit."
  , Array("hit")
)
