package com.google.communityclinic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Appointment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    public void makeNewAppointment (View view) {
        Intent intent = new Intent(getApplicationContext(), NewAppointment.class);
        startActivity(intent);
    }

    public void appointmentRemainder (View view) {
        Intent intent = new Intent(this, Reminder.class);
        startActivity(intent);
    }

    public void appointmentHistory(View view) {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }

}
