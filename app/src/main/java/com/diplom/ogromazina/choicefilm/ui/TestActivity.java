package com.diplom.ogromazina.choicefilm.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.diplom.ogromazina.choicefilm.R;
import com.diplom.ogromazina.choicefilm.conroller.Controller;
import com.diplom.ogromazina.choicefilm.data.Profile;
import com.diplom.ogromazina.choicefilm.data.utils.Sex;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnNext;
    LinearLayout llGenre;
    LinearLayout llRAndR;
    LinearLayout llYear;
    LinearLayout llDuration;
    LinearLayout llCast;
    LinearLayout llCountry;

    int flagOfLayout = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent;

        btnNext = findViewById(R.id.btnNextTestAct);
        llGenre = findViewById(R.id.llGenreTestAct);
        llRAndR = findViewById(R.id.llRatAndRevTestAct);
        llYear = findViewById(R.id.llYearTestAct);
        llDuration = findViewById(R.id.llDurationTestAct);
        llCast = findViewById(R.id.llCastTestAct);
        llCountry = findViewById(R.id.llCountryTestAct);

        llRAndR.setEnabled(false);
        llCountry.setEnabled(false);
        llCast.setEnabled(false);
        llDuration.setEnabled(false);
        llYear.setEnabled(false);
        llGenre.setEnabled(true);

        View.OnClickListener oclBtnNext = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        };
        btnNext.setOnClickListener(oclBtnNext);

    }
}
