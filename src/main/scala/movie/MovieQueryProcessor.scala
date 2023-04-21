package movie

object MovieQueryProcessor extends App {

  class MovieQueryProcessor(val moviesReader: MoviesReader) {
    val movies = moviesReader.readMovies

    //1.Titles directed by given director in the given range
    def getTitlesDirectedBy(directorName: String, startYear: Int, endYear: Int) = {
      //val titles=movies.filter((_.director == directorName) && (_.year >= startYear) && (_.year <= endYear))
      val titles = movies.filter(_.director == directorName).filter(_.year >= startYear).filter(_.year <= endYear)
      titles
    }

    //2. Generate report of English
    def getEnglishTitles(givenUserReview: Int) = {
      val englishTitles = (movies.filter(_.language == "English")).filter(_.reviewsFromUsers > givenUserReview)
      englishTitles
    }

    //3.Generate highest budget titles for given year and country filters
    def getHighestBudgetTitles(givenYear: Int, givenCountry: String) = {
      val highBudgetTitles = movies.filter(_.country == givenCountry).filter(_.year == givenYear).sortBy(_.duration)(Ordering[Int].reverse)
      highBudgetTitles
    }

    //4. Longest Duration titles
    def longestDurTitle(givenCountry: String, minVotes: Int) = {
      movies.filter(_.country == givenCountry).filter(_.votes >= minVotes).sortBy(_.duration)(Ordering[Int].reverse)
    }

    //5. Language wise report
    def langWiseReport(givenCountry:String,givenBudget:String) = {
      val langs = List(movies.flatMap(_.language))
      //langs.foreach(movies.filter(_.country == givenCountry).filter(_.budget == givenBudget) => count)sortBy(count)(Ordering[Int].reverse)
      movies.filter(_.country == givenCountry).filter(_.budget == givenBudget)
    }

  }

}
