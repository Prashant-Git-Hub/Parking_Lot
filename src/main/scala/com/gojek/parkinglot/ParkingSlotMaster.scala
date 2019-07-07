package com.gojek.parkinglot

object ParkingSlotMaster {

  var totalSlot = 0

  var takenVehicle : List[Array[String]] = List(Array("Slot No.\t", "Registration No\t", "Colour\t"))

  var nearestFree: List[Int] = List(0)

  var totalVehicle = 0

  var count = 0

  // Create parking slots
  def createParkingLot(slotCount: Int): Unit = {
    totalSlot = slotCount
    print("Created a parking lot with " + totalSlot + " slots\n")
  }

  // Provide parking lot number
  def availableSlot(): Int = {
    count = 0
    if(nearestFree.length == 1) {
      if(totalVehicle == totalSlot) {
        print("Sorry, parking lot is full\n")
        count = 2
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
            3
        }
      }
  }

  // Storing parked vehicle details
  def vehicleParked(registrationNumber: String, color: String): Unit = {
    try {
      var slotNum = availableSlot()
      if(count != 2) {
        takenVehicle = takenVehicle :+ Array(slotNum.toString, registrationNumber, color)
        print("Allocated slot number: " + availableSlot() + "\n")
        totalVehicle += 1
        if(count == 1) {
          nearestFree = nearestFree.take(1) ++ nearestFree.drop(2)
        }
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

  // Update records when any vehicle left the parking lot
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

  // Give the status of the current parking lot
  def status(): Unit = {
    for(x <- takenVehicle) {
      for(y <- x) {
        print(y + "\t")
      }
      print("\n")
    }
  }

  // Find Slot numbers for particualr color
  def slotForColor(color: String): Unit = {

  }

  // Find Slot number for particualr registration number
  def slotForReg(registrationNumber: String): Unit = {

  }

  // Find registration number for particualr color
  def regForColor(color: String): Unit = {

  }

  def inputErrorHandler(errorInput:String): Unit = {

  }

}
