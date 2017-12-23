package exercise

import org.apache.spark.sql.SparkSession

/**
  * Created by sparkclass on 2017/12/17.
  */
object testRDD {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("GitHub push counter").master("local[*]").getOrCreate()
    val sc = spark.sparkContext
    var pair=sc.parallelize(List((1,2),(2,33),(2,11)))
    var pair2=sc.parallelize(List((2,3),(21,33),(21,333)))
    println(pair.keys.collect())
    var pair3=pair.map(p=>p.swap).groupByKey()
    println(pair3)
   pair.mapValues(x=>x+2).collect()

  }
}
