object RangeTools {

  // val lst = List( 1,2,3,5,6,7,8,10,15,16,17 )
  // exp:
  //       1 - 3
  //       5 - 8
  //       10 - 10
  //       15 - 17
  //
  // List((Some(1), None),
  //      (Some(5), Some(3)),
  //      (Some(10),Some(8)),
  //      (Some(15),Some(10)),
  //      (None,    Some(17)))
  def ranges(lst: List[Int]): List[(Int, Int)] = {
    val sorted = lst.sorted
    val shiftedPairs = (sorted.map(x => Some(x)) ++ List(None))
      .zip(None :: sorted.map(x => Some(x)))

    val compressedPairs = shiftedPairs.flatMap(p => (p._1,p._2) match {
      case (Some(a), Some(b)) if a - b == 1 => None
      case (None, _) => Some(p)
      case (_, None) => Some(p)
      case _ => Some(p)
    })

    compressedPairs
      .dropRight(1)
      .zip(compressedPairs.tail)
      .map(p => (p._1._1.get, p._2._2.get))
  }


}
