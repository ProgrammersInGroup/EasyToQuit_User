package com.easytoquit.easytoquit_user.Insertion;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.easytoquit.easytoquit_user.MainActivity;
import com.easytoquit.easytoquit_user.R;
import com.easytoquit.easytoquit_user.RetreiveData.Stop_Smoking_Really;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by chenyunjing on 2018/5/14.
 */

public class question_stop_smoking extends Fragment {
    int sumaei;
    int sumbfj;
    int sumcgk;
    int sumdhl;

    RadioGroup choose_stop_smoke;
    RadioButton choose_stop_smoke1;
    RadioButton choose_stop_smoke2;
    RadioButton choose_stop_smoke3;
    RadioButton choose_stop_smoke4;
    int a = 0;

    RadioGroup typical;
    RadioButton typical1;
    RadioButton typical2;
    RadioButton typical3;
    RadioButton typical4;
    int b = 0;

    RadioGroup habits;
    RadioButton habits1;
    RadioButton habits2;
    RadioButton habits3;
    RadioButton habits4;
    int c = 0;

    RadioGroup challenge;
    RadioButton challenge1;
    RadioButton challenge2;
    RadioButton challenge3;
    RadioButton challenge4;
    int d = 0;

    RadioGroup breathe;
    RadioButton breathe1;
    RadioButton breathe2;
    RadioButton breathe3;
    RadioButton breathe4;
    int e = 0;

    RadioGroup influences;
    RadioButton influences1;
    RadioButton influences2;
    RadioButton influences3;
    RadioButton influences4;
    int f = 0;

    RadioGroup pollution;
    RadioButton pollution1;
    RadioButton pollution2;
    RadioButton pollution3;
    RadioButton pollution4;
    int g = 0;

    RadioGroup willpower;
    RadioButton willpower1;
    RadioButton willpower2;
    RadioButton willpower3;
    RadioButton willpower4;
    int h = 0;

    RadioGroup health;
    RadioButton health1;
    RadioButton health2;
    RadioButton health3;
    RadioButton health4;
    int i = 0;

    RadioGroup closer;
    RadioButton closer1;
    RadioButton closer2;
    RadioButton closer3;
    RadioButton closer4;
    int j = 0;

    RadioGroup taste_smell;
    RadioButton taste_smell1;
    RadioButton taste_smell2;
    RadioButton taste_smell3;
    RadioButton taste_smell4;
    int k = 0;

    RadioGroup dependence;
    RadioButton dependence1;
    RadioButton dependence2;
    RadioButton dependence3;
    RadioButton dependence4;
    int l = 0;

