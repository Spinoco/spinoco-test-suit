package com.spinoco.testsuit

import scala.Array
import java.util.{TimeZone, Calendar, Date}
import org.bson.types.ObjectId
import org.joda.time.DateTime

/**
 *
 * User: pach
 * Date: 10/5/12
 * Time: 1:04 PM
 * (c) 2011-2012 Spinoco Czech Republic, a.s.
 */
trait ArrayLikeSpecs extends SerializerFactorySpecs {

  def arrayLikeTests() = {

    ////ARRAY

    describe("for Array") {

      def SimpleArrayMessageEqTest(msg: SimpleArrayMessage) = {
        (result: SimpleArrayMessage) => {
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
          result.dateTimePar should be(msg.dateTimePar)
          result.enumPar should be(msg.enumPar)
          result.ssmPar should be(msg.ssmPar)
          result.ptPar should be(msg.ptPar)
        }
      }

      def SimpleArrayOptionMessageEqTest(msg: SimpleArrayOptionMessage) = {
        (result: SimpleArrayOptionMessage) => {
          result.boolPar.get should be(msg.boolPar.get)
          result.bytePar.get should be(msg.bytePar.get)
          result.shortPar.get should be(msg.shortPar.get)
          result.intPar.get should be(msg.intPar.get)
          result.longPar.get should be(msg.longPar.get)
          result.doublePar.get should be(msg.doublePar.get)
          result.floatPar.get should be(msg.floatPar.get)
          result.stringPar.get should be(msg.stringPar.get)
          result.objIdPar.get should be(msg.objIdPar.get)
          result.idPar.get should be(msg.idPar.get)
          result.datePar.get should be(msg.datePar.get)
          result.calendarPar.get should be(msg.calendarPar.get)
          result.dateTimePar.get should be(msg.dateTimePar.get)
          result.enumPar.get should be(msg.enumPar.get)
          result.ssmPar.get should be(msg.ssmPar.get)
          result.ptPar.get should be(msg.ptPar.get)
        }
      }



      it("should serialize simple array message") {
        val msg = SimpleArrayMessage(Array(true, false, true), Array(1.toByte, 2.toByte), Array(2.toShort, 0.toShort), Array(3, 4, 9000), Array(4L, 2338484848484L), Array(2.2, 0.98736455543), Array(4.4f, 9.938474655f),
          Array("OMG String here !!", "and here "), Array(new ObjectId(), new ObjectId()), Array(Id.generate, Id.generate),
          Array(new Date(System.currentTimeMillis()), new Date(0)), Array(Calendar.getInstance(), Calendar.getInstance(TimeZone.getTimeZone("-02:00"))),
          Array(new DateTime(2012-10-10), new DateTime(0)),
          Array(EnumForTest.ENUM_ONE, EnumForTest.ENUM_THREE),
          Array(SimpleStringMessage("first"), SimpleStringMessage("first-two")), Array(SimpleStringMessage("second")))


        doSerialization[SimpleArrayMessage](msg, SimpleArrayMessageEqTest(msg))


      }

      it("should serialize simple array message with empty arrays") {
        val msg = SimpleArrayMessage(Array(), Array(), Array(), Array(), Array(), Array(), Array(),
          Array(), Array(), Array(), Array(), Array(), Array(),
          Array(), Array(), Array())


        doSerialization[SimpleArrayMessage](msg, SimpleArrayMessageEqTest(msg))
      }


      it("should serialize simple optional array message") {
        val msg = SimpleArrayOptionMessage(Some(Array(true, false, true)), Some(Array(1.toByte, 2.toByte)), Some(Array(2.toShort, 0.toShort)), Some(Array(3, 4, 9000)), Some(Array(4L, 2338484848484L)), Some(Array(2.2, 0.98736455543)), Some(Array(4.4f, 9.938474655f)),
          Some(Array("OMG String here !!", "and here ")), Some(Array(new ObjectId(), new ObjectId())), Some(Array(Id.generate, Id.generate)),
          Some(Array(new Date(System.currentTimeMillis()), new Date(0))), Some(Array(Calendar.getInstance(), Calendar.getInstance(TimeZone.getTimeZone("-02:00")))),
          Some(Array(new DateTime(2012-10-10), new DateTime(0))),
          Some(Array(EnumForTest.ENUM_ONE, EnumForTest.ENUM_THREE)),
          Some(Array(SimpleStringMessage("first"), SimpleStringMessage("first-two"))), Some(Array(SimpleStringMessage("second"))))


        doSerialization[SimpleArrayOptionMessage](msg, SimpleArrayOptionMessageEqTest(msg))

      }

      it("should serialize optional array message with empty arrays") {
        val msg = SimpleArrayOptionMessage(Some(Array()), Some(Array()), Some(Array()),
          Some(Array()), Some(Array()), Some(Array()),
          Some(Array()), Some(Array()), Some(Array()),
          Some(Array()), Some(Array()), Some(Array()), Some(Array()),
          Some(Array()), Some(Array()), Some(Array()))
        doSerialization(msg, SimpleArrayOptionMessageEqTest(msg))
      }

      it("should serialize optional array message with empty options") {
        val msg = SimpleArrayOptionMessage(None, None, None, None,
          None, None, None,
          None, None, None,
          None, None, None,
          None, None, None)

        doSerialization[SimpleArrayOptionMessage](msg, result => {
          result.boolPar should be(empty)
          result.bytePar should be(empty)
          result.shortPar should be(empty)
          result.intPar should be(empty)
          result.longPar should be(empty)
          result.doublePar should be(empty)
          result.floatPar should be(empty)
          result.stringPar should be(empty)
          result.objIdPar should be(empty)
          result.idPar should be(empty)
          result.datePar should be(empty)
          result.calendarPar should be(empty)
          result.dateTimePar should be(empty)
          result.enumPar should be(empty)
          result.ssmPar should be(empty)
          result.ptPar should be(empty)
        })
      }

    }


    ///////////////////////////////////////
    //SET

    describe("for Set") {
      it("should serialize simple Set message") {
        val msg = SimpleSetMessage(Set(true, false, true), Set(1.toByte, 2.toByte), Set(2.toShort, 0.toShort), Set(3, 4, 9000), Set(4L, 2338484848484L), Set(2.2, 0.98736455543), Set(4.4f, 9.938474655f),
          Set("OMG String here !!", "and here "), Set(new ObjectId(), new ObjectId()), Set(Id.generate, Id.generate),
          Set(new Date(System.currentTimeMillis()), new Date(0)), Set(Calendar.getInstance(), Calendar.getInstance(TimeZone.getTimeZone("-02:00"))),
          Set(new DateTime(2012-10-10), new DateTime(0)),
          Set(EnumForTest.ENUM_ONE, EnumForTest.ENUM_THREE),
          Set(SimpleStringMessage("first"), SimpleStringMessage("first-two")), Set(SimpleStringMessage("second")))
        doSerialization(msg)


      }


      it("should serialize simple Set message with empty sets") {
        val msg = SimpleSetMessage(Set(), Set(), Set(), Set(), Set(), Set(), Set(),
          Set(), Set(), Set(), Set(), Set(), Set(), Set(),
          Set(), Set())
        doSerialization(msg)
      }


      it("should serialize simple optional Set message") {
        val msg = SimpleOptionSetMessage(Some(Set(true, false, true)), Some(Set(1.toByte, 2.toByte)), Some(Set(2.toShort, 0.toShort)),
          Some(Set(3, 4, 9000)), Some(Set(4L, 2338484848484L)), Some(Set(2.2, 0.98736455543)), Some(Set(4.4f, 9.938474655f)),
          Some(Set("OMG String here !!", "and here ")), Some(Set(new ObjectId, new ObjectId)), Some(Set(Id.generate, Id.generate)),
          Some(Set(new Date(System.currentTimeMillis()), new Date(0))), Some(Set(Calendar.getInstance(), Calendar.getInstance(TimeZone.getTimeZone("-02:00")))),
          Some(Set(new DateTime(2012-10-10), new DateTime(0))),
          Some(Set(EnumForTest.ENUM_ONE, EnumForTest.ENUM_THREE)),
          Some(Set(SimpleStringMessage("first"), SimpleStringMessage("first-two"))), Some(Set(SimpleStringMessage("second"))))
        doSerialization(msg)


      }

      it("should serialize simple optional set message with empty sets") {
        val msg = SimpleOptionSetMessage(Some(Set()), Some(Set()), Some(Set()), Some(Set()),
          Some(Set()), Some(Set()), Some(Set()),
          Some(Set()), Some(Set()), Some(Set()),
          Some(Set()), Some(Set()), Some(Set()),
          Some(Set()), Some(Set()), Some(Set()))
        doSerialization(msg)
      }

      it("shoudl serialize simple optional set message with empty options ") {
        val msg = SimpleOptionSetMessage(None, None, None, None,
          None, None, None,
          None, None, None,
          None, None, None,
          None, None, None)

        doSerialization(msg)
      }


    }


    ///////////////////////////////////////
    //SEQ

    describe("for Seq") {


      it("should serialize simple Seq message") {
        val msg = SimpleSeqMessage(
          Seq(true, false, true), Seq(1.toByte, 2.toByte), Seq(2.toShort, 0.toShort), Seq(3, 4, 9000), Seq(4L, 2338484848484L), Seq(2.2, 0.98736455543), Seq(4.4f, 9.938474655f),
          Seq("OMG String here !!", "and here "), Seq(new ObjectId(), new ObjectId()), Seq(Id.generate, Id.generate),
          Seq(new Date(System.currentTimeMillis()), new Date(0)), Seq(Calendar.getInstance(), Calendar.getInstance(TimeZone.getTimeZone("-02:00"))),
          Seq(new DateTime(2012-10-10), new DateTime(0)),
          Seq(EnumForTest.ENUM_ONE, EnumForTest.ENUM_THREE),
          Seq(SimpleStringMessage("first"), SimpleStringMessage("first-two")), Seq(SimpleStringMessage("second")))
        doSerialization(msg)


      }

      it("should serialize simple Seq message with empty Seq") {
        val msg = SimpleSeqMessage(Seq(), Seq(), Seq(), Seq(), Seq(), Seq(), Seq(),
          Seq(), Seq(), Seq(), Seq(), Seq(), Seq(), Seq(),
          Seq(), Seq())
        doSerialization(msg)
      }


      it("should serialize simple optional Seq message") {
        val msg = SimpleOptionSeqMessage(
          Some(Seq(true, false, true)), Some(Seq(1.toByte, 2.toByte)), Some(Seq(2.toShort, 0.toShort)),
          Some(Seq(3, 4, 9000)), Some(Seq(4L, 2338484848484L)), Some(Seq(2.2, 0.98736455543)), Some(Seq(4.4f, 9.938474655f)),
          Some(Seq("OMG String here !!", "and here ")), Some(Seq(new ObjectId(), new ObjectId())), Some(Seq(Id.generate, Id.generate)),
          Some(Seq(new Date(System.currentTimeMillis()), new Date(0))), Some(Seq(Calendar.getInstance(), Calendar.getInstance(TimeZone.getTimeZone("-02:00")))),
          Some(Seq(new DateTime(2012-10-10), new DateTime(0))),
          Some(Seq(EnumForTest.ENUM_ONE, EnumForTest.ENUM_THREE)),
          Some(Seq(SimpleStringMessage("first"), SimpleStringMessage("first-two"))), Some(Seq(SimpleStringMessage("second"))))
        doSerialization(msg)


      }

      it("should serialize simple optional Seq message with empty seq") {
        val msg = SimpleOptionSeqMessage(Some(Seq()), Some(Seq()), Some(Seq()), Some(Seq()),
          Some(Seq()), Some(Seq()), Some(Seq()),
          Some(Seq()), Some(Seq()), Some(Seq()),
          Some(Seq()), Some(Seq()), Some(Seq()),
          Some(Seq()), Some(Seq()), Some(Seq()))
        doSerialization(msg)
      }

      it("should serialize simple optional Seq message with empty options ") {
        val msg = SimpleOptionSeqMessage(None, None, None, None,
          None, None, None,
          None, None, None,
          None, None, None,
          None, None, None)

        doSerialization(msg)
      }

    }


    ///////////////////////////////////////
    //LIST

    describe("for List") {

      it("should serialize simple List message") {

        val msg = SimpleListMessage(List(true, false, true), List(1.toByte, 2.toByte), List(2.toShort, 0.toShort), List(3, 4, 9000), List(4L, 2338484848484L), List(2.2, 0.98736455543), List(4.4f, 9.938474655f),
          List("OMG String here !!", "and here "), List(new ObjectId(), new ObjectId()), List(Id.generate, Id.generate),
          List(new Date(System.currentTimeMillis()), new Date(0)), List(Calendar.getInstance(), Calendar.getInstance(TimeZone.getTimeZone("-02:00"))),
          List(new DateTime(2012-10-10), new DateTime(0)),
          List(EnumForTest.ENUM_ONE, EnumForTest.ENUM_THREE),
          List(SimpleStringMessage("first"), SimpleStringMessage("first-two")), List(SimpleStringMessage("second")))
        doSerialization(msg)


      }

      it("should serialize simple List message with empty lists") {
        val msg = SimpleListMessage(List(), List(), List(), List(), List(), List(), List(), List(),
          List(), List(), List(), List(), List(), List(),
          List(), List())
        doSerialization(msg)
      }

      it("should serialize simple optional List message") {
        val msg = SimpleOptionSeqMessage(Some(List(true, false, true)), Some(List(1.toByte, 2.toByte)), Some(List(2.toShort, 0.toShort)),
          Some(List(3, 4, 9000)), Some(List(4L, 2338484848484L)), Some(List(2.2, 0.98736455543)), Some(List(4.4f, 9.938474655f)),
          Some(List("OMG String here !!", "and here ")), Some(List(new ObjectId(), new ObjectId())), Some(List(Id.generate, Id.generate)),
          Some(List(new Date(System.currentTimeMillis()), new Date(0))), Some(List(Calendar.getInstance(), Calendar.getInstance(TimeZone.getTimeZone("-02:00")))),
          Some(List(new DateTime(2012-10-10), new DateTime(0))),
          Some(List(EnumForTest.ENUM_ONE, EnumForTest.ENUM_THREE)),
          Some(List(SimpleStringMessage("first"), SimpleStringMessage("first-two"))), Some(List(SimpleStringMessage("second"))))
        doSerialization(msg)


      }

      it("should serialize simple optional List message with empty lists") {

        val msg = SimpleOptionSeqMessage(Some(List()), Some(List()), Some(List()), Some(List()),
          Some(List()), Some(List()), Some(List()),
          Some(List()), Some(List()), Some(List()),
          Some(List()), Some(List()), Some(List()),
          Some(List()), Some(List()), Some(List()))
        doSerialization(msg)
      }

      it("should serialize simple optional List message with empty options") {
        val msg = SimpleOptionSeqMessage(None, None, None, None,
          None, None, None,
          None, None, None,
          None, None, None,
          None, None, None)

        doSerialization(msg)
      }
    }


  }


}
