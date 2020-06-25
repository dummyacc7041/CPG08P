package com.example.app2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    DatabaseHelper studentDB;

    Button btnSubmit;
    EditText txtName, txtAge, txtBirthday, txtAddress, txtContactNo, txtEmail, txtPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        studentDB = new DatabaseHelper(this);

        txtName = (EditText) findViewById(R.id.txtName);
        txtAge = (EditText) findViewById(R.id.txtAge);
        txtBirthday = (EditText) findViewById(R.id.txtBirthday);
        txtAddress = (EditText) findViewById(R.id.txtAddress);
        txtContactNo = (EditText) findViewById(R.id.txtContactNo);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPS = (EditText) findViewById(R.id.txtPS);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        AddData();

    }

    public void AddData() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txtName.getText().toString();
                String age = txtAge.getText().toString();
                String birthday = txtBirthday.getText().toString();
                String address = txtAddress.getText().toString();
                String contactno = txtContactNo.getText().toString();
                String email = txtEmail.getText().toString();
                String previousschool = txtPS.getText().toString();

                boolean insertData = studentDB.addData(name, age, birthday, address, contactno, email, previousschool);

                if (insertData == true){
                    Toast.makeText(NewActivity.this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(NewActivity.this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
                }

                        openHomeActivity();

            }
        });
    }

    public void openHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
