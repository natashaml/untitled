import scala.annotation.tailrec

/**
  * Created by natalya on 23.07.2016.
  */
object Factorial extends App {

  def factorial(n: BigInt): BigInt = {
    @tailrec
    def fun(acc: BigInt, n: BigInt): BigInt = n match {
      case number: BigInt if number == 0 => acc
      case _ => fun(n * acc, n-1)
    }
    fun(1, n)
  }
  println(factorial(25))

}
