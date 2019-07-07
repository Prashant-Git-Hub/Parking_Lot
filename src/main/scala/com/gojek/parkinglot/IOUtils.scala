package com.gojek.parkinglot

import scala.collection.SortedSet

class IOUtils {
  var totalSlot = 0
  var nearestFree: SortedSet[Int] = SortedSet()
  var freeCount = 0
  var totalVehicle = 0
  var takenVehicle : List[Array[String]] = List(Array("Slot No.\t", "Registration No\t", "Colour\t"))
  //val reg = (/^[A-Z]{2}$/i).r

  // Matches the input with some pre-defined commands
  def matchInput(input: String)= {
    var parkingLot = 0
    val splitedCommand = input.split(" ")
    val command = splitedCommand(0).toLowerCase()
    command match {
      case "create_parking_lot" => {
        try {
          if(parkingLot == 0) {
            totalSlot = splitedCommand(1).toInt
            parkingLot = parkingLot + 1
            print("Created a parking lot with " + totalSlot + " slots\n")
          }
          else
            print("Parking lot already created\n")
        }
        catch {
          case ex: IllegalArgumentException =>
            print("Plese provide Number of slots in integer\n")
        }
      }
      case "park" => {
        if(ParkingSlotMaster.vehicleParked(splitedCommand(1), splitedCommand(2), availableSlot, nearestFree, totalVehicle, totalSlot) == 1) {
          takenVehicle = takenVehicle :+ Array(availableSlot(nearestFree, totalVehicle, totalSlot).toString, splitedCommand(1),splitedCommand(2))
          totalVehicle += 1
          if(freeCount == nearestFree.size - 1)
            nearestFree = nearestFree - nearestFree.head
        }
        else{
          print("Sorry, parking lot is full\n")
        }
      }
      case "leave" => {
        val slotNum = ParkingSlotMaster.leave(splitedCommand(1).toInt, nearestFree, totalVehicle, totalSlot)
        if(slotNum > 0) {
          nearestFree = nearestFree + slotNum
          takenVehicle = takenVehicle.filter(x => !x.contains(slotNum.toString))
          print("Slot number " + slotNum + " is free\n")
          totalVehicle -= 1
        }
      }
      case "status" => ParkingSlotMaster.status(takenVehicle)
      case "slot_numbers_for_cars_with_colour" => ParkingSlotMaster.slotForColor(splitedCommand(1), takenVehicle)
      case "slot_number_for_registration_number" => ParkingSlotMaster.slotForReg(splitedCommand(1), takenVehicle)
      case "registration_numbers_for_cars_with_colour" => ParkingSlotMaster.regForColor(splitedCommand(1), takenVehicle)
      case "exit" => System.exit(1)
      case _ => ParkingSlotMaster.inputErrorHandler(input)
    }
  }

  // Provide parking lot number
  def availableSlot(nearest: SortedSet[Int], totalV: Int, totalS: Int): Int = {
    if(nearest.size == 0) {
      if(totalV == totalS) {
        0
      }
      else
        totalV + 1
    }
    else {
      try{
        freeCount = nearest.size - 1
        nearest.head
      }
      catch {
        case ex: NullPointerException =>
          print("There is pointing to nothing\n")
          0
      }
    }
  }
}
