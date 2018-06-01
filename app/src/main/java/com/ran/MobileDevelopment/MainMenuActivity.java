package com.ran.MobileDevelopment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


    }


    public void onCalcClicked(View view) {
        startActivity(new Intent(this, CalculatorActivity.class));
    }


    public void onBdayClicked(View view) {
        startActivity(new Intent(this, BdayActivity.class));
    }


    public void onConstraintLayoutClicked(View view) {
        startActivity(new Intent(this, NoXMLConstraintLayout.class));
    }

}
