package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import android.widget.Toast;
import android.app.AlertDialog;


public class HomeActivity extends AppCompatActivity {

    DatabaseHelper studentDB = new DatabaseHelper(this);
    OldDatabaseHelper OldstudentDB = new OldDatabaseHelper(this);

    private Button btnNew;
    private Button btnOld;
    private Button btnUs;
    private Button btnView;
    private Button OldbtnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnNew = (Button) findViewById(R.id.btnNew);
        btnOld = (Button) findViewById(R.id.btnOld);
        btnUs = (Button) findViewById(R.id.btnUs);
        btnView = (Button) findViewById(R.id.btnView);
        OldbtnView = (Button) findViewById(R.id.OldbtnView);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity();
            }
        });

        btnOld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOldActivity();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewData();
            }
        });

        OldbtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OldViewData();
            }
        });

        btnUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUsActivity();
            }
        });
    }

    public void openNewActivity() {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

    public void openUsActivity() {
        Intent intent2 = new Intent(this, UsActivity.class);
        startActivity(intent2);
    }

    public void openOldActivity() {
        Intent intent3 = new Intent(this, OldActivity.class);
        startActivity(intent3);
    }

    public void ViewData(){
        Cursor data = studentDB.showData();

        if (data.getCount() == 0){
            display("Error", "No Data Found.");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()) {
            buffer.append("Name: " + data.getString(1) + "\n");
            buffer.append("Age: " + data.getString(2) + "\n");
            buffer.append("Address: " + data.getString(3) + "\n");
            buffer.append("Contact: " + data.getString(4) + "\n");
            buffer.append("Email: " + data.getString(5) + "\n");
            buffer.append("Previous School: " + data.getString(6) + "\n");
            buffer.append("\n");
            buffer.append("\n");
        }
        display("All Stored Data:", buffer.toString());
    }

    public void display(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void OldViewData(){
        Cursor data = OldstudentDB.showData();

        if (data.getCount() == 0){
            display("Error", "No Data Found.");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()) {
            buffer.append("Name: " + data.getString(1) + "\n");
            buffer.append("Age: " + data.getString(2) + "\n");
            buffer.append("Address: " + data.getString(3) + "\n");
            buffer.append("Contact: " + data.getString(4) + "\n");
            buffer.append("Email: " + data.getString(5) + "\n");
            buffer.append("Previous School: " + data.getString(6) + "\n");
            buffer.append("\n");
            buffer.append("\n");
        }
        display("All Stored Data:", buffer.toString());
    }

    public void Olddisplay(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
