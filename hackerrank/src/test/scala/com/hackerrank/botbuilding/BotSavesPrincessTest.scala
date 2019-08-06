package com.hackerrank.botbuilding

import org.scalatest.FunSuite

class BotSavesPrincessTest extends FunSuite {

  test("example test") {

    val m : Int = 3
    val input : Array[String] = Array("---","-m-","p--")

    val result : Seq[String] = BotSavesPrincess.displayPathtoPrincess(m, input)

    assert(result.nonEmpty)
    assert(result.size  == 2)


  }

  test("test 5x5") {

    val m : Int = 5
    val input : Array[String] = Array("-----","---m-","--p--","-----","-----")

    val result : Seq[String] = BotSavesPrincess.displayPathtoPrincess(m, input)

    assert(result.nonEmpty)
    assert(result.size == 2)


  }

}
