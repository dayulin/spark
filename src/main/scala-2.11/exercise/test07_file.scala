package exercise

import org.apache.spark.sql.SparkSession

/**
  * Created by sparkclass on 2017/12/23.
  */
object test07_file {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("GitHub push counter").master("local[*]").getOrCreate()
    val sc = spark.sparkContext
    val textFile = sc.textFile("/opt/spark-2.0.2-bin-hadoop2.7/README.md")
    val blankLine = sc.accumulator(0)
    val records=textFile.flatMap(lineDAta=>
        {
          if(lineDAta=="")
            blankLine+=1;
          lineDAta.split(" ")
        })
    records.saveAsTextFile("/home/sparkclass/testOutputDir1")
    print(blankLine.value)
  }

}
