// Name: Devin "Lauren" Elder
// Application: Game Finder Application
// Date: 6/26/2014
// Class: Java 1 Term 201406
// Assignment: Project 4

package classDetails;

// Game List Class
public class Games {
	
	public String gameName;
	public String dealID;
	public String cheapestPrice;
	public String thumbnail;

	public Games(String thisGameName, String thisDealID, String thisCheapestPrice
				, String thisThumbnail) {
		// TODO Auto-generated constructor stub
		this.gameName = thisGameName;
		this.dealID = thisDealID;
		this.cheapestPrice = thisCheapestPrice;
		this.thumbnail= thisThumbnail;
	}
	
	public String toString() {
		return gameName;
	}
}
