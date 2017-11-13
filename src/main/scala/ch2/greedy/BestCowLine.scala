package ch2.greedy

import scala.annotation.tailrec

// given string S, create string T by repeating:
//    1. remove char from S head, add to T tail
//    2. remove char from S tail, add to T tail
// find T with smallest alphabetic order

object BestCowLine {

  // greed: choose smaller, if same, check further position
  @tailrec
  def solve(pre: String, s: String): String = {
    val l = s.length - 1
    if (l <= 0) pre + s
    else {
      @tailrec
      def find(i: Int): Either[Int, Int] = {
        if (i >= l - i) Left(i)
        else if (s(i) > s(l - i)) Right(i)
        else if (s(i) < s(l - i)) Left(i)
        else find(i + 1)
      }

      find(0) match {
        case Left(i) => solve(pre + s.take(i + 1), s.drop(i + 1))
        case Right(i) => solve(pre + s.reverse.take(i + 1), s.dropRight(i + 1))
      }
    }
  }


  def main(args:Array[String]): Unit = {
    print(solve("adlkvnaslknbljfhlkdsnflksdafnhslajdfkldsn vsdjfhljasdfjlkadnf", "lnvsdladkhfoifhlafoovndalskjfhlsdfjlksnvlshfljsdjajnfklasndflksdnfljasjn"))
    print(solve("", "123412057029750897509178092W"))
  }
  
}
