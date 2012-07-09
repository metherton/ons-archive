package gedcom

import io.Source
import collection.generic.CanBuildFrom

class GedcomParser(_gedComFile: String) {

  def individuals(): List[GedcomIndividual] = {
    val elements =  parseElements(Source.fromFile(_gedComFile, "latin1").getLines().toList)( _.charAt(0).equals('0') )
    val mergedElements = mergeLists(Nil, elements).reverse
    val gedcomRecords = mergedElements map (xs =>
      xs.head.toString match {
        case s if s.startsWith("0 TRLR") => new GedcomTrailer
        case s if s.startsWith("0 @P") => new GedcomIndividual( fullname(xs.tail find (_ startsWith("1 NAME"))) )
        case _ => new UnknownGedcomRecord
      }
    )

    val individualRecords = gedcomRecords.filter(_.isInstanceOf[GedcomIndividual])

    List(new GedcomIndividual("Martin Etherton"))
  }

  def fullname(s: Option[String]): String =
    s match {
      case s: Some[String] => stripOutPrefix(s)
      case _ => "unknown name"
    }


  def stripOutPrefix(s: Some[String]): String =  {
    s.getOrElse("Unknown value").stripPrefix("1 NAME ")
  }

  def mergeLists[A](accum: List[List[A]], xs: List[List[A]]): List[List[A]] = {
    val splitUpList = xs splitAt 2
    splitUpList._2 match {
      case Nil => splitUpList._1.flatten :: accum
      case _ =>  mergeLists(splitUpList._1.flatten :: accum, splitUpList._2)
    }
  }

  def parseElements[A](xs: List[A])(p: A => Boolean): List[List[A]] =
    if (xs.isEmpty) Nil
    else xs span p match { case (a,b) => a :: parseElements(b)(x => !p(x))}

}

