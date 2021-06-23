


//enablePlugins(ScalaJSPlugin)
//enablePlugins(ScalaJSBundlerPlugin)
val sharedSettings = Seq(scalaVersion := "2.13.6")

lazy val blocklyPlayground =
  crossProject(JSPlatform, JVMPlatform).in(file("."))
    .settings(sharedSettings)
    .settings(
      name := "blockly-playground",
      version := "1.0",
    )
    .jsSettings(
      Compile / fastOptJS / moduleName := name.value,
      scalaJSUseMainModuleInitializer := true,
      webpackBundlingMode := BundlingMode.Application,
      libraryDependencies ++= Seq("org.scala-js" %%% "scalajs-dom" % "1.1.0"),
      Compile / npmDependencies ++= Seq("blockly" -> "5.20210325.1")
    )
    .jsConfigure { _.enablePlugins(ScalaJSBundlerPlugin) }


//lazy val blocklyPlaygroundJS = blocklyPlayground.js
//lazy val blocklyPlaygroundJVM = blocklyPlayground.jvm