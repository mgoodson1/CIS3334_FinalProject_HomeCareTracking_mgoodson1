package edu.css.mgoodson1.cis3334_finalproject_homecaretracking_mgoodson1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddPatientStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_stats);
    }


    public void onClick(View view) {
        Context context = getApplicationContext();
        CharSequence text = "No Patients";

        if (view.getId() == R.id.btnSubmitStats) {
            //refresh stats window but remain in activity;
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
}

