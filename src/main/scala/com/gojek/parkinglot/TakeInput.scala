package com.gojek.parkinglot

object TakeInput {

  def main(args: Array[String]): Unit = {
    val console_input_count = args.length
    if(console_input_count == 1) {
      val gc = new GiveCommands
      val mi = gc.singleInput(args(0))
    }
    else {

    }


  }

}
