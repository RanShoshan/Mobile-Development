package com.ran.MobileDevelopment;

import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;

public class BdayActivity extends AppCompatActivity {


    EditText name ;
    BdayDB bdaydb;
    String date;
    DatePickerDialog.OnDateSetListener dpd;
    TextView pick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bday);

        name = findViewById(R.id.name);
        pick = findViewById(R.id.pick);
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal  = Calendar.getInstance();
                int year =  cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day =  cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(BdayActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,dpd,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        dpd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                date = year +"-"+month+"-"+dayOfMonth;
                pick.setText(date);
            }
        };

        bdaydb = Room.databaseBuilder(getApplicationContext(),BdayDB.class, "mydb8.db").allowMainThreadQueries().build();
    }


    public void AddBday(View view) {
        String check = pick.getText().toString();
        if(check.equals("pick date") || name.getText().toString().equals("")) {
            Toast.makeText(BdayActivity.this, R.string.emptyFields, Toast.LENGTH_SHORT).show();
            return;
        }
        bdaydb.bdayDao().insertAll(new BdayEntity(name.getText().toString(),pick.getText().toString()));
        Toast.makeText(BdayActivity.this, R.string.added, Toast.LENGTH_SHORT).show();

    }

    public void ToList(View view) {
        Intent intent = new Intent(this, BdayList.class);
        startActivity(intent);
    }
}

