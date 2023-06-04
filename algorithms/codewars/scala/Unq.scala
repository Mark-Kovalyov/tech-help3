//Implement the function unique_in_order which takes as argument a
//sequence and returns a list of items without any elements
//with the same value next to each other and preserving the
//original order of elements.

//For example:

//uniqueInOrder("AAAABBBCCDAABBB")   == List('A', 'B', 'C', 'D', 'A', 'B')
//uniqueInOrder("ABBCcAD")           == List('A', 'B', 'C', 'c', 'A', 'D')
//uniqueInOrder(List(1, 2, 2, 3, 3)) == List(1, 2, 3)

// Scala collections:
//
// Iterable[T]
//   +- Seq[T]

// trait Seq[+A] extends Iterable[A] 
//               with PartialFunction[Int, A] 
//               with SeqOps[A, Seq, Seq[A]] 
//               with IterableFactoryDefaults[A, Seq] 
//               with Equals

// trait Iterator[X]
//   def hasNext: Boolean
//   def next(): X

import scala.collection._

def uniqueInOrder[T](xs: Iterable[T]): Seq[T] = {
  import scala.collection._
  val res = mutable.ArrayBuffer.empty[T]
  val itr = xs.iterator
  var cp : Option[T] = None
  while(itr.hasNext) {
    val c = itr.next()
    if (cp.isEmpty) res += c else if (c != cp.get) res += c
    cp = Some(c)
  }
  res.toSeq
}

