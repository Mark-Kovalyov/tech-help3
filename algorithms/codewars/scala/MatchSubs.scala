object MatchSubst {

  case class Author(title:String, author:String, corp:String, phone:String, date:String, ver:String, level:String)

  def change(s: String, prog: String, version: String): String = {
    (s,prog,version) match {
      case Author("g964",_,_,_,"2019-01-01",_,_) => s"Program: ${author}"
      case _ => "ERROR: VERSION or PHONE"
    }
  }
}
