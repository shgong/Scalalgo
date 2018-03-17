



def champagneTower(poured: Int, query_row: Int, query_glass: Int): Double = {
  val tower = Array.fill(101)(Array.fill(100)(0.0))
  tower(0)(0) = poured.toDouble

  for(i<-0 to 99; j<-0 to i){
    if(tower(i)(j)>1.0) {
      val liquid = (tower(i)(j) - 1.0) * 0.5
      tower(i)(j) = 1.0
      tower(i+1)(j) += liquid
      tower(i+1)(j+1) += liquid
    }
  }

  tower(query_row)(query_glass)
}

champagneTower(1,1,1)
champagneTower(2,1,1)
champagneTower(2,0,0)