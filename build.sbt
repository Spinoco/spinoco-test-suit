organization := "spinoco"

scalaVersion := "2.10.2"

name := "spinoco-test-suit"

libraryDependencies ++= Seq("org.scalatest" % "scalatest_2.10" % "2.0.M5b" withSources(),
"joda-time" % "joda-time" % "2.2" withSources(),
"org.joda" %  "joda-convert" % "1.3.1" withSources(),
"org.mongodb" % "mongo-java-driver" % "2.10.1" withSources(),
"org.scala-lang" % "scala-compiler" % "2.10.2" withSources(),
"org.scala-lang" %% "scala-pickling" % "0.8.0-SNAPSHOT" withSources()
)
