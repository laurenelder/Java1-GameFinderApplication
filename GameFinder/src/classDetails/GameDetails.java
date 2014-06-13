// Name: Devin "Lauren" Elder
// Application: Game Finder Application
// Date: 6/7/2014
// Class: Java 1 Term 201406
// Assignment: Project 2

package classDetails;

// Game Details Class
public class GameDetails {
	
	public Integer storeID;
	public String name;
	public String publisher;
	public String salePrice;
	public String retailPrice;
	public String image;

	public GameDetails(Integer thisStoreID, String thisName, String thisPublisher
			, String thisSalePrice, String thisRetailPrice, String thisImage) {
		// TODO Auto-generated constructor stub
		this.storeID = thisStoreID;
		this.name = thisName;
		this.publisher = thisPublisher;
		this.salePrice = thisSalePrice;
		this.retailPrice = thisRetailPrice;
		this.image = thisImage;
	}
	
	public String toString() {
		return name;
	}
}
