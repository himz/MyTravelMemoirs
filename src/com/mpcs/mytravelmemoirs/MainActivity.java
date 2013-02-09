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
		btnNewTrip.setOnClickListener(myhandler);
	}



	View.OnClickListener myhandler = new View.OnClickListener() {

		public void onClick(View v) {
			Context context = getApplicationContext();
			CharSequence text = "Hello toast!";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			
			Intent i = new Intent( MainActivity.this , CreateTripActivity.class);
			startActivity(i);
			
			//finish();
			
			

		}
	};


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
