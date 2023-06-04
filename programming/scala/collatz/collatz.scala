import scala.annotation.tailrec

def collatz(x:Int) : LazyList[Int] = (x, x % 2 == 0) match
  case(1,_) => 1 #:: LazyList.empty[Int]
  case(_,true) => x #:: collatz( x / 2 )
  case(_,false) => x #:: collatz( x * 3 + 1 )

def collatz2(x:Int) : LazyList[Int] = x #:: ((x, x % 2 == 0) match
  case(1,_)     => LazyList.empty[Int]
  case(_,true)  => collatz2( x / 2 )
  case(_,false) => collatz2( x * 3 + 1 ))



@tailrec
def collatzSize(x : Int , acc : Int = 0) : Int = (x, x % 2 == 0) match
  case(1,_) => acc
  case(_,true) => collatzSize( x / 2 , acc + 1)
  case(_,false) => collatzSize( x * 3 + 1 , acc + 1)

(1 to 20000).map(x => (x,collatzSize(x))).sortBy(x => -x._2).take(10)

collatz(1161).foreach(x=>print(s"${x},"))

(18000 to 158000).map(x => (x,collatzSize(x))).maxBy(x => x._2)
// val res0: (Int, Int) = (52527,339)

val collatzIterator = new Iterator[Int] :
  var i : Int = 1000
  def hasNext() : Boolean = (i != 1)
  def next() : Int =
    i = if (i % 2 == 0)
      i / 2
    else
      i * 3 + 1
    i


val lazyCollatz : LazyList[Int] = LazyList.iterate(100)(i => if (i % 2 == 0) i / 2 else i * 3 + 1)
