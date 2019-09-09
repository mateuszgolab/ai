package com.hackerrank.botbuilding

import org.scalatest.FunSuite

class BotSavesPrincess2Test extends FunSuite {


  test("example test") {

    val m : Int = 3
    val input : Array[String] = Array("---","-m-","p--")

    val result : String = BotSavesPrincess2.nextMove(m, (1,1), input)

    assert(result === "DOWN")


  }

  test("example test 2") {

    val input : Array[String] = Array("-----","-----","p--m-","-----","-----")

    val result : String = BotSavesPrincess2.nextMove(5, (2,3), input)

    assert(result === "LEFT")


  }


  test("test 3") {

    val input : Array[String] = Array("-----","-----","-----","-----", "m---p")

    val result : String = BotSavesPrincess2.nextMove(5, (4,0), input)

    assert(result === "RIGHT")


  }

}
