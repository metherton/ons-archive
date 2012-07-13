package gedcom

class GedcomIndividual(_firstName: String, _surname: String, _birthDate: String, _birthPlace: String) extends GedcomRoot {

  def firstName(): String = _firstName
  def surname(): String = _surname
  def birthDate(): String = _birthDate
  def birthPlace(): String = _birthPlace

}
