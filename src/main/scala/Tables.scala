//import slick.jdbc.H2Profile.api._
import slick.jdbc.MySQLProfile.api._

object Tables {

  case class PersonsRow(id: Int, name: String)
  class Persons(tag: Tag) extends Table[PersonsRow](tag, "Persons") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")

    def * = (id, name) <> (PersonsRow.tupled, PersonsRow.unapply)
  }
  val Persons = TableQuery[Persons]

}
