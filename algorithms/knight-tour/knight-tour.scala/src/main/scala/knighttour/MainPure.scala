package knighttour

class MainPure {

  def pureTour2(n : Int) : IndexedSeq[(Int,Int)] = {
    for {
      i <- 0 until n
      j <- i until n if i + j == n
      //Thread.sleep(1000L)
    } yield (i,j)

  }

  def pureTour(size : Int) : LazyList[List[(Int,Int)]] = {
    Thread.sleep(1 * 1000L)
    List[(Int,Int)]((size,size)) #:: (if (size > 0) pureTour(size - 1) else LazyList.empty)
  }

  def main(args : Array[String]) : Unit = {
    val t = new Thread {
      override def run: Unit = {
        pureTour(5)
          .map(x => x.reverse.map(x => "(" + x._1 + "," + x._2 + ")").mkString(";"))
          .foreach(x => println(x))
      }
    }
    t.start()
    t.join()
  }

}
