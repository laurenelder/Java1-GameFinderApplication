package classDetails;

import classDetails.Stores.storeName;
import android.R.integer;

public class Returns {
	
//	public Integer numberReturned;
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
