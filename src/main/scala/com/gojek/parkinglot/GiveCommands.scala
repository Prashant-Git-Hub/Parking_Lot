package com.gojek.parkinglot

import scala.io.Source

class GiveCommands {

  def singleInput(singleInputCommand: String) {
    if(singleInputCommand.contains(".")) {
      val src = Source.fromFile("C:\\Users\\PRC5COB\\Desktop\\parking-lot-1.4.2\\parking_lot\\functional_spec\\fixtures\\file_input.txt").mkString
    }
    else
      singleInputCommand
  }

  def multiConsoleInput(multiInput : List[String]): Unit = {

  }
}
