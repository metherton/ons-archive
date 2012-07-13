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
        case s if s.startsWith("0 @P") => new GedcomIndividual( firstName(xs.tail find (_ startsWith("1 NAME"))),
                                                                surname(xs.tail find (_ startsWith("1 NAME"))),
                                                                birthDate(xs.tail find (_ startsWith("2 DATE"))),
                                                                birthPlace(xs.tail find (_ startsWith("2 PLAC"))))
        case _ => new UnknownGedcomRecord
      }
    )
    gedcomRecords.filter(_.isInstanceOf[GedcomIndividual]).asInstanceOf[List[GedcomIndividual]]
  }

  def surname(s: Option[String]): String =
    s match {
      case s: Some[String] => stripOutSurname(s)
      case _ => "unknown surname"
    }


  def firstName(s: Option[String]): String =
    s match {
      case s: Some[String] => stripOutFirstName(s)
      case _ => "unknown name"
    }

  def birthDate(s: Option[String]): String =
    s match {
      case s: Some[String] => stripOutBirthDate(s)
      case _ => "unknown birth date"
    }

  def birthPlace(s: Option[String]): String =
    s match {
      case s: Some[String] => stripOutBirthPlace(s)
      case _ => "unknown birth place"
    }

  def stripOutFirstName(s: Some[String]): String =  {
    getFirstName(s.getOrElse("Unknown value").stripPrefix("1 NAME ").replace("/", "").split("""\s+""").toList.dropRight(1))
  }

  def stripOutSurname(s: Some[String]): String =  {
    s.getOrElse("Unknown value").stripPrefix("1 NAME ").replace("/", "").split("""\s+""").toList.last
  }

  def stripOutBirthDate(s: Some[String]): String =  {
    s.getOrElse("Unknown value").stripPrefix("2 DATE ")
  }

  def stripOutBirthPlace(s: Some[String]): String =  {
    s.getOrElse("Unknown value").stripPrefix("2 PLAC ")
  }


  def getFirstName(names: List[String]) =  {
    if (names.isEmpty)
      ""
    else if (names.size > 1) {
      names.reduceLeft(_ + " " + _)
    } else {
      names.head
    }
  }

  def getSurname(names: List[String]) =  {
    if (names.isEmpty)
      ""
    else if (names.size > 1) {
      names.reduceLeft(_ + " " + _)
    } else {
      names.head
    }
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