    Button sure;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_stop_smoking, container, false);
        final String TAG = "Status";

        sure =(Button)view.findViewById(R.id.btn_sure);
        sure.setOnClickListener(onclick);

        choose_stop_smoke = (RadioGroup)view.findViewById(R.id.choose_stop_smoke);
        choose_stop_smoke1 = (RadioButton)view.findViewById(R.id.choose_stop_smoke1);
        choose_stop_smoke2 = (RadioButton)view.findViewById(R.id.choose_stop_smoke2);
        choose_stop_smoke3 = (RadioButton)view.findViewById(R.id.choose_stop_smoke3);
        choose_stop_smoke4 = (RadioButton)view.findViewById(R.id.choose_stop_smoke4);

        typical=(RadioGroup)view.findViewById(R.id.typical_choose);
        typical1=(RadioButton)view.findViewById(R.id.typical_choose1);
        typical2=(RadioButton)view.findViewById(R.id.typical_choose2);
        typical3=(RadioButton)view.findViewById(R.id.typical_choose3);
        typical4=(RadioButton)view.findViewById(R.id.typical_choose4);

        habits=(RadioGroup)view.findViewById(R.id.habits_choose);
        habits1=(RadioButton)view.findViewById(R.id.habits_choose1);
        habits2=(RadioButton)view.findViewById(R.id.habits_choose2);
        habits3=(RadioButton)view.findViewById(R.id.habits_choose3);
        habits4=(RadioButton)view.findViewById(R.id.habits_choose4);

        challenge=(RadioGroup)view.findViewById(R.id.challenge_choose);
        challenge1=(RadioButton)view.findViewById(R.id.challenge_choose1);
        challenge2=(RadioButton)view.findViewById(R.id.challenge_choose2);
        challenge3=(RadioButton)view.findViewById(R.id.challenge_choose3);
        challenge4=(RadioButton)view.findViewById(R.id.challenge_choose4);

        breathe = (RadioGroup)view.findViewById(R.id.breathe_choose);
        breathe1 = (RadioButton)view.findViewById(R.id.breathe_choose1);
        breathe2 = (RadioButton)view.findViewById(R.id.breathe_choose2);
        breathe3 = (RadioButton)view.findViewById(R.id.breathe_choose3);
        breathe4 = (RadioButton)view.findViewById(R.id.breathe_choose4);

        influences=(RadioGroup)view.findViewById(R.id.influences_choose);
        influences1=(RadioButton)view.findViewById(R.id.influences_choose1);
        influences2=(RadioButton)view.findViewById(R.id.influences_choose2);
        influences3=(RadioButton)view.findViewById(R.id.influences_choose3);
        influences4=(RadioButton)view.findViewById(R.id.influences_choose4);

        pollution=(RadioGroup)view.findViewById(R.id.pollution_choose);
        pollution1=(RadioButton)view.findViewById(R.id.pollution_choose1);
        pollution2=(RadioButton)view.findViewById(R.id.pollution_choose2);
        pollution3=(RadioButton)view.findViewById(R.id.pollution_choose3);
        pollution4=(RadioButton)view.findViewById(R.id.pollution_choose4);

        willpower=(RadioGroup)view.findViewById(R.id.willpower_choose);
        willpower1=(RadioButton)view.findViewById(R.id.willpower_choose1);
        willpower2=(RadioButton)view.findViewById(R.id.willpower_choose2);
        willpower3=(RadioButton)view.findViewById(R.id.willpower_choose3);
        willpower4=(RadioButton)view.findViewById(R.id.willpower_choose4);

        health=(RadioGroup)view.findViewById(R.id.health_choose);
        health1=(RadioButton)view.findViewById(R.id.health_choose1);
        health2=(RadioButton)view.findViewById(R.id.health_choose2);
        health3=(RadioButton)view.findViewById(R.id.health_choose3);
        health4=(RadioButton)view.findViewById(R.id.health_choose4);

        closer=(RadioGroup)view.findViewById(R.id.closer_choose);
        closer1=(RadioButton)view.findViewById(R.id.closer_choose1);
        closer2=(RadioButton)view.findViewById(R.id.closer_choose2);
        closer3=(RadioButton)view.findViewById(R.id.closer_choose3);
        closer4=(RadioButton)view.findViewById(R.id.closer_choose4);

        taste_smell=(RadioGroup)view.findViewById(R.id.taste_smell_choose);
        taste_smell1=(RadioButton)view.findViewById(R.id.taste_smell_choose1);
        taste_smell2=(RadioButton)view.findViewById(R.id.taste_smell_choose2);
        taste_smell3=(RadioButton)view.findViewById(R.id.taste_smell_choose3);
        taste_smell4=(RadioButton)view.findViewById(R.id.taste_smell_choose4);

        dependence=(RadioGroup)view.findViewById(R.id.dependence_chooose);
        dependence1=(RadioButton)view.findViewById(R.id.dependence_chooose1);
        dependence2=(RadioButton)view.findViewById(R.id.dependence_chooose2);
        dependence3=(RadioButton)view.findViewById(R.id.dependence_chooose3);
        dependence4=(RadioButton)view.findViewById(R.id.dependence_chooose4);
        return view;
    }
    private View.OnClickListener onclick = new View.OnClickListener() {

        public void onClick(View v) {
                FileInputStream fis = null;
                StringBuilder sb = new StringBuilder();
                try {
                    fis = getActivity().openFileInput("note.txt");
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

                switch(choose_stop_smoke.getCheckedRadioButtonId()){
                    case R.id.choose_stop_smoke1:
                        a=4;
                        break;
                    case R.id.choose_stop_smoke2:
                        a=3;
                        break;
                    case R.id.choose_stop_smoke3:
                        a=2;
                        break;
                    case R.id.choose_stop_smoke4:
                        a=1;
                        break;
                }
                switch(typical.getCheckedRadioButtonId()){
                    case R.id.typical_choose1:
                        b=4;
                        break;
                    case R.id.typical_choose2:
                        b=3;
                        break;
                    case R.id.typical_choose3:
                        b=2;
                        break;
                    case R.id.typical_choose4:
                        b=1;
                        break;
                }
                switch(habits.getCheckedRadioButtonId()){
                    case R.id.habits_choose1:
                        c=4;
                        break;
                    case R.id.habits_choose2:
                        c=3;
                        break;
                    case R.id.habits_choose3:
                        c=2;
                        break;
                    case R.id.habits_choose4:
                        c=1;
                        break;
                }
                switch(challenge.getCheckedRadioButtonId()){
                    case R.id.challenge_choose1:
                        d=4;
                        break;
                    case R.id.challenge_choose2:
                        d=3;
                        break;
                    case R.id.challenge_choose3:
                        d=2;
                        break;
                    case R.id.challenge_choose4:
                        d=1;
                        break;
                }
                switch(breathe.getCheckedRadioButtonId()){
                    case R.id.breathe_choose1:
                        e=4;
                        break;
                    case R.id.breathe_choose2:
                        e=3;
                        break;
                    case R.id.breathe_choose3:
                        e=2;
                        break;
                    case R.id.breathe_choose4:
                        e=1;
                        break;
                }
                switch(influences.getCheckedRadioButtonId()){
                    case R.id.influences_choose1:
                        f=4;
                        break;
                    case R.id.influences_choose2:
                        f=3;
                        break;
                    case R.id.influences_choose3:
                        f=2;
                        break;
                    case R.id.influences_choose4:
                        f=1;
                        break;
                }
                switch(pollution.getCheckedRadioButtonId()){
                    case R.id.pollution_choose1:
                        g=4;
                        break;
                    case R.id.pollution_choose2:
                        g=3;
                        break;
                    case R.id.pollution_choose3:
                        g=2;
                        break;
                    case R.id.pollution_choose4:
                        g=1;
                        break;
                }
                switch(willpower.getCheckedRadioButtonId()){
                    case R.id.willpower_choose1:
                        h=4;
                        break;
                    case R.id.willpower_choose2:
                        h=3;
                        break;
                    case R.id.willpower_choose3:
                        h=2;
                        break;
                    case R.id.willpower_choose4:
                        h=1;
                        break;
                }
                switch(health.getCheckedRadioButtonId()){
                    case R.id.health_choose1:
                        i=4;
                        break;
                    case R.id.health_choose2:
                        i=3;
                        break;
                    case R.id.health_choose3:
                        i=2;
                        break;
                    case R.id.health_choose4:
                        i=1;
                        break;
                }
                switch(closer.getCheckedRadioButtonId()){
                    case R.id.closer_choose1:
                        j=4;
                        break;
                    case R.id.closer_choose2:
                        j=3;
                        break;
                    case R.id.closer_choose3:
                        j=2;
                        break;
                    case R.id.closer_choose4:
                        j=1;
                        break;
                }
                switch(taste_smell.getCheckedRadioButtonId()){
                    case R.id.taste_smell_choose1:
                        k=4;
                        break;
                    case R.id.taste_smell_choose2:
                        k=3;
                        break;
                    case R.id.taste_smell_choose3:
                        k=2;
                        break;
                    case R.id.taste_smell_choose4:
                        k=1;
                        break;
                }
                switch(dependence.getCheckedRadioButtonId()){
                    case R.id.dependence_chooose1:
                        l=4;
                        break;
                    case R.id.dependence_chooose2:
                        l=3;
                        break;
                    case R.id.dependence_chooose3:
                        l=2;
                        break;
                    case R.id.dependence_chooose4:
                        l=1;
                        break;
                }


                sumaei = a+e+i;
                sumbfj = b+f+j;
                sumcgk = c+g+k;
                sumdhl = d+h+l;

                String sumaeiS = Integer.toString(sumaei);
                String sumbfjS = Integer.toString(sumbfj);
                String sumcgkS = Integer.toString(sumcgk);
                String sumdhlS = Integer.toString(sumdhl);

                FirebaseDatabase database = FirebaseDatabase.getInstance("https://wedproject-d750d.firebaseio.com/");
                DatabaseReference myRef = database.getReference("usersAssessment/" + sb);

                Stop_Smoking_Really Stopsmokint = new Stop_Smoking_Really(
                        sumaeiS,
                        sumbfjS,
                        sumcgkS,
                        sumdhlS
                );
                myRef.child("戒菸指數").setValue(Stopsmokint);

                /*Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);*/


            int number;
            Intent intent1 = getActivity().getIntent();
            number = intent1.getIntExtra("number", 2);
            Log.e("idontwantit", "number: "+number);
            if(number ==3){
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("number", 10);
                startActivity(intent);
            }
            if(number ==2){
                Intent intent2 = getActivity().getIntent();
                intent2.putExtra("id", 3);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("id", 3);
                startActivity(intent);
            }

                /*FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new Status());
                ft.commit();*/

            }


    };
    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("你為什麼吸菸？");

    }
}
