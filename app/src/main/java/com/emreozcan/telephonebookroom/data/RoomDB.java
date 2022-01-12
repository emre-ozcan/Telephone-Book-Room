package com.emreozcan.telephonebookroom.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.emreozcan.telephonebookroom.model.PhoneBook;

@Database(entities = PhoneBook.class, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    private static String DATABASE_NAME = "telephone_book_database";
    private static RoomDB database;

    public synchronized static RoomDB getInstance(Context context) {

        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return database;
    }

    public abstract DatabaseDao databaseDao();
}
