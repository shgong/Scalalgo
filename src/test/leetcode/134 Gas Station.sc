/*
Gas Station
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 */
def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
  val k = gas.zip(cost).scanLeft(0){case(remain, next)=> remain + next._1-next._2 }
  // scanLeft include scanner => no need to +1
  // last one means if able to travel
  if(k.last>=0) k.zipWithIndex.min._2 else -1
}

val gas = Array(4)
val cost = Array(5)
canCompleteCircuit(gas, cost)