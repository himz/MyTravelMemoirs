package com.mpcs.mytravelmemoirs;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class TripInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trip_info);
		EditText txtTripName = (EditText) findViewById(R.id.editText1);
		String tripName = getIntent().getExtras().getString("tripName");
		txtTripName.setText(tripName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_trip_info, menu);
		return true;
	}

}
