package com.gojek.parkinglot

import com.gojek.parkinglot.ParkingSlotMaster._
import com.gojek.parkinglot.IOUtils
import org.scalatest._

class ParkingSlotMasterTest extends FunSpec {

  // Unit test for Vehicle Parking method
  describe("ParkingSlotMaster.vehicleParked") {
    it("Should check data, whether we can enter or not") {
      val registrationNumber = "KA-01-TT-4543"
      val color = "Green"
      val nearestFree = List(0,5,3,6,9,123)
      val totalVehicle = 50
      val totalSlot = 150
      val available = {if(nearestFree.length == 1) {
        if(totalVehicle == totalSlot) {
          0
        }
        else
          totalVehicle + 1
      }
      else {
        try{
          nearestFree.sorted
          nearestFree(1)
        }
        catch {
          case ex: NullPointerException =>
            print("There is pointing to nothing\n")
            0
        }
      }
      }
      val actual = ParkingSlotMaster.vehicleParked(registrationNumber, color, available(nearestFree, totalVehicle, totalSlot), nearestFree, totalVehicle, totalSlot)
      val expect = 1
      assertResult(expect)(actual)
    }
  }
}
