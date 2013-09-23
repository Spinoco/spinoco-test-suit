package com.spinoco.testsuit

import java.util.{Calendar, Date}
import org.bson.types.ObjectId
import org.joda.time.DateTime


/**
 *
 * User: pach
 * Date: 10/5/12
 * Time: 8:56 AM
 * (c) 2011-2012 Spinoco Czech Republic, a.s.
 */


case class SimpleMessage(boolPar: Boolean,
                         bytePar: Byte,
                         shortPar: Short,
                         intPar: Int,
                         longPar: Long,
                         doublePar: Double,
                         floatPar: Float,
                         stringPar: String,
                         objIdPar: ObjectId,
                         idPar: Id,
                         datePar: Date,
                         calendarPar: Calendar,
                         dateTimePar: DateTime,
                         enumPar: EnumForTest.Value,
                         ssmPar: SimpleStringMessage,
                         ptPar: ProtocolTest)


case class SimpleOptionMessage(boolPar: Option[Boolean],
                               bytePar: Option[Byte], shortPar: Option[Short], intPar: Option[Int], longPar: Option[Long],
                               doublePar: Option[Double], floatPar: Option[Float], stringPar: Option[String],
                               objIdPar: Option[ObjectId], idPar: Option[Id], datePar: Option[Date], calendarPar: Option[Calendar],
                               dateTimePar: Option[DateTime],
                               enumPar: Option[EnumForTest.Value], ssmPar: Option[SimpleStringMessage],
                               ptPar: Option[ProtocolTest])

case class SimpleEitherMessage(boolPar: Either[Boolean, Boolean],
                               bytePar: Either[Boolean, Byte], shortPar: Either[Boolean, Short], intPar: Either[Boolean, Int], longPar: Either[Boolean, Long],
                               doublePar: Either[Boolean, Double], floatPar: Either[Boolean, Float], stringPar: Either[Boolean, String],
                               objIdPar: Either[Boolean, ObjectId], idPar: Either[Boolean, Id], datePar: Either[Boolean, Date], calendarPar: Either[Boolean, Calendar],
                               dateTimePar: Either[Boolean, DateTime],
                               enumPar: Either[Boolean, EnumForTest.Value], ssmPar: Either[Boolean, SimpleStringMessage],
                               ptPar: Either[Boolean, ProtocolTest])

case class SimpleEitherOptionMessage(boolPar: Either[Option[Boolean], Option[Boolean]],
                                     bytePar: Either[Option[Boolean], Option[Byte]], shortPar: Either[Option[Boolean], Option[Short]], intPar: Either[Option[Boolean], Option[Int]], longPar: Either[Option[Boolean], Option[Long]],
                                     doublePar: Either[Option[Boolean], Option[Double]], floatPar: Either[Option[Boolean], Option[Float]], stringPar: Either[Option[Boolean], Option[String]],
                                     objIdPar: Either[Option[Boolean], Option[ObjectId]], idPar: Either[Option[Boolean], Option[Id]], datePar: Either[Option[Boolean], Option[Date]], calendarPar: Either[Option[Boolean], Option[Calendar]],
                                     dateTimePar: Either[Option[Boolean], Option[DateTime]],
                                     enumPar: Either[Option[Boolean], Option[EnumForTest.Value]], ssmPar: Either[Option[Boolean], Option[SimpleStringMessage]],
                                     ptPar: Either[Option[Boolean], Option[ProtocolTest]])

case class SimpleOptionEitherMessage(boolPar: Option[Either[Boolean, Boolean]],
                                     bytePar: Option[Either[Boolean, Byte]], shortPar: Option[Either[Boolean, Short]], intPar: Option[Either[Boolean, Int]], longPar: Option[Either[Boolean, Long]],
                                     doublePar: Option[Either[Boolean, Double]], floatPar: Option[Either[Boolean, Float]], stringPar: Option[Either[Boolean, String]],
                                     objIdPar: Option[Either[Boolean, ObjectId]], idPar: Option[Either[Boolean, Id]], datePar: Option[Either[Boolean, Date]], calendarPar: Option[Either[Boolean, Calendar]],
                                     dateTimePar: Option[Either[Boolean, DateTime]],
                                     enumPar: Option[Either[Boolean, EnumForTest.Value]], ssmPar: Option[Either[Boolean, SimpleStringMessage]],
                                     ptPar: Option[Either[Boolean, ProtocolTest]])


