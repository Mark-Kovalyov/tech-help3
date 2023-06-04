def dg(s : String, f : String = "", i : Int = 0) : String = {
  val l = s.length
  if (l == 0)
    f
  else if ((i + 1) % 3 == 0)
    dg(s.substring(0,l-1), " " + s.substring(l-1) + f, i + 1);
  else {
    dg(s.substring(0,l-1), s.substring(l-1) + f, i + 1);
  }
}

def dg(s : String, f : String = "", i : Int = 0) : String = {
  val l = s.length
  if (l == 0)
    f
  else
    dg(s.substring(0,l-1),
       (if ((i + 1) % 3 == 0) " " else "") + s.substring(l-1) + f,
       i + 1)
}

def dg(s : String, f : String = "", i : Int = 0) : String = s.length match {
  case 0 => f
  case _ =>
    val l = s.length
    dg(s.substring(0,l-1),
     (if ((i + 1) % 3 == 0) " " else "") + s.substring(l-1) + f,
     i + 1)
}

def dg(s : String, f : String = "", i : Int = 1) : String = s.length match {
  case 0 => f.trim
  case _ =>
    val l = s.length
    dg(s.substring(0,l - 1),
     (if (i % 3 == 0) " " else "") + s.substring(l - 1) + f,
     i + 1)
}

def dg(i : Long) : String = dg(i.toString)



dg("0984756948756983745")
