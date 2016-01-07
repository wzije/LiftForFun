
organization := "org.jee.lift"

name := "LiftForFun"

version := "1.0"

scalaVersion := "2.11.7"

seq(webSettings: _*)

libraryDependencies ++= {
  val liftVersion = "2.6-RC1"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion,
    "net.liftweb" % "lift-mapper_2.11" % liftVersion,
    "mysql" % "mysql-connector-java" % "5.1.38",


    "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container,test",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,compile" artifacts Artifact("javax.servlet", "jar", "jar")
  )
}
