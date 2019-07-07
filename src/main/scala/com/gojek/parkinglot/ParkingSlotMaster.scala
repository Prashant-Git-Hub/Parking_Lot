package com.gojek.parkinglot

object ParkingSlotMaster {

  var totalSlot = 0

  var takenVehicle : List[Array[String]] = List(Array("Slot No.", "Registration No", "Colour"))

  var nearestFree: List[Int] = List(0)

  var totalVehicle = 0

  var count = 0

  def createParkingLot(slotCount: Int): Unit = {
    totalSlot = slotCount
    print("Created a parking lot with " + totalSlot + " slots\n")
  }

  def availableSlot(): Int = {
    count = 0
    if(nearestFree.length == 1) {
      if(totalVehicle == totalSlot) {
        print("Sorry, parking lot is full\n")
        0
      }
      else
        totalVehicle + 1
    }
    else {
        try{
          nearestFree.sorted
          count = 1
          nearestFree(1)
        }
        catch {
          case ex: NullPointerException =>
            print("There is pointing to nothing\n")
            0
        }
      }
  }

  def vacentSlot(): Unit = {

  }

  def vehicleParked(registrationNumber: String, color: String): Unit = {
    try {
      takenVehicle = takenVehicle :+ Array(availableSlot().toString, registrationNumber, color)
      for(x <- takenVehicle) {
        for(y <- x) {
          print(y + "\t")
        }
        print("\n")
      }
      print("Allocated slot number: " + availableSlot() + "\n")
      totalVehicle += 1
      if(count == 1) {
        nearestFree.filter(x => x != nearestFree(1))
      }
    }
    catch {
      case ex: IndexOutOfBoundsException => {
        print("registration number or color is missing from data\n")
      }
      case ex: OutOfMemoryError => {
        print("System is out of memory, too much data, please handle data\n")
      }
    }
  }

  def leave(slotNum: Int): Unit = {
    try {
      if(nearestFree.contains(slotNum) || slotNum > totalVehicle)
        print("This Slot is already vacent\n")
    }
    catch {
      case ex: NullPointerException =>
        print("This is pointing to nothing\n")
    }
    if(slotNum > totalSlot)
      print("No such slot available\n")
    else {
      try {
        nearestFree = nearestFree :+ slotNum
        takenVehicle = takenVehicle.filter(x => !x.contains(slotNum.toString))
        print("Slot number " + slotNum + " is free\n")
        totalVehicle -= 1
      }
      catch {
        case ex: NullPointerException =>
          print("This is pointing to nothing\n")
      }
    }
  }

  def status(): Unit = {
    for(x <- takenVehicle) {
      for(y <- x) {
        print(y + "\t")
      }
      print("\n")
    }
  }

}
