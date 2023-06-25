# Scala ZIO

* ZIO is a zero-dependency Scala library for asynchronous and concurrent programming.

## Links

* https://zio.dev/

```
"dev.zio"           %% "zio"             % "2.0.15",
"dev.zio"           %% "zio-streams"     % "2.0.15"
```

```scala
object SftpZioMonad extends ZIOAppDefault {

  def run: ZIO[Any, ReportError, String] = mainf

  val mainf : ZIO[Any, ReportError, String] =
    for {
      id     <- userByEmail("mail@mail.com")
      costs  <- userCosts(id)
      report <- getReport(costs)
    } yield report

  def userByEmail(email: String) : ZIO[Any, ReportError, Long] = {
    if (!email.contains('@')) {
      ZIO.fail(InvalidEmail)
    } else {
      ZIO.succeed(1L)
    }
  }

  def userCosts(id : Long) : ZIO[Any, ReportError, Array[Int]] = {
    ZIO.succeed(Array[Int](1,2,3))
  }

  def getReport(arr:Array[Int]): ZIO[Any, ReportError, String] = {
    ZIO.succeed("Cool")
  }

}

```

## History

* scalaz8-effect (2017)
* scalaz-ioeffect (2018)
* scalaz-zio (2018)
* ZIO 2019

### Trapmpolining

* прыганье на батуте
  * case Pure(a: A)
  * case FlatMap[A, +B](a : IO[A], f: A => IO[B]) extends IO[B]

### Error handling

* case Throw(err : Throwable)

Некий цикл с continuation который вычисляет

```
@tailrec final def unsafeRun(): A = this match
   case Pure(a) => a
   case FlatMap(fx, f) =>
     fx match
       case Pure(x) => f(x).unsafeRun()
       case FlatMap(fy, g) =>
          fy.FlatMap(y => g(y).flatMap(f)).unsafeRun()
```


### Примитивы синхронизации

* Common::Ref
* Common::Promise
* Common::Sepaphore
* Common::Queue
* Common::resource pattern

```
sealed abstract Resource[F[_], +A] {
  def use
  def flatMap
}
```

```scala
val application : Resource[IO : Unit] = for {
  config <- readConfig
  state  <- initstate(config)
  db     <- initDb(config.db)
  kafka  <- connectToKafka(config.kafka)
  _      <- runBackgroupWorkers(config.bg)
  _      <- httpServ(config.http)
  _      <- IO.never
} yield()
```

* Common::Fiber
* Common::FiberLocal


# Common

* IO monad
* Communications
  * ref
  * queue
  * promise
  * semaphore
  * fiberlocals
* Fiber concurrencey
* Resource structured control

# Complete::Context

cats-effects:
```
type F[A] = ReaderT[AppCont,IO,A]
```
ZIO(встроенный контекст)
```
sealed trait ZIO[-R,+E,+A] {

}
```

# Complete::Unsafe Execution
cats
```
trait Effect[F[_]]
```
cats-3
```
trait Dispatcher
object Dispatcher
```
ZIO
```
object ZIO {
  def runtime[R] : URIO[R, Runtime[R]]
}
trait Runtime[R] {

}
```

# Complete::DomainErrors
vanilla
```
trait UserRepo {
  def findUser(id : UserId) : IO[Either[UserNotFound, User]]
  ....
}
```

ZIO
```
trait UserReportHistory {
  def findUser(id : UserId) : IO[UserNotFound, User]
}
```

# ZIO specials:

* STM (cats-stm)
* Module-pattern
  * Module-pattern 2.0 + ZLayer
  * Distage
* ZSchedule
