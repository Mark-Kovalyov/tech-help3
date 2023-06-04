// The goal of this exercise is to convert a string to a new string where each character
// in the new string is "(" if that character appears only once in the original string, or ")"
// if that character appears more than once in the original string. Ignore capitalization
// when determining if a character is a duplicate.

import scala.collection._

def groupWithCount3[T <: AnyVal](v : Seq[T]): Map[T, Int] = {
  val map : mutable.Map[T, Int] = mutable.Map[T, Int]()
  for(i <- v) map.
	map
}

def groupWithCount2[T <: AnyVal](v : Seq[T]): Map[T, Int] = {
  val map : mutable.Map[T, Int] = mutable.Map[T, Int]()
  for(i <- v)
		if (map.contains(i))
			map(i) = map(i) + 1
		else
			map(i) = 1
  map
}

def duplicateEncode2(word: String): String = {
  val cnt : Map[Char, Int] = groupWithCount2(word.toLowerCase().toCharArray())
  word.toLowerCase().toCharArray().map(c => if (cnt(c) == 1) '(' else ')').mkString("")
}

def duplicateEncode(word: String): String = {
	// TODO: Fix error`
  val cnt : Map[Char, Int] = word.toLowerCase().toCharArray().zipWithIndex.toMap
  word.toLowerCase().toCharArray().map(c => if (cnt(c) == 1) '(' else ')').mkString("")
}



// "din"      =>  "((("
// "recede"   =>  "()()()"
// "Success"  =>  ")())())"
// "(( @"     =>  "))(("

duplicateEncode2("din")
