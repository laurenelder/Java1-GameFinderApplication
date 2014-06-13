// Name: Devin "Lauren" Elder
// Application: Game Finder Application
// Date: 6/7/2014
// Class: Java 1 Term 201406
// Assignment: Project 2

package com.example.gamefinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import classDetails.GameDetails;
import classDetails.Games;
import classDetails.Stores;

public class MainActivity extends Activity {

	// Global Variables
	static String tag = "MAINACTIVITY";
	static Context context;
	String dd = "Not Applicable";
	List<Games> gamesList = new ArrayList<Games>();
	List<Stores> storeList = new ArrayList<Stores>();
	List<GameDetails> gameDetails = new ArrayList<GameDetails>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
        // ListView Code
        ArrayAdapter<Games> listAdapter = new ArrayAdapter<Games>
		(this, android.R.layout.simple_list_item_1, gamesList);
        ListView listView = (ListView)findViewById(R.id.list);
		listView.setAdapter(listAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// Display Game Information Method
				showAlert(view, gamesList.get(position).toString());
//				Log.i(tag, "The listener works!");
			}
			
		});
		
		// Spinner Code
		ArrayAdapter<Stores> spinnerAdapter = new ArrayAdapter<Stores>
		(this, android.R.layout.simple_spinner_item, storeList);
		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinnerView = (Spinner)findViewById(R.id.storeList);
		spinnerView.setAdapter(spinnerAdapter);
		
		// JSON Parse Methods
		parseData("games");
		parseData("stores");
		parseData("details");
