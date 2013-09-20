package com.spinoco.testsuit

import reflect.runtime.universe._
/**
 * 
 * User: pach
 * Date: 10/5/12
 * Time: 12:53 PM
 * (c) 2011-2012 Spinoco Czech Republic, a.s.
 */
trait SerializerFactorySpecs extends SpinocoSpec {

  /**
   * Does the serialization and compares back deserialized product. If the test function is supplied, it will perform that test insetead of simple eq. test
   * @param msg
   * @param msgTest
   * @tparam T
   */
  def doSerialization[T <: Product](msg: T, msgTest: (T) => Unit = null)(implicit tt:TypeTag[T]) = doSerializationWithType(msg,tt.tpe, msgTest) : Unit

  def doSerializationWithType[T <: Product](msg: T, tpe:Type, msgTest: (T) => Unit = null) : Unit

}
