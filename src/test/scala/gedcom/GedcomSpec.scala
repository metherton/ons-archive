package gedcom

import org.scalatest.FunSuite
import org.scalatest.mock.EasyMockSugar
import org.junit.Assert
import org.hamcrest.Matchers

class GedcomSpec extends FunSuite with EasyMockSugar {

  test("first person found in file is Martin Etherton") {

    val gedcomParser = new GedcomParser("/Users/metherton/Downloads/EthertonLondon.ged")
    val firstPersonFound: GedcomIndividual = gedcomParser.individuals().head

    Assert.assertThat(firstPersonFound.fullName(), Matchers.is("Martin Etherton"))
  }

}
