package com.mpcs.mytravelmemoirs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateTripActivity extends Activity {

	private TripDbAdapter db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_trip);
		Button btnStart = (Button) findViewById(R.id.button1);
		btnStart.setOnClickListener(myhandler);
		db = new TripDbAdapter(this);
		db.open();
	}

	
	
	View.OnClickListener myhandler = new View.OnClickListener() {

		public void onClick(View v) {
			int id=1;
			
			Context context = getApplicationContext();
			EditText txtTripName = (EditText)findViewById(R.id.editText1);
			Intent i = new Intent( CreateTripActivity.this , TripInfoActivity.class);
			i.putExtra("tripName", txtTripName.getText().toString());
			startActivity(i);
			
			String tripname=txtTripName.getText().toString();
			
			db.createTrip(id, tripname);
			
			id++;
			
			//finish();
			
			

		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_create_trip, menu);
		return true;
	}

}
