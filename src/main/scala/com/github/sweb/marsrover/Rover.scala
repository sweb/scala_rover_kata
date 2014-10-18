package com.github.sweb.marsrover

/**
 * Created by Florian on 18.10.2014.
 */
import Direction._
case class Rover(x: Int, y: Int, d: Direction, grid: Grid) {
  val numberOfDirections = 4

  val (horMovement, vertMovement) = {
    d match {
      case N => (0,1)
      case S => (0,-1)
      case E => (-1,0)
      case W => (1,0)
    }
  }

  def receiveMoves(moves: Array[Char]): Rover = {
    processMoves(moves.toList)
  }

  def processMoves(moves: List[Char]): Rover = {
    moves match {
      case Nil => this
      case h :: t => processMove(h).processMoves(t)
    }
  }

  private def processMove(c: Char): Rover = {
    c match {
      case 'f' => move()
      case 'b' => move(isBackingUp = true)
      case 'l' => rotate(toRight = false)
      case 'r' => rotate(toRight = true)
    }
  }

  private def move(isBackingUp: Boolean = false): Rover = {
    // May be counter-intuitive but common for 2D programming - Moving up is a negative movement, reducing y
    val f = if (isBackingUp) 1 else -1
    val newX = (x + horMovement * f + grid.width) % grid.width
    val newY = (y + vertMovement * f + grid.height) % grid.height

    Rover(newX, newY, d, grid)
  }

  private def rotate(toRight: Boolean): Rover = {
    val leftOrRight = if (toRight) 1 else -1
    val newD: Direction = ((d + leftOrRight) + numberOfDirections) % numberOfDirections
    Rover(x, y, newD, grid)
  }
}

