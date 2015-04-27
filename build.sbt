import NgAnnotateKeys._
import JsEngineKeys._

name := """test-play"""

version := "1.0-SNAPSHOT"

// resolvers += "Local Repository" at "/Users/msard-abel/.ivy2/local"

val projectResolvers = Seq[Resolver](
  "Local Maven Repository" at ""+Path.userHome.asFile.toURI.toURL+".ivy2/local/"
)

lazy val root = (project in file(".")).enablePlugins(SbtWeb,PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

engineType := JsEngineKeys.EngineType.Node

pipelineStages in Assets := Seq(ngAnnotate,digest)
