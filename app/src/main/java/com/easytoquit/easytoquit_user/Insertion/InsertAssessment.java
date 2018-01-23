package com.easytoquit.easytoquit_user.Insertion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.easytoquit.easytoquit_user.MainActivity;
import com.easytoquit.easytoquit_user.R;
import com.easytoquit.easytoquit_user.RetreiveData.SmokeStatus;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InsertAssessment extends AppCompatActivity {
    EditText edt_assessment_smoking_year;
    EditText edt_assessment_date_smoking;
    EditText edt_assessment_week_smoking;
    EditText edt_assessment_quit_smoking_date;
    EditText edt_assessment_save_money;
    Button sure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_assessment);
        setTitle("新增評估資料");

        edt_assessment_smoking_year=(EditText)findViewById(R.id.edt_assessment_smoking_year);
        edt_assessment_date_smoking=(EditText)findViewById(R.id.edt_assessment_date_smoking);
        edt_assessment_week_smoking=(EditText)findViewById(R.id.edt_assessment_week_smoking);
        edt_assessment_quit_smoking_date=(EditText)findViewById(R.id.edt_assessment_quit_smoking_date);
        edt_assessment_save_money=(EditText)findViewById(R.id.edt_assessment_save_money);
        sure =(Button)findViewById(R.id.btn_sure);
        sure.setOnClickListener(onclick);

    }
    private View.OnClickListener onclick = new View.OnClickListener() {

        public void onClick(View v) {

            if (edt_assessment_smoking_year.getText().toString().matches("") ||
                    edt_assessment_date_smoking.getText().toString().matches("") ||
                    edt_assessment_week_smoking.getText().toString().matches("") ||
                    edt_assessment_quit_smoking_date.getText().toString().matches("") ||
                    edt_assessment_save_money.getText().toString().matches("")) {
                Toast toast = Toast.makeText(InsertAssessment.this, "欄位不能是空白!!", Toast.LENGTH_LONG);
                toast.show();
            }else {
                FileInputStream fis = null;
                StringBuilder sb = new StringBuilder();
                try {
                    fis = getApplication().openFileInput("note.txt");
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    String str = "";
                    while ((str = br.readLine()) != null) {
                        sb.append(str);
                    }
                    br.close();
                    isr.close();
                    fis.close();
                } catch (Exception e) {
                    Log.e("Internal", e.toString());
                }
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://retrievedata-d4c18.firebaseio.com/");
                DatabaseReference myRef = database.getReference("usersAssessment/" + sb);

                SmokeStatus smokeStatus = new SmokeStatus(edt_assessment_smoking_year.getText().toString(), edt_assessment_date_smoking.getText().toString(),
                        edt_assessment_week_smoking.getText().toString(), edt_assessment_quit_smoking_date.getText().toString(),
                        edt_assessment_save_money.getText().toString());
                myRef.child("評估資料").child("第一次評估資料").setValue(smokeStatus);

                Intent intent = new Intent(InsertAssessment.this, MainActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);
            }

        }
    };
}
