trait Lru[T] {
  def put(t : T) : Option[T]
  def get(t : T) : Option[T]
  def size : Int
}

class TwoQ[T] extends [T]

