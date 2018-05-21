package com.example.valetparkingassistant;

import android.os.Bundle;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class YesReservation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yes_reservation);
		
		String name = intent.getStringExtra(EnterGarage.MYNAME);
		String plate = intent.getStringExtra(EnterGarage.MYPLATE);
		String phone = intent.getStringExtra(EnterGarage.MYPHONE);
		String regnum = intent.getStringExtra(EnterGarage.MYREGNUM);
		
		TextView tname= (TextView)findViewById(R.id.textView3);
		TextView tplate= (TextView)findViewById(R.id.textView1);
		TextView tphone= (TextView)findViewById(R.id.textView4);
		TextView tregnum= (TextView)findViewById(R.id.textView2);
				
		tname.setText(name);
		tplate.append(" "+plate);
		tphone.setText(phone);
		tregnum.append(": "+regnum);
		/*
		String resID = intent.getStringExtra(EnterGarage.CAR);
		TextView t= (TextView)findViewById(R.id.textView2);
		t.append(" "+resID);*/
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
		getMenuInflater().inflate(R.menu.yes_reservation, menu);
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
		Intent intent = new Intent(this, GoPark.class);
		startActivity(intent);
	}

}
