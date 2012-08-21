import com.ethertons.domain.{Gedcom, Person}
import java.util
import java.util.ArrayList
import org.easymock.EasyMock
import org.easymock.EasyMock._
import org.hamcrest.Matchers
import org.scalatest.Spec
import web.OnsMock

class OnsControllerSpec extends Spec with OnsMock {

  describe("list of persons") {
    it("should show list of persons")  {
      var persons = new ArrayList[Person]
      persons.add(new Person)
      
      onsService.findAllPersons().andReturn(persons)
      model.addAttribute(anyObject(classOf[String]), anyObject(classOf[ArrayList[Person]])).andReturn(model)

      EasyMock.replay(onsService, model)
      val formName = onsController.findAllPersons(model)
      EasyMock.verify(onsService, model)

      assert(formName == "persons/list")
    }
  }

  describe("list of gedcom files") {
    it("should show a list of gedcom files") {
      var gedcoms = new util.ArrayList[Gedcom]
      gedcoms.add(new Gedcom)

      onsService.findAllGedcoms().andReturn(gedcoms)
      model.addAttribute(anyObject(classOf[String]), anyObject(classOf[ArrayList[Gedcom]])).andReturn(model)

      EasyMock.replay(onsService, model)
      val formName = onsController.findAllGedcoms(model)
      EasyMock.verify(onsService, model)

      assert(formName == "gedcoms/list")
    }
  }
}
