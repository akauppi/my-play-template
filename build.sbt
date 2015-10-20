name := "my-play-template"

version := "0.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  specs2 % Test
)

// This is needed for Specs2 in Play 2.4.x (but built-in tests seem fine without it?) AKa181015
//
//resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
//
routesGenerator := InjectedRoutesGenerator
