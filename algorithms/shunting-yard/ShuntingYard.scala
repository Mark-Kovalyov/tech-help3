// https://en.wikipedia.org/wiki/Shunting_yard_algorithm


  // Input : 1000 * (60 * (60 * h + m) + s)
  // Out :   ?
  //
  // Input : a + b * c - d
  // Output: a b c * + d -
  //
  // Input : 3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3
  // Operator Precedence Associativity
  // -----------------------------
  //     ^    4          right
  //     *    3          left
  //     /    3          left
  //     +    2          left
  //     -    2          left
  //
  // OUtput: 3 4 2 * 1 5 - 2 3 ^ ^ / +

object ShuntingYard {
  def process(expr : String) : String = {
    val split = expr.split(" ")
    ""
  }
}