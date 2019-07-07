package com.gojek.parkinglot

import com.gojek.parkinglot.ParkingSlotMaster._
import com.gojek.parkinglot.IOUtils

import org.scalatest._

class ParkingSlotMasterTest extends FunSpec {
  /*describe("ParkingSlotMaster.createParkingLot") {
    it("Should assign total parking slot and print that\n") {
      val slots = ParkingSlotMaster.createParkingLot(50)
      val expect = print("Created a parking lot with 50 slots\\n")
      assertResult(expect)(slots)
    }
  }*/

  describe("ParkingSlotMaster.vehicleParked") {
    it("Should check data, whether we can enter or not") {
      val registrationNumber = "KA-01-TT-4543"
      val color = "Green"
      val nearestFree = List(0,5,3,6,9,123)
      

      //val actual = ParkingSlotMaster.vehicleParked()
    }
  }
}
