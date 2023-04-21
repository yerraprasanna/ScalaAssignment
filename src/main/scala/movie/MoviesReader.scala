package movie

trait MoviesReader{
  def readMovies():Seq[Movies]
}
case class Movies(imdbTitleId:String,title:String,originalTitle:String,year:Int,datePublished:String,genre:String,duration:Int,country:String,language:String,director:String,writer:String,productionCompany:String,actors:String,description:String,avgVote:Float,votes:Int,budget:String,usaGrossIncome:String="",worlwideGrossIncome:String="",metascore:Int=0,reviewsFromUsers:Int,reviewsFromCritics:Int)
