/*
824. Goat Latin
A sentence S is given, composed of words separated by spaces.
Each word consists of lowercase and uppercase letters only.

"Goat Latin" (a made-up language similar to Pig Latin.)


If a word begins with a vowel (a, e, i, o, or u),
append "ma" to the end of the word.

For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel),
remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word
per its word index in the sentence, starting with 1.

For example, the first word gets "a" added to the end,
the second word gets "aa" added to the end and so on.

Return the final sentence representing the conversion from S to Goat Latin.
 */

def toGoatLatin(S: String): String = {
  val words = S.split(" ", -1)
  val l = words.length

  (0 until l).map{ i =>
    val w = words(i)
    if("aeiou".contains(w(0))) w + "ma" + "a"*(i+1)
    else w.drop(1) + w(0) + "ma" + "a"*(i+1)
  }.mkString(" ")
}

toGoatLatin("I speak Goat Latin")

toGoatLatin("The quick brown fox jumped over the lazy dog")
// Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"