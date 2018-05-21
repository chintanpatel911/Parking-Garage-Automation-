package com.example.valetparkingassistant;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class CollectInfo extends Activity {
	public static String PLATE = "X0X0X0";
	public static String HOUR = "00";
	public static String MIN = "00";
	public static String PHONE = "000-000-0000";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_collect_info);
		String message = intent.getStringExtra(NoReservation.PLATE);
		String message2 = intent.getStringExtra(NoReservation.HOUR);
		String message3 = intent.getStringExtra(NoReservation.MIN);
		
		intent.putExtra(PLATE, message);
		intent.putExtra(HOUR, message2);
		intent.putExtra(MIN, message3);
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
		getMenuInflater().inflate(R.menu.collect_info, menu);
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

	public void goPark(View view)
	{
		Intent intent = new Intent(this, DispDrivLic.class);
		EditText editText = (EditText) findViewById(R.id.editText1);
		String num = editText.getText().toString();
		intent.putExtra(PHONE,num);
		startActivity(intent);
	}
}
