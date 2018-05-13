package edu.css.mgoodson1.cis3334_finalproject_homecaretracking_mgoodson1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface PatientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPatient(Patient patient);

    @Query("select * from patient")
    public List<Patient> getAllPatients();

    @Query("select name from patient")
    public List<String> getAllPatientNames();


    @Query("select * from patient where id =:patientId")
    public List<Patient> getPatient(long patientId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatePatient(Patient patient);

    @Query("delete from patient")
    void removeAllPatients();
}