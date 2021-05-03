package com.make.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.make.model.NewYourWordModel;

@Database(entities = {NewYourWordModel.class}, version = 1)
public abstract class NewYourWordDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "newYourWord.db";
    private static NewYourWordDatabase instance;

    public static synchronized NewYourWordDatabase getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), NewYourWordDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract NewYourWordDAO newYourWordDAO();
}
