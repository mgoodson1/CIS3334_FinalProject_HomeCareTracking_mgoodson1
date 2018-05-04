package edu.css.mgoodson1.cis3334_finalproject_homecaretracking_mgoodson1;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Timestamp;


/**
 * Author: Matt Goodson
 *
 *
 *
 */

@Entity(tableName = "patientStats",
        foreignKeys = {
                @ForeignKey(
                        entity = Patient.class,
                        parentColumns = "id",
                        childColumns = "patientId",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "id")}
)
public class PatientStats {

    @PrimaryKey(autoGenerate = true)
    long id;

    public long patientId;
    double temp_F;
    String logDateTime;

    public PatientStats(long patientId, double  temp_F, String logDateTime) {
        this.patientId = patientId;
        this.temp_F = temp_F;
        this.logDateTime = logDateTime;
    }
}