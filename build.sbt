name := "scala-climbing-classifier"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.5"

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.9"

logBuffered in Test := false
