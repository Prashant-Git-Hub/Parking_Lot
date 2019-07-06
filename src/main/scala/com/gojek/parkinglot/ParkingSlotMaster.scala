package com.gojek.parkinglot

object ParkingSlotMaster {

  var totalSlot = 0

  var takenSlots : List[Array[String]] = null

  var nearestFree: List[Int] = null

  var totalVehicle = 0

  def createParkingLot(slotCount: Int): Unit = {

  }

  def availableSlot(): Unit = {
    nearestFree.sorted
    if(nearestFree == null)
      totalVehicle
    else
      nearestFree.head
  }

  def vacentSlot(): Unit = {

  }

}
