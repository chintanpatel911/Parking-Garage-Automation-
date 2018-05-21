package com.example.valetparkingassistant;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import java.util.Random;
import java.sql.*;

public class EnterGarage extends Activity {
	//public static String CAR = "com.example.valetparkingassitant.CAR";
	//public String LNAME = "com.example.valetparkingassitant.LNAME";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_garage);
		// Show the Up button in the action bar.
		setupActionBar();		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_garage, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void checkReservation(View view)
	{

		// Creating temporary global has license plate.
		Random generator = new Random();
		int licenseplate= generator.nextInt(2);
		
		if(licenseplate == 1)
		{
			Intent intent = new Intent(this, YesReservation.class);
			/*String user = "13group5";
			String password = "bbcpww14";
			String driver = "com.mysql.jdbc.Driver";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/13group5", user, password);
			
			String fiat="Fiat";
			Statement st = con.createStatement();
			String sql = ("SELECT * FROM Reservations123 WHERE car="+fiat+";");
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				int reserveID = rs.getInt("reservationID");
				String resID = Integer.toString(reserveID);
				intent.putExtra(CAR, resID);
			}
			
			con.close();*/
			startActivity(intent);
		}
		else
		{
			Intent intent2 = new Intent(this, NoReservation.class);
			startActivity(intent2);
		}
	}
}
