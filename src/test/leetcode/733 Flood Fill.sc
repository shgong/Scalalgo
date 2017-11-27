// Flood Fill

def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
  val h = image.length
  val w = image(0).length

  var oldColor = image(sr)(sc)
  var targetColor = -1

  def fill(x:Int, y:Int):Unit = {
    image(x)(y) = targetColor

    for((i,j)<-List(
      (x-1,y), (x+1,y), (x,y-1), (x,y+1))
      if i>=0 && j>=0 && i<h && j<w && image(i)(j) == oldColor
    ) fill(i,j)
  }

  fill(sr,sc)

  oldColor = -1
  targetColor = newColor

  fill(sr,sc)

  image
}
