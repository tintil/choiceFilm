package com.diplom.ogromazina.choicefilm.data;

import com.diplom.ogromazina.choicefilm.data.utils.Sex;

/**
 * Created by OGromazina on 4/22/2018.
 */

public class Profile {

    private String name;
    private String surname;
    private Sex sex;
    private int day;
    private int month;
    private int year;
    private String occupation;
    private Matrix matrix;
    private static Profile instance;
    private Profile () {}

    public static Profile getInstance() {
        if (instance == null) {
            instance = new Profile();
        }
        return instance;
    }

    public void setData (String name, String surname, Sex sex, int day, int month, int year, String occupation){
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.day = day;
        this.month = month;
        this.year = year;
        this.occupation = occupation;
    }

    public void setMatrix (Matrix matrix){
        this.matrix = matrix;
    }

    public Matrix getMatrix (){
        return matrix;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName (){
        return name;
    }

    public void setSurname (String surname){
        this.surname = surname;
    }

    public String getSurname (){
        return surname;
    }

    public Sex getSex(){
        return sex;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public void setOccupation (String occupation){
        this.occupation = occupation;
    }

    public String getOccupation (){
        return occupation;
    }
}
