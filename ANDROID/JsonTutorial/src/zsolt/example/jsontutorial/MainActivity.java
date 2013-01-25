package zsolt.example.jsontutorial;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Window;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
	ArrayList<Driver> driverList = new ArrayList<Driver>();
	driverList.add(new Driver("Halo","Zsolt","06302595980"));
	driverList.add(new Driver("Kovacs","Geza","0633262266"));
	driverList.add(new Driver("Balogh","Ferike","734734780"));
	driverList.add(new Driver("Alexa","Mark"));
	
	/*CREATING JSON*/
	
	/*USIN custom JSON Lib to conver object to JSON string directly*/
	Gson jsonTool = new Gson();
	/*WHOLE json string*/
	String jsonStringOfDriverList = jsonTool.toJson(driverList);	
	/*Check log for the JSON string*/
	Log.i(this.getClass().getName(),jsonStringOfDriverList);
	
	
	
	
	/*PARSING JSON string*/
	
	/*Represents a generic type T. You can use this class to get the generic type for a class.*/
	Type type = new TypeToken<ArrayList<Driver>>(){}.getType();
	/*Create an ArrayList with objects type = Driver, from jsonStringOfDriverList.*/
    ArrayList<Driver> newDriverList = jsonTool.fromJson(jsonStringOfDriverList, type);

    for (Driver d : newDriverList) {
        Log.i(this.getClass().getName(),"d.toString = " + d.toString());
    }
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
