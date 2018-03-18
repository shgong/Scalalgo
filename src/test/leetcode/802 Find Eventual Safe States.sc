//Find Eventual Safe States

def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {

  val l = graph.length

  // lastest safe nodes
  var terminal = List[Int]()
  for(i<-0 until l){
    if(graph(i).length==0) terminal ::= i
  }

  // remaining node to check
  var set = (0 until l).toSet
  set = set -- terminal

  while(terminal.nonEmpty){
    var safe = List[Int]()
    for(i<- set){
      graph(i) = graph(i).filter(x => !terminal.contains(x))
      if(graph(i).length==0) safe ::= i
    }
    terminal = safe
    set = set -- safe
  }

  ((0 until l).toSet -- set).toList.sorted
}
val graph = Array(Array(1,2),Array(2,3),Array(5),Array(0),Array(5),Array[Int](),Array[Int]())
eventualSafeNodes(graph)