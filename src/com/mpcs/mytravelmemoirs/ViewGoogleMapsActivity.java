package com.mpcs.mytravelmemoirs;
import com.google.android.gms.maps.SupportMapFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class ViewGoogleMapsActivity extends FragmentActivity 
{    
    /** Called when the activity is first created. */
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SupportMapFragment fragment = new SupportMapFragment();
	    getSupportFragmentManager().beginTransaction()
	            .add(android.R.id.content, fragment).commit();
	}
	
}