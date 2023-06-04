object GapInPrimes {

  // [3,5,7,......i]
	// LazyList[Long] ?
  def primesCandidates(i : Long) : IndexedSeq[Long] = {
		for(x <- 1L to i / 2 - 1) yield 1L + x * 2L
	}



	// scala> 2L #:: 3L #:: LazyList(3L)
  // val res10: LazyList[Long] = LazyList(<not computed>)

  // 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83
	//   2  2  4   2   4   2   4   6   2   6   4   2  4
	//
	def primesCandidatesFastSeq(i : Long) : IndexedSeq[Long] = {
		for(x <- 1L to i / 2 + 1) yield 1L + x * 2L
	}



	def primes(i : Long) : LazyList[Long] = {
			var isPrime : Boolean = false
			var x = 2
      while(x < math.sqrt(i).toInt + 1 && !isPrime) {
				if (i % x == 0) isPrime = true
				x = x + 1
			}
		  if (isPrime) i else ::# primes(i + 1)
	}

	def gap(g: Int, m: Long, n: Long): String = {
	  var i = m
		var ranges = mutable.BufferList[(Long,Long)]()
    var prev = None
		while(i < n) {
			if (prev.isEmpty) {

			} else {

			}
		}
		ranges.toString
	}

}
