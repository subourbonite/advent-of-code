package org.subourbonite
package day1

object Part2 {
  def main(args: Array[String]): Unit = {
    val numIncreases = scala.io.Source
      .fromURL(getClass.getResource("/day1/input.txt"))
      .getLines
      .map(_.toInt)
      .sliding(3, 1)
      .map(_.sum)
      .sliding(2, 1)
      .count {
        case Seq(x, y) => x < y
        case _         => false
      }

    println(
      s"Input file had $numIncreases value increases using a sliding window of 3 aggregate values"
    )
  }
}
