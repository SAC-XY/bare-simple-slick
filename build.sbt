name := "bare-simple-slick"

version := "0.1"

scalaVersion := "2.12.10"

// slick
libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.1",
  "org.slf4j" % "slf4j-nop" % "1.7.26",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.1"
)

// use application.conf
libraryDependencies += "com.typesafe" % "config" % "1.4.0"

// Database Drivers
libraryDependencies += "com.h2database" % "h2" % "1.4.200"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.19"
