package object knighttour {
  
  val MIN_DESK = 5

  val horseDirections : List[(Int,Int)] = List(
    (2,1),(1,2),
    (-2,1),(-1,2),
    (2,-1),(1,-2),
    (-2,-1),(-1,-2)
  )

  def is_allowed_move(xx:Int,yy:Int,size:Int) : Boolean = xx >= 0 && xx < size && yy >= 0 && yy < size
  
}
