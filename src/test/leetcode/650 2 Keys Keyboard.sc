/*
Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.

Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
*/

def minSteps(n: Int): Int = {
  var remain = n
  var factors:List[Int] = Nil

  while(remain%2==0){
    factors ::= 2
    remain /= 2
  }

  var prime = 3
  while(prime <= remain){
    while(remain%prime == 0){
      factors ::= prime
      remain /= prime
    }
    prime += 2
  }

  factors.sum
}

minSteps(3)