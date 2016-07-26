
/**
  * Created by natalya on 25.07.2016.
  */
object Node extends App {

  val root = new Node[Integer](0, Some(Node[Integer](1)), Some(Node[Integer](2)))
  dfs(root)
  println(toList(root))
  println(reduce[Integer]((root), (_ - _)))

  def dfs[A](root: Node[A]) {
    root.left.foreach(dfs)
    root.right.foreach(dfs)
    println(root.value)
  }

  def toList[A](t: Node[A]): List[A] = t match {
    case Node(value, left: Option[Node[A]], right) => List(value) ++ toList(left) ++ toList(right)
  }

  def toList[A](t: Option[Node[A]]): List[A] = t match {
    case None => List()
    case Some(node: Node[A]) => toList(node)
  }

  def reduce[A](t: Node[A], f: (A, A) => A): A = t match {
    case Node(value, None, None) => value
    case Node(value, Some(left), Some(right)) => f(value, f(reduce(left, f), reduce(right, f)))
    case Node(value, Some(left), None) => f(value, reduce(left, f))
    case Node(value, None, Some(right)) => f(value, reduce(right, f))
  }
}

case class Node[A](value: A, left: Option[Node[A]] = Option.empty, right: Option[Node[A]] = Option.empty)