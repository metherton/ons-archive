package gedcom

import io.Source

class GedcomParser(_gedComFile: String) {

  def individuals(): List[GedcomIndividual] = {
    Source.fromFile(_gedComFile, "latin1").getLines().foreach(line => {
        println(line.length + " " + line)
    })
    List(new GedcomIndividual("Martin Etherton"))
  }

}

