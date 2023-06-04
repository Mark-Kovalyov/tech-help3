/*
val testCases = List( //(s1, s2, expected)
    ("rkqodlw", "world", true),
    ("cedewaraaossoqqyt", "codewars", true),
    ("katas", "steak", false),
    ("scriptjava", "javascript", true),
    ("scriptingjava", "javascript", true)
  )
*/

object Scramblies {
  
  def scramble(s1: String, s2: String): Boolean = s1.toList.toSet.contains(s2.toList.toSet)

}

