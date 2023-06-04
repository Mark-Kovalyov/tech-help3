// Ancient Egyptian multiplication (Int/BigInt)

def half(a:Int) : Int = a / 2
def half(a:BigInt) : BigInt = a / 2

def odd(a:Int) : Boolean = a % 2 == 1
def odd(a:BigInt) : Boolean = a % 2 == 1

def mult_acc4(n:Int, a:Int, r:Int = 0) : Int = (odd(n), n) match
  case (true, 1) => r + a
  case (true, _) => mult_acc4(half(n), a + a, r + a)
  case (_,_)     => mult_acc4(half(n), a + a, r)

def mult_acc5(n:BigInt, a:BigInt, r:BigInt = 0) : BigInt = (odd(n), n) match
  case (true, 1) => r + a
  case (true, _) => mult_acc5(half(n), a + a, r + a)
  case (_,_)     => mult_acc5(half(n), a + a, r)

/////////////// Little bit Haskell-style //////////////////////////////////////

def odd(a: BigInt): Boolean = a % BigInt(2) == BigInt(0)
def odd(a: Int): Boolean = a % 2 == 0

def half(a: BigInt): BigInt = a / BigInt(2)
def half(a: Int): Int = a / 2

def sum(a: Int, b: Int) : Int = a + b
def sum(a: BigInt, b: BigInt) : BigInt = a + b

def one(x : Any) : String = x match {
  case (x:Int) => "1"
  case (x:BigInt) => "1"
}


/*def sum[T](a: T, b:T): T = (a, b) match
  case (x: Int, y: Int) => (x + y).asInstanceOf[T]
  case (x: BigInt, y: BigInt) => (x + y).asInstanceOf[T]*/

 def mult_acc[T](n: T, a: T, r: T): T = {
   val odin = one(n)
   (odd(n), n) match {
     case (true, n) if (n == odin) => sum(r, a)
     case (true, _)     => mult_acc(half(n), sum(a, a), sum(r, a))
     case (_, _)        => mult_acc(half(n), sum(a, a), r)
   }
 }


