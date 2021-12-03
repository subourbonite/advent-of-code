package org.subourbonite
package day2

import scala.io.Source
import scala.util.Using
import scala.util.matching.Regex

case class SubmarineLocation(x: Int = 0, y: Int = 0, z: Int = 0) {
  def +(other: SubmarineLocation): SubmarineLocation =
    SubmarineLocation(this.x + other.x, this.y + other.y, this.z + other.z)
}

object SubmarineLocation {
  val instructionRegex: Regex = raw"([a-zA-Z]+)\s+(\d+)".r.unanchored

  def fromString(instruction: String): SubmarineLocation = instruction.toLowerCase match {
    case instructionRegex("forward", num) => SubmarineLocation(num.toInt, 0, 0)
    case instructionRegex("down", num)    => SubmarineLocation(0, num.toInt, 0)
    case instructionRegex("up", num)      => SubmarineLocation(0, num.toInt * -1, 0)
  }
}
object Part1 {
  def main(args: Array[String]): Unit = {
    val parsedInstructions = Using(Source.fromURL(getClass.getResource("/day2/input.txt"))) {
      instructions =>
        instructions.getLines().map(SubmarineLocation.fromString).reduce(_ + _)
    }.get

    println(s"Final value is ${parsedInstructions.x * parsedInstructions.y}")
  }
}
