def isMonotonic(i : Int, o : Option[Int] = None) : Boolean = o match {
	case Some(x) => i % 10 <= x
	case None => isMonotonic(i / 10, Some(i % 10))
}
