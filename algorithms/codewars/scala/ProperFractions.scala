object Sol {

  @scala.annotation.tailrec
  def gcd(a:Long,b:Long) : Long = if (b != 0L) gcd(b,a % b) else a

  def gcdList(a:Long*) : Long = a.reduce((a,b) => gcd(a,b))

  // 2 3   7
  // 2 3 5 7
  //   3 5 7 11
  // 2 3   7 11
  // List[Long](42, 105, 1155, 231)

  def primeCandidates(n : Long = 3, step : Long = 2) : LazyList[Long] = {
    n ::# (step match {
      case 4 => primeCandidates(n + 2, 2)
      case 2 => primeCandidates(n + 4, 4)
    })
  }

	def primeCandidates() = {
		for (i <- 3 to ) yield i * 2
	}

	def factorize(a:Long) : List[Int] = {
		List()
	}

  def properFractions(n: Long): Long = {
    if (n == 1) return 0L
    var sum : Long = 0L
    var i : Long = 0L
    while(i < n) {
      if (gcd(i,n)==1) sum = sum + 1L
      i = i + 1
    }
    sum
  }
}

// 6257701328: 2 2 2 2 73 313 17117

// 5 -> 9 :
//          1/5 2/5 3/5 4/5
//

// 73 * 313 = 22849,   properFractions(22849) = 22464
//
