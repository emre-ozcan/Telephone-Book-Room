package com.emreozcan.telephonebookroom.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.emreozcan.telephonebookroom.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddActivity extends AppCompatActivity {

    private TextInputEditText etName,etNumber;
    private Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        btAdd = findViewById(R.id.btAdd);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO Kişi ekleme özelliği eklenecek.
                startActivity(new Intent(AddActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}