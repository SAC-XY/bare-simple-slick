import Tables._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object Main {
  def main(args: Array[String]): Unit = {
    // import slick.jdbc.H2Profile.api._
    import slick.jdbc.MySQLProfile.api._

    val db = Database.forConfig("docker_mysql")

    try {
      val actions = (for {
        _ <- Persons.schema.create

        _ <- DBIO.seq(
          Persons += PersonsRow(1, "XY"),
          Persons += PersonsRow(2, "XYXY")
        )

        p <- Persons.result
      } yield p)

      // actionを実行
      val resultFuture = db.run(actions.transactionally)

      // Futureなのでブロッキングさせて結果を取り出さなきゃいけません
      val personsSeq = Await.result(resultFuture, Duration.Inf)
      personsSeq.foreach(Predef.println)

    } finally db.close
  }
}
