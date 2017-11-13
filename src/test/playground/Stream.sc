
def from(init:Stream[Int]):Stream[Int] = init #::: from(init)