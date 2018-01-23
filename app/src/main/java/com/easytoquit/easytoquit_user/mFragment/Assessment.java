package com.easytoquit.easytoquit_user.mFragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by Polaris0712 on 11/01/2018.
 */

public class Assessment extends Fragment {

    EditText edt_assessment_smoking_year;
    EditText edt_assessment_date_smoking;
    EditText edt_assessment_week_smoking;
    EditText edt_assessment_quit_smoking_date;
    EditText edt_assessment_save_money;
    Button sure;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assessment, container, false);

        /*Intent intent = new Intent();
        intent.setClass(getActivity(), InsertAssessment.class);
        startActivity(intent);*/
        edt_assessment_smoking_year=(EditText)view.findViewById(R.id.edt_assessment_smoking_year);
        edt_assessment_date_smoking=(EditText)view.findViewById(R.id.edt_assessment_date_smoking);
        edt_assessment_week_smoking=(EditText)view.findViewById(R.id.edt_assessment_week_smoking);
        edt_assessment_quit_smoking_date=(EditText)view.findViewById(R.id.edt_assessment_quit_smoking_date);
        edt_assessment_save_money=(EditText)view.findViewById(R.id.edt_assessment_save_money);
        sure =(Button)view.findViewById(R.id.btn_sure);
        sure.setOnClickListener(onclick);
        return view;
    }

    private View.OnClickListener onclick = new View.OnClickListener() {

        public void onClick(View v) {

            if (edt_assessment_smoking_year.getText().toString().matches("") ||
                    edt_assessment_date_smoking.getText().toString().matches("") ||
                    edt_assessment_week_smoking.getText().toString().matches("") ||
                    edt_assessment_quit_smoking_date.getText().toString().matches("") ||
                    edt_assessment_save_money.getText().toString().matches("")) {
                Toast toast = Toast.makeText(getActivity(), "欄位不能是空白!!", Toast.LENGTH_LONG);
                toast.show();
            }else {
                FileInputStream fis = null;
                StringBuilder sb = new StringBuilder();
                try {
                    fis = getActivity().getApplication().openFileInput("note.txt");
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

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);
            }
        }
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("評估自我");
    }
}