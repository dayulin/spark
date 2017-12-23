package exercise

import org.apache.spark.sql.SparkSession

import scala.io.Source

/**
  * Created by sparkclass on 2017/12/17.
  */
object test01_readjson_filter {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().appName("GitHub push counter").master("local[*]").getOrCreate()
    var homeDir=System.getenv("HOME")
    println(homeDir)
    var inputPath=homeDir+"/sparkClass/src/main/resources/tutor/2015-03-01-0.json"
    println(inputPath)
    var githublog=spark.read.json(inputPath)
    val emppath = homeDir + "/sparkClass/src/main/resources/tutor/ghEmployees.txt"
    val empss = Set() ++ (for {line <- Source.fromFile(emppath).getLines()} yield line.trim)
    val isemp: (String => Boolean) = {
      name: String => empss.contains(name)
    }
    //githublog.printSchema()
    var isemps = spark.udf.register("isEmpUdf", isemp)
    import spark.implicits._
    var pushes=githublog.filter("type='PushEvent' ") //like sql where item
    println("all eves:"+githublog.count())
    githublog.show(15)
    println("fil eves:"+pushes.count())
    pushes.show(5)
    println("--------------------------------------------------------------")
    var groups1=pushes.groupBy("actor.login").count()
    groups1.show(5)
    println("--------------------------------------------------------------")
    var order1=groups1.orderBy(groups1("count"))
    order1.show(5)
    println("--------------------------------------------------------------")
    var order2=groups1.orderBy(groups1("count").desc)
    order2.show(5)
    println("--------------------------------------------------------------")

    println("==spark.implicits._===========================")
    import spark.implicits._
    val ccc=githublog.where("type='PushEvent' ").groupBy("actor.login").count().orderBy('count.desc)
    ccc.show(5)
    println("=============================")
  }
}
