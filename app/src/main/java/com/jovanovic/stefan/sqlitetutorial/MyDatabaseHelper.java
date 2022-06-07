package com.jovanovic.stefan.sqlitetutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_prescription";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PID= "prescription_pid";
    private static final String COLUMN_PREID = "prescription_preid";
    private static final String COLUMN_NIC = "prescription_nic";
    private static final String COLUMN_NAME = "prescription_name";
    private static final String COLUMN_EMAIL = "prescription_email";
    private static final String COLUMN_ADDRESS = "prescription_address";
    private static final String COLUMN_CONTACT = "prescription_contact";
    private static final String COLUMN_DOC= "prescription_doc";
    private static final String COLUMN_SPECI = "prescription_speci";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_PID + " TEXT, " +
                        COLUMN_PREID + " TEXT, " +
                COLUMN_NIC +"INTEGER,"+
                COLUMN_NAME+"TEXT,"+
                COLUMN_EMAIL+"TEXT,"+
                COLUMN_ADDRESS+"TEXT,"+
                COLUMN_CONTACT+"TEXT,"+
                COLUMN_DOC+"TEXT,"+ COLUMN_SPECI + " INTEGER   );";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addPrescription(String pid, String preid, int nic,String name,String email,String address,String contact,String doc,String speci){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PID, pid);
        cv.put(COLUMN_PREID, preid);
        cv.put(COLUMN_NIC, nic);
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_ADDRESS, address);

        cv.put(COLUMN_CONTACT, contact);
        cv.put(COLUMN_DOC, doc);
        cv.put(COLUMN_SPECI, speci);



        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String pid, String preid, String nic, String name, String email, String address, String contact, String doc, String speci){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PREID, preid);
        cv.put(COLUMN_NIC, nic);
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_ADDRESS, address);

        cv.put(COLUMN_CONTACT, contact);
        cv.put(COLUMN_DOC, doc);
        cv.put(COLUMN_SPECI, speci);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

    public void addPrescripion(String trim, String trim1, Integer valueOf, String trim2, String trim3, String trim4, String trim5, String trim6, Integer valueOf1) {
    }
}
