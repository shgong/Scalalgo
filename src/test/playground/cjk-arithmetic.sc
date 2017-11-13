

val 一 = 1
val 二 = 2
val 三 = 3
val 四 = 4
val 五 = 5
val 六 = 6
val 七 = 7
val 八 = 8
val 九 = 9

implicit class 四则运算(a:Int){
  def 减(b:Int) = a-b
  def 十(b:Int) = 10*a + b
  def 加(b:Int) = a+b
  def 乘(b:Int) = a*b
  def 除(b:Int) = a/b
}

( 三 十 二 加 五 ) 乘 七


