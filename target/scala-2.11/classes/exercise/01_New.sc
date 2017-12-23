
//
//1 + 1
//"ab" + "be"
//
//val avvava = "avdvad"
//
//var varavvava = "avdvad"
//varavvava = "ascasc"
//
//def checkID(ID: String) = {
//  var ss = ""
//  println(ID)
//  println(ID.length)
//  if (ID.length > 0)
//    ss = "ok"
//  else
//    ss = "no"
//  ss
//}
//checkID("xcxc")
//
//def sqrt(x: Double, xx: Int) = Math.sqrt(x)
//
//def hdorderfun(xx: (Double, Int) => Double) = xx(Math.random() * 40, 20)
//
//hdorderfun(sqrt)
//
//
//def funDep(factor: Int): (Double => Double) = {
//  //   => factor * x
//  (rateBase: Double) => factor * rateBase
//}
//
//def funFace = funDep(12)
//funFace(33.33)
//funFace(44.44)
//
//class cal {
//  var Name: String = "test1"
//
//  def fun(i: Int, j: Int): Int = {
//    i * j
//  }
//}
//
//var ss = new cal
//ss.Name
//ss.fun(2, 3)
//ss
//
//ss.Name = "new test"
//ss.Name
//
//class caladv(base: String) {
//  var Name: String = base
//
//  def fun(i: Int, j: Int): Int = {
//    i * j
//  }
//}
//
//class caladv2(base: String) {
//  var Name2: String = base
//
//  def fun2(i: Int, j: Int): Int = {
//    i * j
//  }
//}
//
//class caladv3() {
//  var Name2: String = "22"
//
//  def fun2(i: Int, j: Int): Int = {
//    i * j
//  }
//}
//
//var ss2 = new caladv("te")
//ss2.Name
//ss2.fun(4, 3)
//ss2
//
//ss2.Name = "new test"
//ss2.Name
//
////===================extend ======================//
//class caladvEx(base: String) extends caladv(base) {
//  def funadv(i: Int, j: Int): Int = {
//    i * j * 2
//  }
//}
//
//
//var ss3 = new caladvEx("t3")
//ss3.Name
//ss3.fun(4, 3)
//ss3.funadv(4, 3)
//ss3
//
//ss3.Name = "new test"
//ss3.Name

//=================interface=======================//
trait caladv44 {
  var Name: String
}

trait caladv55 {
  var Name2: String
}

class caladvEx2 extends caladv44 with caladv55 {
  override var Name: String = "cc"
  override var Name2: String = "ccccc"
}

var caladv4 = new caladvEx2()
caladv4.Name
var caladv55 = new caladvEx2()
caladv4.Name
//==============================================//
class caladvtest {
  var Name2: String="20"
}
object caladvEx3 extends caladv44 with caladv55 {
  override var Name: String = "cc"
  override var Name2: String = "ccccc"
  def acc(name:String)=new caladvtest()
}

var caladv66 = caladvEx3
caladv66.Name
var caladv77 = caladvEx3
caladv77.Name2
caladv77.acc("a")

