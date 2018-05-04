package edu.css.mgoodson1.cis3334_finalproject_homecaretracking_mgoodson1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface PatientStatsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPatientStats(PatientStats patientStats);

    @Query("SELECT * FROM PatientStats WHERE patientId=:patientId")
    List<PatientStats> findPatientStatsForPatient(int patientId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatePatientStats(PatientStats patientStats);

    @Query("delete from patientStats where id = :id")
    void delete(int id);

}