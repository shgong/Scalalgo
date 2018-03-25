/*
In a given integer array A, we must move every element of A to either list B or list C. (B and C initially start empty.)

Return true if and only if after such a move,
it is possible that the average value of B is equal to the average value of C
B and C are both non-empty.
 */

def splitArraySameAverage(A: Array[Int]): Boolean = {

  val l = A.length
  val total = A.sum
  val arr = A.sorted


  def search(pos:Int, sum:Int, count:Int): Boolean = {
    if(count != 0 && count * total == sum * l && count != l) return true
    if(count > l/2) return false
    if(pos >= l) return false

    search(pos+1, sum+arr(pos), count + 1) || search(pos+1, sum, count)
  }

  search(0, 0, 0)
}

splitArraySameAverage(Array(1,2,3,4,5,6,7,8))
splitArraySameAverage(Array(1,3))
splitArraySameAverage(Array(10,29,13,53,33,48,76,70,5,5))
/*
while(i<=j)
{
if(average==ave)
{for(int s=0;s<=i;s++)
printf("%d",a[s]);
for(int s=n-1;s>=j;s++)
printf("%d",a[s]);
}
if(average<ave)
{
sum+=a[++i];
}
else
sum+=a[++j];

average=sum/(++count);

 */


def splitArraySameAverage2(A: Array[Int]): Boolean = {

  val l = A.length
  val sum = A.sum
  val arr = A.sorted

  var i = 0
  var j = l-1
  var s = arr(i) + arr(j)
  var count = 2

  while(i+1<j){
    val diff = s*l - count*sum
    if(diff==0) return true
    else if (diff>0){
      i += 1
      s += arr(i)
      count += 1
    } else {
      j -= 1
      s += arr(j)
      count += 1
    }
  }

  false
}