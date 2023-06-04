object SameUrl extends App {

	// There are 400 thousands keywords. Each keyword related to 10 urls.
	// Please find keyword pairs witch have 4 and more same urls.

	// Limitations: 
	//  - no one url related to each words.
	//  - unique urls covers around 30% of all database

	case class UrlEntity(urls : List[String])

	def generator() : LazyList[UrlEntity] = {
		
	}

}