package web

import com.ethertons.domain.{Person, Surname, OnsServiceImpl}
import java.util.ArrayList
import org.scalatest.mock.EasyMockSugar
import org.easymock.EasyMock._
import org.scalatest.Spec
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import reflect.Class
import com.ethertons.web.{OnsController, AddPersonForm}

trait OnsMock extends EasyMockSugar {
  val onsService = mock[OnsServiceImpl]
  val model = mock[Model]
  val result = mock[BindingResult]
  val addPersonForm = new AddPersonForm(onsService)
  val possibleSurnames = listPossibleSurnames()
  val possibleFathers = listPossibleFathers()
  val possibleMothers = listPossibleMothers()
  val person = aNewPerson()
  val onsController = new OnsController(onsService)

  def listPossibleFathers(): ArrayList[Person] = {
    var possibleFathers = new ArrayList[Person]
    possibleFathers.add(new Person)
    possibleFathers.add(new Person)
    possibleFathers
  }

  def listPossibleMothers(): ArrayList[Person] = {
    var possibleMothers = new ArrayList[Person]
    possibleMothers.add(new Person)
    possibleMothers.add(new Person)
    possibleMothers
  }

  def listPossibleSurnames(): ArrayList[Surname] = {
    var possibleSurnames = new ArrayList[Surname]
    possibleSurnames.add(new Surname)
    possibleSurnames.add(new Surname)
    possibleSurnames
  }

  def aNewPerson(): Person = {
    var newPerson = new Person
    newPerson.setId(5)
    newPerson.setSurname(new Surname)
    newPerson.setFirstName("newPerson")
    newPerson.setGender(true)
    newPerson.setFather(new Person)
    newPerson.setMother(new Person)
    newPerson
  }

}

