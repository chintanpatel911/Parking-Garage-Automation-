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

/*
 * import java.sql.*;
 * import net.sourceforge.jtds.jdbc.*;
*/


public class EnterGarage extends Activity {
	//public static String CAR = "com.example.valetparkingassitant.CAR";
	public static String MYNAME = "com.example.valetparkingassitant.MYNAME";
	public static String MYPLATE = "com.example.valetparkingassitant.MYPLATE";
	public static String MYPHONE = "com.example.valetparkingassitant.MYPHONE";
	public static String MYREGNUM = "com.example.valetparkingassitant.MYREGNUM";
	public static String MYLOTNUM = "com.example.valetparkingassitant.MYLOTNUM";
	public static int counter = -1;
	
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
		String regnum[]={"67","66","68","70","101"};
		String people[]={"Bruce Wayne", "Peter Parker", "Jane Doe", "Paul Kingston", "Jimmy Dean"};
		String license[]={"BATMAN","SPYDER","JOFBGM","CA8QW9","JI329X"};
		String parklot[]={"16","5","9","6","7"};
		String phonenumber[]={"777-777-7777","777-291-2177","777-123-7777","777-321-7777","777-412-7777"};
		if(licenseplate == 1)
		{
			Intent intent = new Intent(this, YesReservation.class);
			/*String driver = "net.sourceforge.jtds.jdbc.Driver";
			Class.forName(driver).newInstance();
			
			//
			
			String user = "13group5";
			String password = "bbcpww14";
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
			int person = 0;
			if(counter > 3)
			{
				person  = 0;
				counter = 0;
			}
			else
			{
				person  = counter + licenseplate;
				counter = counter + 1;
			}
			intent.putExtra(MYNAME, people[person]);
			intent.putExtra(MYPLATE, license[person]);
			intent.putExtra(MYPHONE, phonenumber[person]);
			intent.putExtra(MYREGNUM, regnum[person]);
			startActivity(intent);
		}
		else
		{
			Intent intent2 = new Intent(this, NoReservation.class);
			startActivity(intent2);
		}
	}
}
