package com.github.sweb.marsrover

/**
 * Created by Florian on 18.10.2014.
 * Disclaimer: Instead of using the explained grid, this grid starts on the top left, i.e. (0,0) is the top left
 * position and if I move north I immediately get off the grid.
 */
case class Grid(width: Int, height: Int, obstacles: List[(Int, Int)]) {

}
