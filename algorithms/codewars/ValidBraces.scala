/*
Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!

All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.

What is considered Valid?
A string of braces is considered valid if all braces are matched with the correct brace.

Examples
"(){}[]"   =>  True
"([{}])"   =>  True
"(}"       =>  False
"[(])"     =>  False
"[({})](]" =>  False

*/

import scala.collection.mutable._

def mirror(c1:Char,c2:Char) : Boolean = {
  "()".contains(c1) && "()".contains(c2) ||
  "[]".contains(c1) && "[]".contains(c2) ||
  "{}".contains(c1) && "{}".contains(c2)
}

def validBraces(s: String): Boolean = {
  val st = scala.collection.mutable.Stack[Char]()
  for(i <- s) {
    if ("([{)".contains(i)) {
      st.push(i)
    } else {
      val r = st.pop()
      if (!mirror(r, i)) return false
    }
  }
  st.size == 0
}

// "[(])"" , st = ""
// "[(])"" , st = "["
// "[(])"" , st = "[("

def validBracesRec(lst : List[Char], st : Stack[Char]) : Boolean = lst.head, lst.size > 0 match {
	case '{' | '(' | '[', true => st.push(lst.head)
	case _,true => {

	}
	case _,false => true

}

def validBraces2(s: String): Boolean = {
  val st = scala.collection.mutable.Stack[Char]()
	val it = s.toCharArray.iterator()
  while(i <- s) {
    if ("([{)".contains(i)) {
      st.push(i)
    } else {
      val r = st.pop()
      if (!mirror(r, i)) return false
    }
  }
  st.size == 0
}
