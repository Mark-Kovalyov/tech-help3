import scala.annotation.tailrec
import scala.collection.immutable.ListMap
import scala.collection.Map
import scala.collection.Set
import scala.collection.mutable.LinkedHashMap

@main def hello: Unit = {

  case class ConsFr(c : Char, freq : Double)

  var consonantFreq = List(
    ConsFr('н', 0.067),
    ConsFr('т', 0.06318),
    ConsFr('с', 0.05473),
    ConsFr('р', 0.04746),
    ConsFr('в', 0.04533),
    ConsFr('л', 0.04343),
    ConsFr('к', 0.03486),
    ConsFr('м', 0.03203),
    ConsFr('д', 0.02977),
    ConsFr('п', 0.02804),
    ConsFr('г', 0.01687),
    ConsFr('з', 0.01641),
    ConsFr('б', 0.01592),
    ConsFr('ч', 0.0145),
    ConsFr('х', 0.00966),
    ConsFr('ж', 0.0094),
    ConsFr('ш', 0.00718),
    ConsFr('ц', 0.00486),
    ConsFr('щ', 0.00361),
    ConsFr('ф', 0.00267)
  )

  var consonantFreqMap : Map[Char, Double] = consonantFreq.map(x => x.c -> x.freq).toMap

  println(s"consonantFreq.size = ${consonantFreq.size}")


  val initialMapping : Map[Char, String] = LinkedHashMap(
    '0' -> "н", '1' -> "р", '2' -> "д", '3' -> "т", '4' -> "ч",
    '5' -> "п", '6' -> "ш", '7' -> "с", '8' -> "в", '9' -> "к"
  )

  println(s"initialMapping.size = ${initialMapping.size}")

  val allConsonants : Set[Char] = consonantFreq.map(cf => cf.c).toSet

  val lastConsonants : Set[Char] = allConsonants.diff(initialMapping.map(_._2).map(_(0)).toSet)

  println(s"selectedConsonants.size = ${lastConsonants.size}")

  def cumulativeFrequency(map : Map[Char, String], list : List[ConsFr]) : List[(Char, Double)] = {
    //list.map(x => (x.c))
    List(['x',0.0])
  }

  def finalMapping(currentLastConsonants : Set[Char]) : Boolean = {
    if (currentLastConsonants.size > 0) {
      val cumFr : List[(Char, Double)] = cumulativeFrequency(initialMapping, consonantFreq)
      val minChar : Char = cumFr.sortBy(f => f._2).head._1
      println(s"${minChar}")
      finalMapping(currentLastConsonants - (currentLastConsonants.head))
    } else {
      true
    }
  }

  val res = finalMapping(lastConsonants)

  println("Done")

  //val allConsonants : Set[Char] = "бвгдежзклмнпрстфхцчшщ".toCharArray().toSet()

  //println(s"Mapping : ${initialMapping}")

  //val lastConsonants : Set[Char] = initialMapping toList map(x => x._2) map(c => c(0).toChar) toSet

  //val diff = allConsonants diff(last)

}
