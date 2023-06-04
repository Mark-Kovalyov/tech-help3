/*
Create a function that takes a Roman numeral as its argument and returns 
its value as a numeric decimal integer. You don't need to validate the 
form of the Roman numeral.

Modern Roman numerals are written by expressing each decimal digit of 
the number to be encoded separately, starting with the leftmost digit 
and skipping any 0s. So 1990 is rendered "MCMXC" (1000 = M, 900 = CM, 90 = XC) 
and 2008 is rendered "MMVIII" (2000 = MM, 8 = VIII). The Roman numeral 
for 1666, "MDCLXVI", uses each letter in descending order.

Example:

Roman.decode("XXI") // should return 21

Symbol    Value
I          1
V          5
X          10
L          50
C          100
D          500
M          1,000
*/

// "MCMXC" == 1990
//
// Rank:      1000, 100, 1000, 10,  100, None
// RankShift: None, 1000, 100, 1000, 10, 100
// 
// Diff:      None,  -1,   +1, -1,   +1, None
// Trunclast: None,  -1,   +1, -1,   +1
// Reverse:   ......

// Reverse pairs: ((100,+1), (10,-1), (1000,+1)

import scala.annotation.tailrec

object Roman  {

	val rank = Map(
		'I' -> 1,  'V' -> 5,   'X' -> 10, 
		'L' -> 50, 'C' -> 100, 'D' -> 500, 
		'M' -> 1000)

	@tailrec
	def reduceRoman(i : List[(Int, Option[Int])], sum : Int = 0) : Int = i match {
		case head :: tail => reduceRoman(i.tail, sum + (if (head._2.isDefined) head._1 * head._2.get else head._1))
		case Nil => sum	
	}

	def decode(s : String) : Int = {
		val roman : List[Int] = s.toCharArray.map(x => rank(x)).toList		
		reduceRoman(
			roman.zip(roman.map(x => Some(x))
			.tail ++ List(None))
			.map(pair => if (pair._2.isEmpty) (pair._1, None) 
						 else (pair._1, Some(if (pair._1 >= pair._2.get) 1 else -1)))
			.reverse)
	}
}

/* 

solution from Xavier GUIHOT
===========================

def decode(roman: String): Int =
 Map("M" -> 1000, "CM" -> -200, "D" -> 500, "CD" -> -200, "C" -> 100, "XC" -> -20, "L" -> 50, "XL" -> -20, "X" -> 10, "IX" -> -2, "V" -> 5, "IV" -> -2, "I" -> 1)
  .map { case (s, d) => s.r.findAllMatchIn(roman).size * d }
  .sum


solution from 

val SYMBOL_TO_VALUE_MAP = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)

  case class Acc(last: Int, overall: Int)

  def decode(roman: String): Int = {
    roman
      .toArray
      .map(SYMBOL_TO_VALUE_MAP(_))
      .foldRight(Acc(0,0))((curr, acc) => if (curr < acc.last) Acc(curr, acc.overall - curr) else Acc(curr, acc.overall + curr))
      .overall
  }  
*/

