// Pyramid Transition Matrix

// DFS with Memorization
def pyramidTransition(bottom: String, allowed: List[String]): Boolean = {

  val hm: Map[String, List[String]] = allowed.groupBy(_.take(2)).mapValues(_.map(_.drop(2)))
  val impossible = collection.mutable.Set[String]()

  // rec for each row
  def iterate(left: String, next: String): Boolean = {
    if (left.length <= 1) generate_status(next)
    else {
      val toMatch = left.take(2)

      if (hm.contains(toMatch)) hm(toMatch).foreach { i =>
        if ((next.isEmpty || hm.contains(next.takeRight(1) + i)) &&
          iterate(left.drop(1), next + i)) return true
      }
      if(next.isEmpty) impossible.add(left)
      false
    }
  }

  def generate_status(bottom: String): Boolean = {
    println(bottom)

    if (bottom.length == 1) true
    else if (impossible.contains(bottom)) false
    else iterate(bottom, "")
  }

  generate_status(bottom)
}

pyramidTransition("ABDBACAAAC",
  List("ACC", "AAC", "AAB", "BCB", "BAD", "CAC", "CCD", "CAA", "CCB", "DAD", "ACD", "DCB", "ABB", "BDA", "BDC", "BDB", "BBD", "BBC", "BBB", "ADB", "ADC", "DDC", "DDB", "CDD", "CBC", "CBA", "CBD", "CDC", "DBC"))

pyramidTransition("ABCD",
  List("BCE","BCF","ABA","CDA","AEG","FAG","GGG")
)


/*
pyramidTransition("ABDFDGFDDEBGFFEDBCECEBAFCECEBEFBCDDDFDGFDGAEEBDECGDBBECABGDDAGDDAACFGDECGGCBDBGBCFCFECFEDDCEGBEBBCFA",
  List("BGA","BGB","BGC","BGD","BGE","BGF","BGG","EGC","CCD","CCG","EGG","EGF","EGE","EGD","ADD","DCF","DCD","DCB","DCA","FGD","FGF","FGB","BFB","BFG","BFF","BFE","DDE","CDA","FAA","DBA","DBC","DBB","DBD","DBG","DBF","FFG","FFF","FFE","FFD","BDE","FFA","GBG","GBE","FDE","GBC","FDG","FDF","BEB","BEA","BEG","AEA","CCE","GCB","AEE","AED","AEG","AEF","EEE","GCE","DEB","DEC","DED","EGA","EEC","CEF","CEE","CED","CEC","GCG","GDA","GEC","GEB","GEG","GEF","GEE","GED","FBG","CCB","GDE","GCA","BDD","BDG","BDF","EGB","BDC","GCF","AFE","GDG","AFA","AFC","DGA","ECC","DDA","EFC","EFD","DDF","EFF","EFG","CBC","CBA","CBF","CBD","GBA","ACA","ACG","ACF","BCD","BCG","FDB","GBB","EFB","DGB","ECF","ECE","ECD","DGF","DGG","ECA","CGC","CGB","CGE","CGG","CGF","GGE","GGG","GGF","FCE","GGC","GGB","CCC","DDD","FEF","FED","FEB","FEC","FEA","BBG","BBD","EDB","FCG","ADB","ADC","DFE","DFG","DFF","CDD","CDE","EDA","EDG","CDB","CDC","FBC","FBB","GDB","GDD","FBF","FBE","FBD","AAD","AAG","AAA","AAB","FCC","BAF","BAG","BAE","BAB","BAC","CAB","CAA","CAF","CAD","DAD","DAF","EEF","DAA","DAB","EAA","EEA","EAC","EAB","EAE","EAD","DEF","FAC","GAD","GAC","GAB","GAA","ABD","ABE","ABF","EFE","FAG","ECG","EBD","EBA","EBC","CFD","CFE","CFB","CFC","CFA","GFB","GFC","GFG","GFD"))