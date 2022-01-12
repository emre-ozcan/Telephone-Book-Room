package com.emreozcan.telephonebookroom.data;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.emreozcan.telephonebookroom.model.PhoneBook;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM phone_book_table")
    List<PhoneBook> loadAllPersons();

    @Insert(onConflict = REPLACE)
    void insertPerson(PhoneBook phoneBook);

    @Delete
    void deletePerson(PhoneBook phoneBook);

    @Update
    void updatePerson(PhoneBook phoneBook);

}
