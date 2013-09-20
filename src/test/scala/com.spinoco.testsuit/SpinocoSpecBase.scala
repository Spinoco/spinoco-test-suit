package com.spinoco.testsuit

import concurrent.{Await, Future}
import concurrent.duration._
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Tag

/**
 *
 * User: pach
 * Date: 3/7/13
 * Time: 3:56 PM
 * (c) 2011-2013 Spinoco Czech Republic, a.s.
 */
trait SpinocoSpecBase extends ShouldMatchers {
  val X                = Tag("X")
  val PerformanceTest  = Tag("performance")
  val LongDurationTest = Tag("long-duration")

  val empty      = 'empty
  val terminated = 'terminated
  val active     = true
  val completed  = 'completed
  val left       = 'left
  val right      = 'right
  val success    = 'right
  val failed     = 'left


  implicit val defaultTimeout = 1 minute


  def sleep(time: Duration) = Thread.sleep(time.toMillis)


  def awaitCondition(test: () => Boolean, errorMessage: String, delay: Duration = 100.millis, timeout: FiniteDuration = 10.seconds) = {
    var attempt = 0
    var success = false

    val terminate: Deadline = timeout.fromNow
    while (!success && !terminate.isOverdue()) {
      success = test()
      Thread.sleep(delay.toMillis)
      attempt += 1
    }

    if (!success) fail(errorMessage)

  }

  def await[T](f: Future[T]): T = {
    Await.result(f, defaultTimeout)
  }

}
