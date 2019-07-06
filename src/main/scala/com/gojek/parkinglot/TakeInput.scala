package com.gojek.parkinglot

import java.io.{FileNotFoundException, IOException}

import scala.io.Source
import scala.util.control.Breaks._

object TakeInput {

  def main(args: Array[String]): Unit = {
    val console_input_count = args.length
    val ioUtils = new IOUtils
    if(console_input_count == 1) {
      val singleI = if(args(0).contains(".")) {
        try {
          val src = Source.fromFile(args(0)).mkString
        }
        catch {
          case ex: FileNotFoundException =>{
            println("file name or location is invalid")
          }
          case ex: IOException => {
            println("IO Exception")
          }
        }
      }
      else
        args(0)
    }

    var input = scala.io.StdIn.readLine()
      while (input.toLowerCase() != "exit") {
        ioUtils.matchInput(input)
        input = scala.io.StdIn.readLine()
      }
    }
}
