

val qs: List[Int] => List[Int] = {
  case x@(_ :: Nil | Nil) => x
  case x => val p = x(x.length / 2)
    qs(x.filter(p >)) ::: x.filter(p ==) ::: qs(x.filter(p <))
}

qs(List(1,4,6,1,7,3,7,21,3))