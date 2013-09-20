package com.spinoco.testsuit

import java.util.{Calendar, Date}
import org.joda.time.DateTime
import org.bson.types.ObjectId

/**
 *
 * User: pach
 * Date: 10/5/12
 * Time: 12:54 PM
 * (c) 2011-2012 Spinoco Czech Republic, a.s.
 */
trait BasicSerializerSpecs extends SerializerFactorySpecs {
  def basicTests() = {
    it("should serialize simple type message") {
      doSerialization(SimpleMessage(true, 1, 2, 3, 4L, 2.2, 4.4f, "OMG String here !!",
        new ObjectId(), Id.generate, new Date(System.currentTimeMillis()), Calendar.getInstance(), new DateTime(0),
        EnumForTest.ENUM_ONE,
        SimpleStringMessage("first"), SimpleStringMessage("second")
      ))
    }
    it("should serialize simple option message") {
      doSerialization(SimpleOptionMessage(Some(true), Some(1.toByte), Some(2.toShort), Some(3), Some(4L), Some(2.2), Some(4.4f),
        Some("OMG String here !!"), Some(new ObjectId()), Some(Id.generate),
        Some(new Date(System.currentTimeMillis())), Some(Calendar.getInstance()), Some(new DateTime(0)), Some(EnumForTest.ENUM_ONE),
        Some(SimpleStringMessage("first")), Some(SimpleStringMessage("second"))
      ))
      doSerialization(SimpleOptionMessage(None, None, None, None, None, None, None,
        None, None, None, None, None, None, None,
        None, None
      ))
    }

    it("should serialize simple either message") {
      doSerialization(SimpleEitherMessage(Right(true), Right(1.toByte), Right(2.toShort), Right(3), Right(4L), Right(2.2), Right(4.4f),
        Right("OMG String here !!"), Right(new ObjectId()), Right(Id.generate),
        Right(new Date(System.currentTimeMillis())), Right(Calendar.getInstance()), Right(new DateTime(0)), Right(EnumForTest.ENUM_ONE),
        Right(SimpleStringMessage("first")), Right(SimpleStringMessage("second"))
      ))

      doSerialization(SimpleEitherMessage(Left(true), Left(true), Left(true), Left(true), Left(true), Left(true), Left(true),
        Left(true), Left(true), Left(true),
        Left(true), Left(true), Left(true),
        Left(true), Left(true), Left(true)
      ))
    }
    //SimpleEitherOptionMessage
    it("should serialize either message with options Rights - Full ") {
      doSerialization(SimpleEitherOptionMessage(Right(Option(true)), Right(Option(1.toByte)), Right(Option(2.toShort)), Right(Option(3)), Right(Option(4L)), Right(Option(2.2)), Right(Option(4.4f)),
        Right(Option("OMG String here !!")), Right(Option(new ObjectId())), Right(Option(Id.generate)),
        Right(Option(new Date(System.currentTimeMillis()))), Right(Option(Calendar.getInstance())), Right(Option(new DateTime(0))), Right(Option(EnumForTest.ENUM_ONE)),
        Right(Option(SimpleStringMessage("first"))), Right(Option(SimpleStringMessage("second")))
      ))
    }

    it("should serialize either message with options Rights - Empty ") {
      doSerialization(SimpleEitherOptionMessage(Right(None), Right(None), Right(None), Right(None), Right(None), Right(None),
        Right(None), Right(None), Right(None), Right(None), Right(None),
        Right(None), Right(None), Right(None), Right(None), Right(None)))
    }

    it("should serialize either message with options Lefts - Full ") {
      doSerialization(SimpleEitherOptionMessage(Left(Option(true)), Left(Option(true)), Left(Option(true)), Left(Option(true)), Left(Option(true)), Left(Option(true)),
        Left(Option(true)), Left(Option(true)), Left(Option(true)), Left(Option(true)), Left(Option(true)),
        Left(Option(true)), Left(Option(true)), Left(Option(true)), Left(Option(true)), Left(Option(true))
      ))
    }

    it("should serialize either message with options Letfs - Empty ") {
      doSerialization(SimpleEitherOptionMessage(Left(None), Left(None), Left(None), Left(None), Left(None), Left(None),
        Left(None), Left(None), Left(None), Left(None), Left(None), Left(None),
        Left(None), Left(None), Left(None), Left(None)))
    }



    it("should serialize option message with eithers Full Right") {
      doSerialization(SimpleOptionEitherMessage(Option(Right(true)), Option(Right(1.toByte)), Option(Right(2.toShort)), Option(Right(3)), Option(Right(4L)), Option(Right(2.2)), Option(Right(4.4f)),
        Option(Right("OMG String here !!")), Option(Right(new ObjectId())), Option(Right(Id.generate)),
        Option(Right(new Date(System.currentTimeMillis()))), Option(Right(Calendar.getInstance())), Option(Right(new DateTime(0))), Option(Right(EnumForTest.ENUM_ONE)),
        Option(Right(SimpleStringMessage("first"))), Option(Right(SimpleStringMessage("second")))
      ))
    }

    it("should serialize option message with eithers Full Left") {
      doSerialization(SimpleOptionEitherMessage(Option(Left(true)), Option(Left(true)), Option(Left(true)), Option(Left(true)), Option(Left(true)), Option(Left(true)), Option(Left(true)),
        Option(Left(true)), Option(Left(true)), Option(Left(true)),
        Option(Left(true)), Option(Left(true)), Option(Left(true)),
        Option(Left(true)), Option(Left(true)), Option(Left(true))
      ))
    }

    it("should serialize option message with eithers Empty") {
      doSerialization(SimpleOptionEitherMessage(None, None, None, None, None, None,
        None, None, None, None, None, None,
        None, None, None, None))
    }


    it("should serialize empty Object Message") {
      doSerialization(EmptyObjectMessage)
    }

    it("should serialize simple abstract nested object message") {
      doSerialization(NestedAbstractObjectMessage(EmptyObjectMessage))
    }

  }
}
