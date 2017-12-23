package exercise
import java.util.Properties
import kafka.producer.{KeyedMessage, Producer, ProducerConfig}
import scala.util.Random

/**
  * Created by sparkclass on 2017/12/23.
  */
object test09_ScalaProduceExample {
  def main(args: Array[String]): Unit = {
    val topic ="testTopic"
    //val random=new Random()
    val props=new Properties()
    props.put("metadata.broker.list","localhost:9092")
    props.put("serializer.class","kafka.serializer.StringEncoder")
    props.put("producer.type","async")

    val conf=new ProducerConfig(props)
    val producer=new Producer[String,String](conf)
    for (xxxxx <-Range(0,10))
    {
      val ip="192.168.2."+Random.nextInt(500)
      val msg="test mess "+Random.nextInt(500)
      val data=new KeyedMessage[String,String](topic,ip,msg)
      //val datas=new KeyedMessage[String,String](topic,msg)
      producer.send(data)
    }
    producer.close()
  }
}
