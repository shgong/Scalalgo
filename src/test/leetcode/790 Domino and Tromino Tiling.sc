/*

Domino and Tromino Tiling

XX  <- domino

XX  <- "L" tromino
X
 */

def numTilings(N: Int): Int = {
  val MOD = 1000000007
  var dp = Array.fill(4)(0L)
  dp(0) = 1

  for (n <- 0 until N)
    dp =
      Array(
        (dp(0) + dp(1) + dp(2) + dp(3)) % MOD, // all
        (dp(3) + dp(2)) % MOD,
        (dp(3) + dp(1)) % MOD,
        dp(0) % MOD
      )

  dp(0).toInt
}

for(x<-1 until 10)
println(numTilings(x))

/*
	        int mod = 1000000007;
	        long[] dp = new long[4];
	        dp[0] = 1;
	        for(int i = 0;i < n;i++){
	        	long[] ndp = new long[4];
	        	// ||
	        	ndp[3] += dp[0];
	        	// |
	        	ndp[1] += dp[2];
	        	ndp[2] += dp[1];
	        	// none
	        	ndp[0] += dp[3];
	        	// -
	        	ndp[0] += dp[0];

	        	ndp[1] += dp[0];
	        	ndp[2] += dp[0];
	        	ndp[3] += dp[1];
	        	ndp[3] += dp[2];

	        	for(int j = 0;j < 4;j++){
	        		dp[j] = ndp[j] % mod;
	        	}
	        }
	        return (int)dp[0];
 */