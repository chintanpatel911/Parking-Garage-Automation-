package com.example.valetparkingassistant;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class ObtainCar extends Activity {
	public static String NUM = "A Ticket Number";
	public static String PICKUP = "Picking up Car";
	public static String NAME = "Name";
	
	public static String rn[] = {"67","66","68","70","101"};
	public static String nl[] = {"Bruce Wayne", "Peter Parker", "Jane Doe", "Paul Kingston", "Jimmy Dean"};
	public static String lp[] = {"BATMAN","SPYDER","JOFBGM","CA8QW9","JI329X"};
	public static String lt[] = {"16","5","9","6","7"};
	public static int st[] = {0, 0, 0, 0, 0};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_obtain_car);
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
		getMenuInflater().inflate(R.menu.obtain_car, menu);
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
	
	public void getInfo(View view)
	{
		/*String regnum[]={"67","66","68","70","101"};
		String people[]={"Bruce Wayne", "Peter Parker", "Jane Doe", "Paul Kingston", "Jimmy Dean"};
		String license[]={"BATMAN","SPYDER","JOFBGM","CA8QW9","JI329X"};
		String parklot[]={"16","5","9","6","7"};*/
		
		Intent intent = new Intent(this, ObtainInfo.class);
		EditText editText = (EditText) findViewById(R.id.editText1);
		String message = editText.getText().toString();
		intent.putExtra(NUM, message);
		
		int temp = 0, remember = -1;
		for (;temp<5;temp++)
		{				
			if(message.equals(rn[temp]))
			{
				if(st[temp]==0)
				{
					remember = temp;			
					intent.putExtra(PICKUP, lt[temp]);
					intent.putExtra(NAME, nl[temp]);
					st[temp]=1;
					break;
				}
				else
				{
					remember = temp;			
					intent.putExtra(PICKUP, "Already Taken");
					intent.putExtra(NAME, nl[temp]);
					break;
				}
					
			}
			remember = -1;
		}
		if(remember == -1)
		{
			intent.putExtra(NAME, "Test Mode");
			/*Random generator = new Random();
			int lot= generator.nextInt(20)+1;*/
			intent.putExtra(PICKUP, "Test Lot Number");
		}
		
		startActivity(intent);
	}

}
