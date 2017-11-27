// Asteroid Collision

def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
  val a = collection.mutable.ArrayBuffer(asteroids:_*)
  var lastlen = a.length
  var tag = true

  while(tag){
    var i = 0
    while(i < a.length - 1){
      if(a(i)>0 && a(i+1)<0){
        val l = Math.abs(a(i))
        val r = Math.abs(a(i+1))
        if(l == r) {
          a.remove(i)
          a.remove(i)
        } else if (l<r) a.remove(i)
        else a.remove(i+1)
      } else i+=1
    }
    if(lastlen == a.length) tag = false
    lastlen = a.length
  }
  a.toArray
}



asteroidCollision(Array(5,10,-5))
asteroidCollision(Array(8,-8))