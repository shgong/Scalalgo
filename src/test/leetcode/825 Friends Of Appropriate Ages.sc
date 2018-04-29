/*
825. Friends Of Appropriate Ages

Some people will make friend requests.
ages[i] is the age of the ith person.

Person A will NOT friend request person B (B != A)
if any of the following conditions are true:

  age[B] <= 0.5 * age[A] + 7
  age[B] > age[A]
  age[B] > 100 && age[A] < 100

Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.
Also, people will not friend request themselves.

How many total friend requests are made?

1 <= ages.length <= 20000.
1 <= ages[i] <= 120

req 0.5*a+7 < b <= a
 */

def numFriendRequests(ages: Array[Int]): Int = {
  val length = ages.length
  val age = ages.sorted


  // last index for each age
  val m = Array.fill(121)(-1)

  // traverse
  for(i<-0 until length) m(age(i)) = i

  // fill the gaps
  var max = -1
  for(i<-1 until m.length){
    m(i) = if (m(i)== -1) max else m(i)
    max = m(i)
  }

  var res = 0
  //                      there is people at this age
  for(i<-1 until m.length if m(i)>m(i-1)){
    val left = Math.floor(0.5*i + 7).toInt
    // add by people at this age * (possible ages - self )
    if(left<i) res += (m(i) - m(i-1)) * (m(i) - m(left) - 1)
  }
  res
}


numFriendRequests(Array(16,16))
numFriendRequests(Array(16,17,18))
numFriendRequests(Array(20,30,100,110,120))
numFriendRequests(Array(108,115,5,24,82))
numFriendRequests(Array(118,14,7,63,103))
