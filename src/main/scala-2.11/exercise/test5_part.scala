package exercise

import org.apache.spark.sql.SparkSession

/**
  * Created by sparkclass on 2017/12/23.
  */
object test5_part {

    def main(args: Array[String]): Unit =
    {
      val spark = SparkSession.builder().appName("GitHub push counter").master("local[*]").getOrCreate()
      val sc = spark.sparkContext
      val nums=sc.parallelize(1 to 100000000,100)
      val filted=nums.filter(_     >99999900)
      filted.collect()
      filted.getNumPartitions
      val ss=filted.coalesce(2)

      val lists=List.fill(500)(scala.util.Random.nextInt(10))
      val listsrdd=sc.parallelize(lists,5)
      val paa=listsrdd.map(xx=>(xx,xx*xx))
      val ree= paa.reduceByKey((vv,bb)=>vv+bb)
      val finrdd=ree.mapPartitions(ii=>ii.map({case(key,valu)=>"key"+key+",Value"+valu}))



    }

}
