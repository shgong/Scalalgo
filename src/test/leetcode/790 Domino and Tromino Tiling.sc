/*

Domino and Tromino Tiling

XX  <- domino
XX  <- "L" tromino
X

2 => 2
3 => 5
4 => 2*n3 + n1 = 11
5 => 2*n4 + n2 = 24

why
https://cs.stackexchange.com/questions/66658/domino-and-tromino-combined-tiling

f(n) = f(n-1) + f(n-2) + 2 * f(prev)
f(n-1) = f(n-2) + f(n-3) + 2* f(prev)
=>
f(n) = 2*f(n-1) + f(n-3)
 */

def numTilings(N: Int): Int = {
  val MOD = 1000000007
  var dp = Array(1L,1L,0L)
  for (n <- 2 to N){
    dp = Array(
      (dp(0)*2+dp(2)) % MOD,
      dp(0),
      dp(1)
    )
  }

  dp(0).toInt
}

numTilings(30)
