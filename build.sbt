import com.lihaoyi.workbench.Plugin._

enablePlugins(ScalaJSPlugin)

workbenchSettings

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0",
  "com.lihaoyi" %%% "scalatags" % "0.5.2"
)

bootSnippet := "example.ScalaJSExample().main(document.getElementById('canvas'));"

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)

val scalajsOutputDir = Def.settingKey[File]("directory for javascript files output by scalajs")

scalajsOutputDir := (baseDirectory in Compile).value / "src/main/webapp/assets/js"

crossTarget in fastOptJS := scalajsOutputDir.value

crossTarget in fullOptJS := scalajsOutputDir.value

javaOptions in Jetty ++= Seq(
  "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
)


