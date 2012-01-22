package web

import com.ethertons.domain.{Person, Surname, OnsServiceImpl}
import com.ethertons.web.{AddPersonForm, OnsController}
import java.util.ArrayList
import org.scalatest.mock.EasyMockSugar
import org.easymock.EasyMock._
import org.scalatest.Spec
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import reflect.Class

class PersonDetailsSpec extends Spec with OnsMock {

  describe("Person Details Form") {
    it("should add Person object to model and render view") {


      model.addAttribute( anyObject(classOf[String]), anyObject(classOf[Person])).andReturn(model)

      replay(onsService, model, result)
      val formName = addPersonForm.setUpForm(model)
      verify(onsService, model, result)

      assert(formName == "persons/form")
    }
  }

}
