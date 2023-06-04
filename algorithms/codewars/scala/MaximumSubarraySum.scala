
// Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)

def sequence(arr: Array[Int]): Int = {
  var max = Int.MinValue
  for(i <- 0 until arr.length ; j <- 0 until i) {
		println(s"${i},${j}")
    val ss = arr.slice(i, j).max
    println(s"max(${i},${j}) = ${ss}")
    max = if (ss > max) ss else max
  }
  if (max == Int.MinValue) 0 else max
}

sequence(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4))
