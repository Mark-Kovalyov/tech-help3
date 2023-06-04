def kb(i : BigInt, m : List[String] = List("bytes","K","M","G","T")) : String = {
  if (i < 1024 || m.tail == Nil) "" + i + " " + m.head else kb(i / 1024, m.tail)
}
