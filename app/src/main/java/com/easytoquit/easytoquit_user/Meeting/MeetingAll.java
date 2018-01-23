package com.easytoquit.easytoquit_user.Meeting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.easytoquit.easytoquit_user.R;
import com.easytoquit.easytoquit_user.RetreiveData.MeetingAllUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MeetingAll extends AppCompatActivity {

    TextView name, id, birth, age, case1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_all);

        setTitle("總表");

        name = (TextView)findViewById(R.id.txt_name);
        id = (TextView)findViewById(R.id.txt_id);
        birth = (TextView)findViewById(R.id.txt_birth);
        age = (TextView)findViewById(R.id.txt_age);
        case1 = (TextView)findViewById(R.id.txt_case);


        //讀出檔案
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();
        try{
            fis = openFileInput("note.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String str = "";
            while ((str = br.readLine())!=null){
                sb.append(str);
            }
            br.close();
            isr.close();
            fis.close();
        }catch (Exception e){
            Log.e("Internal",  e.toString() );
        }


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users/" + sb + "/訪談紀錄/總表/");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                MeetingAllUser value = dataSnapshot.getValue(MeetingAllUser.class);
                name.setText(value.getname());
                id.setText(value.getedt_id());
                birth.setText(value.getedt_birthday());
                age.setText(value.getedt_age());

                String caseResult = null;

                if (value.getrbtn_outpatient() != null){
                    caseResult = value.getrbtn_outpatient();
                }
                else if (value.getrbtn_inpatient() != null){
                    caseResult = value.getrbtn_inpatient();
                }
                else if (value.getrbtn_emergency() != null){
                    caseResult = value.getrbtn_emergency();
                }
                else if (value.getrbtn_society() != null){
                    caseResult = value.getrbtn_society();
                }

                case1.setText(caseResult);
                Log.d("aa", "Value is: " + value.getrbtn_outpatient());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("aa", "Failed to read value.", error.toException());
            }
        });

    }


}
