package com.example.valetparkingassistant;


import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class SecurityCheck extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.valetparkingassitant.MESSAGE";
	public static String MYNAME = "com.example.valetparkingassitant.MYNAME";
	public static String MYPLATE = "com.example.valetparkingassitant.MYPLATE";
	public static String MYREGNUM = "com.example.valetparkingassitant.MYREGNUM";
	public static String MYLOTNUM = "com.example.valetparkingassitant.MYLOTNUM";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_security_check);
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
		getMenuInflater().inflate(R.menu.security_check, menu);
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
	
	public void ticketnum(View view)
	{
		final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox1);
		
		String regnum[]={"67","66","68","70","101"};
		String people[]={"Bruce Wayne", "Peter Parker", "Jane Doe", "Paul Kingston", "Jimmy Dean"};
		String license[]={"BATMAN","SPYDER","JOFBGM","CA8QW9","JI329X"};
		String parklot[]={"16","5","9","6","7"};
		//String phonenumber[]={"777-777-7777","777-291-2177","777-123-7777","777-321-7777","777-412-7777"};
		
		if(checkBox.isChecked())
		{
			Intent intent = new Intent(this, LotInfo.class);
			EditText editText = (EditText) findViewById(R.id.editText1);
			String message = editText.getText().toString();
			intent.putExtra(EXTRA_MESSAGE, message);
			
			int temp = 0, remember = -1;
			for (;temp<5;temp++)
			{				
				if(message.equals(license[temp]))
				{
					remember = temp;
					intent.putExtra(MYNAME, people[remember]);
					intent.putExtra(MYPLATE, license[remember]);
					intent.putExtra(MYREGNUM, regnum[remember]);
					intent.putExtra(MYLOTNUM, parklot[remember]);
					break;
				}
				remember = -1;
			}
			if(remember == -1)
			{
				intent.putExtra(MYNAME, "A Person");
				intent.putExtra(MYREGNUM, "###");
				Random generator = new Random();
				int lot= generator.nextInt(20)+1;
				intent.putExtra(MYLOTNUM, Integer.toString(lot));
			}
			
			startActivity(intent);
		}
		else
		{
			// Do nothing!
			TextView t=new TextView(this);
		    t=(TextView)findViewById(R.id.textView1);
		    t.setText("Security Pictures Required to Obtain Lot Number");
		}
	}
	

}
