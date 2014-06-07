package classDetails;

import java.net.URL;

public class GameDetails {
	
	public Integer storeID;
	public String name;
	public String publisher;
	public String salePrice;
	public String retailPrice;
	public URL image;

	public GameDetails(Integer thisStoreID, String thisName, String thisPublisher
			, String thisSalePrice, String thisRetailPrice, URL thisImage) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}