package org.subourbonite
package day2

import scala.io.Source
import scala.util.Using
import scala.util.matching.Regex

case class Position(horizontal: Int = 0, depth: Int = 0)
case class SubmarineState(position: Position = Position(), aim: Int = 0)

object Part2 {
  val instructionRegex: Regex = raw"([a-zA-Z]+)\s+(\d+)".r

  def main(args: Array[String]): Unit = {
    val finalState = Using(Source.fromURL(getClass.getResource("/day2/input.txt"))) {
      instructions =>
        instructions.getLines().foldLeft(SubmarineState()) { (state, line) =>
          line match {
            case instructionRegex("down", num) => state.copy(aim = state.aim + num.toInt)
            case instructionRegex("up", num)   => state.copy(aim = state.aim - num.toInt)
            case instructionRegex("forward", num) =>
              state.copy(position =
                state.position.copy(
                  horizontal = state.position.horizontal + num.toInt,
                  depth = state.position.depth + (num.toInt * state.aim)
                )
              )
          }
        }
    }.get

    println(s"Final state is ${finalState.position.horizontal * finalState.position.depth}")
  }
}
