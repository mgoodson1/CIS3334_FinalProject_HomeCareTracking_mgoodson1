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


//TODO : Matt Goodson - working on getting patient name to display in tvPatientName and now this Actvity fails when called from MainActivity

public class AddPatientStats extends AppCompatActivity {

    private PatientStats patientStats;
    private AppDatabase database;
    Patient patient;

    String patientName;

    //EditText txtPatientName;
    //EditText txtPatientAge;
    //EditText txtPatientWeight;
    TextView txtPatientName = (TextView) findViewById(R.id.tvPatientName);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_stats);
        database = AppDatabase.getDatabase(getApplicationContext());

        patient=database.patientDao().getPatient(0);

        txtPatientName.setText(patientName);


    }



    public void onClick(View view) {
        Context context = getApplicationContext();
        CharSequence text = "No Patients";

      //  patientStats= (0, 101.3, "2018-04-01 10:00AM");
        database.patientStatsDao().addPatientStats(patientStats);

        if (view.getId() == R.id.btnSubmitStats) {
           // refresh stats window but remain in activity;
            //todo add code to submit stat and refresh stats display
        }

        if (view.getId() == R.id.btnCancelStats) {
            //return to Main streen
            returnToMain();
        }

    }

    public void returnToMain() {
        Intent returnToMainActivity = new Intent(this, MainActivity.class);
        startActivity(returnToMainActivity);

    }


    public void setTxtPatientName(TextView txtPatientName) {
        this.txtPatientName = txtPatientName;
    }

    public TextView getTxtPatientName() {
        return txtPatientName;
    }
}
