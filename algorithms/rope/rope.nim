type
  Rope[T]* = ref object
    data: T

proc concat*(rope: var Rope[T]) : Rope[T] =
  Rope()
