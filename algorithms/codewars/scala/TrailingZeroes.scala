/*
Write a program that will calculate the number of trailing 
zeros in a factorial of a given number.

N! = 1 * 2 * 3 *  ... * N

Be careful 1000! has 2568 digits...
*/



object Solution {
  // Execution Timed Out (16000 ms)
  // Why did my code time out?
  // Our servers are configured to only allow a 
  // certain amount of time for your code to execute. 
  // In rare cases the server may be taking on too much 
  // work and simply wasn't able to run your 
  // code efficiently enough. Most of the time though 
  // this issue is caused by inefficient algorithms. 
  // If you see this error multiple times you should try to optimize your code further. 
  def zeros(n: Int): Int = {
  	val s = (BigInt(1) to BigInt(n)).fold(BigInt(1))(_*_).toString.toList
  	s.length - s.reverse.dropWhile(_=='0').length
  }
}