case class SimpleArrayMessage(boolPar: Array[Boolean],
                              bytePar: Array[Byte], shortPar: Array[Short], intPar: Array[Int], longPar: Array[Long],
                              doublePar: Array[Double], floatPar: Array[Float], stringPar: Array[String], objIdPar: Array[ObjectId], idPar: Array[Id],
                              datePar: Array[Date], calendarPar: Array[Calendar],
                              dateTimePar: Array[DateTime],
                              enumPar: Array[EnumForTest.Value], ssmPar: Array[SimpleStringMessage],
                              ptPar: Array[ProtocolTest])

case class SimpleArrayOptionMessage(boolPar: Option[Array[Boolean]],
                                    bytePar: Option[Array[Byte]], shortPar: Option[Array[Short]], intPar: Option[Array[Int]], longPar: Option[Array[Long]],
                                    doublePar: Option[Array[Double]], floatPar: Option[Array[Float]], stringPar: Option[Array[String]], objIdPar: Option[Array[ObjectId]], idPar: Option[Array[Id]],
                                    datePar: Option[Array[Date]], calendarPar: Option[Array[Calendar]],
                                    dateTimePar: Option[Array[DateTime]],
                                    enumPar: Option[Array[EnumForTest.Value]], ssmPar: Option[Array[SimpleStringMessage]],
                                    ptPar: Option[Array[ProtocolTest]])

case class SimpleSetMessage(boolPar: Set[Boolean],
                            bytePar: Set[Byte], shortPar: Set[Short], intPar: Set[Int], longPar: Set[Long],
                            doublePar: Set[Double], floatPar: Set[Float], stringPar: Set[String], objIdPar: Set[ObjectId], idPar: Set[Id],
                            datePar: Set[Date], calendarPar: Set[Calendar],
                            dateTimePar: Set[DateTime],
                            enumPar: Set[EnumForTest.Value], ssmPar: Set[SimpleStringMessage],
                            ptPar: Set[ProtocolTest])

case class SimpleSeqMessage(boolPar: Seq[Boolean],
                            bytePar: Seq[Byte], shortPar: Seq[Short], intPar: Seq[Int], longPar: Seq[Long],
                            doublePar: Seq[Double], floatPar: Seq[Float], stringPar: Seq[String], objIdPar: Seq[ObjectId], idPar: Seq[Id],
                            datePar: Seq[Date], calendarPar: Seq[Calendar],
                            dateTimePar: Seq[DateTime],
                            enumPar: Seq[EnumForTest.Value], ssmPar: Seq[SimpleStringMessage],
                            ptPar: Seq[ProtocolTest])

case class SimpleListMessage(boolPar: List[Boolean],
                             bytePar: List[Byte], shortPar: List[Short], intPar: List[Int], longPar: List[Long],
                             doublePar: List[Double], floatPar: List[Float], stringPar: List[String], objIdPar: List[ObjectId], idPar: List[Id],
                             datePar: List[Date], calendarPar: List[Calendar],
                             dateTimePar: List[DateTime],
                             enumPar: List[EnumForTest.Value], ssmPar: List[SimpleStringMessage],
                             ptPar: List[ProtocolTest])


case class SimpleOptionSetMessage(boolPar: Option[Set[Boolean]],
                                  bytePar: Option[Set[Byte]], shortPar: Option[Set[Short]], intPar: Option[Set[Int]], longPar: Option[Set[Long]],
                                  doublePar: Option[Set[Double]], floatPar: Option[Set[Float]], stringPar: Option[Set[String]], objIdPar: Option[Set[ObjectId]], idPar: Option[Set[Id]],
                                  datePar: Option[Set[Date]], calendarPar: Option[Set[Calendar]],
                                  dateTimePar: Option[Set[DateTime]],
                                  enumPar: Option[Set[EnumForTest.Value]], ssmPar: Option[Set[SimpleStringMessage]],
                                  ptPar: Option[Set[ProtocolTest]])

