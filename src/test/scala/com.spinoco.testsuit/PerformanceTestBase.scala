package com.spinoco.testsuit

import java.util.{Calendar, Date}
import org.bson.types.ObjectId
import org.joda.time.DateTime

/**
 *
 * User: pach
 * Date: 10/8/12
 * Time: 7:46 PM
 * (c) 2011-2012 Spinoco Czech Republic, a.s.
 */
trait PerformanceTestBase extends SpinocoSpec {
  def perfTest[T](serializerName: String, serializer: (SimpleMessage) => T, deserializer: (T) => SimpleMessage, messages: Int, thresholdFactor: Double) = {

    val msg = SimpleMessage(true, 1, 2, 3, 4L, 2.2, 4.4f, "OMG String here !!", new ObjectId(), Id.generate,
                             new Date(System.currentTimeMillis()), Calendar.getInstance(), new DateTime(0),
                             EnumForTest.ENUM_ONE,
                             SimpleStringMessage("first"), SimpleStringMessage("second")
                           )

    def doJob(job: () => Unit, threshold:Int) = {
      val now = System.currentTimeMillis()

      for (i <- 0 until messages) {
        job()
      }
      val passed = System.currentTimeMillis() - now

      val performance = messages.toDouble / (passed.toDouble / 1000)

      if (performance < threshold*thresholdFactor) {
        fail("Performance is below treshold (%s): %s, #%s =>> %s/sec".format(threshold, passed, messages, performance))
      } else {
        info("Passed %s,#%s ==> %s/sec".format(passed, messages, performance))
      }
    }


    it("will perform as expected on serialization") {
      doJob(() => serializer(msg), 10000)
    }

    it("will perform as expected on deserialization") {
      val serialized = serializer(msg)
      doJob(() => deserializer(serialized), 10000)
    }

    it("will perform as expected on full cycle") {
      doJob(() => {
        val serialized = serializer(msg)
        deserializer(serialized)
      }, 5000)

    }


  }

}
