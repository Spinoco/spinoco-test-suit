package com.spinoco.testsuit

import java.util.Date
import org.bson.types.ObjectId
import reflect.runtime.universe._
import scala.pickling.FastTypeTag

/**
 *
 * User: pach
 * Date: 10/7/12
 * Time: 11:48 AM
 * (c) 2011-2012 Spinoco Czech Republic, a.s.
 */
trait MapLikeSpecsConcrete extends MapLikeSpecs {
/*
  def mapTests() {

    describe("String Map") {makeTestFor[String]}
    describe("Boolean Map") {makeTestFor[Boolean]}
    describe("Byte Map") {makeTestFor[Byte]}
    describe("Short Map") {makeTestFor[Short]}
    describe("Int Map") {makeTestFor[Int]}
    describe("Long Map") {makeTestFor[Long]}
    describe("Double Map") {makeTestFor[Double]}
    describe("Float Map") {makeTestFor[Float]}
    describe("Char Map") {makeTestFor[Char]}
    describe("ObjectId Map") {makeTestFor[ObjectId]}
    describe("Id Map") {makeTestFor[Id]}
    describe("Date Map") {makeTestFor[Date]}
    describe("Enum Map") {makeTestFor[EnumForTest.Value]}
  }


  def makeTestFor[K: FastTypeTag] = {

    val messages = prepareMapTest[K]

    messages.filterNot(_._1.contains("Array")).foreach(tm => {
      it("will serialize " + tm._1) {
        doSerializationWithType(tm._2._2)
      }
    })

    def compareSimpleMapArrayMessage(msg: SimpleMapArrayMessage[K]) = {
      (result: SimpleMapArrayMessage[K]) => {
        result.boolPar should be(msg.boolPar)
        result.bytePar should be(msg.bytePar)
        result.shortPar should be(msg.shortPar)
        result.intPar should be(msg.intPar)
        result.longPar should be(msg.longPar)
        result.doublePar should be(msg.doublePar)
        result.floatPar should be(msg.floatPar)
        result.stringPar should be(msg.stringPar)
        result.objIdPar should be(msg.objIdPar)
        result.idPar should be(msg.idPar)
        result.datePar should be(msg.datePar)
        result.calendarPar should be(msg.calendarPar)
        result.enumPar should be(msg.enumPar)
        result.ssmPar should be(msg.ssmPar)
        result.ptPar should be(msg.ptPar)
      }
    }

    it("will serialize SimpleMapArrayMessage Empty") {
      val tm = messages("SimpleMapArrayMessage Empty")
      val msg = tm._2.asInstanceOf[SimpleMapArrayMessage[K]]
      doSerializationWithType[SimpleMapArrayMessage[K]](msg, compareSimpleMapArrayMessage(msg))
    }

    it("will serialize SimpleMapArrayMessage Full") {
      val tm = messages("SimpleMapArrayMessage Full")
      val msg = tm._2.asInstanceOf[SimpleMapArrayMessage[K]]
      doSerializationWithType[SimpleMapArrayMessage[K]](msg, compareSimpleMapArrayMessage(msg))
    }

    it("will serialize SimpleMapArrayMessage Empty Map") {
      val tm = messages("SimpleMapArrayMessage Empty Map")
      val msg = tm._2.asInstanceOf[SimpleMapArrayMessage[K]]
      doSerializationWithType[SimpleMapArrayMessage[K]](msg, compareSimpleMapArrayMessage(msg))
    }

    def compareSimpleMapArrayValueMessage(msg: SimpleMapArrayValueMessage[K]) = {
      (result: SimpleMapArrayValueMessage[K]) => {

        def compareMaps(original: Map[K, Array[_]], deserialized: Map[K, Array[_]]) = {
          original.foreach(e => e._2 should be(deserialized(e._1)))
        }

        compareMaps(result.boolPar, msg.boolPar)
        compareMaps(result.bytePar, msg.bytePar)
        compareMaps(result.shortPar, msg.shortPar)
        compareMaps(result.intPar, msg.intPar)
        compareMaps(result.longPar, msg.longPar)
        compareMaps(result.doublePar, msg.doublePar)
        compareMaps(result.floatPar, msg.floatPar)
        compareMaps(result.stringPar, msg.stringPar)
        compareMaps(result.objIdPar, msg.objIdPar)
        compareMaps(result.idPar, msg.idPar)
        compareMaps(result.datePar, msg.datePar)
        compareMaps(result.calendarPar, msg.calendarPar)
        compareMaps(result.enumPar, msg.enumPar)
        compareMaps(result.ssmPar, msg.ssmPar)
        compareMaps(result.ptPar, msg.ptPar)
        compareMaps(result.charPar, msg.charPar)


      }
    }

    it("will serialize SimpleMapArrayValueMessage Full") {
      val tm = messages("SimpleMapArrayValueMessage Full")
      val msg = tm._2.asInstanceOf[SimpleMapArrayValueMessage[K]]
      doSerializationWithType[SimpleMapArrayValueMessage[K]](msg,  compareSimpleMapArrayValueMessage(msg))
    }

    it("will serialize SimpleMapArrayValueMessage Empty Value") {
      val tm = messages("SimpleMapArrayValueMessage Empty Value")
      val msg = tm._2.asInstanceOf[SimpleMapArrayValueMessage[K]]
      doSerializationWithType[SimpleMapArrayValueMessage[K]](msg,  compareSimpleMapArrayValueMessage(msg))
    }

  }
 */
}
