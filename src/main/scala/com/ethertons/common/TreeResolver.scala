package com.ethertons.common

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.{Session, SessionFactory}
import com.ethertons.domain.Person
import org.hibernate.criterion.Restrictions

@Component(value = "treeResolver")
class TreeResolver @Autowired()(sessionFactory: SessionFactory){

  def currentSession(): Session = sessionFactory.getCurrentSession

  implicit def toIntegerList( lst: List[Int] ) =
    seqAsJavaList( lst.map( i => i:java.lang.Integer ) )

  def ids(rootPersonId: java.lang.Integer): java.util.List[java.lang.Integer] = {
    val rootPerson: java.util.List[com.ethertons.domain.Person] = currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("id", rootPersonId)).list.asInstanceOf[java.util.List[Person]]
    val children = currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", rootPerson.head)).list.asInstanceOf[java.util.List[Person]]
//    (rootPerson :: ancestors(children.head, children.tail.toList)).map((x: Person) => x.getId).toList
//    val persons: java.util.List[Person] = (rootPerson.head :: ancestors(children.head, children.tail.toList)).asInstanceOf[java.util.List[Person]]
    val persons: java.util.List[Person] = (rootPerson.head :: ancestors(children.asScala.toList))//.asInstanceOf[java.util.List[Person]]
    persons.map((x: Person) => x.getId).toList
  }

//  def ids(rootPersonId: java.lang.Integer): java.util.List[java.lang.Integer] = {
//    val persons: java.util.List[Person] = currentSession().createCriteria((classOf[Person])).add(Restrictions.in("id", List(1,2))).list.asInstanceOf[java.util.List[Person]]
//    persons.map((x: Person) => x.getId).toList
//  }

  def ancestors(children: List[Person]): List[Person] = {
    children match {
      case Nil => Nil
      case first :: Nil => first :: ancestors(currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", first)).list.asInstanceOf[java.util.List[Person]].asScala.toList)
//      case first :: rest => first :: ancestors(rest.tail)
//      case first :: rest => first :: ancestors(rest.asInstanceOf[java.util.List[Person]].toList) :: ancestors(currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", first)).list.asInstanceOf[java.util.List[Person]].asScala.toList)
//      case first :: rest => first :: (ancestors(rest) ::: ancestors((currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", first)).list).asInstanceOf[java.util.List[Person]]))
      case first :: rest => first :: (ancestors(rest) ::: ancestors(currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", first)).list.asInstanceOf[java.util.List[Person]].asScala.toList))
    }


//    val children = currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", currentPerson)).list.asInstanceOf[java.util.List[Person]]
//    if (!children.isEmpty)
//      currentPerson :: ancestors(children.head, children.tail.toList)
//    else if (!siblings.isEmpty) {
//      currentPerson :: ancestors(siblings.head, siblings.tail)
//    } else {
//      List(currentPerson)
//    }
//    val grandchildren = currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", currentPerson)).list.asInstanceOf[java.util.List[Person]]
//    if (!children.isEmpty)
//      ancestors(children.head, children.tail)
//    else if (!grandchildren.isEmpty) {
//      currentPerson :: ancestors(grandchildren.head, grandchildren.tail)
//    } else {
//
//    }
//    } else {
//
//    }
//    val grandchildren = currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", currentPerson)).list.asInstanceOf[java.util.List[Person]]
//    if (grandchildren.isEmpty) {
//      if (!children.isEmpty) {
//        val  grandchildren1 = currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", children.head)).list.asInstanceOf[java.util.List[Person]]
//        if (grandchildren1.isEmpty)
//        val  grandchildren2 = currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", children.head.head)).list.asInstanceOf[java.util.List[Person]]
//      }
//    }

//    val grandchildren = currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", currentPerson)).list.asInstanceOf[java.util.List[Person]]
//    if (!grandchildren.isEmpty)
//      currentPerson :: ancestors(children.head, grandchildren.tail.toList)
//    val grandchildren = currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", currentPerson)).list.asInstanceOf[java.util.List[Person]]
//    if (!grandchildren.isEmpty) currentPerson :: ancestors(grandchildren.head, grandchildren.tail.toList)
//    else if (!children.isEmpty)
//      currentPerson :: ancestors(children.head, children.tail)
//    else {
//      currentPerson :: Nil
//    }
  }

//  def ancestors(currentPerson: Person, children: List[Person]): List[Person] = {
//    val grandchildren = currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", currentPerson)).list.asInstanceOf[java.util.List[Person]]
//    if (!grandchildren.isEmpty) currentPerson :: ancestors(grandchildren.head, grandchildren.tail.toList)
//    else if (!children.isEmpty)
//      currentPerson :: ancestors(children.head, children.tail)
//    else {
//      currentPerson :: Nil
//    }
//  }



}
