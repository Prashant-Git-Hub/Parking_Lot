package com.gojek.parkinglot

class IOUtils {
  def matchInput(input: String): Int = {
    val inputLowerCase = input.toLowerCase()
    val splitedCommand = inputLowerCase.split(" ")
    val command = splitedCommand(0)
    command match {
      case "create_parking_lot" => provideParkingSlot(splitedCommand(1).toInt)
      case "park" => parkVehicle(splitedCommand(1),splitedCommand(2))
      case "leave" => leave(splitedCommand(1).toInt)
      case "status" => status()
      case "slot_numbers_for_cars_with_colour" => slotForColor(splitedCommand(1))
      case "slot_number_for_registration_number" => slotForReg(splitedCommand(1))
      case "registration_numbers_for_cars_with_colour" => regForColor(splitedCommand(1))
      case _ => inputErrorHandler(input)
    }
    4
  }

  def provideParkingSlot(totalSlot: Int): Unit = {
    ParkingSlotMaster.totalSlot = totalSlot
  }

  def parkVehicle(registrationNumber: String, color: String): Unit = {

  }

  def leave(slotNum: Int): Unit = {

  }

  def status(): Unit = {

  }

  def slotForColor(color: String): Unit = {

  }

  def slotForReg(registrationNumber: String): Unit = {

  }

  def regForColor(color: String): Unit = {

  }

  def inputErrorHandler(errorInput:String): Unit = {

  }

}
