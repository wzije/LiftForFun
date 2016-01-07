# LiftForFun 
Lift is powerful, lightweight, secure web framework, it claim have 7 thing are hard and impossible in other web framework, such as :

1. Lazy Loading
2. Parallel page rendering
3. Comet and Ajax
4. Wiring -- declare interdepencies between page elements
5. Designer friendly templates
6. Wizard -- multi page input screens with full back-button support Security

#####Sure? Let's prove it.

#####First build project using sbt (scratch)

#####1. Sbt version, set on project/build.properties
<pre>
    sbt.version = 0.13.9
</pre>

#####2. Required plugin, set on project/plugins.sbt:
<pre>
    addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.7.0")
</pre>
troubleShot : if you're using sbt version under 13, the repository unresolved

#####3. Sbt configuration on build.sbt:
<pre>
    organization := "org.jee.fun.lift"

    name := "LiftForFun"

    version := "1.0"

    scalaVersion := "2.11.7"

    seq(webSettings :_*)

    libraryDependencies ++= {
      val liftVersion = "2.6-RC1"
      Seq(
        "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
        "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910"  % "container,test",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,compile" artifacts Artifact("javax.servlet", "jar", "jar")
      )
}
</pre>

#####4. Architecture must be like this, so you must create file or directory manually on first create project.
<pre>
    - project root directory
  | build.sbt
  - project/
    | plugins.sbt
  - src/
    - main/
      - scala/
        - bootstrap/
          | Boot.scala
        - org/
          - yourorganization/
            - liftfromscratch/
              | =>your Scala code goes here
    - webapp/
    | index.html
    | =>any other web resources - images, HTML, JavaScript, etc - go here
    - WEB-INF/
    | web.xml
    - test/
    - scala/
    - org/
    - yourorganization/
    - liftfromscratch/
    | =>your tests go here
</pre>

###### ref: <a href="http://chimera.labs.oreilly.com/books/1234000000030/ch01.html#_solution_2">http://chimera.labs.oreilly.com/books/1234000000030/ch01.html#_solution_2</a>

