package com.example.technical_assistant.services.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.technical_assistant.domain.User;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user.db";
    public static final String TABLE_NAME = "user";
    private static final int DATABASE_VERSION = 1;
    private Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(SQLiteUser.CREATE_TABLE_USER);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean InsertUser(User user) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("lastName", user.getLastName());
        values.put("firstName", user.getFirstName());
        values.put("mailAddress", user.getMailAddress());
        values.put("phone", user.getPhone());
        values.put("post", user.getPost());
        values.put("companyAffiliation", user.getCompanyAffiliation());
        values.put("language", user.getLanguage());
        values.put("login", user.getLogin());
        values.put("password", user.getPassword());
        values.put("server", user.getServer());
        values.put("port", user.getPort());
        values.put("nameDB", user.getNameDB());
        values.put("userDB", user.getUserDB());
        values.put("server", user.getServer());
        values.put("passwordDB", user.getPasswordDB());

        long resultSet = database.insert(TABLE_NAME, null, values);
        if(resultSet == -1){
            return false;
        } else return true;

    }

    public User getUser(){
        User user = new User();

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
            if(cursor.moveToFirst()) {
                do {
                    user.setId(cursor.getInt(0));
                    user.setLastName(cursor.getString(1));
                    user.setFirstName(cursor.getString(2));
                    user.setMailAddress(cursor.getString(3));
                    user.setPhone(cursor.getString(4));
                    user.setPost(cursor.getString(5));
                    user.setCompanyAffiliation(cursor.getString(6));
                    user.setLanguage(cursor.getString(7));
                    user.setLogin(cursor.getString(8));
                    user.setPassword(cursor.getString(9));
                    user.setServer(cursor.getString(10));
                    user.setPort(cursor.getString(11));
                    user.setNameDB(cursor.getString(12));
                    user.setUserDB(cursor.getString(13));
                    user.setPasswordDB(cursor.getString(14));
                } while (cursor.moveToNext());
            }
        cursor.close();

        return user;
    }

    public void updateUser(User originalUser, User newUser){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id", newUser.getId());
        values.put("lastName", newUser.getLastName());
        values.put("firstName", newUser.getFirstName());
        values.put("mailAddress", newUser.getMailAddress());
        values.put("phone", newUser.getPhone());
        values.put("post", newUser.getPost());
        values.put("companyAffiliation", newUser.getCompanyAffiliation());
        values.put("language", newUser.getLanguage());
        values.put("login", newUser.getLogin());
        values.put("password", newUser.getPassword());
        values.put("server", newUser.getServer());
        values.put("port", newUser.getPort());
        values.put("nameDB", newUser.getNameDB());
        values.put("userDB", newUser.getUserDB());
        values.put("server", newUser.getServer());
        values.put("passwordDB", newUser.getPasswordDB());

        db.update(TABLE_NAME, values, "id = ?", new String[]{String.valueOf(originalUser.getId())});
        db.close();
    }

}
