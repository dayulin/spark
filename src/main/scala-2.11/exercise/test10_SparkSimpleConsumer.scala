package exercise

import kafka.serializer.StringDecoder
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by sparkclass on 2017/12/23.
  */
object test10_SparkSimpleConsumer {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local[2]").setAppName("KafkaStreaming")
    val ssc=new StreamingContext(conf,Seconds(5))
    val kkparam=Map[String,String]("metadata.broker.list"->"localhost:9092")

    val kkStream=KafkaUtils.createDirectStream[String,String,StringDecoder,StringDecoder](
      ssc,kkparam,Set("testTopic"))

    kkStream.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
