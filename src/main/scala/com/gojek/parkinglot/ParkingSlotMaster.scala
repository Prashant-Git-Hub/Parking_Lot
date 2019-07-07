package com.gojek.parkinglot
import scala.collection.SortedSet
import util.control.Breaks._

object ParkingSlotMaster {

  // Storing parked vehicle details
  def vehicleParked(registrationNumber: String, color: String, availableSlot: (SortedSet[Int], Int, Int) => Int, nearestF: SortedSet[Int], totalV: Int, totalS: Int): Int = {
    try {
      val slotNum = availableSlot(nearestF, totalV, totalS)
      if(slotNum >= 1) {
        print("Allocated slot number: " + availableSlot(nearestF, totalV, totalS) + "\n")
        1
      }
      else
        0
      }
    catch {
      case ex: IndexOutOfBoundsException => {
        print("registration number or color is missing from data\n")
        0
      }
      case ex: OutOfMemoryError => {
        print("System is out of memory, too much data, please handle data\n")
        0
      }
    }
  }

  // Update records when any vehicle left the parking lot
  def leave(slotNum: Int, nearestFree: SortedSet[Int], totalVehicle: Int, totalSlot: Int): Int = {
    try {
      if(nearestFree.contains(slotNum) && slotNum <= totalSlot) {
        print("This Slot is already vacant\n")
        0
      }
      else {
        if(slotNum > totalSlot) {
          print("No such slot available\n")
          0
        }
        else {
          slotNum
        }
      }
    }
    catch {
      case ex: NullPointerException =>
        print("This is pointing to nothing\n")
        0
    }
  }

  // Give the status of the current parking lot
  def status(takenVehicle: List[Array[String]]): Unit = {
    for(x <- takenVehicle) {
      for(y <- x) {
        print(y + "\t")
      }
      print("\n")
    }
  }

  // Find Slot numbers for particular color
  def slotForColor(color: String, takenVehicle: List[Array[String]]): Unit = {
    var test = 0
      for(x <- takenVehicle) {
        if(x(2) == color) {
          print(x(0) + ", ")
          test += 1
        }
      }
    if(test == 0)
      print("Not found")
    print("\n")
  }


  // Find Slot number for particular registration number
  def slotForReg(registrationNumber: String, takenVehicle: List[Array[String]]): Unit = {
    breakable{
      for(x <- takenVehicle) {
        if(x(1) == registrationNumber) {
          print(x(0) + "\n")
          break()
        }
      }
      print("Not found\n")
    }
  }

  // Find registration numbers for particular color
  def regForColor(color: String, takenVehicle: List[Array[String]]): Unit = {
    var test = 0
    for(x <- takenVehicle) {
      if(x(2) == color) {
        print(x(1) + ", ")
        test += 1
      }
    }
    if(test == 0)
      print("Not found")
    print("\n")
  }

  // It will take the wrong input data
  def inputErrorHandler(errorInput:String): Unit = {
    print("Your input does not matches with our input format, please read the application manual\n")
  }
}
