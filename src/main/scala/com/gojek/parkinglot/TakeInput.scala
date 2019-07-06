package com.gojek.parkinglot

import java.io.{FileNotFoundException, IOException}

import scala.io.Source

object TakeInput {

  def main(args: Array[String]): Unit = {
    val console_input_count = args.length
    val ioUtils = new IOUtils
    if(console_input_count == 1) {
      val singleI = if(args(0).contains(".")) {
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
        args(0)

    }
    else {

    }


  }

}
