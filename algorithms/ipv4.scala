def octal(x:AnyVal) : String = String.format("%o", x)

def powLong(x:Int,y:Int) : Long = (1 to y).map(_ => x).foldLeft(1L)((z1,z2) => z1.toLong * z2.toLong)

def powBigInt(x:BigInt,y:Int) : BigInt = (1 to y).map(_ => x).foldLeft(BigInt(1)((z1,z2) => z1 * z2)

def ipv4toNum(ipv4:String) : Long = {
  ipv4
  .split("\\.")
  .map(_.toInt)
  .toList
  .reverse
  .zipWithIndex
  .map(x => (powLong(256, x._2), x._1))
  .map(_ * _)
  .sum
}

def num2ipv4(num:Long, ipv4:String = "", i:Int = 4) : String = i match {
  case 1   => (num & 0xFF).toString + "." + ipv4
  case 2|3 => num2ipv4(num >> 8, (num & 0xFF).toString + "." + ipv4, i - 1)
  case _   => num2ipv4(num >> 8, (num & 0xFF).toString, i - 1)
}


import scala.util.Try

def tryToInt(s : String) : Option[Int] = Try(s.toInt).toOption

// V1
def checkIp(ip : String) : Boolean = {
  val parts = ip.split("\\.").map(tryToInt(_)).flatten
  parts.length == 4 && parts.map(x => x >= 0 && x < 256).forall(_ == true)
}

// V2
def checkIp(ip : String) : Boolean = {
  val parts = ip.split("\\.").map(Try[Int](_.toInt).toOption).flatten
  parts.length == 4 && parts.map(x => x >= 0 && x < 256).forall(_ == true)
}
