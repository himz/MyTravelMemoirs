package com.mpcs.mytravelmemoirs;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ViewOldTripsActivity extends ListActivity {

	private TripDbAdapter db;
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_old_trips);
		//Button btnStart = (Button) findViewById(R.id.button1);
		
		db = new TripDbAdapter(this);
		db.open();
		
		listView=(ListView) findViewById(R.id.list);
		fillData();
		
	}



	private void fillData() {
		// TODO Auto-generated method stub
		Cursor TripsCursor = db.getAllTrips();
        startManagingCursor(TripsCursor);

        // Create an array to specify the fields we want to display in the list
        
        String[] from = new String[] { TripDbAdapter.trip_name };

        // and an array of the fields we want to bind those fields to (in this
        // case just text1)
        int[] to = new int[] { R.id.list};

        // Now create a simple cursor adapter and set it to display
        ListAdapter trips = new SimpleCursorAdapter(this,R.layout.activity_view_old_trips, TripsCursor, from, to);
        listView.setAdapter(trips);

        /*
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.two_line_list_item, 
                TripsCursor,
                from,           
                to);  

        // Bind to our new adapter.
        setListAdapter(adapter);
       */
        
        
        
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_create_trip, menu);
		return true;
	}

}
