package mayton

import java.nio.file.{Files, Path}
import java.util.regex.Matcher
import scala.annotation.tailrec
import scala.util.matching.Regex
import java.nio.file.{Files, Paths}
import scala.collection.mutable
import scala.jdk.CollectionConverters.*
import scala.jdk.StreamConverters.*

case class Node[T](value : T) :
  var parent : Option[Node[T]] = None
  override def toString: String = value.toString

@tailrec
def stepUp[T](current : Option[Node[T]], cnt : Int) : Option[Node[T]] = {
  (current,cnt) match {
    case (None,_) => None
    case (current,0) => current
    case (current,cnt) => stepUp(current.get.parent, cnt - 1)
  }
}

// Dirty implementation with loop and mutable set
def lca2[T](first : Node[T], second : Node[T]) : Option[Node[T]] = {
  if (first == second) Some(first) else {
    val set1 = mutable.Set[T]()
    val set2 = mutable.Set[T]()
    var p1 = first
    var p2 = second
    var res : Option[Node[T]] = None
    var b1 = false
    var b2 = false
    while (!set1.contains(p2.value) && !set2.contains(p1.value)) {
      set1 += p1.value
      if (p1.parent.isDefined) p1 = p1.parent.get
      set2 += p2.value
      if (p2.parent.isDefined) p2 = p2.parent.get
    }
    if (set1.contains(p2.value)) Some(p2)
    else if (set2.contains(p1.value)) Some(p1)
    else None
  }
}

def lca3[T](first : Node[T], second : Node[T]) : Option[Node[T]] = {
  if (first == second) Some(first) else {
    var set1 = Set[T]()
    var set2 = Set[T]()
    var p1 = first
    var p2 = second
    var res : Option[Node[T]] = None
    var b1 = false
    var b2 = false
    while (!set1.contains(p2.value) && !set2.contains(p1.value)) {
      set1 = set1 + p1.value
      if (p1.parent.isDefined) p1 = p1.parent.get
      set2 = set1 + p2.value
      if (p2.parent.isDefined) p2 = p2.parent.get
    }
    if (set1.contains(p2.value)) Some(p2)
    else if (set2.contains(p1.value)) Some(p1)
    else None
  }
}


// Much better with tail recursion
@tailrec
def lca4[T](p1 : Node[T], p2 : Node[T], set1 : Set[T] = Set[T](), set2 : Set[T] = Set[T]()) : Option[Node[T]] = {
  if (!set1.contains(p2.value) && !set2.contains(p1.value))
    lca4(
      if (p1.parent.isDefined) p1.parent.get else p1,
      if (p2.parent.isDefined) p2.parent.get else p2,
      set1 + p1.value,
      set2 + p2.value)
  else
    if (set1.contains(p2.value)) Some(p2)
    else if (set2.contains(p1.value)) Some(p1)
    else None
}

@tailrec
def lca5[T](p1 : Node[T], p2 : Node[T], set1 : Set[T] = Set[T](), set2 : Set[T] = Set[T]()) : Option[Node[T]] = {
  val pred1 = set1.contains(p2.value)
  val pred2 = set2.contains(p1.value)
  if (!pred1 && !pred2)
    lca5(
      if (p1.parent.isDefined) p1.parent.get else p1,
      if (p2.parent.isDefined) p2.parent.get else p2,
      set1 + p1.value,
      set2 + p2.value)
  else
    (pred1, pred2) match {
      case (true, _) => Some(p2)
      case (_, true) => Some(p1)
      case (_,_) => None
    }
}

@tailrec
def lca6[T](p1 : Node[T], p2 : Node[T], set1 : Set[T] = Set[T](), set2 : Set[T] = Set[T]()) : Option[Node[T]] = {
  (set1.contains(p2.value), set2.contains(p1.value)) match {
      case (true, _) => Some(p2)
      case (_, true) => Some(p1)
      case (_,_) => lca6(
        if (p1.parent.isDefined) p1.parent.get else p1,
        if (p2.parent.isDefined) p2.parent.get else p2,
        set1 + p1.value,
        set2 + p2.value)
  }
}


@main def hello(): Unit =
  println("OK")