case class SimpleOptionSeqMessage(boolPar: Option[Seq[Boolean]],
                                  bytePar: Option[Seq[Byte]], shortPar: Option[Seq[Short]], intPar: Option[Seq[Int]], longPar: Option[Seq[Long]],
                                  doublePar: Option[Seq[Double]], floatPar: Option[Seq[Float]], stringPar: Option[Seq[String]], objIdPar: Option[Seq[ObjectId]], idPar: Option[Seq[Id]],
                                  datePar: Option[Seq[Date]], calendarPar: Option[Seq[Calendar]],
                                  dateTimePar: Option[Seq[DateTime]],
                                  enumPar: Option[Seq[EnumForTest.Value]], ssmPar: Option[Seq[SimpleStringMessage]],
                                  ptPar: Option[Seq[ProtocolTest]])

case class SimpleOptionListMessage(boolPar: Option[List[Boolean]],
                                   bytePar: Option[List[Byte]], shortPar: Option[List[Short]], intPar: Option[List[Int]], longPar: Option[List[Long]],
                                   doublePar: Option[List[Double]], floatPar: Option[List[Float]], stringPar: Option[List[String]], objIdPar: Option[List[ObjectId]], idPar: Option[List[Id]],
                                   datePar: Option[List[Date]], calendarPar: Option[List[Calendar]],
                                   dateTimePar: Option[List[DateTime]],
                                   enumPar: Option[List[EnumForTest.Value]], ssmPar: Option[List[SimpleStringMessage]],
                                   ptPar: Option[List[ProtocolTest]])


case class SimpleMapMessage[K](boolPar: Map[K, Boolean],
                               bytePar: Map[K, Byte], shortPar: Map[K, Short], intPar: Map[K, Int], longPar: Map[K, Long],
                               doublePar: Map[K, Double], floatPar: Map[K, Float], stringPar: Map[K, String], charPar: Map[K, Char],
                               objIdPar: Map[K, ObjectId], idPar: Map[K, Id],
                               datePar: Map[K, Date], calendarPar: Map[K, Calendar],
                               dateTime: Map[K, DateTime],
                               enumPar: Map[K, EnumForTest.Value], ssmPar: Map[K, SimpleStringMessage],
                               ptPar: Map[K, ProtocolTest])

case class SimpleMapOptionMessage[K](boolPar: Option[Map[K, Boolean]],
                                     bytePar: Option[Map[K, Byte]], shortPar: Option[Map[K, Short]], intPar: Option[Map[K, Int]], longPar: Option[Map[K, Long]],
                                     doublePar: Option[Map[K, Double]], floatPar: Option[Map[K, Float]], stringPar: Option[Map[K, String]], charPar: Option[Map[K, Char]],
                                     objIdPar: Option[Map[K, ObjectId]], idPar: Option[Map[K, Id]],
                                     datePar: Option[Map[K, Date]], calendarPar: Option[Map[K, Calendar]],
                                     dateTimePar: Option[Map[K, DateTime]],
                                     enumPar: Option[Map[K, EnumForTest.Value]], ssmPar: Option[Map[K, SimpleStringMessage]],
                                     ptPar: Option[Map[K, ProtocolTest]])

case class SimpleMapArrayMessage[K](boolPar: Array[Map[K, Boolean]],
                                    bytePar: Array[Map[K, Byte]], shortPar: Array[Map[K, Short]], intPar: Array[Map[K, Int]], longPar: Array[Map[K, Long]],
                                    doublePar: Array[Map[K, Double]], floatPar: Array[Map[K, Float]], stringPar: Array[Map[K, String]], charPar: Array[Map[K, Char]],
                                    objIdPar: Array[Map[K, ObjectId]], idPar: Array[Map[K, Id]],
                                    datePar: Array[Map[K, Date]], calendarPar: Array[Map[K, Calendar]],
                                    dateTimePar: Array[Map[K, DateTime]],
                                    enumPar: Array[Map[K, EnumForTest.Value]], ssmPar: Array[Map[K, SimpleStringMessage]],
                                    ptPar: Array[Map[K, ProtocolTest]])

