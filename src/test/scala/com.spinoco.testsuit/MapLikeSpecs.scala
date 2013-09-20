package com.spinoco.testsuit


import java.util.{Date, TimeZone, Calendar}
import org.bson.types.ObjectId
import org.joda.time.DateTime
import reflect.runtime.universe._
import reflect.ClassTag

/**
 *
 * User: pach
 * Date: 10/5/12
 * Time: 2:54 PM
 * (c) 2011-2012 Spinoco Czech Republic, a.s.
 */
trait MapLikeSpecs extends BasicSerializerSpecs {

  def prepareMapTest[K](implicit keyTypeTag: TypeTag[K]) = {

    val mapValues =
      Map[Type, Seq[Any]](
        typeOf[Boolean] -> Seq(true, false, false),
        typeOf[Byte] -> Seq(1.toByte, 2.toByte, 3.toByte),
        typeOf[Short] -> Seq(1.toShort, 2.toShort, 3.toShort),
        typeOf[Int] -> Seq(1, 2, 3),
        typeOf[Long] -> Seq(123456789L, 987654321L, 456328291L),
        typeOf[Double] -> Seq(0.234, 0.67543, 234.789),
        typeOf[Float] -> Seq(0.34f, 765.534f, 34f),
        typeOf[String] -> Seq("one", "two", "three"),
        typeOf[Char] -> Seq('q', 'w', 'e'),
        typeOf[ObjectId] -> Seq(new ObjectId, new ObjectId, new ObjectId),
        typeOf[Id] -> Seq(Id.generate, Id.generate, Id.generate),
        typeOf[Date] -> Seq(new Date(System.currentTimeMillis()), new Date(0), new Date(Long.MaxValue)),
        typeOf[Calendar] -> Seq(Calendar.getInstance(), Calendar.getInstance(TimeZone.getTimeZone("-10:00")), Calendar.getInstance(TimeZone.getTimeZone("+11:00"))),
        typeOf[DateTime] -> Seq(new DateTime("2012-02-10"), new DateTime(0)),
        typeOf[EnumForTest.Value] -> Seq(EnumForTest.ENUM_ONE, EnumForTest.ENUM_THREE, EnumForTest.ENUM_TWO),
        typeOf[SimpleStringMessage] -> Seq(SimpleStringMessage("one"), SimpleStringMessage("two"), SimpleStringMessage("three")),
        typeOf[ProtocolTest] -> Seq(SimpleStringMessage("one"), SimpleStringMessage("two"), SimpleStringMessage("three"))
      )




    def createTestMessages[K](keyFactory: (Int) => K) = {

      def extractValues[V](implicit tt: TypeTag[V]): Seq[V] = mapValues(tt.tpe).map(_.asInstanceOf[V])

      def createKV[CK, V](values: Seq[V]): Map[CK, V] = {


        var i = 0
        values.map(v => {
          val entry = (keyFactory(i).asInstanceOf[CK], v)
          i = i + 1
          entry
        }).toMap
      }

      def createKVArray[CK, V](values: Seq[V]): Array[Map[CK, V]] = {
        Array(createKV[CK, V](values), createKV[CK, V](values).tail, createKV[CK, V](values).init)
      }
      def createKVSeq[CK, V](values: Seq[V]): Seq[Map[CK, V]] = {
        Seq(createKV[CK, V](values), createKV[CK, V](values).tail, createKV[CK, V](values).init)
      }

      def createKVOption[CK, V](values: Seq[V], full: Boolean = true): Map[CK, Option[V]] = {
        if (full) {
          createKV[CK, V](values).map(e => (e._1, Some(e._2)))
        } else {
          createKV[CK, V](values).map(e => (e._1, None))
        }

      }

      def createKVNestedArray[V](values: Seq[V], full: Boolean = true)(implicit ct: ClassTag[V]): Map[K, Array[V]] = {

        if (full) {
          Map(keyFactory(0) -> values.toArray, keyFactory(1) -> values.toArray.tail, keyFactory(2) -> values.toArray.init)
        } else {
          Map(keyFactory(0) -> ct.newArray(0), keyFactory(1) -> ct.newArray(0), keyFactory(2) -> ct.newArray(0))
        }


      }

      def createKVNestedSeq[V](values: Seq[V], full: Boolean = true): Map[K, Seq[V]] = {
        if (full) {
          Map(keyFactory(0) -> values, keyFactory(1) -> values.tail, keyFactory(2) -> values.init)
        } else {
          Map(keyFactory(0) -> Seq[V](), keyFactory(1) -> Seq[V](), keyFactory(2) -> Seq[V]())
        }


      }

      val messages =
        Map("SimpleMapMessage" ->
            SimpleMapMessage[K](
              createKV(extractValues[Boolean]),
              createKV(extractValues[Byte]),
              createKV(extractValues[Short]),
              createKV(extractValues[Int]),
              createKV(extractValues[Long]),
              createKV(extractValues[Double]),
              createKV(extractValues[Float]),
              createKV(extractValues[String]),
              createKV(extractValues[Char]),
              createKV(extractValues[ObjectId]),
              createKV(extractValues[Id]),
              createKV(extractValues[Date]),
              createKV(extractValues[Calendar]),
              createKV(extractValues[DateTime]),
              createKV(extractValues[EnumForTest.Value]),
              createKV(extractValues[SimpleStringMessage]),
              createKV(extractValues[ProtocolTest])
            ),
          "SimpleMapOptionMessage Full" -> SimpleMapOptionMessage[K](
            Some(createKV(extractValues[Boolean])),
            Some(createKV(extractValues[Byte])),
            Some(createKV(extractValues[Short])),
            Some(createKV(extractValues[Int])),
            Some(createKV(extractValues[Long])),
            Some(createKV(extractValues[Double])),
            Some(createKV(extractValues[Float])),
            Some(createKV(extractValues[String])),
            Some(createKV(extractValues[Char])),
            Some(createKV(extractValues[ObjectId])),
            Some(createKV(extractValues[Id])),
            Some(createKV(extractValues[Date])),
            Some(createKV(extractValues[Calendar])),
            Some(createKV(extractValues[DateTime])),
            Some(createKV(extractValues[EnumForTest.Value])),
            Some(createKV(extractValues[SimpleStringMessage])),
            Some(createKV(extractValues[ProtocolTest]))
          ),


          "SimpleMapOptionMessage Empty" -> SimpleMapOptionMessage[K](None, None, None, None, None,
            None, None, None, None, None, None, None,
            None, None, None, None, None),

          "SimpleMapOptionMessage EmptyMap" -> SimpleMapOptionMessage[K](Some(Map()), Some(Map()), Some(Map()), Some(Map()), Some(Map()),
            Some(Map()), Some(Map()), Some(Map()), Some(Map()), Some(Map()), Some(Map()),
            Some(Map()), Some(Map()), Some(Map()), Some(Map()), Some(Map()), Some(Map())),

          "SimpleMapArrayMessage Full" -> SimpleMapArrayMessage[K](createKVArray(extractValues[Boolean]),
            createKVArray(extractValues[Byte]),
            createKVArray(extractValues[Short]),
            createKVArray(extractValues[Int]),
            createKVArray(extractValues[Long]),
            createKVArray(extractValues[Double]),
            createKVArray(extractValues[Float]),
            createKVArray(extractValues[String]),
            createKVArray(extractValues[Char]),
            createKVArray(extractValues[ObjectId]),
            createKVArray(extractValues[Id]),
            createKVArray(extractValues[Date]),
            createKVArray(extractValues[Calendar]),
            createKVArray(extractValues[DateTime]),
            createKVArray(extractValues[EnumForTest.Value]),
            createKVArray(extractValues[SimpleStringMessage]),
            createKVArray(extractValues[ProtocolTest])
          ),
          "SimpleMapArrayMessage Empty" -> SimpleMapArrayMessage[K](Array(), Array(), Array(), Array(), Array(),
            Array(), Array(), Array(), Array(), Array(), Array(),
            Array(), Array(), Array(), Array(), Array(), Array()
          ),
          "SimpleMapArrayMessage Empty Map" -> SimpleMapArrayMessage[K](Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map()),
            Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map()),
            Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map()), Array(Map(), Map())
          ),

