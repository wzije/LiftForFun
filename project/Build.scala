import com.earldouglas.xwp.JettyPlugin
import sbt.Keys._
import sbt._

object Build extends Build {

  lazy val liftVersion = "2.6-RC1"

  lazy val commonSettings = Seq(
    organization := "org.jee.lift",
    version := "0.1.0",
    version := "LiftForFun",
    scalaVersion := "2.11.4",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature"),
    parallelExecution in Test := false
  )


  lazy val root = (project in file("."))
    .enablePlugins(JettyPlugin)
    .settings(commonSettings: _*)
    .settings(libraryDependencies ++=
      Seq(
        "net.liftweb" %% "lift-webkit" % liftVersion,
        "net.liftweb" % "lift-mapper_2.11" % liftVersion,
        "mysql" % "mysql-connector-java" % "5.1.38",

        "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",

        "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container,test",

        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,compile" artifacts Artifact("javax.servlet", "jar", "jar")
      ))



}