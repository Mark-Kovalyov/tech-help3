def isMonotonic(i:Int,o:Option[Int] = None) : Boolean = {
	if (o.isDefined) (i % 10 <= o.get) else isMonotonic(i / 10,Some(i % 10))
}
