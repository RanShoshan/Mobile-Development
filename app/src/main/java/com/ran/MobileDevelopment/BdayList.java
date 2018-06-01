package com.ran.MobileDevelopment;


import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class BdayList extends AppCompatActivity {

    RecyclerView bdaylist;
    RecyclerView.Adapter adapter;
    BdayDB bdaydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_bday);
        bdaylist = findViewById(R.id.bdaylist);

        bdaydb = Room.databaseBuilder(getApplicationContext(),BdayDB.class, "mydb8.db").allowMainThreadQueries().build();

        List<BdayEntity> birthDay = bdaydb.bdayDao().getallbirthday();

        bdaylist.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BdayAdapter(birthDay);
        bdaylist.setAdapter(adapter);
    }
}
