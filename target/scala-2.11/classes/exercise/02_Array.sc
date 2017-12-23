var cc = 2
var resultss = cc match {
  case 1 => "A"
  case 2 => "B"
  case 3 => "C"
  case _ => "D"
}

def chec(id: Int): String = id match {
  case 1 => "A"
  case 2 => "B"
  case 3 => "C"
  case _ => "D"
}

chec(3)

def checTYPE(types: Any): String = types match {
  case _: Int => "Int TYPE"
  case _: String => "String TYPE"
  case _: Double => "Double TYPE"
  case _: Float => "Float TYPE"
}

checTYPE(1)
checTYPE("sdf")
checTYPE(1.11)
checTYPE(1.1f)

case class comdata(title: String, data: String)

var d01 = comdata("aa", "bb")
var d02 = comdata("bbb", "ccc")
d01.title
d01.data
d02.title
d02.data

def comput(checkdata: comdata) = checkdata match {
  case comdata("aa", "bb") => "type one"
  case comdata("bbb", "ccc") => "type two"
  case _ => "unknown"
}
comput(d01)
comput(d02)

var datalist = Array(1,2,"3")
datalist(1)
datalist(2)="fsdf"

var datalist2 = List(4,5,"6")
datalist2(1)
datalist2(2)

//tuple
var  datalist3 = (7,8,"9")
datalist3._1
datalist3._2
datalist3._3


