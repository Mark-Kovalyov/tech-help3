import scala.annotation.tailrec

@tailrec
def gcd(a:Long,b:Long) : Long = if (b != 0) gcd(b,a % b) else a

def gcdList(a:Long*) : Long = a.reduce((a,b) => gcd(a,b))

gcdList(42,231,105)