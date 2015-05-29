resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.3.0")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "0.8.5")

//Scala code scoverage plugin
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.1.0")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.0.0")

//Intellij plugin
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

//Eclipse sbt plugin
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "3.0.0")

//Scalastyle - SBT plugin
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.6.0")

//Static code analysis via PMD/CPD
addSbtPlugin("de.johoop" % "cpd4sbt" % "1.1.5")

//Static code analysis via FindBugs
addSbtPlugin("de.johoop" % "findbugs4sbt" % "1.4.0")


