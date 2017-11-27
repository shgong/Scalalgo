def computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int = {
  val s1 = (C-A) * (D-B)
  val s2 = (G-E) * (H-F)

  val a = Math.max(A,E)
  val b = Math.min(C,G)
  val c = Math.max(B,F)
  val d = Math.min(D,H)

  val sinter =  if(a<b && c<d) (b-a)*(d-c) else 0
  s1 + s2 - sinter
}

computeArea(-3,0,3,4,0,-1,9,2)