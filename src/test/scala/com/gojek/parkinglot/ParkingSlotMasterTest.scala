package com.gojek.parkinglot

import com.gojek.parkinglot.ParkingSlotMaster._
import org.scalatest._

class ParkingSlotMasterTest extends FunSpec {
  describe("ParkingSlotMaster.createParkingLot") {
    it("Should assign total parking slot and print that\n") {
      val slots = ParkingSlotMaster.createParkingLot(50)
      val expect = print("Created a parking lot with 50 slots\\n")
      assertResult(expect)(slots)
    }

  }
}
