package exercise

import org.apache.spark.sql.SparkSession

import scala.io.Source

/**
  * Created by sparkclass on 2017/12/17.
  */
object test02 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("GitHub push counter").master("local[*]").getOrCreate()
    var homeDir = System.getenv("HOME")
    println(homeDir)
    var inputPath = homeDir + "/sparkClass/src/main/resources/tutor/2015-03-01-0.json"
    println(inputPath)
    var githublog = spark.read.json(inputPath)
    var pushes = githublog.filter("type='PushEvent' ")
    var groups1 = pushes.groupBy("actor.login").count()
    var orders = groups1.orderBy(groups1("count").desc)
    val emppath = homeDir + "/sparkClass/src/main/resources/tutor/ghEmployees.txt"
    var empss = Set() ++ (
      for {
        line <- Source.fromFile(emppath).getLines()

      } yield line.trim
      )
    println(empss)
    println("=================================")
    var isemp: (String => Boolean) = {
      name: String => empss.contains(name)
    }
    println(isemp("mikebronner"))
    //    val isemp2=(name:String)=>empss.contains(name)
    //    println(isemp2("mikebronner"))
    //    val isemp3=empss.contains(_)
    //    println(isemp3("mikebronner"))
    println("=================================")
    var isemps = spark.udf.register("isEmpUdf", isemp)
    import spark.implicits._
    var fiilter = orders.filter(isemps($"login"))
    println("---orders.show(5)----------------------------------------------------------------------")
    orders.show(5)
    println("---orders.show(5)----------------------------------------------------------------------")
    println("=================================")
    println("---fiilter.show(5)----------------------------------------------------------------------")
    fiilter.show(5)
    println("---fiilter.show(5)----------------------------------------------------------------------")
    spark.catalog.listFunctions()


    println("=================================")
    val emppath2 = "/media/share/userprofile.tsv"
    var empss2 = Set() ++ (
      for {
        line <- Source.fromFile(emppath2).getLines()

      } yield line.trim
      )
    println(empss2)
    println("=================================")
    println("=broadcast================================")
    var em2= spark.sparkContext.broadcast(empss2)
    var em2list=em2.value
    println(em2list)
    println("=broadcast================================")
  }
}
