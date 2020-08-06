name := "code-katas"

version := "1.0"

scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.typelevel" %% "cats" % "0.9.0",
  "org.typelevel" %% "cats-tagless-macros" % "0.11",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "org.scalatest" %% "scalatest" % "3.2.0",
  "args4j" % "args4j" % "2.33"
)

mainClass in Compile := Some("CmdLineApp")
    