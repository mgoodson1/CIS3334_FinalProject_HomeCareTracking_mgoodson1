package edu.css.mgoodson1.cis3334_finalproject_homecaretracking_mgoodson1;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Author: Matt Goodson
 *
 *
 *
 */
@Entity
        (tableName = "patient",
               indices = { @Index(value = "id")}
        )

public class Patient {

    @PrimaryKey(autoGenerate = true)
    long id;
    public String name;
    public int age;
    public int weight;


    public Patient(String name, int age, int weight) {
        this.name = name;
        this.age  = age;
        this.weight = weight;
    }

}