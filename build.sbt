lazy val akkaHttpVersion = "10.2.10"
lazy val akkaVersion    = "2.6.20"

// Run in a separate JVM, to make sure sbt waits until all threads have
// finished before returning.
// If you want to keep the application running while executing other
// sbt tasks, consider https://github.com/spray/sbt-revolver/
fork := true

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "com.example",
      scalaVersion    := "2.12.15"
    )),
    name := "akka-http-app-scala",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"                % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json"     % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-actor-typed"         % akkaVersion,
      "com.typesafe.akka" %% "akka-stream"              % akkaVersion,
      "ch.qos.logback"    % "logback-classic"           % "1.2.3",
      "ch.megard"         %% "akka-http-cors" % "1.1.3",
      "com.typesafe.akka" %% "akka-http-testkit"        % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"                % "3.1.4"         % Test,
      jdbc,
  cache,
  ws
    )
  ).enablePlugins(PlayScala)

resolvers += Resolver.url("maven_central", url("https://repo.maven.apache.org/maven2/"))
libraryDependencies += "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.0-M2"
resolvers += Resolver.url("maven_central", url("https://repo.maven.apache.org/maven2/"))
