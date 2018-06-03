/*

You may call master.guess(word) to guess a word.

Representing the number of exact matches (value and position) of your guess to the secret word.
If your guess is not in the given wordlist, it will return -1 instead.

For each test case,
you have 10 guesses to guess the word.

At the end of any number of calls,
if you have made 10 or less calls to master.guess and
at least one of these guesses was the secret, you pass the testcase.

Besides the example test case below,
there will be 5 additional test cases,
each with 100 words in the word list.

The letters of each word in those testcases were chosen independently at random from 'a' to 'z',
such that every word in the given word lists is unique.


审错题了
should not guess something not in the given wordlist
 */

class Master(s: String) {
  def guess(word: String): Int = {
    var count = 0
    for (i <- 0 to 5 if word(i) == s(i)) count += 1
    count
  }
}

def findSecretWord(wordlist: Array[String], master: Master): Unit = {
  var currentList = wordlist
  for (times <- 0 to 9) {
    // calculate frequency of each char among candidates
    val dict = (0 until 6).map(idx => currentList.map(_ (idx)).groupBy(identity).mapValues(_.length))

    // choose the candidate with highest char frequency
    val scores = currentList.map(word => (word, (0 until 6).map(id => dict(id)(word(id))).sum))
    val guess = scores.maxBy(_._2)._1

    val r = master.guess(guess.mkString)
    if (r == 6) return

    // filter down the candidate list
    currentList = currentList.filter(_.zip(guess).count(z => z._1 == z._2) == r)
  }
}

findSecretWord(
  Array("acckzz", "ccbazz", "eiowzz", "abcczz"),
  new Master("acckzz")
)

