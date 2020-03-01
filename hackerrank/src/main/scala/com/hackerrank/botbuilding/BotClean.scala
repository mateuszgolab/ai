package com.hackerrank.botbuilding

object BotClean {

  def main(args: Array[String]): Unit = {
    val pos = scala.io.StdIn.readLine()
    val board = new Array[String](5)
    for (i <- 0 until 5) {
      board.update(i, scala.io.StdIn.readLine())
    }
    nextMove(pos, board)
  }


  def nextMove(pos: String, board: Array[String]): Unit = {

    def distance(a: (Int, Int), b: (Int, Int)): Int = Math.abs(a._1 - b._1) + Math.abs(a._2 - b._2)

    def minVec(a: (Int, Int), b: (Int, Int), startingPoint: (Int, Int)): (Int, Int) = {
      if (distance(a, startingPoint) < distance(b, startingPoint)) a
      else b
    }

    def bfs(startingPoint: (Int, Int), currentPoint: (Int, Int), vector: Vector[(Int, Int)], currentDistance: Int): Int = {

      if (vector.length == 1) {
        currentDistance + distance(currentPoint, vector.head)
      } else {

        val closest1 = vector.reduceLeft((a, b) => minVec(a, b, currentPoint))
        val closest2 = vector.filter(v => v._1 != closest1._1 || v._2 != closest1._2).reduceLeft((a, b) => minVec(a, b, currentPoint))

        val min1 = bfs(startingPoint, closest1, vector.filter(v => v._1 != closest1._1 || v._2 != closest1._2), currentDistance + distance(currentPoint, closest1))
        val min2 = bfs(startingPoint, closest2, vector.filter(v => v._1 != closest2._1 || v._2 != closest2._2), currentDistance + distance(currentPoint, closest2))

        Math.min(min1, min2)

      }
    }

    val r: Int = pos.charAt(0) - 48
    val c: Int = pos.charAt(2) - 48
    var vec: Vector[(Int, Int)] = Vector.empty

    for (i <- 0 to 4) {
      for (j <- 0 to 4) {
        if (board(i).charAt(j) == 'd') {
          vec = vec :+ (i, j)
        }
      }
    }

    var closest: (Int, Int) = null

    if (vec.isEmpty) {
      println("CLEAN")
      return
    } else if (vec.size == 1) {
      closest = vec.head
    } else {

      val closest1 = vec.reduceLeft((a, b) => minVec(a, b, (r, c)))
      val closest2 = vec.filter(v => v._1 != closest1._1 || v._2 != closest1._2).reduceLeft((a, b) => minVec(a, b, (r, c)))

      val min1 = bfs(closest1, closest1, vec.filter(v => v._1 != closest1._1 || v._2 != closest1._2), distance((r, c), closest1))
      val min2 = bfs(closest2, closest2, vec.filter(v => v._1 != closest2._1 || v._2 != closest2._2), distance((r, c), closest2))

      if (min1 < min2) {
        closest = closest1
      } else {
        closest = closest2
      }
    }

    if (r < closest._1) println("DOWN")
    else if (r > closest._1) println("UP")
    else if (c < closest._2) println("RIGHT")
    else if (c > closest._2) println("LEFT")
    else println("CLEAN")
  }

}