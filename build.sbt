name := "code-katas"

version := "1.0"

scalaVersion := "2.12.4"


libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "args4j" % "args4j" % "2.33"
)

mainClass in Compile := Some("CmdLineApp")
    