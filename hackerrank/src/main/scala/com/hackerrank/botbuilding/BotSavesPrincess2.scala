package com.hackerrank.botbuilding

import scala.io.StdIn

object BotSavesPrincess2 {

  def main(args: Array[String]): Unit = {
    val m = StdIn.readInt()
    val xy = StdIn.readLine().split(" ")
    val grid = new Array[String](m)
    for (i <- 0 until m) {
      grid.update(i, StdIn.readLine())
    }
    Console.out.println(nextMove(m, (xy(0).toInt, xy(1).toInt), grid))

  }


  def nextMove(m: Int, start: (Int, Int), grid: Array[String]): String = {

    def locate(grid: Array[String], character: Char): (Int, Int) = {
      val x = grid.indexWhere(s => s.contains(character))
      val y = grid(x).indexOf(character)
      (x, y)
    }

    val stop: (Int, Int) = locate(grid, 'p')

    if (start._1 > stop._1) {
      "UP"
    } else if (start._1 < stop._1) {
      "DOWN"
    }
    else if (start._2 > stop._2) {
      "LEFT"
    } else {
      "RIGHT"
    }


  }

}