package com.hackerrank.botbuilding

object BotCleanStochastic {

  def main(args: Array[String]): Unit = {
    val pos = scala.io.StdIn.readLine()
    val board = new Array[String](5)
    for (i <- 0 until 5) {
      board.update(i, scala.io.StdIn.readLine())
    }
    nextMove(pos, board)
  }


  def nextMove(pos: String, board: Array[String]): Unit = {

    def locate(grid: Array[String], character: Char): (Int, Int) = {
      val x = grid.indexWhere(s => s.contains(character))
      val y = grid(x).indexOf(character)
      (x, y)
    }

    val x: Int = pos.charAt(0) - 48
    val y: Int = pos.charAt(2) - 48

    if (board(x).charAt(y) == 'd') System.out.println("CLEAN")
    else {
      val target: (Int, Int) = locate(board, 'd')
      if (x < target._1) System.out.println("DOWN")
      else if (x > target._1) System.out.println("UP")
      else if (y < target._2) System.out.println("RIGHT")
      else System.out.println("LEFT")
    }

  }

}