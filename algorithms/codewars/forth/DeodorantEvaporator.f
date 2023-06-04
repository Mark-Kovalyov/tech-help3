\ def evaportor(content:Double, evapperday:Int, threshold:Int, days:Int, ost:Double) : Int = {
\  if (ost < content * threshold / 100.0) {
\     return days
\  } else {
\     val speed = ost * evapperday / 100.0
\     evaportor(content, evapperday, threshold, days + 1, ost - speed)
\  }  
\ }
