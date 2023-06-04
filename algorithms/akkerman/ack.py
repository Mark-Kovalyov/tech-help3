def ack(n:int, m:int) -> int:
  match (n,m):
    case (0,_) :
      return n + 1
    case (_,0) :
      return ack(n-1, 1)
    case (_,_) :
      return ack(n-1, ack(n,(m-1)))

