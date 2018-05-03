package com.diplom.ogromazina.choicefilm.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.diplom.ogromazina.choicefilm.R;
import com.diplom.ogromazina.choicefilm.data.Profile;
import com.diplom.ogromazina.choicefilm.data.utils.Sex;

public class RegistryActivity extends AppCompatActivity{

    EditText etName;
    EditText etSurname;
    EditText etBirth;
    EditText etOccupation;
    RadioButton rbMale;
    RadioButton rbFemale;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);

        etName = findViewById(R.id.etNameActReg);
        etSurname = findViewById(R.id.etSurnameActReg);
        etBirth = findViewById(R.id.etBirthdayActReg);
        etOccupation = findViewById(R.id.etWorkActReg);
        rbFemale = findViewById(R.id.rbFemaleActReg);
        rbMale = findViewById(R.id.rbMaleActReg);
        btnSave = findViewById(R.id.btnSaveActReg);

        rbFemale.setChecked(true);
        rbMale.setChecked(false);

       OnClickListener oclBtnSave = new OnClickListener() {
           @Override
           public void onClick(View v) {
               if (etName.getText().toString() == getString(R.string.name) ||
                       etName.getText().toString() == "" ||
                       etName.getText().toString() == " ") {
                   Toast toast = Toast.makeText(getApplicationContext(),
                           "Вы не ввели имя!",
                           Toast.LENGTH_SHORT);
                   toast.show();
               } else if (etName.getText().toString().length() > 20) {
                   Toast toast = Toast.makeText(getApplicationContext(),
                           "Имя превышает допустимое количество символов",
                           Toast.LENGTH_LONG);
                   toast.show();
               } else if (etSurname.getText().toString() == getString(R.string.surname) ||
                       etSurname.getText().toString() == "" ||
                       etSurname.getText().toString() == " ") {
                   Toast toast = Toast.makeText(getApplicationContext(),
                           "Вы не ввели фамилию!",
                           Toast.LENGTH_SHORT);
                   toast.show();
               }else if (etSurname.getText().toString().length() > 40) {
                   Toast toast = Toast.makeText(getApplicationContext(),
                           "Фамилия превышает допустимое количество символов",
                           Toast.LENGTH_LONG);
                   toast.show();
               }else if (etBirth.getText().toString() == getString(R.string.birthday)) {
                   Toast toast = Toast.makeText(getApplicationContext(),
                           "Вы не ввели дату рождения!",
                           Toast.LENGTH_SHORT);
                   toast.show();
               }else if (etBirth.getText().toString().length() != 10) {
                   Toast toast = Toast.makeText(getApplicationContext(),
                           "Дата рождения не подходит под формат",
                           Toast.LENGTH_LONG);
                   toast.show();
               }else if (etOccupation.getText().toString() == getString(R.string.work) ||
                       etOccupation.getText().toString() == "" ||
                       etOccupation.getText().toString() == " ") {
                   Toast toast = Toast.makeText(getApplicationContext(),
                           "Вы не ввели род деятельности!",
                           Toast.LENGTH_SHORT);
                   toast.show();
               }else{
                   if (rbFemale.isChecked()) {
                       Profile.getInstance().setData(etName.getText().toString(),
                               etSurname.getText().toString(), Sex.female,
                               Integer.parseInt(etBirth.getText().toString().substring(0,2)),
                               Integer.parseInt(etBirth.getText().toString().substring(3,5)),
                               Integer.parseInt(etBirth.getText().toString().substring(6)),
                               etOccupation.getText().toString());
                   }else {
                       Profile.getInstance().setData(etName.getText().toString(),
                               etSurname.getText().toString(), Sex.male,
                               Integer.parseInt(etBirth.getText().toString().substring(0,2)),
                               Integer.parseInt(etBirth.getText().toString().substring(3,5)),
                               Integer.parseInt(etBirth.getText().toString().substring(6)),
                               etOccupation.getText().toString());
                   }
                   Intent intent = new Intent(RegistryActivity.this, ResultActivity.class);
                   startActivity(intent);
                   finish();
               }
           }
       };
       btnSave.setOnClickListener(oclBtnSave);

    }
}
