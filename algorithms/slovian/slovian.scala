object Slovian {

  val yat = ('Ѣ','ѣ')
  val fita = ('Ѳ','ѳ')
  val izhitsa = ('Ѵ','ѵ') // гласное И (редко используется)
  val consonantSet : Set[Char] = ("бвгджзклмнпрстфхцчшщ".toList).toSet

  def isConsonant(c : Char) : Boolean = consonantSet.contains(c)

  def isPunkt(c : Char) : Boolean = {
    //Pattern.matches("\\p{Punct}", c.toString)
    c == ',' || c == ';' || c == '.'
  }

  def znak(s : String) : String = {
    val zipped = (s.toCharArray.map(Some(_)).toList ++ List(None))
                                .zip(List(None) ++ s.toCharArray.map(Some(_)).toList)
    zipped.map(pair => (pair._1,pair._2) match {
      case (Some(_), Some(_)) => if ((isPunkt(pair._1.get) || pair._1.get == ' ') && isConsonant(pair._2.get)) "ъ" + pair._1.get.toString else pair._1.get.toString
      case (Some(_), None) => pair._1.get.toString
      case (None, Some(_)) => if (isConsonant(pair._2.get)) "ъ" else ""
      case (_,_) => ""
    }).mkString
  }

  def elder(s: String): String = {
    znak(s)
      .replace('е', 'ѣ')
      .replace('Е', 'Ѣ')
      .replace('ф','ѳ')
      .replace('Ф','Ѳ')
      .replace('и','і')
      .replace('И','І')
  }


}

