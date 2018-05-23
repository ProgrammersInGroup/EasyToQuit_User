package com.easytoquit.easytoquit_user.mFragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

    int sumaeiint;
    int sumbfjint;
    int sumcgkint;
    int sumdhlint;

    TextView sumstimulate;
    TextView sumcontrol;
    TextView sumrelax;
    TextView sumemotional＿support;
    TextView sumdesire;
    TextView sumhabitual;

    int sumstimulateint;
    int sumcontrolint;
    int sumrelaxint;
    int sumemotional＿supportint;
    int sumdesireint;
    int sumhabitualint;

    LinearLayout sumaeicolor;
    TextView sumaei_layout_forhealth;
    TextView sumaei_layout_score;

    TextView sumbfj_layout_forexample;
    TextView sumbfj_layout_score;

    TextView sumcgk_layout_forpretty;
    TextView sumcgk_layout_score;

    TextView sumdhl_layout_forcontrol;
    TextView sumdhl_layout_score;

    TextView stimulate_for;
    TextView stimulate_score;

    TextView control_for;
    TextView control_score;

    TextView relax_for;
    TextView relax_score;

    TextView emotional＿supportint_for;
    TextView emotional＿supportint_score;
    TextView desireint_for;
    TextView desireint_score;
    TextView habitualint_for;
    TextView habitualint_score;
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

        sumaeicolor=(LinearLayout)view.findViewById(R.id.aeisumcolor);
        sumaei_layout_forhealth=(TextView)view.findViewById(R.id.sumaei_layout_forhealth);
        sumaei_layout_score=(TextView)view.findViewById(R.id.sumaei_layout_score);

        sumbfj_layout_forexample=(TextView)view.findViewById(R.id.sumbfj_layout_forexample);
        sumbfj_layout_score=(TextView)view.findViewById(R.id.sumbfj_layout_score);

        sumcgk_layout_forpretty=(TextView)view.findViewById(R.id.sumcgk_layout_forpretty);
        sumcgk_layout_score=(TextView)view.findViewById(R.id.sumcgk_layout_score);

        sumdhl_layout_forcontrol=(TextView)view.findViewById(R.id.sumdhl_layout_forcontrol);
        sumdhl_layout_score=(TextView)view.findViewById(R.id.sumdhl_layout_score);

        stimulate_for=(TextView)view.findViewById(R.id.stimulate_for);
        stimulate_score=(TextView)view.findViewById(R.id.stimulate_score);

        control_for=(TextView)view.findViewById(R.id.control_for);
        control_score=(TextView)view.findViewById(R.id.control_score);

        relax_for=(TextView)view.findViewById(R.id.relax_for);
        relax_score=(TextView)view.findViewById(R.id.relax_score);

        emotional＿supportint_for=(TextView)view.findViewById(R.id.emotional＿support_for);
        emotional＿supportint_score=(TextView)view.findViewById(R.id.emotional＿support_score);

        desireint_for=(TextView)view.findViewById(R.id.desire_for);
        desireint_score=(TextView)view.findViewById(R.id.desire_score);

        habitualint_for=(TextView)view.findViewById(R.id.habits_for);
        habitualint_score=(TextView)view.findViewById(R.id.habits_score);

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
        Log.d(TAG, "momery_i_want: " + sb);
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
//                Log.d(TAG, "Value is: " + stopsmoking.getsumaei());
                sumaei.setText(stopsmoking.getsumaei());
                sumbfj.setText(stopsmoking.getsumbfj());
                sumcgk.setText(stopsmoking.getsumcgk());
                sumdhl.setText(stopsmoking.getsumdhl());

                sumaeiint = Integer.valueOf(stopsmoking.getsumaei());
                sumbfjint=Integer.valueOf(stopsmoking.getsumbfj());
                sumcgkint=Integer.valueOf(stopsmoking.getsumcgk());
                sumdhlint=Integer.valueOf(stopsmoking.getsumdhl());

                if(sumaeiint>=9){
                    //sumaeicolor.setBackgroundColor(Color.RED);
                    sumaei_layout_forhealth.setTextColor(Color.RED);
                    sumaei.setTextColor(Color.RED);
                    sumaei_layout_score.setTextColor(Color.RED);
                    Log.w(TAG, "it is big than nine");
                }
                if(sumbfjint>=9){
                    //sumaeicolor.setBackgroundColor(Color.RED);
                    sumbfj_layout_forexample.setTextColor(Color.RED);
                    sumbfj.setTextColor(Color.RED);
                    sumbfj_layout_score.setTextColor(Color.RED);
                    Log.w(TAG, "it is big than nine");
                }
                if(sumcgkint>=9){
                    //sumaeicolor.setBackgroundColor(Color.RED);
                    sumcgk_layout_forpretty.setTextColor(Color.RED);
                    sumcgk.setTextColor(Color.RED);
                    sumcgk_layout_score.setTextColor(Color.RED);
                    Log.w(TAG, "it is big than nine");
                }
                if(sumdhlint>=9){
                    //sumaeicolor.setBackgroundColor(Color.RED);
                    sumdhl_layout_forcontrol.setTextColor(Color.RED);
                    sumdhl.setTextColor(Color.RED);
                    sumdhl_layout_score.setTextColor(Color.RED);
                    Log.w(TAG, "it is big than nine");
                }
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

                sumstimulateint = Integer.valueOf(why_smoking.getsumStimulate());
                sumcontrolint=Integer.valueOf(why_smoking.getsumControl());
                sumrelaxint=Integer.valueOf(why_smoking.getsumRelax());
                sumemotional＿supportint=Integer.valueOf(why_smoking.getsumEmotional＿support());
                sumdesireint=Integer.valueOf(why_smoking.getsumDesire());
                sumhabitualint=Integer.valueOf(why_smoking.getsumHabitual());

                if(sumstimulateint>=11){
                    stimulate_for.setTextColor(Color.RED);
                    sumstimulate.setTextColor(Color.RED);
                    stimulate_score.setTextColor(Color.RED);
                }
                if(sumcontrolint>=11) {
                    control_for.setTextColor(Color.RED);
                    sumcontrol.setTextColor(Color.RED);
                    control_score.setTextColor(Color.RED);
                }
                if(sumrelaxint>=11) {
                    relax_for.setTextColor(Color.RED);
                    sumrelax.setTextColor(Color.RED);
                    relax_score.setTextColor(Color.RED);
                }
                if(sumemotional＿supportint>=11) {
                    emotional＿supportint_for.setTextColor(Color.RED);
                    sumemotional＿support.setTextColor(Color.RED);
                    emotional＿supportint_score.setTextColor(Color.RED);
                }
                if(sumdesireint>=11) {
                    desireint_for.setTextColor(Color.RED);
                    sumdesire.setTextColor(Color.RED);
                    desireint_score.setTextColor(Color.RED);
                }
                if(sumhabitualint>=11) {
                    habitualint_for.setTextColor(Color.RED);
                    sumhabitual.setTextColor(Color.RED);
                    habitualint_score.setTextColor(Color.RED);
                }
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
