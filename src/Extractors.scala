import scala.util.matching.Regex

/**
  * Created by levkovich.n on 22/07/2016.
  */
object Extractors extends App {
  println(unapply("#1f1f1FF"));   // => None
  println(unapply("#f1f1FF"));    // =>    Some((#,f1f1FF))
  println(unapply("natasha.ml.lev1993@gmail.com"));   // => Some((natasha.ml.lev1993,gmail.com))

  def isValidHex(str: String): Boolean = {
    val hexRegex =  "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$".r
    if (hexRegex.findFirstIn(str) == None) false
    else true
  }

  def isValidMail(str: String): Boolean = {
    val mailRegex = """(\w+)@([\w\.]+)""".r
    if (mailRegex.findFirstIn(str) == None) false
    else true
  }

  def isValidUrl(str: String): Boolean = {
    val urlRegex =  """(http|ftp)://(.*)\.([a-z]+)""".r
    if (urlRegex.findFirstIn(str) == None) false
    else true
  }

  def unapply(arg: String): Option[(String, String)] = {
      val subString = arg split "@"
      val subStringHex = arg split "#"
      if (isValidHex(arg)) Some("#", subStringHex(1))
      else if (isValidMail(arg)) Some(subString(0), subString(1))
      else None
  }
}
