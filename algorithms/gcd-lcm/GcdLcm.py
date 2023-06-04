import functools
from typing import List

def gcd(a:int, b:int) -> int:
  if b!=0:
    return gcd(b,a%b)
  else:
    return a


def lcm(a:int, b:int) -> int : return a * b // gcd(a,b)


def gcd_list(xlist : List[int]) -> int: return functools.reduce(lambda a,b: gcd(a,b), xlist)


def lcm_list(xlist : List[int]) -> int: return functools.reduce(lambda a,b: lcm(a,b), xlist)




gcd_list([42,231,105])

