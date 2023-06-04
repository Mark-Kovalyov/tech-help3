//extends Iterable<String>, Comparable<Rope> {
trait Rope:
    def rebalance()
    // O(log n)
    def index(i : Int) : Char
    // O(log n)
    def split(i : Int) : (Rope, Rope)
    // O(log n) without rebalancing / O(n) worst case
    def concat(that : Rope) : Unit
    // O(log n) without rebalancing / O(n) worst case
    def insert(s : String, i : Int) : Unit
    // O(log n) without rebalancing / O(n) worst case
    def append(s : String) : Unit
    // O(log n)
    def delete(i : Int, j : Int) : Unit
    // O(n)
    def build() : String
