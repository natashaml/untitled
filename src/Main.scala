/**
  * Created by levkovich.n on 22/07/2016.
  */
object Main extends App {
  printTable((a: Boolean, b: Boolean, c: Boolean) => and(a, and(b, c)))

  def printTable(f: (Boolean, Boolean, Boolean) => Boolean): Unit = {
    val bool = List(false, true)
    println(s"A\t\tB\t\tC\t\tresult")
    for (a <- bool; b <- bool; c <- bool)
      println(s"$a\t$b\t$c\t${f(a, b, c)}")
  }

  def and(a: Boolean, b: Boolean): Boolean = a && b
}
