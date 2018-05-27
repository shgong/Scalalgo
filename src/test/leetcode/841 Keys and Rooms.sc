/*
841. Keys and Rooms

There are N rooms and you start in room 0.
Each room has a distinct number in 0, 1, 2, ..., N-1,
each room may have some keys to access the next room.

Formally,
each room i has a list of keys rooms[i],
each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.

A key rooms[i][j] = v opens the room with number v.


Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.
 */

def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
  val s = collection.mutable.Set[Int]()

  def visit(room:Int): Unit = {
    s.add(room)
    for(k <- rooms(room) if !s.contains(k)) visit(k)
  }

  visit(0)
  s.size == rooms.length
}

canVisitAllRooms(
  List(List(1),List(2),List(3),List())
)

canVisitAllRooms(
  List(List(1,3),List(3,0,1),List(2),List(0))
)