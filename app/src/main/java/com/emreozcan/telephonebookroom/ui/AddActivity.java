package com.emreozcan.telephonebookroom.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.emreozcan.telephonebookroom.R;
import com.emreozcan.telephonebookroom.data.RoomDB;
import com.emreozcan.telephonebookroom.model.PhoneBook;
import com.google.android.material.textfield.TextInputEditText;

public class AddActivity extends AppCompatActivity {

    private TextInputEditText etName, etNumber;
    private Button btAdd, btDelete;

    /**
     * Room Database Tanımlanması
     */
    private RoomDB database;

    private PhoneBook phoneBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        btAdd = findViewById(R.id.btAdd);
        btDelete = findViewById(R.id.btDelete);

        boolean isFromFab = getIntent().getBooleanExtra("isFromFab", false);
        if (!isFromFab) {
            phoneBook = (PhoneBook) getIntent().getSerializableExtra("person");
            btDelete.setVisibility(View.VISIBLE);

            etName.setText(phoneBook.getPersonName());
            etNumber.setText(phoneBook.getPersonNumber());
        }

        database = RoomDB.getInstance(this);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String personName = etName.getText().toString().trim();
                String personNumber = etNumber.getText().toString().trim();
                if (isFromFab) {
                    database.databaseDao().insertPerson(new PhoneBook(personName, personNumber));
                } else {
                    phoneBook.setPersonName(personName);
                    phoneBook.setPersonNumber(personNumber);
                    database.databaseDao().updatePerson(phoneBook);
                }
                startActivity(new Intent(AddActivity.this, MainActivity.class));
                finish();

            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database.databaseDao().deletePerson(phoneBook);

                startActivity(new Intent(AddActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}