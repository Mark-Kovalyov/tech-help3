// AB = 3 (A,B,AB)
// ABC = 7 (A,B,C,AB,AC,BC,ABC)
// ABCD = 15 (A,B,C,D, AB,AC,AD, ...)
// ABCDE = 31


def fact(n:Int) : Int = (1 to n).foldLeft(1)(_*_)

def perm(n:Int,m:Int) : Int = {
	fact(m) / (fact(m - n) * fact(n))
}

def facets(n:Int) : Int = {
	(1 to n).map(x => perm(x,n)).sum
}

def facets2(n:Int) : Int = (1 << n) - 1