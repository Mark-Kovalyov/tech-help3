import math.Ordering

class Rational(x:Long, y:Long) extends Ordering[Rational] {

  require(y != 0, "Denominator must not be zero!")

  def this(x: Long) = this(x, 1L)

  private def gcd(a:Long, b:Long):Long = if (b == 0L) a else gcd(b, a % b)

  val numer = x / gcd(x,y)
  val denom = y / gcd(x,y)

  def <(that:Rational) = numer * that.denom < that.numer * denom
  def >(that:Rational) = numer * that.denom > that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def +(that: Rational) = Rational(
    numer * that.denom + that.numer * denom,
    denom * that.denom
  )

  def neg : Rational = Rational(- numer, denom)

  def ==(that: Rational) : Boolean = {
    numer == that.numer && denom == that.denom
  }

  override def toString = numer + " / " + denom

  def compare(a: Rational, b: Rational): Int = {
    if (a < b) -1 else if (a > b) 1 else 0
  }

}
