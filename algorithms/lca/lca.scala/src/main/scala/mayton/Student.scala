package mayton

case class Student(name : String, age : Int) extends Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Student]
  override def equals(that: Any): Boolean = that match {
    case that: Student => {
      that.canEqual(this) && this.name == that.name && this.age == that.age
    }
    case _ => false
  }
  override def hashCode(): Int = {
    val prime = 31
    var result = 1
    result = prime * result + age;
    result = prime * result + (if (name == null) 0 else name.hashCode)
    result
  }
}