case class SimpleMapSeqMessage[K](boolPar: Seq[Map[K, Boolean]],
                                  bytePar: Seq[Map[K, Byte]], shortPar: Seq[Map[K, Short]], intPar: Seq[Map[K, Int]], longPar: Seq[Map[K, Long]],
                                  doublePar: Seq[Map[K, Double]], floatPar: Seq[Map[K, Float]], stringPar: Seq[Map[K, String]], charPar: Seq[Map[K, Char]],
                                  objIdPar: Seq[Map[K, ObjectId]], idPar: Seq[Map[K, Id]],
                                  datePar: Seq[Map[K, Date]], calendarPar: Seq[Map[K, Calendar]],
                                  dateTimePar: Seq[Map[K, DateTime]],
                                  enumPar: Seq[Map[K, EnumForTest.Value]], ssmPar: Seq[Map[K, SimpleStringMessage]],
                                  ptPar: Seq[Map[K, ProtocolTest]])

case class SimpleMapOptionValueMessage[K](boolPar: Map[K, Option[Boolean]],
                                          bytePar: Map[K, Option[Byte]], shortPar: Map[K, Option[Short]], intPar: Map[K, Option[Int]], longPar: Map[K, Option[Long]],
                                          doublePar: Map[K, Option[Double]], floatPar: Map[K, Option[Float]], stringPar: Map[K, Option[String]], charPar: Map[K, Option[Char]],
                                          objIdPar: Map[K, Option[ObjectId]], idPar: Map[K, Option[Id]],
                                          datePar: Map[K, Option[Date]], calendarPar: Map[K, Option[Calendar]],
                                          dateTimePar: Map[K, Option[DateTime]],
                                          enumPar: Map[K, Option[EnumForTest.Value]], ssmPar: Map[K, Option[SimpleStringMessage]],
                                          ptPar: Map[K, Option[ProtocolTest]])

case class SimpleMapArrayValueMessage[K](boolPar: Map[K, Array[Boolean]],
                                         bytePar: Map[K, Array[Byte]], shortPar: Map[K, Array[Short]], intPar: Map[K, Array[Int]], longPar: Map[K, Array[Long]],
                                         doublePar: Map[K, Array[Double]], floatPar: Map[K, Array[Float]], stringPar: Map[K, Array[String]], charPar: Map[K, Array[Char]],
                                         objIdPar: Map[K, Array[ObjectId]], idPar: Map[K, Array[Id]],
                                         datePar: Map[K, Array[Date]], calendarPar: Map[K, Array[Calendar]],
                                         dateTimePar: Map[K, Array[DateTime]],
                                         enumPar: Map[K, Array[EnumForTest.Value]], ssmPar: Map[K, Array[SimpleStringMessage]],
                                         ptPar: Map[K, Array[ProtocolTest]])


case class SimpleMapSeqValueMessage[K](boolPar: Map[K, Seq[Boolean]],
                                       bytePar: Map[K, Seq[Byte]], shortPar: Map[K, Seq[Short]], intPar: Map[K, Seq[Int]], longPar: Map[K, Seq[Long]],
                                       doublePar: Map[K, Seq[Double]], floatPar: Map[K, Seq[Float]], stringPar: Map[K, Seq[String]], charPar: Map[K, Seq[Char]],
                                       objIdPar: Map[K, Seq[ObjectId]], idPar: Map[K, Seq[Id]],
                                       datePar: Map[K, Seq[Date]], calendarPar: Map[K, Seq[Calendar]],
                                       dateTimePar: Map[K, Seq[DateTime]],
                                       enumPar: Map[K, Seq[EnumForTest.Value]], ssmPar: Map[K, Seq[SimpleStringMessage]],
                                       ptPar: Map[K, Seq[ProtocolTest]])


case class SimpleStringMessage(str: String) extends ProtocolTest

trait ProtocolTest


object EnumForTest extends Enumeration {
  val ENUM_ONE                         = Value
  val ENUM_TWO, ENUM_THREE, ENUM_OTHER = Value
}

case object EmptyObjectMessage

case class NestedAbstractObjectMessage(oPar: Product)

