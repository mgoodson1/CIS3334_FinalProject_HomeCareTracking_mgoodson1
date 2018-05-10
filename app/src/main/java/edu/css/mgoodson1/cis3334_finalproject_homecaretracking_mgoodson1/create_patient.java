package edu.css.mgoodson1.cis3334_finalproject_homecaretracking_mgoodson1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class create_patient extends AppCompatActivity {

    private Patient patient;
    private AppDatabase database;

    EditText txtPatientName;
    EditText txtPatientAge;
    EditText txtPatientWeight;
    TextView textViewDisplayPatients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_patient);


    }
    public void onClick(View view) {

        Context context = getApplicationContext();
        if (view.getId() == R.id.btnAddPatient) {

       //not working
         //   txtPatientName = findViewById(R.id.editTextPatientName);
         //   txtPatientAge = findViewById(R.id.editTextPatientAge);
         //   int aAge = Integer.parseInt(txtPatientAge.getText().toString());
         //   txtPatientWeight = findViewById(R.id.editTextPatientWeight);
         //   int aWeight = Integer.parseInt(txtPatientWeight.getText().toString());
         //    database.patientDao().addPatient(new Patient(txtPatientName.getText().toString(), aAge, aWeight));

            returnToMain();
        }

        if (view.getId() == R.id.btnRetunToMain) {
            returnToMain();
        }

    }

    public void returnToMain() {
        Intent returnToMainActivity = new Intent(this, MainActivity.class);
        startActivity(returnToMainActivity);

    }


}