package com.gojek.parkinglot

class IOUtils {
  def matchInput(input: String): Int = {
    val inputLowerCase = input.toLowerCase()
    val splitedCommand = inputLowerCase.split(" ")
    val command = splitedCommand(0)
    command match {
      case "create_parking_lot" => createParkingLot(splitedCommand(1).toInt)
      case "park" => parkVehicle(splitedCommand(1),splitedCommand(2))
      case "leave" => leave(splitedCommand(1).toInt)
      case "status" => status()
    }
    4
  }

  def createParkingLot(lotNum: Int): Unit = {

  }

  def parkVehicle(registrationNumber: String, color: String): Unit = {

  }

  def leave(lotNum: Int): Unit = {

  }

  def status(): Unit = {

  }
}
