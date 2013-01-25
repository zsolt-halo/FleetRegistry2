package com.fleetregistry.main;

import com.fleetregistry.vehicles.VehiclesActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_menu);

		/* Listview fill up */
		ListView menuListView = (ListView) findViewById(R.id.menuListView);
		String[] menus = new String[] { "Munk‡k", "SofÎršk", "Telephelyek",
				"Partnerek", "Aut—k", "Adminok", "Profil" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.menu_fragment, R.id.label, menus);
		menuListView.setAdapter(adapter);
		/**/
		menuListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent;
				
				switch (position) {
				case 0:
					intent = new Intent(MenuActivity.this, WorksActivity.class);
					MenuActivity.this.startActivity(intent);
					break;
				case 1:
					intent = new Intent(MenuActivity.this, DriversActivity.class);
					MenuActivity.this.startActivity(intent);
					break;
				case 2:
					intent = new Intent(MenuActivity.this, StationsActivity.class);
					MenuActivity.this.startActivity(intent);
					break;
				case 3:
					intent = new Intent(MenuActivity.this, PartnersActivity.class);
					MenuActivity.this.startActivity(intent);
					break;
				case 4:
					intent = new Intent(MenuActivity.this, VehiclesActivity.class);
					MenuActivity.this.startActivity(intent);
					break;
				case 5:
					intent = new Intent(MenuActivity.this, AdminsActivity.class);
					MenuActivity.this.startActivity(intent);
					break;
				case 6:
					intent = new Intent(MenuActivity.this, ProfilActivity.class);
					MenuActivity.this.startActivity(intent);
					break;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}

}
