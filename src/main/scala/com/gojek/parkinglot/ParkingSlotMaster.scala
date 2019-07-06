package com.gojek.parkinglot

object ParkingSlotMaster {

  var totalSlot = 0

  var takenVehicle : List[Array[String]] = List(Array("Slot No.", "Registration No", "Colour"))

  var nearestFree: List[Int] = null

  var totalVehicle = 0

  def createParkingLot(slotCount: Int): Unit = {
    totalSlot = slotCount
    print("Created a parking lot with " + totalSlot + " slots\n")
  }

  def availableSlot(): Unit = {
    nearestFree.sorted
    if(nearestFree == null)
      totalVehicle + 1
    else
      nearestFree.head
  }

  def vacentSlot(): Unit = {

  }

  def vehicleParked(registrationNumber: String, color: String): Unit = {
    try {
      takenVehicle :+ List(Array(availableSlot().toString, registrationNumber, color))
      print("Allocated slot number: " + availableSlot() + "\n")
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
    if(nearestFree.contains(slotNum) || slotNum > totalVehicle)
      print("This Slot is already vacent\n")
    if(slotNum > totalSlot)
      print("No such slot available\n")
    else {
      nearestFree :+ List(slotNum)
      takenVehicle = takenVehicle.filter(x => !x.contains(slotNum.toString))
      print("Slot number" + slotNum + "is free\n")
    }

  }

  def status(): Unit = {

  }

}
