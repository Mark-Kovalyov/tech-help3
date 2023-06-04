def tankVol(h:Double, d:Double, vt:Double) : Double = {
  assume(h < d)
  assume(h >= 0)
  assume(d >= 0)
  assume(vt >= 0)
  val r = d / 2.0
  val L = vt / (Math.PI * r * r)
  val v = L * (r * r * Math.acos( ( r - h) / r) - (r - h) * Math.sqrt(r * r - (r - h) * (r - h)))
  v
}

def tankVol(h:Double, d:Double, vt:Double) : Double = {
  val r = d / 2.0
  val rr = r*r
  val rmh = r-h
  val L = vt / (Math.PI * rr)
  val v = L * (rr * Math.acos( rmh / r) -
               rmh * Math.sqrt(rr - rmh * rmh))
  return v
}

