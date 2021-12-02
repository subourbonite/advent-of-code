package org.subourbonite
package day1

object Part1 {
  def main(args: Array[String]): Unit = {
    val numIncreases = scala.io.Source
      .fromURL(getClass.getResource("/day1/input.txt"))
      .getLines
      .map(_.toInt)
      .sliding(2, 1)
      .count(x => x.head < x.tail.headOption.getOrElse(0))

    println(s"Input file had $numIncreases value increases")
  }
}
