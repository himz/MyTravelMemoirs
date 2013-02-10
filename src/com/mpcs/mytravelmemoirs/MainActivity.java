package com.mpcs.mytravelmemoirs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnNewTrip = (Button) findViewById(R.id.btnNewTrip);

		Button btnOldTrips = (Button) findViewById(R.id.btnOldTrips);		
		






		btnNewTrip.setOnClickListener(new View.OnClickListener() {

			private Context context = getApplicationContext();

			public void onClick(View v) {
				Intent i1 = new Intent(MainActivity.this, CreateTripActivity.class);
				
				Toast.makeText(this.context, "Calling CreateTripActivity", Toast.LENGTH_LONG).show();

				startActivity(i1);

			}
		});
		
		
		
		btnOldTrips.setOnClickListener(new View.OnClickListener() {

			private Context context = getApplicationContext();

            public void onClick(View v) {
            	
				Intent i2 = new Intent(MainActivity.this, ViewOldTripsActivity.class);
				
				Toast.makeText(this.context, "Calling ViewOldTripsActivity", Toast.LENGTH_LONG).show();

                startActivity(i2);

            }
        }); 

		}




		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_main, menu);
			return true;
		}

	}
