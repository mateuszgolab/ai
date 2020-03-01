package com.hackerrank.botbuilding

import org.scalatest.FunSuite

class BotCleanTest extends FunSuite {

  test("example test") {

    val m : String = "0 0"
    val input: Array[String] = Array("b---d", "-d--d", "--dd-", "--d--", "----d")

    BotClean.nextMove(m, input)
  }

  test("test 1") {

    val m : String = "0 0"
    val input: Array[String] = Array("bd---", "-d---", "---d-", "---d-", "--d-d")

    BotClean.nextMove(m, input)
  }


//    b------
//    d--d---
//    d------
//    d------
//    d------
//    d------
//

}
