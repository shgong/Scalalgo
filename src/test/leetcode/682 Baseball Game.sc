def calPoints(ops: Array[String]): Int = {

  val score = collection.mutable.ArrayBuffer[Int]()
  ops.foreach {
    case "C" => score.remove(0)
    case "D" => score.insert(0, 2*score(0))
    case "+" => score.insert(0, score(0) + score(1))
    case x => score.insert(0, x.toInt)
  }
  score.sum
}

val input = Array("5","-2","4","C","D","9","+","+")
calPoints(input)