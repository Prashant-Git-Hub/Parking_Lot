#!/usr/bin/env bash

sbt clean

sbt compile package

scala -cp target\scala-2.11\parkinglot_2.11-0.1.jar com.gojek.parkinglot.ParkingSlotMasterTest
