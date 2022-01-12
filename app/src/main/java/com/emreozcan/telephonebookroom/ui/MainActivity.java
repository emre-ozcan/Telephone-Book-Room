package com.emreozcan.telephonebookroom.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.emreozcan.telephonebookroom.R;
import com.emreozcan.telephonebookroom.adapter.RecyclerCardAdapter;
import com.emreozcan.telephonebookroom.model.PhoneBook;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**Viewların Tanımlanması*/
    private RecyclerView rvMain;
    private FloatingActionButton fab;

    /**Recycler View'da Gösterilecek Olan Itemların Adaptörünün Tanımlanması*/
    private RecyclerCardAdapter recyclerCardAdapter;

    private ArrayList<PhoneBook> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Viewların Bağlanması*/
        rvMain = findViewById(R.id.rvMain);
        fab = findViewById(R.id.floatingActionButton);

        setPersonList();

        /**Recycler View'ın Görünüm Tipinin Belirlenmesi*/
        rvMain.setLayoutManager(new LinearLayoutManager(this));

        /**Adaptörün Initialize Edilmesi*/
        recyclerCardAdapter = new RecyclerCardAdapter(personList);

        /**Adaptörün Recycler View'a Bağlanması*/
        rvMain.setAdapter(recyclerCardAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddActivity.class));
            }
        });

        //TODO Kişi verileri database tarafından gelmeli
    }

    private void setPersonList(){
        personList = new ArrayList<>();
        PhoneBook phoneBook1 = new PhoneBook("Emre Özcan","05741852963");
        PhoneBook phoneBook2 = new PhoneBook("Berkay Kulak","05987654321");
        PhoneBook phoneBook3 = new PhoneBook("Süleyman Akıllı","05456123987");
        PhoneBook phoneBook4 = new PhoneBook("Ethem Büyüksaçlı","05963741852");

        personList.add(phoneBook1);
        personList.add(phoneBook2);
        personList.add(phoneBook3);
        personList.add(phoneBook4);
    }
}