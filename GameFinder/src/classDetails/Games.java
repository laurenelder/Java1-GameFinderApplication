package classDetails;

import java.net.URL;
import java.util.ArrayList;

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
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
