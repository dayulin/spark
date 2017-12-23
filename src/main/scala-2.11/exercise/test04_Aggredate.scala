package exercise

import org.apache.spark.sql.SparkSession

/**
  * Created by sparkclass on 2017/12/17.
  */
object test04_Aggredate {
  def main(args: Array[String]): Unit =
  {
    val spark = SparkSession.builder().appName("GitHub push counter").master("local[*]").getOrCreate()
    val sc = spark.sparkContext
    var pair=sc.parallelize(List(1,2,2,33,2,11))

    //val (su,nu)=pair.aggregate((0,0))((acc,num)=>(Math.max(acc,num)),(p1,p2) =>(Math.max(p1,p2))    )

    var pairs=sc.parallelize(List((1,2),(2,33),(2,11)))
    var sss=pairs.aggregateByKey((0,0))(
      (acc,value)=>(acc._1+value , acc._2+1   ),
      (p1,p2)    =>(p1._1+p2._1  , p2._1+p2._2)).collect


    var ssss=pairs.foldByKey(0)(Math.max(_,_)).collect


    var words=Array("aa","bb","cc","dd","ff","gg","aa","dd")
    var wo= sc.parallelize(words).map(w=>(w,0))
    var woreduce= wo.reduceByKey(_+_).collect

    print("1",pair.groupBy(x=>x).collect)

    var wordspair=List(("a",2),("b",33),("a",11))
    var wop= sc.parallelize(wordspair)
    print("2",wop.groupByKey().collect)

    print("3", wop.groupByKey().mapValues(v=>v.size).collect)
  }

}
