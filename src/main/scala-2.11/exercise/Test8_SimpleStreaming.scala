package exercise

import org.apache.parquet.filter2.recordlevel.IncrementallyUpdatedFilterPredicate.Or
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by sparkclass on 2017/12/23.
  */
object Test8_SimpleStreaming extends App {
  val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
  val ssc = new StreamingContext(conf,Seconds(5))
  val lines=ssc.socketTextStream("localhost",9999)

  val words=lines.flatMap(_.split(" ")).filter(
    x=>(
        x.toLowerCase().contains("error") ||
        x.toLowerCase().contains("ok")
       )
  )

  //val words=lines.flatMap(_.split(" ")).filter(_.contains("error"))
  val pairs=words.map(w=>(w,1))
  val wordCounts=pairs.reduceByKey(_+_)

  wordCounts.print()
  ssc.start()
  ssc.awaitTermination()
}
