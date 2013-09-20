package com.spinoco.testsuit

import java.nio.ByteBuffer
import java.util.Arrays


/**
 *
 * User: pach
 * Date: 3/29/13
 * Time: 6:11 AM
 * (c) 2011-2013 Spinoco Czech Republic, a.s.
 */
class Id (val value: Array[Byte]) extends Comparable[Id] with Serializable {

  @transient
  lazy val time: Int =
    ByteBuffer.wrap(this.value.take(4)).getInt

  def timestamp = time * 1000

  @transient
  lazy val increment: Int =
    ByteBuffer.wrap(this.value.takeRight(4)).getInt

  @transient
  lazy val machine: Int =
    ByteBuffer.wrap(this.value.drop(4).take(4)).getInt

  override def equals(obj: Any): Boolean = obj match {
    case other: Id => Arrays.equals(value, other.value)
    case _         => false
  }

  @transient
  override lazy val hashCode: Int = Arrays.hashCode(value)


  private def _compareUnsigned(i: Int, j: Int): Int =
    (i & 0xFFFFFFFFL) - (j & 0xFFFFFFFFL) match {
      case diff if diff < Integer.MIN_VALUE => Integer.MIN_VALUE
      case diff if diff > Integer.MAX_VALUE => Integer.MAX_VALUE
      case diff                             => diff.toInt
    }


  def compareTo(other: Id) =
    if (other == null) {
      -1
    } else {
      val timeCmp = _compareUnsigned(time, other.time)
      if (timeCmp == 0) {
        val machineCmp = _compareUnsigned(machine, other.machine)
        if (machineCmp == 0) {
          _compareUnsigned(increment, increment)
        } else {
          machineCmp
        }
      } else {
        timeCmp
      }

    }

  private val hex = "0123456789abcdef".toCharArray
  def toHexString(array: Array[Byte]) =
    (for (b <- array) yield Array(hex((b >> 4) & 0x0F), hex(b & 0x0F))).flatten.mkString

  @transient
  lazy val stringify =
    toHexString(value)

  override def toString = stringify
}

object Id {


  private val maxCounterValue = 16777216
  private val increment       = new java.util.concurrent.atomic.AtomicInteger(scala.util.Random.nextInt(maxCounterValue))

  private def counter = (increment.getAndIncrement + maxCounterValue) % maxCounterValue

  def apply(time: Int, machine: Int, increment: Int) = {
    val bb = ByteBuffer.allocate(12)
    bb.putInt(time)
    bb.putInt(machine)
    bb.putInt(increment)
    new Id(bb.array())
  }


  def unapply(id: Id): Option[(Int, Int, Int)] =
    Some(id.time, id.machine, id.increment)

  def generate = {
    Id(1, 2, 3)
  }

}

