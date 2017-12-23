var  datalist4 = Map(("title","ascas"),2->"asaf",3->"ggrw",3.3->"ggccccrw")

datalist4("title")
datalist4(3)
datalist4(3.3)
//datalist4(4)
datalist4.getOrElse(6,"un known")



var datalist5 = List("4","5","6")
def adddun(x:String)=x+"vv"
var newlis01=datalist5.map(adddun)
def toInt(x:String):Int=Integer.parseInt(x)
def toString(x:Any):String=String.valueOf(x)
def toRoundSize(x:String):Double=Integer.parseInt(x)*Integer.parseInt(x)*Math.PI
def toRoundSize2(x:Int):Double=x*x*Math.PI

var newlis02=datalist5.map(toInt)
var newlis03=datalist5.map(toRoundSize)
var newlis04=datalist5.map((x:String)=>x+"vv")
var newlis05=datalist5.map(x=>Integer.parseInt(x)+1)
var newlis06=datalist5
  .map(Integer.parseInt(_))
  .map(toRoundSize2)
  .map(toString)
//
var datalist6 = List(List(4,5,6),List(4,5,6),List(4,5,6))
var datalist7=datalist6.map((ls:List[Int])=>  ls.map(_+1))

var datalist8= List("4x","5x","6x")
datalist8.foreach(println(_))

var datalist7_1=datalist6.map((ls:List[Int])=>  ls.filter(x=>x%2!=0))
datalist8.zip(datalist5)
datalist6.zip(datalist5)
datalist5.zip(datalist6)
var datalist8_1=List(4,5,6)
def aggregateFunc(acc:Int,ni:Int) =( acc+ni)
datalist8_1.foldLeft(0)(aggregateFunc)

datalist6.flatten


