package com.gojek.parkinglot

class IOUtils {

  // Matches the input with some pre-defined commands
  def matchInput(input: String)= {
    var parkingLot = 0
    val splitedCommand = input.split(" ")
    val command = splitedCommand(0).toLowerCase()
    command match {
      case "create_parking_lot" => {
        if(parkingLot == 0) {
          ParkingSlotMaster.createParkingLot(splitedCommand(1).toInt)
          parkingLot = parkingLot + 1
        }
        else
          print("Parking lot already created\n")
      }
      case "park" => ParkingSlotMaster.vehicleParked(splitedCommand(1),splitedCommand(2))
      case "leave" => ParkingSlotMaster.leave(splitedCommand(1).toInt)
      case "status" => ParkingSlotMaster.status()
      case "slot_numbers_for_cars_with_colour" => ParkingSlotMaster.slotForColor(splitedCommand(1))
      case "slot_number_for_registration_number" => ParkingSlotMaster.slotForReg(splitedCommand(1))
      case "registration_numbers_for_cars_with_colour" => ParkingSlotMaster.regForColor(splitedCommand(1))
      case "exit" =>
      case _ => ParkingSlotMaster.inputErrorHandler(input)
    }
  }
}
