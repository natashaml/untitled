/**
  * Created by natalya on 23.07.2016.
  */
object URL extends App {
  val URL = """(http|ftp)://(.*)\.([a-z]+)""".r

  def unapplyUrl(url: String) = url match {
    case URL(protocol, domain, tld) => println(Some(protocol, domain, tld))
    case _ => println(None)
  }

  unapplyUrl("http://www.music.yandex.by") // => Some((http,www.music.yandex,by))
  unapplyUrl("adsdf") // => None
}
