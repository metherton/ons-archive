package web
import org.scalatest.Spec
import com.ethertons.domain.Tree

class TreeAddSpec extends Spec with OnsMock {


  describe("add new Tree Form") {
    it("should show blank unfilled form where we can add a new tree") {

      model.addAttribute(anyObject(classOf[String]), anyObject(classOf[Tree])).andReturn(model)

      replay(onsService, model, result)
      val formName = addTreeForm.setUpForm(model)
      verify(onsService, model, result)

      assert(formName == "trees/form")

    }
  }
}
