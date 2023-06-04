# Quantum computing

## Qubit

```scala
class Qubit {
  def a : Double = 0.0
  def b : Double = 1.0
  // |a|² + |b|² = 1
}
```

## Algorithms:

* Алгори́тм Шо́ра () — квантовый алгоритм факторизации (разложения числа на простые множители), позволяющий разложить число M {\displaystyle M} M за время O ( log 3 ⁡ M ) {\displaystyle O(\log ^{3}M)} {\displaystyle O(\log ^{3}M)}, используя O ( log ⁡ M ) {\displaystyle O(\log M)} {\displaystyle O(\log M)} логических кубитов.

* Алгоритм Гровера (также GSA от англ. Grover search algorithm) — квантовый алгоритм решения задачи перебора, то есть нахождения решения уравнения
```
f(x) = 1
```

## Frameworks and Languages

|Lang|Framework|Link|
|-|-|-|
|Scala|Scotty|xyz.entangled::scotty:0.1.0|
|Scala|Scalala|org.scalala|

def one[T](n:T): T = {
  n match {
      case x: Int => 1.asInstanceOf[T]
      case x: BigInt => BigInt(1).asInstanceOf[T]
  }
}
