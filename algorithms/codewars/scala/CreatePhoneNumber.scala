def createPhoneNumber(numbers: Seq[Int]): String = {
  val x = numbers.map(x => x.toString).mkString
  s"(${x.substring(0,3)}) ${x.substring(3,6)}-${x.substring(6,10)}"
}
