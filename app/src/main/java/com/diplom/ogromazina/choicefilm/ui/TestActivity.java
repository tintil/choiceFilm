package com.diplom.ogromazina.choicefilm.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.diplom.ogromazina.choicefilm.R;
import com.diplom.ogromazina.choicefilm.data.Matrix;
import com.diplom.ogromazina.choicefilm.data.utils.Constants;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnFirstChoice;
    Button btnSecondChoice;
    Button btnSkip;
    Button btnNoChoicable;
    Matrix matrix;
    int[] indexes = new int[2];
    String[] filmsItem = {"Жанр", "Длительность", "Отзывы", "Рейтинг", "Новизна", "Популярность", "Актёрский состав"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btnFirstChoice = findViewById(R.id.btnFirstChoiceActTest);
        btnSecondChoice = findViewById(R.id.btnSecondChoiceActTest);
        btnSkip = findViewById(R.id.btnSkipTestAct);
        btnNoChoicable = findViewById(R.id.btnNoChoicableTestAct);

        matrix = new Matrix();

        indexes[0] = 0;
        indexes[1] = 1;
        btnFirstChoice.setText(filmsItem[indexes[0]]);
        btnSecondChoice.setText(filmsItem[indexes[1]]);

        btnFirstChoice.setOnClickListener(this);
        btnSecondChoice.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
        btnNoChoicable.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch(v.getId()) {
            case R.id.btnFirstChoiceActTest:
                btnFirstChoice.setEnabled(false);
                btnSecondChoice.setEnabled(false);
                indexes = matrix.full(indexes[0], indexes[1], Constants.dominance.index());
                if (indexes[0] == -1 && indexes[1] == -1){
                    intent = new Intent(this, ResultActivity.class);
                    intent.putExtra("matrix", matrix.getMatrix());
                    intent.putExtra("isTransitive", matrix.getTransitive());
                    intent.putExtra("isLinear", matrix.getLinear());
                    intent.putExtra("sizeOfMatrix", matrix.getSize());
                    startActivity(intent);
                }else {
                    btnFirstChoice.setText(filmsItem[indexes[0]]);
                    btnSecondChoice.setText(filmsItem[indexes[1]]);
                    btnFirstChoice.setEnabled(true);
                    btnSecondChoice.setEnabled(true);
                }
                break;
            case R.id.btnSecondChoiceActTest:
                btnFirstChoice.setEnabled(false);
                btnSecondChoice.setEnabled(false);
                indexes = matrix.full(indexes[0], indexes[1], Constants.dominated.index());
                if (indexes[0] == -1 && indexes[1] == -1){
                    intent = new Intent(this, ResultActivity.class);
                    intent.putExtra("matrix", matrix.getMatrix());
                    intent.putExtra("isTransitive", matrix.getTransitive());
                    intent.putExtra("isLinear", matrix.getLinear());
                    intent.putExtra("sizeOfMatrix", matrix.getSize());
                    startActivity(intent);
                }else {
                    btnFirstChoice.setText(filmsItem[indexes[0]]);
                    btnSecondChoice.setText(filmsItem[indexes[1]]);
                    btnFirstChoice.setEnabled(true);
                    btnSecondChoice.setEnabled(true);
                }
                break;
            case R.id.btnSkipTestAct:
                btnFirstChoice.setEnabled(false);
                btnSecondChoice.setEnabled(false);
                indexes = matrix.full(indexes[0], indexes[1], Constants.nocomparable.index());
                if (indexes[0] == -1 && indexes[1] == -1){
                    intent = new Intent(this, ResultActivity.class);
                    intent.putExtra("matrix", matrix.getMatrix());
                    intent.putExtra("isTransitive", matrix.getTransitive());
                    intent.putExtra("isLinear", matrix.getLinear());
                    intent.putExtra("sizeOfMatrix", matrix.getSize());
                    startActivity(intent);
                }else {
                    btnFirstChoice.setText(filmsItem[indexes[0]]);
                    btnSecondChoice.setText(filmsItem[indexes[1]]);
                    btnFirstChoice.setEnabled(true);
                    btnSecondChoice.setEnabled(true);
                }
                break;
            case R.id.btnNoChoicableTestAct:
                btnFirstChoice.setEnabled(false);
                btnSecondChoice.setEnabled(false);
                indexes = matrix.full(indexes[0], indexes[1], Constants.indifference.index());
                if (indexes[0] == -1 && indexes[1] == -1){
                    intent = new Intent(this, ResultActivity.class);
                    intent.putExtra("matrix", matrix.getMatrix());
                    intent.putExtra("isTransitive", matrix.getTransitive());
                    intent.putExtra("isLinear", matrix.getLinear());
                    intent.putExtra("sizeOfMatrix", matrix.getSize());
                    startActivity(intent);
                }else {
                    btnFirstChoice.setText(filmsItem[indexes[0]]);
                    btnSecondChoice.setText(filmsItem[indexes[1]]);
                    btnFirstChoice.setEnabled(true);
                    btnSecondChoice.setEnabled(true);
                }
                break;
        }
    }
}
