// Name: Devin "Lauren" Elder
// Application: Game Finder Application
// Date: 6/26/2014
// Class: Java 1 Term 201406
// Assignment: Project 4

package classDetails;


public class Returns {
	
	public display numberDisplay;
	public static enum display {
		Show_5_Results,
		Show_10_Results,
		Show_15_Results,
		Show_20_Results
	}

	public Returns(Integer number) {
		// TODO Auto-generated constructor stub
//		this.numberReturned = number;
		if (number == 5) {
			this.numberDisplay = display.Show_5_Results;
		}
		if (number == 10) {
			this.numberDisplay = display.Show_10_Results;
		}
		if (number == 15) {
			this.numberDisplay = display.Show_15_Results;
		}
		if (number == 20) {
			this.numberDisplay = display.Show_20_Results;
		}
	}

	public String toString() {
		String showNumber = numberDisplay.toString();
		showNumber = showNumber.replace("_", " ");
		return showNumber;
	}
}
