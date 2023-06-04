import scala.io.Source

object DumpWords extends App {
 for (line <- Source.fromFile("words.txt").getLines) {
     val words = line.split(" ")
     words.foreach(println)
 }
}

