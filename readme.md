# Scalalgo

## Introduction

- This a repo for algorithm practice 
- Why using Scala
    + Following the example as it is is always boring
    + Scala enable us to switch between imperative & functional style freely
    + Functional style can greatly simplify some questions
    + Scala is just great
- Drawbacks
    + for comprehension is syntactic sugar for map/flatmap instead of imperative loop
    + will cause some problem in early termination (break)
    + tail recursion require more fields in loop, make it difficult to support dynamic programming style
- Solutions
    + import scala.util.control.Break._
    + lazyness ( stream, view, iterator )
    + mutable global variables
    + function return 

Current folder structure reflect the book _Programming Contest Challenge_, written & translated by top ACM players, including iwi, wata, kita_masa, watashi/rejudge and navi/navimoe. It is subject to change though.

## scala style algorithms

#### Largest triangle perimeter
```scala
array.sorted.reverse.toList.view
     .sliding(3)
     .filter(x=>x(0)<x(1)+x(2))
     .map(_.sum)
     .headOption
```

#### BribeThePrisoners
```scala
    val A = 0 +: a :+ (P + 1)
    val dp = Array.fill(Q + 1)(Array.fill(Q + 2)(0))

    // from smallest sections, build dp up
    for (w <- 2 to Q + 1; i <- 0 to Q + 1 - w; j = i + w)
      dp(i)(j) = (i + 1 until j).map(k => dp(i)(k) + dp(k)(j)).min + A(j) + 2 - A(i)

    dp(0)(Q + 1)
```

#### Best Cow Line
```scala
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

```

