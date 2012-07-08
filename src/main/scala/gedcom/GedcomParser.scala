package gedcom

import io.Source

class GedcomParser(_gedComFile: String) {

  def individuals(): List[GedcomIndividual] = {
//    println(toggledPartition(Source.fromFile(_gedComFile, "latin1").getLines().toList)(x => x.charAt(0).equals('0')))
//    println(Source.fromFile(_gedComFile, "latin1").getLines().toList map (_.charAt(0).equals('0')) )
//    println(Source.fromFile(_gedComFile, "latin1").getLines().toList filter (_.length > 70) )
//    println(Source.fromFile(_gedComFile, "latin1").getLines().toList takeWhile  ( _.charAt(0).equals('0') ))
//    println(Source.fromFile(_gedComFile, "latin1").getLines().toList span  ( _.charAt(0).equals('0') ))
//    println( parseElements(Source.fromFile(_gedComFile, "latin1").getLines().toList)( _.charAt(0).equals('0') )  map (_.length)  )


//   val elements =  parseElements(Source.fromFile(_gedComFile, "latin1").getLines().toList)( _.charAt(0).equals('0') )  splitAt 2
//    println(elements._1)

    val orgList = List(1,2,3,1,4,5,6,1,3,4,8,1,5,6,7)



//    val elements = parseElements(orgList)(_ == 1)// (_ splitList)//splitAt 2
    val elements =  parseElements(Source.fromFile(_gedComFile, "latin1").getLines().toList)( _.charAt(0).equals('0') )

    println(mergeLists(Nil, elements))



//    elements filter
//    println( parseElements(Source.fromFile(_gedComFile, "latin1").getLines().toList)( _.charAt(0).equals('0')) flatten  )


//    println(List(1,2,3,-4,-5,7) span (_ > 0))
//    Source.fromFile(_gedComFile, "latin1").getLines().foreach(line => {
//        println(line.length + " " + line)
//    })
    List(new GedcomIndividual("Martin Etherton"))
  }

  def mergeLists[A](accum: List[List[A]], xs: List[List[A]]): List[List[A]] = {
    val splitUpList = xs splitAt 2
    splitUpList._2 match {
      case Nil => splitUpList._1.flatten :: accum
      case _ =>  mergeLists(splitUpList._1.flatten :: accum, splitUpList._2)
    }
  }

  def mergeLists1[A](accum: List[List[A]], xs: List[List[A]]): List[List[A]] = {
    val splitUpList = xs splitAt 2
    //    println((splitUpList._1).flatten)
    //    println(splitUpList._2)
    //    val flattenedList = splitUpList._1 flatten

    splitUpList._2 match {
      case Nil => accum
      //      case _ =>  List((splitUpList._1).flatten) // mergeLists(splitUpList._2)
      case _ =>  mergeLists1(splitUpList._1.flatten :: accum, splitUpList._2)
    }
  }



  //  def joinList[A](xs: List[A]): List[List[A]] =
//    if (xs.isEmpty) Nil
//    else xs splitAt 2 match { case (a,b) => a :: splitList(b)}


  def longerThanSeventy(s: String): Boolean = s.length > 70

  def parseElements[A](xs: List[A])(p: A => Boolean): List[List[A]] =
    if (xs.isEmpty) Nil
    else xs span p match { case (a,b) => a :: parseElements(b)(x => !p(x))}

//  def parseElements[A](xs: List[A])(p: A => Boolean): List[List[A]] =
//    if (xs.isEmpty) Nil
//    else xs span p match { case (a,b) => a :: parseElements(b)(x => !p(x)) }



  def toggledPartition[A](xs: List[A])(p: A => Boolean): List[List[A]] =
    if (xs.isEmpty) Nil
    else xs span p match { case (a,b) => a :: toggledPartition(b)(x => !p(x)) }

}

