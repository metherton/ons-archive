package gedcom

import org.scalatest.{BeforeAndAfter, GivenWhenThen, FeatureSpec}
import org.scalatest.mock.{MockitoSugar, EasyMockSugar}
import org.scalatest.matchers.ShouldMatchers

class GedcomSpec extends FeatureSpec  with GivenWhenThen with ShouldMatchers with MockitoSugar with BeforeAndAfter {

  feature("person returned after parsing file")  {
    scenario("returns a person after parsing file") {
      when("file is read")
        val gedcomParser = new GedcomParser("/Users/metherton/Downloads/EthertonLondon.ged")
        val firstPersonFound = gedcomParser.individuals().head
      then ("a person is returned with first name Martin")
        firstPersonFound.firstName() should be("Martin")
      and  ("surname is Etherton")
        firstPersonFound.surname() should be("Etherton")
      and ("date of birth is 4 MAR 1963")
        firstPersonFound.birthDate() should be ("4 MAR 1963")
      and ("place of birth is Sheffield")
        firstPersonFound.birthPlace() should be ("Sheffield")
    }
  }

}
