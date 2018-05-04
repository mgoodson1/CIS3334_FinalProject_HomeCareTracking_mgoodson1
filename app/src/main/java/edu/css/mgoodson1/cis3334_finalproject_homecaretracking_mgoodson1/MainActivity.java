package edu.css.mgoodson1.cis3334_finalproject_homecaretracking_mgoodson1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Patient patient;
    private AppDatabase database;

    EditText txtPatientName;
    EditText txtPatientAge;
    EditText txtPatientWeight;
    TextView textViewDisplayPatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = AppDatabase.getDatabase(getApplicationContext());

        // cleanup for testing some initial data
        database.patientDao().removeAllPatients();
        // add some data
        List<Patient> patients = database.patientDao().getAllPatients();
        if (patients.size()==0) {
            database.patientDao().addPatient(new Patient( "Baby1", 1, 8));
            patient = database.patientDao().getAllPatients().get(0);
            Toast.makeText(this, String.valueOf(patient.id), Toast.LENGTH_SHORT).show();
            PatientStats stats = new PatientStats(patient.id, 101.3, "2018-04-01 10:00AM");
            database.patientStatsDao().addPatientStats(stats);
            database.patientDao().addPatient(new Patient( "Child1", 4, 35));
            database.patientDao().addPatient(new Patient( "Teen1", 14, 110));
        }

     //   updateFirstPatientData();

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

    public void onClick(View view){

        Context context = getApplicationContext();
        CharSequence text = "No Patients";
        int duration = Toast.LENGTH_SHORT;



        if (view.getId()==R.id.btnAddPatient) {
            // TODO add trophy
            txtPatientName = findViewById(R.id.editTextPatientName);
            txtPatientAge = findViewById(R.id.editTextPatientAge);
            int aAge = Integer.parseInt(txtPatientAge.getText().toString());
            txtPatientWeight = findViewById(R.id.editTextPatientWeight);
            int aWeight = Integer.parseInt(txtPatientWeight.getText().toString());
            textViewDisplayPatients = findViewById(R.id.tvDisplayPatients);

            database.patientDao().addPatient(new Patient( txtPatientName.getText().toString(), aAge, aWeight));

            List<Patient> patients = database.patientDao().getAllPatients();
            if (patients.size()==0) {
                Toast.makeText(this, String.valueOf(patient.id), Toast.LENGTH_SHORT).show();
                textViewDisplayPatients.setText(patients.toString());
            }
            else {
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }


            // TODO call updatefirstUserData
            //Toast.makeText(this,String.valueOf(user.id), Toast.LENGTH_SHORT).show();
            //Trophy trophy = new Trophy(user.id, "More stuff");
            //database.trophyDao().addTrophy(trophy);

        }
   //     if (view.getId()==R.id.increaseskills ){
   //         user.skillPoints++;
    //        database.userDao().updateUser(user);
      //      // TODO to skillpoints
//
  //      }
    //    // TODO call updatefirstUserData
      //  updateFirstUserData();

    }
    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}