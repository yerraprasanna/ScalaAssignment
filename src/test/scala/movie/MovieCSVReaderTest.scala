package movie
import org.scalatest.FunSuite
import org.scalatest.Matchers._
class MovieCSVReaderTest extends FunSuite{

  test("Load CSV file") {
    val movies=new MovieCSVReader("src/main/resources/imdb_movies.csv")
    movies.size shouldBe 20019
  }
}
