object Spectrumize extends App {

  case class RGBColor(r:Double,g:Double,b:Double)

  def gammaCorrection(image : Image, gamma : Double) : Image = {
     null
  }

  def clusterize(image : Image, xf : Int, yf : Int) : (RGBColor,RGBColor) = {
     
     (RGBColor(0,0,0),RGBColor(0,0,0))
  }

  val filename = args(0)

  // Define spectrum Palette

  val WIDTH = 256
  val HEIGHT = 192
  val FRAME = 8

  val BRIGHTNESS = 1.0
  val CONTRAST = 1.0
  val GAMMA = 1.0

  val image = ImageIO.read(filename)

  for(xf <- 0 until WIDTH / FRAME ; yf <- 0 until HEIGHT / FRAME) {
    
  }


}