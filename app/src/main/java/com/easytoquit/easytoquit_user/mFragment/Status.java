package com.easytoquit.easytoquit_user.mFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easytoquit.easytoquit_user.R;
import com.easytoquit.easytoquit_user.RetreiveData.SmokeStatus;
import com.easytoquit.easytoquit_user.RetreiveData.Stop_Smoking_Really;
import com.easytoquit.easytoquit_user.RetreiveData.Why_smoking;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Polaris0712 on 11/01/2018.
 */

public class Status extends Fragment {

    TextView show_smoking_year;
    //TextView show_week_smoking;
    TextView show_date_smoking;
    TextView show_quit_smoking_date;
    TextView show_smoking_money;

    TextView sumaei;
    TextView sumbfj;
    TextView sumcgk;
    TextView sumdhl;

    TextView sumstimulate;
    TextView sumcontrol;
    TextView sumrelax;
    TextView sumemotional＿support;
    TextView sumdesire;
    TextView sumhabitual;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.status, container, false);
        final String TAG="Status";
        show_smoking_year = (TextView)view.findViewById(R.id.show_smoking_year) ;
        //show_week_smoking = (TextView)view.findViewById(R.id.show_week_smoking) ;
        show_date_smoking = (TextView)view.findViewById(R.id.show_date_smoking) ;
        show_quit_smoking_date = (TextView)view.findViewById(R.id.show_quit_smoking_date) ;
        show_smoking_money = (TextView)view.findViewById(R.id.show_smoking_money) ;

        sumaei=(TextView)view.findViewById(R.id.sumaei_layout);
        sumbfj=(TextView)view.findViewById(R.id.sumbfj_layout);
        sumcgk=(TextView)view.findViewById(R.id.sumcgk_layout);
        sumdhl=(TextView)view.findViewById(R.id.sumdhl_layout);

        sumstimulate = (TextView)view.findViewById(R.id.stimulate＿layout);
        sumcontrol =(TextView)view.findViewById(R.id.control_layout) ;
        sumrelax=(TextView)view.findViewById(R.id.relax_layout);
        sumemotional＿support=(TextView)view.findViewById(R.id.emotional＿support_layout);
        sumdesire=(TextView)view.findViewById(R.id.desire_layout);
        sumhabitual=(TextView)view.findViewById(R.id.habitual_layout);



        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();
        try{
            fis = getActivity().openFileInput("note.txt");
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

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://wedproject-d750d.firebaseio.com/");
        DatabaseReference myRef = database.getReference("usersAssessment/" + sb +"/評估資料/"+"第一次評估資料");

        DatabaseReference myRef1 = database.getReference("usersAssessment/" + sb +"/戒菸指數");

        DatabaseReference myRef2 = database.getReference("usersAssessment/" + sb +"/為什麼戒菸？");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                /*User user = dataSnapshot.getValue(User.class);
                // [START_EXCLUDE]
                Log.d(TAG, "Value is: " + user);*/

                SmokeStatus value = dataSnapshot.getValue(SmokeStatus.class);

                //計算菸價
                float day = Float.parseFloat(value.getsmokehowmuchday());
                float money = Float.parseFloat(value.getsmokemoney());
                float moneyofmonth;
                moneyofmonth = day*money*1.5f;
                String textmoneyofmonth = String.valueOf(moneyofmonth);

                show_smoking_year.setText(value.getsmokeage());
                //show_week_smoking.setText(value.getsmokehowmuchweek());
                show_date_smoking.setText(value.getsmokehowmuchday());
                show_quit_smoking_date.setText(value.getsmokequitday());
                //show_smoking_money.setText(value.getsmokemoney());
                show_smoking_money.setText(textmoneyofmonth);

                Log.d(TAG, "Value is: " + value.getsmokeage());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // [START_EXCLUDE]
               /* Toast.makeText(Profile.this, "Failed to load post.",
                        Toast.LENGTH_SHORT).show();*/
                // [END_EXCLUDE]
            }
        });
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Stop_Smoking_Really stopsmoking = dataSnapshot.getValue(Stop_Smoking_Really.class);
                Log.d(TAG, "Value is: " + stopsmoking.getsumaei());
                sumaei.setText(stopsmoking.getsumaei());
                sumbfj.setText(stopsmoking.getsumbfj());
                sumcgk.setText(stopsmoking.getsumcgk());
                sumdhl.setText(stopsmoking.getsumdhl());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Why_smoking why_smoking = dataSnapshot.getValue(Why_smoking.class);
                sumstimulate.setText(why_smoking.getsumStimulate());
                sumcontrol.setText(why_smoking.getsumControl());
                sumrelax.setText(why_smoking.getsumRelax());
                sumemotional＿support.setText(why_smoking.getsumEmotional＿support());
                sumdesire.setText(why_smoking.getsumDesire());
                sumhabitual.setText(why_smoking.getsumHabitual());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("目前狀態");
    }
}
