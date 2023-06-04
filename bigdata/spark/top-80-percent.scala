val input = List(
  ("KING",5000.0),
  ("FORD",3000.0),
  ("SCOTT",3000.0),
  ("JONES",2975.0),
  ("BLAKE",2850.0),
  ("CLARK",2450.0),
  ("ALLEN",1600.0),
  ("TURNER",1500.0),
  ("MILLER",1300.0),
  ("MARTIN",1250.0),
  ("WARD",1250.0),
  ("ADAMS",1100.0),
  ("JAMES",950.0),
  ("SMITH",800.0)
)

val sum = input.map(x => x._2).sum

def cumulative_sum(input : List[(String, Double)]) : Seq[(String, Double, Double)] = {
  var sum : Double = 0.0
  for(pair <- input) yield {
    sum = sum + pair._2
    (pair._1, pair._2, sum)
  }
}

cumulative_sum(input).filter(item => item._3 < 0.8 * sum).foreach(item => println(item))

(KING,5000.0,5000.0)
(FORD,3000.0,8000.0)
(SCOTT,3000.0,11000.0)
(JONES,2975.0,13975.0)
(BLAKE,2850.0,16825.0)
(CLARK,2450.0,19275.0)
(ALLEN,1600.0,20875.0)
(TURNER,1500.0,22375.0)
