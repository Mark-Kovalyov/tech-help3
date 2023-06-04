def inArray(array1: Array[String], array2: Array[String]): Array[String] = {
  array1.filter(x => array2.exists(v => v.contains(x))).sortWith(_ < _)
}



def inArray(array1: Array[String], array2: Array[String]): Array[String] = {
		 for {
			 s1 <- array1
			 s2 <- array2
			 if s2 contains s1
		 } yield s1
	 }.distinct.sorted
