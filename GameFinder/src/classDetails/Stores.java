package classDetails;

public class Stores {
	
	public storeName name;
	public static enum storeName {
		Steam,
		Gamers_Gate,
		GreenManGaming,
		Amazon,
		GameStop,
		GameFly,
		GoG,
		Origin,
		Get_Games,
		Shiny_Loot,
		Humble_Store,
		Desura
	}
	public String storeID;

	public Stores(Integer ID) {
		// TODO Auto-generated constructor stub
		if (ID == 1) {
			this.storeID = ID.toString();
			this.name = storeName.Steam;
		}
		if (ID == 2) {
			this.storeID = ID.toString();
			this.name = storeName.Gamers_Gate;
		}
		if (ID == 3) {
			this.storeID = ID.toString();
			this.name = storeName.GreenManGaming;
		}
		if (ID == 4) {
			this.storeID = ID.toString();
			this.name = storeName.Amazon;
		}
		if (ID == 5) {
			this.storeID = ID.toString();
			this.name = storeName.GameStop;
		}
		if (ID == 6) {
			this.storeID = ID.toString();
			this.name = storeName.GameFly;
		}
		if (ID == 7) {
			this.storeID = ID.toString();
			this.name = storeName.GoG;
		}
		if (ID == 8) {
			this.storeID = ID.toString();
			this.name = storeName.Origin;
		}
		if (ID == 9) {
			this.storeID = ID.toString();
			this.name = storeName.Get_Games;
		}
		if (ID == 10) {
			this.storeID = ID.toString();
			this.name = storeName.Shiny_Loot;
		}
		if (ID == 11) {
			this.storeID = ID.toString();
			this.name = storeName.Humble_Store;
		}
		if (ID == 12) {
			this.storeID = ID.toString();
			this.name = storeName.Desura;
		}
	}
	
	public String toString() {
		return name.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
