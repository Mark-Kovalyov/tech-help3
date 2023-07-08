import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

class SimpleGraph[V,E] {
  val vertices : Set[V]           = HashSet[V]()
  val edges    : HashMap[(V,V),E] = HashMap()
  def addV(v : V) : Unit          = vertices.append(v)
  def addE(v1 : V, v2 : V, e : E) : Unit = edges.put((v1,v2),e)
}

def dms2dd(s : String) : (Double,Double) = {
  val lat =
  val lon =
  (lat, lon)
}

def dd2dms(lat:Double, lon:Double) : String = {
  val lat_min =
  s"° ' " N ° ' " "
}

Decimal degrees (DD): 41.40338, 2.17403
Degrees, minutes, and seconds (DMS): 41°24'12.2"N 2°10'26.5"E
Degrees and decimal minutes (DMM): 41 24.2028, 2 10.4418

Geographic Coordinate System (GCS)
Universal Transverse Mercator (UTM)
Military Grid Reference System (MGRS)
Geohash

kiev :
  by_wiki:    "50° 27′ 00″ N  30° 31′ 24″ E"
  by_maxmind:  50.4333,       30.5167
