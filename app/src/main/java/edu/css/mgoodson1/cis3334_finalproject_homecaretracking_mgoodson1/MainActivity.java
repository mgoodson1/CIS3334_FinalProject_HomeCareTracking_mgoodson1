package edu.css.mgoodson1.cis3334_finalproject_homecaretracking_mgoodson1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Patient patient;
    private AppDatabase database;

    EditText txtPatientName;
    EditText txtPatientAge;
    EditText txtPatientWeight;
    TextView textViewDisplayPatients;

    public static final String PATIENT_KEY = "PATIENT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = AppDatabase.getDatabase(getApplicationContext());

        // cleanup for testing some initial data
        database.patientDao().removeAllPatients();
        // add some data
        List<String> patientNames = database.patientDao().getAllPatientNames();
        List<Patient> patients = database.patientDao().getAllPatients();
        if (patientNames.size() == 0) {
            database.patientDao().addPatient(new Patient("Baby1", 1, 8));
            patient = database.patientDao().getAllPatients().get(0);
            Toast.makeText(this, String.valueOf(patient.id), Toast.LENGTH_SHORT).show();
            PatientStats stats = new PatientStats(patient.id, 101.3, "2018-04-01 10:00AM");
            database.patientStatsDao().addPatientStats(stats);
            database.patientDao().addPatient(new Patient("Child1", 4, 35));
            database.patientDao().addPatient(new Patient("Teen1", 14, 110));
        }

        //   updateFirstPatientData();

        Spinner spinngerExistingPatients = (Spinner) findViewById(R.id.patients_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                     android.R.layout.simple_spinner_item,database.patientDao().getAllPatientNames());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinngerExistingPatients.setAdapter(adapter);

    }


    //  private void updateFirstPatientData() {
    //      List<Patient> patients = database.patientDao().getAllPatients();
    //      List<PatientStats> statsForPatient = database.patientStatsDao().findPatientStatsForPatient(patients.get(0).id);
    //      TextView textView = findViewById(R.id.result);
    //      Toast.makeText(this, statsForPatient.toString(), Toast.LENGTH_SHORT).show();
    //      if (statsForPatient.size()>0){
    //          textView.setText(patients.get(0).name + " Age " + patients.get(0).age + " Number of Stats " + statsForPatient.size() );
    //      }
    //  }

    public void onClick(View view) {

        Context context = getApplicationContext();
        CharSequence text = "No Patients";
        int duration = Toast.LENGTH_SHORT;

        if (view.getId() == R.id.btnGoToAddPatient) {
            openAddPatient(view);
        }

        if (view.getId() == R.id.btnAddStats) {
            openAddStats(view);
        }
    }


    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    public void openAddPatient(View view) {
        Intent startAddPatientActivity = new Intent(this,create_patient.class);
        startActivity(startAddPatientActivity);
    }

    public void openAddStats(View view) {
        Intent startAddStats = new Intent(this,AddPatientStats.class);
        startActivity(startAddStats);
    }
}