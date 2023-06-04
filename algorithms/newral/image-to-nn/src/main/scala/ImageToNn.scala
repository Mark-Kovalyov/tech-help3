import java.awt.image.BufferedImage
import java.io.{FileInputStream, OutputStream}
import javax.imageio.ImageIO
import scala.math.{exp, pow}
import scala.util.Random

object ImageToNn extends App {

  case class Matrix(v : Array[Float], width : Int, height : Int)
  case class Vector(v : Array[Float], n : Int)

  case class YUVMatrix(y : Matrix, u : Matrix, v : Matrix)

  def getpixel(a : Array[Float], w : Int): Unit = {

  }

  def matrix2image(m : YUVMatrix) : BufferedImage = {
    new BufferedImage(m.y.width, m.y.height, BufferedImage.TYPE_INT_ARGB)
  }

  def image2matrix(image : BufferedImage) : YUVMatrix = {
    val width = image.getWidth()
    val height = image.getHeight()
    val v = new Array[Float](width * height)
    val rmatrix = YUVMatrix(Matrix(v, width, height), Matrix(v, width, height), Matrix(v, width, height))
    rmatrix
  }

  def sigmoid(x : Double) : Double = {
    1.0 / (1.0 + exp(-x))
  }

  def sigmoid_diff(x : Double) : Double = {
    exp(-x) / pow(1.0 + exp(-x) , 2.0)
  }

  def th(x : Double) : Double = {
    (exp(2.0 * x) - 1.0) / (exp(2.0 * x) + 1.0)
  }

  def ch(x : Double) : Double = {
    (exp(x) + exp(-x)) / 2.0
  }

  def th_diff(x : Double) : Double = {
    1.0 / pow(ch(x), 2.0)
  }

  var epoch = 0

  val image : BufferedImage = ImageIO.read(new FileInputStream("/bigdata/pics/flowers/collection1/103624469_f873987f44_b.jpg"))
  val matrix : YUVMatrix = image2matrix(image)
  val w = image.getWidth()
  val h = image.getHeight()

  val mymultiarr = Array.ofDim[Float](2, 2)

  val random = new Random()

  val INPUTS    : Int = 2    // (x,y) coordinates
  val FIRST_LR  : Int = 10   //
  val SECOND_LR : Int = 3    // (y,u,v) output colors
  val η : Int = 10 // Learning rate

  def simulate() : Unit = {

  }

  val network : Array[Matrix]

  def backErrorPropagation() : Unit = {
    val di = 0.0
    val yi = 0.0
    val si = 0.0
    val xj = 0.0
    for(layers <- network) {
      val Δw = η * (di - yi) * th_diff(si) * xj
    }
  }

  do {
    val x = random.nextInt(w)
    val y = random.nextInt(h)
    epoch = epoch + 1
    val m = Matrix
    val res = simulate()
    backErrorPropagation(res)
    var total_error = ???
    println(s"Epoch ${epoch}")
  } while(epoch < 1000)

  ImageIO.write(matrix2image(m), "PNG", OutputStream.nullOutputStream())

  println("OK")

}
