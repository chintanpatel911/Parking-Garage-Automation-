package com.example.valetparkingassistant;


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
		
		if(checkBox.isChecked())
		{
			Intent intent = new Intent(this, LotInfo.class);
			EditText editText = (EditText) findViewById(R.id.editText1);
			String message = editText.getText().toString();
			intent.putExtra(EXTRA_MESSAGE, message);
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
