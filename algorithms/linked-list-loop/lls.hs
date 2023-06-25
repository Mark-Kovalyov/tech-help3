class LLE(var x : Int, var next : LLE) {
   override def toString() = "key = ${x}"
}

val e5 = new LLE(5, null)
val e4 = new LLE(4, e5)
val e3 = new LLE(3, e4)
val e2 = new LLE(2, e3)
val e1 = new LLE(1, e2)

e5.next = e2

import scala.annotation.tailrec

race
race p1 : LLE -> p2 : LLE -> LLE =
  if p1 == p2 then p1 else race p1.next p2.next.next


def checkLoop(list : LLE) : LLE = {
  race(list, race(list, list.next))
}
