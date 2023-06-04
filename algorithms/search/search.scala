def bsearch[T](arr : Array[T], pos : Int) : Option[T] = {
   
}


def bsearch[T](arr : Array[T]) : Option[T] = {
   arr.length match {
      case 0 => None
      case 1 => Some(arr(0))
      case _ => 
   }
}