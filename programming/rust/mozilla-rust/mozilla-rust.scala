//package mayton.rust

  import java.nio.file.{Files, Path}
  import java.util.regex.Matcher
  import scala.annotation.tailrec
  import scala.util.matching.Regex
  import java.nio.file.{Files, Paths}
  import scala.collection.mutable
  import scala.jdk.CollectionConverters.*
  import scala.jdk.StreamConverters.*

object MozillaRust extends App {

    //if (args.length > 0) {
    //    println("args.length > 0")
    //}

    val hgHome = "/bigdata"

    val mozillaPath = "/hg/firefox-source"
    val linuxPath   = "/git.c/linux"

    val collection : mutable.Map[String, Int] = Files.walk(Path.of(hgHome + linuxPath))
      .toScala(LazyList)
      .flatMap(path => {
        val pattern: Regex = "^(.+\\.)(?<extension>c|cpp|rs)$".r
        val matcher : Matcher = pattern.pattern.matcher(path.getFileName.toString)
        if (matcher.matches()) Some((matcher.group("extension"),1)) else None
      })
      .foldLeft(mutable.Map[String,Int]())((mmap, item) => {
        if (mmap.contains(item._1))
          mmap(item._1) = mmap(item._1) + 1
        else
          mmap += (item._1 -> item._2)
        mmap
      })

      val sum = collection.values.sum

      println(s"Sum : ${sum}")

      val resultCollection : mutable.Iterable[(String, Int, String)] = collection.map(x => (x._1, x._2, java.lang.String.format("%.02f", x._2 / sum.toDouble)))

      println(resultCollection)

      val rankedCollection = resultCollection.toList.map(x => x._1 match {
        case "rs"  => (x,0)
        case "c"   => (x,1)
        case "cpp" => (x,2)
        case _     => (x,3)
      })

      println(rankedCollection)

}
