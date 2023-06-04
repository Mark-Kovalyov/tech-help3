/*
На улице стоят пять домов.
Англичанин живёт в красном доме.
У испанца есть собака.
В зелёном доме пьют кофе.
Украинец пьёт чай.
Зелёный дом стоит сразу справа от белого дома.
Тот, кто курит Old Gold, разводит улиток.
В жёлтом доме курят Kool.
В центральном доме пьют молоко.
Норвежец живёт в первом доме.
Сосед того, кто курит Chesterfield, держит лису.
В доме по соседству с тем, в котором держат лошадь, курят Kool.
Тот, кто курит Lucky Strike, пьёт апельсиновый сок.
Японец курит Parliament.
Норвежец живёт рядом с синим домом.
Кто пьёт воду? Кто держит зебру?

В целях ясности следует добавить, что каждый из пяти домов окрашен в 
свой цвет, а их жители — разных национальностей, владеют разными животными, пьют 
разные напитки и курят разные марки американских сигарет. Ещё одно замечание: в утверждении 
6 справа означает справа относительно вас.
*/

object Einstein extends App {

  // Facts
  val country = "eng" :: "sp" :: "ua" :: "nor" :: "jap" :: Nil
  val colors = "red" :: "green" :: "yellow" :: Nil
  val cigarette = "Kool" :: "Lucky Strike" :: "Parliament" :: "Chesterfield" :: Nil
  val driks = "milk" :: "water" :: "juice" :: 

  // Rules
  val rule1 = (f1:Fact => Boolean) = f1.country == "eng" && f1.color = "red"
  val rule2 = ((f1:Fact, f2:Fact) => Boolean) = abs(f1.n - f2.n) == 1
  val rule3 = (f1:Fact => Boolean) = f1.color == "yellow" && f1.smoke = "Kool"
  val rule4 = 
  

  def deep_dive(facts:List[Fact]) : Unit = ???

  case class Fact(n:Int, country:String, houseColor:String, habbit:String, smoke:String, drink:String, pet:String)

  


}