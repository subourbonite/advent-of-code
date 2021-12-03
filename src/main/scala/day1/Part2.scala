package org.subourbonite
package day1

import scala.io.Source
import scala.util.Using

object Part2 {
  def main(args: Array[String]): Unit = {
    val numIncreases = Using(Source.fromURL(getClass.getResource("/day1/input.txt"))) { input =>
      input.getLines
        .map(_.toInt)
        .sliding(3, 1)
        .map(_.sum)
        .sliding(2, 1)
        .count {
          case Seq(x, y) => x < y
          case _         => false
        }
    }
    println(
      s"Input file had ${numIncreases.get} value increases using a sliding window of 3 aggregate values"
    )
  }
}
