package com.gojek.parkinglot

import com.gojek.parkinglot.ParkingSlotMaster._
import org.scalatest._

import scala.collection.SortedSet

class ParkingSlotMasterTest extends FunSpec {

  // Unit test for Vehicle Parking method
  describe("ParkingSlotMaster.vehicleParked") {
    it("Should allocate slot") {
      val registrationNumber = "KA-01-TT-4543"
      val color = "Green"
      val nearestFree: SortedSet[Int] = SortedSet(5,3,67,9,123)
      val totalVehicle = 50
      val totalSlot = 150
      def available(nearestFree:SortedSet[Int], totalVehicle:Int, totalSlot:Int): Int = {
        if(nearestFree.size == 0) {
          if(totalVehicle == totalSlot) {
            0
          }
          else
            totalVehicle + 1
        }
      else {
        try{
          nearestFree.head
        }
        catch {
          case ex: NullPointerException =>
            print("There is pointing to nothing\n")
            0
        }
      }
      }
      val actual = ParkingSlotMaster.vehicleParked(registrationNumber, color, available, nearestFree, totalVehicle, totalSlot)
      val expect = 1
      assertResult(expect)(actual)
    }
    it("Should not allocate and say parking lot is full") {
      val registrationNumber = "KA-01-TT-4543"
      val color = "Green"
      val nearestFree: SortedSet[Int] = SortedSet()
      val totalVehicle = 150
      val totalSlot = 150
      def available(nearestFree:SortedSet[Int], totalVehicle:Int, totalSlot:Int): Int = {
        if(nearestFree.size == 0) {
          if(totalVehicle == totalSlot) {
            0
          }
          else
            totalVehicle + 1
        }
        else {
          try{
            nearestFree.head
          }
          catch {
            case ex: NullPointerException =>
              print("There is pointing to nothing\n")
              0
          }
        }
      }
      val actual = ParkingSlotMaster.vehicleParked(registrationNumber, color, available, nearestFree, totalVehicle, totalSlot)
      val expect = 0
      assertResult(expect)(actual)
    }
  }

  // Unit test for vehicle leaving logic
  describe("ParkingSlotMaster.leave") {
    it("Should check data, whether we can enter or not") {
      val nearestFree = SortedSet(145,2,33,45,34)
      val totalVehicle = 50
      val totalSlot = 150
      val slotNumber = 55
      val actual = ParkingSlotMaster.leave(slotNumber, nearestFree, totalVehicle, totalSlot)
      val expect = 55
      assertResult(expect)(actual)
    }
    it("Should say this slot is already vacant") {
      val nearestFree = SortedSet(145,2,33,45,34)
      val totalVehicle = 50
      val totalSlot = 150
      val slotNumber = 45
      val actual = ParkingSlotMaster.leave(slotNumber, nearestFree, totalVehicle, totalSlot)
      val expect = 0
      assertResult(expect)(actual)
    }
  }

  // Unit test for slot for color method
  describe("ParkingSlotMaster.slotForColor") {
    it("Should give all the slots for a test color") {
      val color = "Black"
      val takenVehicle: List[Array[String]] = List(Array("1", "KA-01-HH-1234", "White"), Array("2", "DL-01-HH-9929", "White"), Array("31", "KA-01-BB-0401", "Black"), Array("52", "KA-01-HH-2701", "Black"), Array("67", "KA-01-HH-3141", "Yellow"))
      val actual = ParkingSlotMaster.slotForColor(color, takenVehicle)
      val expect = print("32, 52,")
      assertResult(expect)(actual)
    }
    it("Should not found the results") {
      val color = "Green"
      val takenVehicle: List[Array[String]] = List(Array("1", "KA-01-HH-1234", "White"), Array("2", "DL-01-HH-9929", "White"), Array("31", "KA-01-BB-0401", "Black"), Array("52", "KA-01-HH-2701", "Black"), Array("67", "KA-01-HH-3141", "Yellow"))
      val actual = ParkingSlotMaster.slotForColor(color, takenVehicle)
      val expect = print("Not Found")
      assertResult(expect)(actual)
    }
  }

  // Unit test for Slot number for particular registration number method
  describe("ParkingSlotMaster.slotForReg") {
    it("Should give slot number for given registration number") {
      val registrationNumber = "DL-01-HH-9929"
      val takenVehicle: List[Array[String]] = List(Array("1", "KA-01-HH-1234", "White"), Array("2", "DL-01-HH-9929", "White"), Array("31", "KA-01-BB-0401", "Black"), Array("52", "KA-01-HH-2701", "Black"), Array("67", "KA-01-HH-3141", "Yellow"))
      val actual = ParkingSlotMaster.slotForReg(registrationNumber, takenVehicle)
      val expect = print("2")
      assertResult(expect)(actual)
    }
    it("Should not found the results") {
      val registrationNumber = "DL-01-HH-9949"
      val takenVehicle: List[Array[String]] = List(Array("1", "KA-01-HH-1234", "White"), Array("2", "DL-01-HH-9929", "White"), Array("31", "KA-01-BB-0401", "Black"), Array("52", "KA-01-HH-2701", "Black"), Array("67", "KA-01-HH-3141", "Yellow"))
      val actual = ParkingSlotMaster.slotForReg(registrationNumber, takenVehicle)
      val expect = print("Not Found")
      assertResult(expect)(actual)
    }
  }

  // Unit test for registration numbers for particular color method
  describe("ParkingSlotMaster.regForColor") {
    it("Should give slot number for given registration number") {
      val registrationNumber = "White"
      val takenVehicle: List[Array[String]] = List(Array("1", "KA-01-HH-1234", "White"), Array("2", "DL-01-HH-9929", "White"), Array("31", "KA-01-BB-0401", "Black"), Array("52", "KA-01-HH-2701", "Black"), Array("67", "KA-01-HH-3141", "Yellow"))
      val actual = ParkingSlotMaster.regForColor(registrationNumber, takenVehicle)
      val expect = print("KA-01-HH-1234, DL-01-HH-9929,")
      assertResult(expect)(actual)
    }
    it("Should not found the results") {
      val registrationNumber = "Orange"
      val takenVehicle: List[Array[String]] = List(Array("1", "KA-01-HH-1234", "White"), Array("2", "DL-01-HH-9929", "White"), Array("31", "KA-01-BB-0401", "Black"), Array("52", "KA-01-HH-2701", "Black"), Array("67", "KA-01-HH-3141", "Yellow"))
      val actual = ParkingSlotMaster.regForColor(registrationNumber, takenVehicle)
      val expect = print("Not Found")
      assertResult(expect)(actual)
    }
  }
}
