package br.com.lauratobiasf.rocketcommversao2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class RocketDAO {

    SQLiteDatabase db;

    public RocketDAO(Context c) {

        db = c.openOrCreateDatabase("rocketcomm", c.MODE_PRIVATE,null);

        db.execSQL("CREATE TABLE IF NOT EXISTS rockets(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "rocket_name TEXT NOT NULL," +
                "creation_date TEXT NOT NULL," +
                "rocket_height REAL," +
                "rocket_weight REAL," +
                "stages INTEGER," +
                "rocket_desc TEXT);");
    }

    public ArrayList<Rocket> getRockets(){

        ArrayList<Rocket> rocketArrayList = new ArrayList<Rocket>();

        Cursor cursor = db.rawQuery("SELECT * FROM rockets", null, null);

        cursor.moveToFirst();

        int id, stages;
        float rocket_height, rocket_weight;
        String rocket_name, creation_date, rocket_description;

        while(!cursor.isAfterLast()){

            id = cursor.getInt(cursor.getColumnIndex("id"));
            rocket_name = cursor.getString(cursor.getColumnIndex("rocket_name"));
            creation_date = cursor.getString(cursor.getColumnIndex("creation_date"));
            rocket_height = cursor.getFloat(cursor.getColumnIndex("rocket_height"));
            rocket_weight = cursor.getFloat(cursor.getColumnIndex("rocket_weight"));
            stages = cursor.getInt(cursor.getColumnIndex("stages"));
            rocket_description = cursor.getString(cursor.getColumnIndex("rocket_desc"));

            cursor.moveToNext();

        }

        return rocketArrayList;

    }
}
