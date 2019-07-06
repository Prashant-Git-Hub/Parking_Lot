package com.gojek.parkinglot

import scala.io.Source
import java.io.FileNotFoundException
import java.io.IOException

class GiveCommands {

  def singleInput(singleInputCommand: String) {
    if(singleInputCommand.contains(".")) {
      try {
        val src = Source.fromFile("C:\\Users\\PRC5COB\\Desktop\\parking-lot-1.4.2\\parking_lot\\functional_spec\\fixtures\\file_input.txt").mkString
      }
      catch {
        case ex: FileNotFoundException =>{
          println("Command or file location is inva")
        }
        case ex: IOException => {
          println("IO Exception")
        }
      }
    }
    else
      singleInputCommand
  }

  def multiConsoleInput(multiInput : Array[String]): Unit = {

  }
}
