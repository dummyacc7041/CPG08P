package com.example.app2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class OldActivity extends AppCompatActivity {

    OldDatabaseHelper OldstudentDB;

    Button OldbtnSubmit;
    EditText OldtxtName, OldtxtAge, OldtxtBirthday, OldtxtAddress, OldtxtContactNo, OldtxtEmail, OldtxtStrand, OldtxtYrLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old);

        OldstudentDB = new OldDatabaseHelper(this);

        OldtxtName = (EditText) findViewById(R.id.OldtxtName);
        OldtxtAge = (EditText) findViewById(R.id.OldtxtAge);
        OldtxtBirthday = (EditText) findViewById(R.id.OldtxtBirthday);
        OldtxtAddress = (EditText) findViewById(R.id.OldtxtAddress);
        OldtxtContactNo = (EditText) findViewById(R.id.OldtxtContactNo);
        OldtxtEmail = (EditText) findViewById(R.id.OldtxtEmail);
        OldtxtStrand = (EditText) findViewById(R.id.OldtxtStrand);
        OldtxtYrLevel = (EditText) findViewById(R.id.OldtxtYrLevel);
        OldbtnSubmit = (Button) findViewById(R.id.OldbtnSubmit);

        OldAddData();

    }

    public void OldAddData() {
        OldbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Oldname = OldtxtName.getText().toString();
                String Oldage = OldtxtAge.getText().toString();
                String Oldbirthday = OldtxtBirthday.getText().toString();
                String Oldaddress = OldtxtAddress.getText().toString();
                String Oldcontactno = OldtxtContactNo.getText().toString();
                String Oldemail = OldtxtEmail.getText().toString();
                String Oldstrand = OldtxtStrand.getText().toString();
                String Oldyrlevel = OldtxtYrLevel.getText().toString();

                boolean insertData = OldstudentDB.OldaddData(Oldname, Oldage, Oldbirthday, Oldaddress, Oldcontactno, Oldemail, Oldstrand, Oldyrlevel);

                if (insertData == true) {
                    Toast.makeText(OldActivity.this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(OldActivity.this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
                }

                openHomeActivity();

            }
        });
    }

    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
