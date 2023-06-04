
// cos(x) = 1  - x^2/2! + x^4/4! + x^6/6!

import scala.annotation.tailrec

@tailrec
def tcos2(x:Double, i:Int, num:Double, denum:Long, sum:Double) : Double = {
	val kn : Double = num / denum
	if (kn > 0.001)
		tcos2(x, i + 1, num * x * x, denum * (i - 1) * i, sum + (if (i % 2 == 0) 1.0 else -1.0) * kn)
	else
	  kn
}

def tcos(x:Double) : Double = {
	1.0 - tcos2(x, 2, x * x, 1 * 2L, 0.0)
}
