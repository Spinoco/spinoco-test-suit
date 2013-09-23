package com.spinoco.testsuit.pickling

import com.spinoco.testsuit.CommonSerializerSpecs

import reflect.runtime.universe._
import scala.pickling._
import json._
/**
 *
 * User: pach
 * Date: 10/5/12
 * Time: 9:11 AM
 * (c) 2011-2012 Spinoco Czech Republic, a.s.
 */
class PicklingSerializerSpec extends CommonSerializerSpecs {

  describe("Pickling spec") {
    basicTests()
    //arrayLikeTests()
    //mapTests()
  }


  def doSerializationWithType[T : SPickler : FastTypeTag ](msg: T, msgTest: (T) => Unit) {

    val serialized = msg.pickle

    //val deserialized = serialized.unpickle[T]

    //Option(msgTest).map(_(deserialized)).getOrElse(deserialized.asInstanceOf[T] should be(msg))
  }

}
