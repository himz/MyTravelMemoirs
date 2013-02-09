/*
 * Copyright (C) 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.mpcs.mytravelmemoirs;

import android.app.Application;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;

/**
 * Simple notes database access helper class. Defines the basic CRUD operations
 * for the notepad example, and gives the ability to list all notes as well as
 * retrieve or modify a specific note.
 * 
 * This has been improved from the first version of this tutorial through the
 * addition of better error handling and also using returning a Cursor instead
 * of using a collection of inner classes (which is less scalable and not
 * recommended).
 */
public class TripDbAdapter {

    public static final String trip_id = "id";
    public static final String trip_name = "name";
   

  
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    /**
     * Database creation sql statement
     */
   
  

    private Context mCtx;
    
    
    private static String tripsCreate = "create table Trips ( id integer primary key autoincrement, name text not null);";
	private static String tripDetailsCreate = "create table TripDetails( id integer primary key autoincrement, startLocationId integer not null, endLocationId integer not null, startDate date not null, endDate date not null);";
	private static String locationsCreate = "create table Location( id integer primary key autoincrement, name text not null);" ;
	private static String photosCreate = "create table Photos( id integer primary key autoincrement, name text not null);";
    private static final String TAG = "DBHelper";
    private static final String DATABASE_NAME = "TripIt";
    private static final String DATABASE_TABLE1 = "Trips";
    private static final String DATABASE_TABLE2 = "TripDetails";
    private static final String DATABASE_TABLE3 = "Location";
    private static final String DATABASE_TABLE4 = "Photos";
    
    
    private static final int DATABASE_VERSION = 2;

    private static class DatabaseHelper extends SQLiteOpenHelper {

    	private     Context context;

        DatabaseHelper(Context context) {
        	

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        	System.out.println("In DatabaseHelper constructor");

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        	
        	System.out.println("In onCreate()");
			
        	db.execSQL(tripsCreate);
    		db.execSQL(tripDetailsCreate);
    		db.execSQL(locationsCreate);
    		db.execSQL(photosCreate);
    		
    		Toast.makeText(context, "4 table created", Toast.LENGTH_LONG).show();
    		 
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS TripIt");
            onCreate(db);
        }
    }

    /**
     * Constructor - takes the context to allow the database to be
     * opened/created
     * 
     * @param ctx the Context within which to work
     */
    public TripDbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    /**
     * Open the notes database. If it cannot be opened, try to create a new
     * instance of the database. If it cannot be created, throw an exception to
     * signal the failure
     * 
     * @return this (self reference, allowing this to be chained in an
     *         initialization call)
     * @throws SQLException if the database could be neither opened or created
     */
    public TripDbAdapter open() throws SQLException {
    	
    	System.out.println("In open()");

        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }
    
    public long createTrip(int id , String name)
    {
    	 ContentValues initialValues = new ContentValues();
         initialValues.put(trip_id, id);
         initialValues.put(trip_name, name);

         return mDb.insert("Trips", null, initialValues);
    }

  

    public boolean deleteTrip(int id)
    {
    	return mDb.delete("Trips", id + "=" + id, null) > 0;

    }
    



    public void createPhoto()
    {

    }


    public void deletePhoto(int id)
    {

    }

}