          "SimpleMapSeqMessage Full" -> SimpleMapSeqMessage[K](createKVSeq(extractValues[Boolean]),
            createKVSeq(extractValues[Byte]),
            createKVSeq(extractValues[Short]),
            createKVSeq(extractValues[Int]),
            createKVSeq(extractValues[Long]),
            createKVSeq(extractValues[Double]),
            createKVSeq(extractValues[Float]),
            createKVSeq(extractValues[String]),
            createKVSeq(extractValues[Char]),
            createKVSeq(extractValues[ObjectId]),
            createKVSeq(extractValues[Id]),
            createKVSeq(extractValues[Date]),
            createKVSeq(extractValues[Calendar]),
            createKVSeq(extractValues[DateTime]),
            createKVSeq(extractValues[EnumForTest.Value]),
            createKVSeq(extractValues[SimpleStringMessage]),
            createKVSeq(extractValues[ProtocolTest])
          ),
          "SimpleMapSeqMessage Empty" -> SimpleMapSeqMessage[K](Seq(), Seq(), Seq(), Seq(), Seq(),
            Seq(), Seq(), Seq(), Seq(), Seq(), Seq(),
            Seq(), Seq(), Seq(), Seq(), Seq(), Seq()
          ),
          "SimpleMapSeqMessage Empty Map" -> SimpleMapSeqMessage[K](Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map()),
            Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map()),
            Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map()), Seq(Map(), Map())
          ),

          "SimpleMapOptionValueMessage Full" -> SimpleMapOptionValueMessage[K](createKVOption(extractValues[Boolean]),
            createKVOption(extractValues[Byte]),
            createKVOption(extractValues[Short]),
            createKVOption(extractValues[Int]),
            createKVOption(extractValues[Long]),
            createKVOption(extractValues[Double]),
            createKVOption(extractValues[Float]),
            createKVOption(extractValues[String]),
            createKVOption(extractValues[Char]),
            createKVOption(extractValues[ObjectId]),
            createKVOption(extractValues[Id]),
            createKVOption(extractValues[Date]),
            createKVOption(extractValues[Calendar]),
            createKVOption(extractValues[DateTime]),
            createKVOption(extractValues[EnumForTest.Value]),
            createKVOption(extractValues[SimpleStringMessage]),
            createKVOption(extractValues[ProtocolTest])

          ),

          "SimpleMapOptionValueMessage Empty Map" -> SimpleMapOptionValueMessage[K](Map(), Map(), Map(), Map(), Map(),
            Map(), Map(), Map(), Map(), Map(), Map(),
            Map(), Map(), Map(), Map(), Map(), Map()

          ),

          "SimpleMapOptionValueMessage Empty Value" -> SimpleMapOptionValueMessage[K](createKVOption(extractValues[Boolean], full = false),
            createKVOption(extractValues[Byte], full = false),
            createKVOption(extractValues[Short], full = false),
            createKVOption(extractValues[Int], full = false),
            createKVOption(extractValues[Long], full = false),
            createKVOption(extractValues[Double], full = false),
            createKVOption(extractValues[Float], full = false),
            createKVOption(extractValues[String], full = false),
            createKVOption(extractValues[Char], full = false),
            createKVOption(extractValues[ObjectId], full = false),
            createKVOption(extractValues[Id], full = false),
            createKVOption(extractValues[Date], full = false),
            createKVOption(extractValues[Calendar], full = false),
            createKVOption(extractValues[DateTime], full = false),
            createKVOption(extractValues[EnumForTest.Value], full = false),
            createKVOption(extractValues[SimpleStringMessage], full = false),
            createKVOption(extractValues[ProtocolTest], false)

          ),

          "SimpleMapArrayValueMessage Full" -> SimpleMapArrayValueMessage[K](createKVNestedArray(extractValues[Boolean]),
            createKVNestedArray(extractValues[Byte]),
            createKVNestedArray(extractValues[Short]),
            createKVNestedArray(extractValues[Int]),
            createKVNestedArray(extractValues[Long]),
            createKVNestedArray(extractValues[Double]),
            createKVNestedArray(extractValues[Float]),
            createKVNestedArray(extractValues[String]),
            createKVNestedArray(extractValues[Char]),
            createKVNestedArray(extractValues[ObjectId]),
            createKVNestedArray(extractValues[Id]),
            createKVNestedArray(extractValues[Date]),
            createKVNestedArray(extractValues[Calendar]),
            createKVNestedArray(extractValues[DateTime]),
            createKVNestedArray(extractValues[EnumForTest.Value]),
            createKVNestedArray(extractValues[SimpleStringMessage]),
            createKVNestedArray(extractValues[ProtocolTest])),

          "SimpleMapArrayValueMessage Empty Value" -> SimpleMapArrayValueMessage[K](createKVNestedArray(extractValues[Boolean], full = false),
            createKVNestedArray(extractValues[Byte], full = false),
            createKVNestedArray(extractValues[Short], full = false),
            createKVNestedArray(extractValues[Int], full = false),
            createKVNestedArray(extractValues[Long], full = false),
            createKVNestedArray(extractValues[Double], full = false),
            createKVNestedArray(extractValues[Float], full = false),
            createKVNestedArray(extractValues[String], full = false),
            createKVNestedArray(extractValues[Char], full = false),
            createKVNestedArray(extractValues[ObjectId], full = false),
            createKVNestedArray(extractValues[Id], full = false),
            createKVNestedArray(extractValues[Date], full = false),
            createKVNestedArray(extractValues[Calendar], full = false),
            createKVNestedArray(extractValues[DateTime], full = false),
            createKVNestedArray(extractValues[EnumForTest.Value], full = false),
            createKVNestedArray(extractValues[SimpleStringMessage], full = false),
            createKVNestedArray(extractValues[ProtocolTest], false)),

          "SimpleMapSeqValueMessage Full" -> SimpleMapSeqValueMessage[K](createKVNestedSeq(extractValues[Boolean]),
            createKVNestedSeq(extractValues[Byte]),
            createKVNestedSeq(extractValues[Short]),
            createKVNestedSeq(extractValues[Int]),
            createKVNestedSeq(extractValues[Long]),
            createKVNestedSeq(extractValues[Double]),
            createKVNestedSeq(extractValues[Float]),
            createKVNestedSeq(extractValues[String]),
            createKVNestedSeq(extractValues[Char]),
            createKVNestedSeq(extractValues[ObjectId]),
            createKVNestedSeq(extractValues[Id]),
            createKVNestedSeq(extractValues[Date]),
            createKVNestedSeq(extractValues[Calendar]),
            createKVNestedSeq(extractValues[DateTime]),
            createKVNestedSeq(extractValues[EnumForTest.Value]),
            createKVNestedSeq(extractValues[SimpleStringMessage]),
            createKVNestedSeq(extractValues[ProtocolTest])),

          "SimpleMapSeqValueMessage Empty Value" -> SimpleMapSeqValueMessage[K](createKVNestedSeq(extractValues[Boolean], full = false),
            createKVNestedSeq(extractValues[Byte], full = false),
            createKVNestedSeq(extractValues[Short], full = false),
            createKVNestedSeq(extractValues[Int], full = false),
            createKVNestedSeq(extractValues[Long], full = false),
            createKVNestedSeq(extractValues[Double], full = false),
            createKVNestedSeq(extractValues[Float], full = false),
            createKVNestedSeq(extractValues[String], full = false),
            createKVNestedSeq(extractValues[Char], full = false),
            createKVNestedSeq(extractValues[ObjectId], full = false),
            createKVNestedSeq(extractValues[Id], full = false),
            createKVNestedSeq(extractValues[Date], full = false),
            createKVNestedSeq(extractValues[Calendar], full = false),
            createKVNestedSeq(extractValues[DateTime], full = false),
            createKVNestedSeq(extractValues[EnumForTest.Value], full = false),
            createKVNestedSeq(extractValues[SimpleStringMessage], full = false),
            createKVNestedSeq(extractValues[ProtocolTest], false))

        )

      messages
    }

    val keys = Map[Type, Map[Int, _]](
      typeOf[String] -> Map[Int, Any](0 -> "one", 1 -> "two", 2 -> "three"),
      typeOf[Boolean] -> Map[Int, Any](0 -> true, 1 -> false, 2 -> true),
      typeOf[Byte] -> Map[Int, Any](0 -> 33, 1 -> 44, 2 -> 55),
      typeOf[Short] -> Map[Int, Any](0 -> 333, 1 -> 444, 2 -> 555),
      typeOf[Int] -> Map[Int, Any](0 -> 3333, 1 -> 4444, 2 -> 5555),
      typeOf[Long] -> Map[Int, Any](0 -> 33L, 1 -> 444L, 2 -> 5555L),
      typeOf[Double] -> Map[Int, Any](0 -> 3.2, 1 -> 3.4, 2 -> 4.5),
      typeOf[Float] -> Map[Int, Any](0 -> 3.2f, 1 -> 3.4f, 2 -> 4.5f),
      typeOf[Char] -> Map[Int, Any](0 -> 'a', 1 -> 'b', 2 -> 'c'),
      typeOf[ObjectId] -> Map[Int, Any](0 -> new ObjectId, 1 -> new ObjectId, 2 -> new ObjectId),
      typeOf[Id] -> Map[Int, Any](0 -> Id.generate, 1 -> Id.generate, 2 -> Id.generate),
      typeOf[Date] -> Map[Int, Any](0 -> new Date(), 1 -> new Date(0), 2 -> new Date(Long.MaxValue)),
      typeOf[EnumForTest.Value] -> Map[Int, Any](0 -> EnumForTest.ENUM_ONE, 1 -> EnumForTest.ENUM_TWO, 2 -> EnumForTest.ENUM_THREE)
    )


    val messageTypes = Map[Type, Map[String, Type]](
      typeOf[String] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[String]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[String]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[String]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[String]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[String]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[String]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[String]]

      ),
      typeOf[Boolean] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[Boolean]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[Boolean]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[Boolean]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[Boolean]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[Boolean]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[Boolean]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[Boolean]]

      ),
      typeOf[Byte] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[Byte]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[Byte]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[Byte]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[Byte]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[Byte]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[Byte]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[Byte]]

      ),
      typeOf[Short] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[Short]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[Short]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[Short]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[Short]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[Short]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[Short]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[Short]]

      ),
      typeOf[Int] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[Int]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[Int]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[Int]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[Int]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[Int]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[Int]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[Int]]

      ),
      typeOf[Long] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[Long]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[Long]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[Long]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[Long]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[Long]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[Long]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[Long]]

      ),
      typeOf[Double] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[Double]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[Double]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[Double]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[Double]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[Double]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[Double]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[Double]]

      ),
      typeOf[Float] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[Float]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[Float]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[Float]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[Float]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[Float]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[Float]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[Float]]

      ),
      typeOf[Char] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[Char]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[Char]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[Char]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[Char]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[Char]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[Char]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[Char]]

      ),
      typeOf[ObjectId] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[ObjectId]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[ObjectId]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[ObjectId]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[ObjectId]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[ObjectId]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[ObjectId]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[ObjectId]]

      ),

      typeOf[Id] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[Id]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[Id]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[Id]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[Id]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[Id]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[Id]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[Id]]

      ),

      typeOf[Date] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[Date]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[Date]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[Date]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[Date]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[Date]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[Date]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[Date]]

      ),
      typeOf[EnumForTest.Value] -> Map(
        "SimpleMapMessage" -> typeOf[SimpleMapMessage[EnumForTest.Value]],
        "SimpleMapOptionMessage" -> typeOf[SimpleMapOptionMessage[EnumForTest.Value]],
        "SimpleMapArrayMessage" -> typeOf[SimpleMapArrayMessage[EnumForTest.Value]],
        "SimpleMapSeqMessage" -> typeOf[SimpleMapSeqMessage[EnumForTest.Value]],
        "SimpleMapOptionValueMessage" -> typeOf[SimpleMapOptionValueMessage[EnumForTest.Value]],
        "SimpleMapArrayValueMessage" -> typeOf[SimpleMapArrayValueMessage[EnumForTest.Value]],
        "SimpleMapSeqValueMessage" -> typeOf[SimpleMapSeqValueMessage[EnumForTest.Value]]

      )
    )


    def keyFactory[V] = {
      val k = keys(keyTypeTag.tpe)
      (idx: Int) => k(idx).asInstanceOf[V]
    }

    val testMessages = createTestMessages(keyFactory)

    testMessages.map(tm => {
      messageTypes(keyTypeTag.tpe).find(e => tm._1.startsWith(e._1)).map(found => {
        (tm._1, (found._2, tm._2))
      }).getOrElse(throw new Exception("No message types found for " + tm._1))
    })

  }


}
