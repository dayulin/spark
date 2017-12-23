package exercise

import org.apache.spark.sql.SparkSession

import scala.io.Source

/**
  * Created by sparkclass on 2017/12/17.
  */
object test02_submatformat {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("GitHub push counter").master("local[*]").getOrCreate()
    val sc = spark.sparkContext

    val inputPath = args(0)
    val emppath = args(1)

    val githublog = spark.read.json(inputPath)
//    val githublog = spark.read.csv(inputPath)
    val pushes = githublog.filter("type='PushEvent' ")
    val grouped = pushes.groupBy("actor.login").count()
    val ordered = grouped.orderBy(grouped("count").desc)

    val empss = Set() ++ (for {line <- Source.fromFile(emppath).getLines()} yield line.trim)
    val bcEmp = sc.broadcast(empss)
    import spark.implicits._

    val isemp: (String => Boolean) = {
      name: String => empss.contains(name)
    }

    val isemps = spark.udf.register("isEmpUdf", isemp)
    val fiilteed = ordered.filter(isemps($"login"))

    fiilteed.write.format(args(3)).save(args(2))


  }
}
