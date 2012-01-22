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

class AddPerson extends Spec with OnsMock {

  describe("Create Person")  {
    it("should add person to database and return user to view of newly added persons details") {
      result.hasErrors().andReturn(false)
      onsService.storePerson(person)

      replay(onsService, result)
      val formName = addPersonForm.processSubmit(person, result)
      verify(onsService, result)

      assert(formName == "redirect:/persons/5")
    }
  }




}

