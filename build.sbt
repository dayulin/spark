name := "sparkClass"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.0.2"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.2"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "2.0.2"
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka-0-8-assembly_2.11" % "2.0.2"
libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" % "2.0.0-M3"
libraryDependencies += "log4j" % "log4j" % "1.2.16"