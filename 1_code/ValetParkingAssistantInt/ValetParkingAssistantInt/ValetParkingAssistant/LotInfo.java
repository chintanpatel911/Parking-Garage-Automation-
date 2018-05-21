package com.example.valetparkingassistant;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class LotInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lot_info);
		String message = intent.getStringExtra(SecurityCheck.EXTRA_MESSAGE);
		TextView t= (TextView)findViewById(R.id.TextView01);
		t.append(message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lot_info, menu);
		return true;
	}

	public void next(View view)
	{
		// Fill in with something.
	}
}