//		Log.i(tag, gamesList.toString());

		// Refresh Adapter Methods
		listAdapter.notifyDataSetChanged();
		spinnerAdapter.notifyDataSetChanged();
    }


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
	// Get and Parse JSON Function
	public void parseData(String classType) {
		
		//Get Data
		StringBuffer jsonBuffer = new StringBuffer();
		BufferedReader reader = null;
		try {
			// Selection of Static JSON Data and Parse According to JSON Format
			if (classType.matches("games")) {
				reader = new BufferedReader(new InputStreamReader(getAssets().open(
						"games.JSON")));
			}
			if (classType.matches("stores")) {
				reader = new BufferedReader(new InputStreamReader(getAssets().open(
						"stores.JSON")));
			}
			if (classType.matches("details")) {
				reader = new BufferedReader(new InputStreamReader(getAssets().open(
						"gameDetails.JSON")));
			}
			String temporaryData;
			while ((temporaryData = reader.readLine()) != null)
				jsonBuffer.append(temporaryData);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close(); 
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		String jsonString = jsonBuffer.toString();
//		Log.i(tag, jsonString);
		// Parse JSON
		try {
			// Creating JSONObject from String
			if (classType.matches("games")) {
				JSONArray jsonArray = new JSONArray(jsonString);
				for (int i = 0; i < jsonArray.length(); i++) {
					
					// Creating JSONObject from JSONArray
					JSONObject jsonSubObject = jsonArray.getJSONObject(i);
					
					// Class Specific Data
					String thisGameName = jsonSubObject.getString("external");
					String thisDealID = jsonSubObject.getString("cheapestDealID");
					String thisCheapestPrice = jsonSubObject.getString("cheapest");
					String thisThumbnail = jsonSubObject.getString("thumb");
/*					Log.i(tag, thisGameName);
					Log.i(tag, thisDealID);
					Log.i(tag, thisCheapestPrice);
					Log.i(tag, thisThumbnail);*/
					
					// Dummy Data
					Integer thisStoreID = 0;
					String thisName = dd;
					String thisPublisher = dd;
					String thisSalePrice = dd;
					String thisRetailPrice = dd;
					String thisImage = dd;
					Integer thisID = 0;
					
					// Set Class Method
					setClass( classType, thisGameName, thisDealID, thisCheapestPrice
							, thisThumbnail, thisStoreID, thisName, thisPublisher, thisSalePrice
							, thisRetailPrice, thisImage, thisID);
				}
				
			}
			if (classType.matches("stores")) {
				JSONArray jsonArray = new JSONArray(jsonString);
				for (int i = 0; i < jsonArray.length(); i++) {
					
					// Creating JSONObject from JSONArray
					JSONObject jsonSubObject = jsonArray.getJSONObject(i);
					
					// Class Specific Data
					Integer thisID = Integer.parseInt(jsonSubObject.getString("storeID"));
//					Log.i(tag, thisID.toString());
					
					// Dummy Data
					String thisGameName = dd;
					String thisDealID = dd;
					String thisCheapestPrice = dd;
					String thisThumbnail = dd;
					Integer thisStoreID = 0;
					String thisName = dd;
					String thisPublisher = dd;
					String thisSalePrice = dd;
					String thisRetailPrice = dd;
					String thisImage = dd;
					
					// SetClass Method
					setClass( classType, thisGameName, thisDealID, thisCheapestPrice
							, thisThumbnail, thisStoreID, thisName, thisPublisher, thisSalePrice
							, thisRetailPrice, thisImage, thisID);
				}
			}
			if (classType.matches("details")) {
				JSONObject mainObject = new JSONObject(jsonString);
				JSONObject subObject = mainObject.getJSONObject("gameInfo");
				
				// Class Specific Data
				Integer thisStoreID = Integer.parseInt(subObject.getString("storeID"));
				String thisName = subObject.getString("name");
				String thisPublisher = subObject.getString("publisher");
				String thisSalePrice = subObject.getString("salePrice");
				String thisRetailPrice = subObject.getString("retailPrice");
				String thisImage = subObject.getString("thumb");
/*				Log.i(tag, thisStoreID.toString());
				Log.i(tag, thisName);
				Log.i(tag, thisPublisher);
				Log.i(tag, thisSalePrice);
				Log.i(tag, thisRetailPrice);
				Log.i(tag, thisImage);*/
				
				// Dummy Data
				String thisGameName = dd;
				String thisDealID = dd;
				String thisCheapestPrice = dd;
				String thisThumbnail = dd;
				Integer thisID = 0;
				
				// Set Class Method
				setClass( classType, thisGameName, thisDealID, thisCheapestPrice
						, thisThumbnail, thisStoreID, thisName, thisPublisher, thisSalePrice
						, thisRetailPrice, thisImage, thisID);
			}
		} 
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	// Assigning Parsed Data to Proper Class
	public void setClass( String type, String gameName, String dealID, String cheapestPrice
			, String thumbnail, Integer StoreID, String Name, String Publisher
			, String SalePrice, String RetailPrice, String Image, Integer ID) {
		if (type.matches("games")) {
			Games newGame = new Games(gameName, dealID, cheapestPrice, thumbnail);
			gamesList.add(newGame);
			Log.i(tag, "This Part Works!");
		}
		if (type.matches("stores")) {
			Stores newStoreList = new Stores(ID);
			storeList.add(newStoreList);
		}
		if (type.matches("details")) {
			GameDetails details = new GameDetails(StoreID, Name, Publisher
					, SalePrice, RetailPrice, Image);
			gameDetails.add(details);
		}
	}

	// Alert Dialog with Game Information
    private void showAlert(View view, String findName) { 
    	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
    	alertDialogBuilder.setTitle(R.string.dialog_title);
    	// Constructing Alert Information from JSON Data
        for (int i = 0; i < gamesList.size(); i++) {
        	if (findName.matches(gamesList.get(i).toString()) ) {
        		String selectedStore = null;
				for (int a = 0; a < storeList.size(); a++) {
					if (gameDetails.get(0).storeID.toString().matches
							(storeList.get(a).storeID.toString())) {
						selectedStore = storeList.get(a).name.toString();
						selectedStore = selectedStore.replace("_", " ");
					}
				}
        		String allData = "Game: " + gamesList.get(i).gameName.toString()
        				+ "\r\nPublisher: " + gameDetails.get(0).publisher.toString()
        				+ "\r\nStore: " + selectedStore
        				+ "\r\nRetail Price: " + gameDetails.get(0).retailPrice.toString()
        				+ "\r\nSale Price: " + gameDetails.get(0).salePrice.toString();
        				
        		alertDialogBuilder.setMessage(allData);
        	}
        }
    	// Setting the Text for the Dialog Button
    	alertDialogBuilder.setNegativeButton(R.string.dialog_button,new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog,int id) {
    			// Close the Alert Dialog
    			dialog.cancel();
    		}
    	});
    	AlertDialog alertDialog = alertDialogBuilder.create();
    	// show alert
    	alertDialog.show();
    }
}
