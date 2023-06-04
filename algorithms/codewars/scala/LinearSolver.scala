object LinearSolver {

	/*
	"2x + 4y + 6z = 18"
	"3y + 3z = 6"
	"x + 2y = z - 3"

	should result in a map :

	x = 2
	y = -1
	z = 3

	All coefficients are integers and generally fall within the range
	of -150 to 150, with a few ranging from -1000 to 1000. Free
	terms are integers in range -20000 to 20000.
	*/

	def 

  def solve(equations: String*): Map[String, Double] = {
			// Parse rows:
			// Detect variables
			for(equation <- equations) {

			}
			val varNames : mutable.Map[String,Double]()

			// Create matrix and vector of free terms
      val m = Array.ofDim[Double](3, 3)
			m(0,0) = 2
			m(0,1) = 4
			m(0,2) = 6

			m(1,0) = 3
			m(1,1) = 0
			m(1,2) = 3

			m(2,0) = 1
			m(2,1) = 2
			m(2,2) = -1

			val vec = Array[Double](3)
			vec
			// Solve

	}

}
