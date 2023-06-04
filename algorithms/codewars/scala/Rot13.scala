object Rot13 {
  def rot13(message: String): String = {
    message.toCharArray.map(x => x match {
      case _ if (x >= 'a' && x <= 'z') => 'a' + ((x - 'a') + 13) % 26
      case _ if (x >= 'A' && x <= 'Z') => 'A' + ((x - 'A') + 13) % 26
      case _ => x.toInt
    }).map(x => x.toChar).mkString
  }
}
