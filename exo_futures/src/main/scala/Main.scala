import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
object Main {

  val api = new BlogApi

  // A implémenter en se basant sur les méthodes de Api
  // (utiliser des flatMap, pas de for-expression)
  def getTextsOfPostsCommentedByUser(userId: Int): Future[Seq[String]] =
    ???

  // A implémenter en se basant sur les méthodes de Api
  // (utiliser des for-expression, pas de flatMap)
  def getTextsOfPostsCommentedByUserWithForExpressions(userId: Int): Future[Seq[String]] =
    ???

  def main(args: Array[String]): Unit = {
    val texts = Await.result(getTextsOfPostsCommentedByUser(1), 10.seconds)
    println("Resultats :")
    texts.foreach(println)
  }

}
