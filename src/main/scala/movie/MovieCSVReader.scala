package movie
import scala.io.Source
object MovieCSVReader {
  def main(args: Array[String]): Unit = {
    val fileName="C:/Users/yprasanna/Desktop/Scala/imdb_movies.csv"
    val fileSource=Source.fromFile(fileName)
    for(line <- fileSource.getLines){
      println(line)

    }
    fileSource.close()
  }

}

class MovieCSVReader(val fileName: String) extends MoviesReader{
  override def readMovies(): Seq[Movies] = {
    for{
      line <- Source.fromFile(fileName).getLines().drop(1).toVector
      values = line.split(",").map(_.trim)
    } yield Movies(values(0),values(1),values(2),values(3).toInt,values(5),values(6),values(7).toInt,values(8),values(9),values(10),values(11),values(12),values(13),values(14),values(15).toFloat,values(16).toInt,values(17),values(18),values(19),values(20).toInt,values(21).toInt,values(22).toInt)
  }
}


