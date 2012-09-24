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
    val persons: java.util.List[Person] = (rootPerson.head :: ancestors(children.asScala.toList))
    persons.map((x: Person) => x.getId).toList
  }

  def ancestors(children: List[Person]): List[Person] = {
    children match {
      case Nil => Nil
      case first :: Nil => first :: ancestors(currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", first)).list.asInstanceOf[java.util.List[Person]].asScala.toList)
      case first :: rest => first :: (ancestors(rest) ::: ancestors(currentSession().createCriteria((classOf[Person])).add(Restrictions.eq("father", first)).list.asInstanceOf[java.util.List[Person]].asScala.toList))
    }
  }
}
