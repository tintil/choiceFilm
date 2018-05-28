package com.diplom.ogromazina.choicefilm.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.diplom.ogromazina.choicefilm.R;
import com.diplom.ogromazina.choicefilm.data.Profile;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnResAct;
    ImageButton btnRefreshResAct;
    LinearLayout llNotResultResAct;
    LinearLayout llResultResAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        /*if (Profile.getInstance().getName() == null){
            Intent intent = new Intent(ResultActivity.this, RegistryActivity.class);
            startActivity(intent);
        }*/

        if (Profile.getInstance().getMatrix() == null){
            llNotResultResAct = findViewById(R.id.llNotResultResAct);
            llResultResAct = findViewById(R.id.llResultResAct);
            btnRefreshResAct = findViewById(R.id.btnRefreshResAct);
            btnResAct = findViewById(R.id.btnResAct);

            llNotResultResAct.setEnabled(true);
            llResultResAct.setEnabled(false);
            btnResAct.setText(R.string.passTest);
            btnRefreshResAct.setEnabled(false);

        } else {
            llNotResultResAct = findViewById(R.id.llNotResultResAct);
            llResultResAct = findViewById(R.id.llResultResAct);
            btnRefreshResAct = findViewById(R.id.btnRefreshResAct);
            btnResAct = findViewById(R.id.btnResAct);

            llNotResultResAct.setEnabled(false);
            llResultResAct.setEnabled(true);
            btnResAct.setText(R.string.statistic);
            btnRefreshResAct.setEnabled(true);
        }

        btnResAct.setOnClickListener(this);
        btnRefreshResAct.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch(v.getId()) {
            case R.id.btnResAct:
                break;
            case R.id.btnRefreshResAct:
                break;
        }
    }


}
