package gedcom

class GedcomIndividual(_firstName: String, _surname: String, _birthDate: String, _birthPlace: String, _id: String, _familyId: String) extends GedcomRoot {

  def firstName(): String = _firstName
  def surname(): String = _surname
  def birthDate(): String = _birthDate
  def birthPlace(): String = _birthPlace
  def id(): String = _id
  def familyId(): String = _familyId

  def getFirstName(): String = _firstName
  def getSurname(): String = _surname
  def getBirthDate(): String = _birthDate
  def getBirthPlace(): String = _birthPlace
  def getId(): String = _id
  def getFamilyId(): String = _familyId

}