package com.hackerrank.botbuilding

import scala.collection.mutable.ListBuffer

object BotSavesPrincess {

  def main(args: Array[String]): Unit = {
    val m = scala.io.StdIn.readInt()
    val grid = new Array[String](m)
    for (i <- 0 until m) {
      grid.update(i, scala.io.StdIn.readLine())
    }
    displayPathtoPrincess(m, grid).foreach(e => Console.out.println(e))
  }


  def displayPathtoPrincess(m: Int, grid: Array[String]): Seq[String] = {

    def locate(grid: Array[String], character : Char): (Int, Int) = {
      val x = grid.indexWhere(s => s.contains(character))
      val y = grid(x).indexOf(character)
      (x, y)
    }

    val start: (Int, Int) = locate(grid, 'm')
    val stop: (Int, Int) = locate(grid, 'p')
    val result : ListBuffer[Seq[String]] = ListBuffer()

    if(start._1 > stop._1) {
      result += Seq.fill(start._1 - stop._1)("UP")
    } else{
      result += Seq.fill(stop._1 - start._1)("DOWN")
    }

    if(start._2 > stop._2) {
      result += Seq.fill(start._2 - stop._2)("LEFT")
    } else{
      result += Seq.fill(stop._2 - start._2)("RIGHT")
    }

    result.flatten

  }

}