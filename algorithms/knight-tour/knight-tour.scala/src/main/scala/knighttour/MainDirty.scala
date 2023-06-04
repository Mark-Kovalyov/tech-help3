package knighttour

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object MainDirty {

  def demoList(size : Int) : LazyList[(Int,Int)] = {
    (size - 1,size - 1) #:: (if ((size - 1) > 0) demoList(size - 1) else LazyList.empty)
  }

  def lazyTour(size : Int, x : Int, y : Int, cnt : Int = 0) : LazyList[List[(Int,Int)]] = {
    val x : List[(Int,Int)] = List[(Int,Int)]((1,2))
    LazyList.empty[List[(Int,Int)]]
  }

  // Dirty, mutable
  def tour(size : Int, x : Int = 0, y : Int = 0) : Either[String, List[(Int,Int)]] = {
    if (size < MIN_DESK || x < 0 || y < 0 || x >= size || y >= size) {
      Left("Error")
    } else {
      val desk : Array[Array[Int]] = Array.ofDim[Int](size, size)
      val currentStack : mutable.Stack[(Int,Int)] = mutable.Stack()

      def tour2(x : Int, y : Int, cnt : Int) : List[(Int,Int)] = {
        if (cnt < size * size) {
          for(v <- horseDirections) {
            val xx = x + v._1
            val yy = y + v._2
            if (is_allowed_move(xx, yy, size) && desk(xx)(yy) == 0) {
              desk(xx)(yy) = 1
              currentStack.push((xx, yy))
              tour2(xx, yy, cnt + 1)
              currentStack.pop()
              desk(xx)(yy) = 0
            }
          }
          currentStack.toList
        } else {
          currentStack.toList
        }
      }
      Right(tour2(x,y,1))
    }
  }

  
  

  def main(args : Array[String]) : Unit = {
    println(tour(7))
  }

}
