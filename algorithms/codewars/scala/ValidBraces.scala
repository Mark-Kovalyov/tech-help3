object ValidBraces {


  def is_pair(c1:Char,c2:Char) : Boolean = '(' == c1 && ')' == c2 || '[' == c1 && ']' == c2 || '{' == c1 && '}' == c2 
    
  def collapse(lst: List[Char]) : List[Char] = {
    if (lst.length >= 2) {
      if (is_pair(lst.dropRight(1).last, lst.last)) lst.dropRight(2) else lst
    } else {
      lst
    }
  }

  def validBracesRec(lst: List[Char], stack : List[Char]) : Boolean = (lst.head, lst.tail, stack) match {        
    case (_, Nil, _) => collapse(stack.appended(lst.head)).isEmpty
    case (_, _,   _) => validBracesRec(lst.tail, collapse(stack.appended(lst.head)))
  }
  
  def validBraces(s : String) = validBracesRec(s.toList, List[Char]())


}