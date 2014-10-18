package com.github.sweb.marsrover

import org.scalatest.FlatSpec

/**
 * Created by Florian on 18.10.2014.
 */
import Direction._
class RoverSpec extends FlatSpec {
  val grid = Grid(100,100, Nil)

  val testdata = List(
    TestDataMoves(5,5,N,Array('f'), 5, 4,N),
    TestDataMoves(5,5,N,Array('f', 'f'), 5, 3,N),
    TestDataMoves(5,5,N,Array('f', 'b'), 5, 5,N),
    TestDataMoves(5,5,N,Array('f', 'b', 'f'), 5, 4,N),
    TestDataMoves(5,5,N,Array('b'), 5, 6,N),
    TestDataMoves(5,5,N,Array('b', 'b'), 5, 7,N),
    TestDataMoves(5,5,E,Array('f', 'b', 'f'), 6, 5,E),
    TestDataMoves(5,5,N,Array('l'), 5, 5,W),
    TestDataMoves(5,5,N,"ffrff".toCharArray, 7, 3,E),
    TestDataMoves(0,0,N,"ffrff".toCharArray, 2, 98,E)
  )

  "A new Rover" should "have coordinates and a direction" in {
    val r = Rover(5,5,N, grid)
    assert(r.toString == "Rover(5,5,"+N+","+grid+")")
  }
  it should "move forward on command" in {
    for (td <- testdata) {
      val r = Rover(td.startX,td.startY,td.startDirection, grid).receiveMoves(td.moves)
      assert(r.x == td.resultX && r.y == td.resultY && r.d == td.resultD)
    }
  }
}


case class TestDataMoves(startX: Int, startY: Int, startDirection: Direction, moves: Array[Char],
                         resultX: Int, resultY: Int, resultD: Direction)