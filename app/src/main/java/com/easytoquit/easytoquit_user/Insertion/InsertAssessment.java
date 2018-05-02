package com.easytoquit.easytoquit_user.Insertion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.easytoquit.easytoquit_user.MainActivity;
import com.easytoquit.easytoquit_user.R;
import com.easytoquit.easytoquit_user.RetreiveData.SmokeStatus;
import com.easytoquit.easytoquit_user.RetreiveData.Stop_Smoking_Really;
import com.easytoquit.easytoquit_user.RetreiveData.Why_smoking;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InsertAssessment extends AppCompatActivity {

    int sumaei;
    int sumbfj;
    int sumcgk;
    int sumdhl;

    int sumstimulate;
    int sumcontrol;
    int sumrelax;
    int sumemotional＿support;
    int sumdesire;
    int sumhabitual;

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

    RadioGroup spirit;
    RadioButton spirit1;
    RadioButton spirit2;
    RadioButton spirit3;
    RadioButton spirit4;
    RadioButton spirit5;
    int aa = 0;

    RadioGroup pleasure;
    RadioButton pleasure1;
    RadioButton pleasure2;
    RadioButton pleasure3;
    RadioButton pleasure4;
    RadioButton pleasure5;
    int bb = 0;

    RadioGroup happy;
    RadioButton happy1;
    RadioButton happy2;
    RadioButton happy3;
    RadioButton happy4;
    RadioButton happy5;
    int cc = 0;

    RadioGroup angry;
    RadioButton angry1;
    RadioButton angry2;
    RadioButton angry3;
    RadioButton angry4;
    RadioButton angry5;
    int dd = 0;

    RadioGroup unbearable;
    RadioButton unbearable1;
    RadioButton unbearable2;
    RadioButton unbearable3;
    RadioButton unbearable4;
    RadioButton unbearable5;
    int ee = 0;

    RadioGroup no＿perception;
    RadioButton no＿perception1;
    RadioButton no＿perception2;
    RadioButton no＿perception3;
    RadioButton no＿perception4;
    RadioButton no＿perception5;
    int ff = 0;

    RadioGroup stimulate;
    RadioButton stimulate1;
    RadioButton stimulate2;
    RadioButton stimulate3;
    RadioButton stimulate4;
    RadioButton stimulate5;
    int gg = 0;

    RadioGroup moment;
    RadioButton moment1;
    RadioButton moment2;
    RadioButton moment3;
    RadioButton moment4;
    RadioButton moment5;
    int hh = 0;

    RadioGroup madeyouhappy;
    RadioButton madeyouhappy1;
    RadioButton madeyouhappy2;
    RadioButton madeyouhappy3;
    RadioButton madeyouhappy4;
    RadioButton madeyouhappy5;
    int ii = 0;

    RadioGroup irritability;
    RadioButton irritability1;
    RadioButton irritability2;
    RadioButton irritability3;
    RadioButton irritability4;
    RadioButton irritability5;
    int jj = 0;

    RadioGroup clearperception;
    RadioButton clearperception1;
    RadioButton clearperception2;
    RadioButton clearperception3;
    RadioButton clearperception4;
    RadioButton clearperception5;
    int kk = 0;

    RadioGroup another;
    RadioButton another1;
    RadioButton another2;
    RadioButton another3;
    RadioButton another4;
    RadioButton another5;
    int ll = 0;

    RadioGroup better;
    RadioButton better1;
    RadioButton better2;
    RadioButton better3;
    RadioButton better4;
    RadioButton better5;
    int mm = 0;

    RadioGroup joy;
    RadioButton joy1;
    RadioButton joy2;
    RadioButton joy3;
    RadioButton joy4;
    RadioButton joy5;
    int nn = 0;

    RadioGroup release;
    RadioButton release1;
    RadioButton release2;
    RadioButton release3;
    RadioButton release4;
    RadioButton release5;
    int oo = 0;

    RadioGroup exclude;
    RadioButton exclude1;
    RadioButton exclude2;
    RadioButton exclude3;
    RadioButton exclude4;
    RadioButton exclude5;
    int pp = 0;

    RadioGroup desire;
    RadioButton desire1;
    RadioButton desire2;
    RadioButton desire3;
    RadioButton desire4;
    RadioButton desire5;
    int qq = 0;

    RadioGroup whytime;
    RadioButton whytime1;
    RadioButton whytime2;
    RadioButton whytime3;
    RadioButton whytime4;
    RadioButton whytime5;
    int rr = 0;


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

        choose_stop_smoke = (RadioGroup)findViewById(R.id.choose_stop_smoke);
        choose_stop_smoke1 = (RadioButton)findViewById(R.id.choose_stop_smoke1);
        choose_stop_smoke2 = (RadioButton)findViewById(R.id.choose_stop_smoke2);
        choose_stop_smoke3 = (RadioButton)findViewById(R.id.choose_stop_smoke3);
        choose_stop_smoke4 = (RadioButton)findViewById(R.id.choose_stop_smoke4);

        typical=(RadioGroup)findViewById(R.id.typical_choose);
        typical1=(RadioButton)findViewById(R.id.typical_choose1);
        typical2=(RadioButton)findViewById(R.id.typical_choose2);
        typical3=(RadioButton)findViewById(R.id.typical_choose3);
        typical4=(RadioButton)findViewById(R.id.typical_choose4);

        habits=(RadioGroup)findViewById(R.id.habits_choose);
        habits1=(RadioButton)findViewById(R.id.habits_choose1);
        habits2=(RadioButton)findViewById(R.id.habits_choose2);
        habits3=(RadioButton)findViewById(R.id.habits_choose3);
        habits4=(RadioButton)findViewById(R.id.habits_choose4);

        challenge=(RadioGroup)findViewById(R.id.challenge_choose);
        challenge1=(RadioButton)findViewById(R.id.challenge_choose1);
        challenge2=(RadioButton)findViewById(R.id.challenge_choose2);
        challenge3=(RadioButton)findViewById(R.id.challenge_choose3);
        challenge4=(RadioButton)findViewById(R.id.challenge_choose4);

        breathe = (RadioGroup)findViewById(R.id.breathe_choose);
        breathe1 = (RadioButton)findViewById(R.id.breathe_choose1);
        breathe2 = (RadioButton)findViewById(R.id.breathe_choose2);
        breathe3 = (RadioButton)findViewById(R.id.breathe_choose3);
        breathe4 = (RadioButton)findViewById(R.id.breathe_choose4);

        influences=(RadioGroup)findViewById(R.id.influences_choose);
        influences1=(RadioButton)findViewById(R.id.influences_choose1);
        influences2=(RadioButton)findViewById(R.id.influences_choose2);
        influences3=(RadioButton)findViewById(R.id.influences_choose3);
        influences4=(RadioButton)findViewById(R.id.influences_choose4);

        pollution=(RadioGroup)findViewById(R.id.pollution_choose);
        pollution1=(RadioButton)findViewById(R.id.pollution_choose1);
        pollution2=(RadioButton)findViewById(R.id.pollution_choose2);
        pollution3=(RadioButton)findViewById(R.id.pollution_choose3);
        pollution4=(RadioButton)findViewById(R.id.pollution_choose4);

        willpower=(RadioGroup)findViewById(R.id.willpower_choose);
        willpower1=(RadioButton)findViewById(R.id.willpower_choose1);
        willpower2=(RadioButton)findViewById(R.id.willpower_choose2);
        willpower3=(RadioButton)findViewById(R.id.willpower_choose3);
        willpower4=(RadioButton)findViewById(R.id.willpower_choose4);

        health=(RadioGroup)findViewById(R.id.health_choose);
        health1=(RadioButton)findViewById(R.id.health_choose1);
        health2=(RadioButton)findViewById(R.id.health_choose2);
        health3=(RadioButton)findViewById(R.id.health_choose3);
        health4=(RadioButton)findViewById(R.id.health_choose4);

        closer=(RadioGroup)findViewById(R.id.closer_choose);
        closer1=(RadioButton)findViewById(R.id.closer_choose1);
        closer2=(RadioButton)findViewById(R.id.closer_choose2);
        closer3=(RadioButton)findViewById(R.id.closer_choose3);
        closer4=(RadioButton)findViewById(R.id.closer_choose4);

        taste_smell=(RadioGroup)findViewById(R.id.taste_smell_choose);
        taste_smell1=(RadioButton)findViewById(R.id.taste_smell_choose1);
        taste_smell2=(RadioButton)findViewById(R.id.taste_smell_choose2);
        taste_smell3=(RadioButton)findViewById(R.id.taste_smell_choose3);
        taste_smell4=(RadioButton)findViewById(R.id.taste_smell_choose4);

        dependence=(RadioGroup)findViewById(R.id.dependence_chooose);
        dependence1=(RadioButton)findViewById(R.id.dependence_chooose1);
        dependence2=(RadioButton)findViewById(R.id.dependence_chooose2);
        dependence3=(RadioButton)findViewById(R.id.dependence_chooose3);
        dependence4=(RadioButton)findViewById(R.id.dependence_chooose4);

        spirit=(RadioGroup)findViewById(R.id.spirit_choose);
        spirit1=(RadioButton)findViewById(R.id.spirit_choose1);
        spirit2=(RadioButton)findViewById(R.id.spirit_choose2);
        spirit3=(RadioButton)findViewById(R.id.spirit_choose3);
        spirit4=(RadioButton)findViewById(R.id.spirit_choose4);
        spirit5=(RadioButton)findViewById(R.id.spirit_choose5);

        pleasure=(RadioGroup)findViewById(R.id.pleasure_choose);
        pleasure1=(RadioButton)findViewById(R.id.pleasure_choose1);
        pleasure2=(RadioButton)findViewById(R.id.pleasure_choose2);
        pleasure3=(RadioButton)findViewById(R.id.pleasure_choose3);
        pleasure4=(RadioButton)findViewById(R.id.pleasure_choose4);
        pleasure5=(RadioButton)findViewById(R.id.pleasure_choose5);

        happy=(RadioGroup)findViewById(R.id.happy_choose);
        happy1=(RadioButton)findViewById(R.id.happy_choose1);
        happy2=(RadioButton)findViewById(R.id.happy_choose2);
        happy3=(RadioButton)findViewById(R.id.happy_choose3);
        happy4=(RadioButton)findViewById(R.id.happy_choose4);
        happy5=(RadioButton)findViewById(R.id.happy_choose5);

        angry=(RadioGroup)findViewById(R.id.angry_choose);
        angry1=(RadioButton)findViewById(R.id.angry_choose1);
        angry2=(RadioButton)findViewById(R.id.angry_choose2);
        angry3=(RadioButton)findViewById(R.id.angry_choose3);
        angry4=(RadioButton)findViewById(R.id.angry_choose4);
        angry5=(RadioButton)findViewById(R.id.angry_choose5);

        unbearable=(RadioGroup)findViewById(R.id.unbearable_choose);
        unbearable1=(RadioButton)findViewById(R.id.unbearable_choose1);
        unbearable2=(RadioButton)findViewById(R.id.unbearable_choose2);
        unbearable3=(RadioButton)findViewById(R.id.unbearable_choose3);
        unbearable4=(RadioButton)findViewById(R.id.unbearable_choose4);
        unbearable5=(RadioButton)findViewById(R.id.unbearable_choose5);

        no＿perception=(RadioGroup)findViewById(R.id.no_perception_choose);
        no＿perception1=(RadioButton)findViewById(R.id.no_perception_choose1);
        no＿perception2=(RadioButton)findViewById(R.id.no_perception_choose2);
        no＿perception3=(RadioButton)findViewById(R.id.no_perception_choose3);
        no＿perception4=(RadioButton)findViewById(R.id.no_perception_choose4);
        no＿perception5=(RadioButton)findViewById(R.id.no_perception_choose5);

        stimulate=(RadioGroup)findViewById(R.id.stimulate_choose);
        stimulate1=(RadioButton)findViewById(R.id.stimulate_choose1);
        stimulate2=(RadioButton)findViewById(R.id.stimulate_choose2);
        stimulate3=(RadioButton)findViewById(R.id.stimulate_choose3);
        stimulate4=(RadioButton)findViewById(R.id.stimulate_choose4);
        stimulate5=(RadioButton)findViewById(R.id.stimulate_choose5);

        moment=(RadioGroup)findViewById(R.id.moment_choose);
        moment1=(RadioButton)findViewById(R.id.moment_choose1);
        moment2=(RadioButton)findViewById(R.id.moment_choose2);
        moment3=(RadioButton)findViewById(R.id.moment_choose3);
        moment4=(RadioButton)findViewById(R.id.moment_choose4);
        moment5=(RadioButton)findViewById(R.id.moment_choose5);

        madeyouhappy=(RadioGroup)findViewById(R.id.madeyouhappy_choose);
        madeyouhappy1=(RadioButton)findViewById(R.id.madeyouhappy_choose1);
        madeyouhappy2=(RadioButton)findViewById(R.id.madeyouhappy_choose2);
        madeyouhappy3=(RadioButton)findViewById(R.id.madeyouhappy_choose3);
        madeyouhappy4=(RadioButton)findViewById(R.id.madeyouhappy_choose4);
        madeyouhappy5=(RadioButton)findViewById(R.id.madeyouhappy_choose5);

        irritability=(RadioGroup)findViewById(R.id.irritability_choose);
        irritability1=(RadioButton)findViewById(R.id.irritability_choose1);
        irritability2=(RadioButton)findViewById(R.id.irritability_choose2);
        irritability3=(RadioButton)findViewById(R.id.irritability_choose3);
        irritability4=(RadioButton)findViewById(R.id.irritability_choose4);
        irritability5=(RadioButton)findViewById(R.id.irritability_choose5);

        clearperception=(RadioGroup)findViewById(R.id.clearperception_choose);
        clearperception1=(RadioButton)findViewById(R.id.clearperception_choose1);
        clearperception2=(RadioButton)findViewById(R.id.clearperception_choose2);
        clearperception3=(RadioButton)findViewById(R.id.clearperception_choose3);
        clearperception4=(RadioButton)findViewById(R.id.clearperception_choose4);
        clearperception5=(RadioButton)findViewById(R.id.clearperception_choose5);

        another=(RadioGroup)findViewById(R.id.another_choose);
        another1=(RadioButton)findViewById(R.id.another_choose1);
        another2=(RadioButton)findViewById(R.id.another_choose2);
        another3=(RadioButton)findViewById(R.id.another_choose3);
        another4=(RadioButton)findViewById(R.id.another_choose4);
        another5=(RadioButton)findViewById(R.id.another_choose5);

        better=(RadioGroup)findViewById(R.id.better_choose);
        better1=(RadioButton)findViewById(R.id.better_choose1);
        better2=(RadioButton)findViewById(R.id.better_choose2);
        better3=(RadioButton)findViewById(R.id.better_choose3);
        better4=(RadioButton)findViewById(R.id.better_choose4);
        better5=(RadioButton)findViewById(R.id.better_choose5);

        joy=(RadioGroup)findViewById(R.id.joy_choose);
        joy1=(RadioButton)findViewById(R.id.joy_choose1);
        joy2=(RadioButton)findViewById(R.id.joy_choose2);
        joy3=(RadioButton)findViewById(R.id.joy_choose3);
        joy4=(RadioButton)findViewById(R.id.joy_choose4);
        joy5=(RadioButton)findViewById(R.id.joy_choose5);

        release=(RadioGroup)findViewById(R.id.release_choose);
        release1=(RadioButton)findViewById(R.id.release_choose1);
        release2=(RadioButton)findViewById(R.id.release_choose2);
        release3=(RadioButton)findViewById(R.id.release_choose3);
        release4=(RadioButton)findViewById(R.id.release_choose4);
        release5=(RadioButton)findViewById(R.id.release_choose5);

        exclude=(RadioGroup)findViewById(R.id.exclude_choose);
        exclude1=(RadioButton)findViewById(R.id.exclude_choose1);
        exclude2=(RadioButton)findViewById(R.id.exclude_choose2);
        exclude3=(RadioButton)findViewById(R.id.exclude_choose3);
        exclude4=(RadioButton)findViewById(R.id.exclude_choose4);
        exclude5=(RadioButton)findViewById(R.id.exclude_choose5);

        desire=(RadioGroup)findViewById(R.id.desire_choose);
        desire1=(RadioButton)findViewById(R.id.desire_choose1);
        desire2=(RadioButton)findViewById(R.id.desire_choose2);
        desire3=(RadioButton)findViewById(R.id.desire_choose3);
        desire4=(RadioButton)findViewById(R.id.desire_choose4);
        desire5=(RadioButton)findViewById(R.id.desire_choose5);

        whytime=(RadioGroup)findViewById(R.id.whytime_choose);
        whytime1=(RadioButton)findViewById(R.id.whytime_choose1);
        whytime2=(RadioButton)findViewById(R.id.whytime_choose2);
        whytime3=(RadioButton)findViewById(R.id.whytime_choose3);
        whytime4=(RadioButton)findViewById(R.id.whytime_choose4);
        whytime5=(RadioButton)findViewById(R.id.whytime_choose5);



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
                switch(spirit.getCheckedRadioButtonId()){
                    case R.id.spirit_choose1:
                        aa=5;
                        break;
                    case R.id.spirit_choose2:
                        aa=4;
                        break;
                    case R.id.spirit_choose3:
                        aa=3;
                        break;
                    case R.id.spirit_choose4:
                        aa=2;
                        break;
                    case R.id.spirit_choose5:
                        aa=1;
                        break;
                }
                switch(pleasure.getCheckedRadioButtonId()){
                    case R.id.pleasure_choose1:
                        bb=5;
                        break;
                    case R.id.pleasure_choose2:
                        bb=4;
                        break;
                    case R.id.pleasure_choose3:
                        bb=3;
                        break;
                    case R.id.pleasure_choose4:
                        bb=2;
                        break;
                    case R.id.pleasure_choose5:
                        bb=1;
                        break;
                }
                switch(happy.getCheckedRadioButtonId()){
                    case R.id.happy_choose1:
                        cc=5;
                        break;
                    case R.id.happy_choose2:
                        cc=4;
                        break;
                    case R.id.happy_choose3:
                        cc=3;
                        break;
                    case R.id.happy_choose4:
                        cc=2;
                        break;
                    case R.id.happy_choose5:
                        cc=1;
                        break;
                }
                switch(angry.getCheckedRadioButtonId()){
                    case R.id.angry_choose1:
                        dd=5;
                        break;
                    case R.id.angry_choose2:
                        dd=4;
                        break;
                    case R.id.angry_choose3:
                        dd=3;
                        break;
                    case R.id.angry_choose4:
                        dd=2;
                        break;
                    case R.id.angry_choose5:
                        dd=1;
                        break;
                }
                switch(unbearable.getCheckedRadioButtonId()){
                    case R.id.unbearable_choose1:
                        ee=5;
                        break;
                    case R.id.unbearable_choose2:
                        ee=4;
                        break;
                    case R.id.unbearable_choose3:
                        ee=3;
                        break;
                    case R.id.unbearable_choose4:
                        ee=2;
                        break;
                    case R.id.unbearable_choose5:
                        ee=1;
                        break;
                }
                switch(no＿perception.getCheckedRadioButtonId()){
                    case R.id.no_perception_choose1:
                        ff=5;
                        break;
                    case R.id.no_perception_choose2:
                        ff=4;
                        break;
                    case R.id.no_perception_choose3:
                        ff=3;
                        break;
                    case R.id.no_perception_choose4:
                        ff=2;
                        break;
                    case R.id.no_perception_choose5:
                        ff=1;
                        break;
                }
                switch(stimulate.getCheckedRadioButtonId()){
                    case R.id.stimulate_choose1:
                        gg=5;
                        break;
                    case R.id.stimulate_choose2:
                        gg=4;
                        break;
                    case R.id.stimulate_choose3:
                        gg=3;
                        break;
                    case R.id.stimulate_choose4:
                        gg=2;
                        break;
                    case R.id.stimulate_choose5:
                        gg=1;
                        break;
                }
                switch(moment.getCheckedRadioButtonId()){
                    case R.id.moment_choose1:
                        hh=5;
                        break;
                    case R.id.moment_choose2:
                        hh=4;
                        break;
                    case R.id.moment_choose3:
                        hh=3;
                        break;
                    case R.id.moment_choose4:
                        hh=2;
                        break;
                    case R.id.moment_choose5:
                        hh=1;
                        break;
                }
                switch(madeyouhappy.getCheckedRadioButtonId()){
                    case R.id.madeyouhappy_choose1:
                        ii=5;
                        break;
                    case R.id.madeyouhappy_choose2:
                        ii=4;
                        break;
                    case R.id.madeyouhappy_choose3:
                        ii=3;
                        break;
                    case R.id.madeyouhappy_choose4:
                        ii=2;
                        break;
                    case R.id.madeyouhappy_choose5:
                        ii=1;
                        break;
                }
                switch(irritability.getCheckedRadioButtonId()){
                    case R.id.irritability_choose1:
                        jj=5;
                        break;
                    case R.id.irritability_choose2:
                        jj=4;
                        break;
                    case R.id.irritability_choose3:
                        jj=3;
                        break;
                    case R.id.irritability_choose4:
                        jj=2;
                        break;
                    case R.id.irritability_choose5:
                        jj=1;
                        break;
                }
                switch(clearperception.getCheckedRadioButtonId()){
                    case R.id.clearperception_choose1:
                        kk=5;
                        break;
                    case R.id.clearperception_choose2:
                        kk=4;
                        break;
                    case R.id.clearperception_choose3:
                        kk=3;
                        break;
                    case R.id.clearperception_choose4:
                        kk=2;
                        break;
                    case R.id.clearperception_choose5:
                        kk=1;
                        break;
                }
                switch(another.getCheckedRadioButtonId()){
                    case R.id.another_choose1:
                        ll=5;
                        break;
                    case R.id.another_choose2:
                        ll=4;
                        break;
                    case R.id.another_choose3:
                        ll=3;
                        break;
                    case R.id.another_choose4:
                        ll=2;
                        break;
                    case R.id.another_choose5:
                        ll=1;
                        break;
                }
                switch(better.getCheckedRadioButtonId()){
                    case R.id.better_choose1:
                        mm=5;
                        break;
                    case R.id.better_choose2:
                        mm=4;
                        break;
                    case R.id.better_choose3:
                        mm=3;
                        break;
                    case R.id.better_choose4:
                        mm=2;
                        break;
                    case R.id.better_choose5:
                        mm=1;
                        break;
                }
                switch(joy.getCheckedRadioButtonId()){
                    case R.id.joy_choose1:
                        nn=5;
                        break;
                    case R.id.joy_choose2:
                        nn=4;
                        break;
                    case R.id.joy_choose3:
                        nn=3;
                        break;
                    case R.id.joy_choose4:
                        nn=2;
                        break;
                    case R.id.joy_choose5:
                        nn=1;
                        break;
                }
                switch(release.getCheckedRadioButtonId()){
                    case R.id.release_choose1:
                        oo=5;
                        break;
                    case R.id.release_choose2:
                        oo=4;
                        break;
                    case R.id.release_choose3:
                        oo=3;
                        break;
                    case R.id.release_choose4:
                        oo=2;
                        break;
                    case R.id.release_choose5:
                        oo=1;
                        break;
                }
                switch(exclude.getCheckedRadioButtonId()){
                    case R.id.exclude_choose1:
                        pp=5;
                        break;
                    case R.id.exclude_choose2:
                        pp=4;
                        break;
                    case R.id.exclude_choose3:
                        pp=3;
                        break;
                    case R.id.exclude_choose4:
                        pp=2;
                        break;
                    case R.id.exclude_choose5:
                        pp=1;
                        break;
                }
                switch(desire.getCheckedRadioButtonId()){
                    case R.id.desire_choose1:
                        qq=5;
                        break;
                    case R.id.desire_choose2:
                        qq=4;
                        break;
                    case R.id.desire_choose3:
                        qq=3;
                        break;
                    case R.id.desire_choose4:
                        qq=2;
                        break;
                    case R.id.desire_choose5:
                        qq=1;
                        break;
                }
                switch(whytime.getCheckedRadioButtonId()){
                    case R.id.whytime_choose1:
                        rr=5;
                        break;
                    case R.id.whytime_choose2:
                        rr=4;
                        break;
                    case R.id.whytime_choose3:
                        rr=3;
                        break;
                    case R.id.whytime_choose4:
                        rr=2;
                        break;
                    case R.id.whytime_choose5:
                        rr=1;
                        break;
                }

                sumstimulate=aa+gg+mm;
                sumcontrol=bb+hh+nn;
                sumrelax=cc+ii+oo;
                sumemotional＿support=dd+jj+pp;
                sumdesire=ee+kk+qq;
                sumhabitual=ff+ll+rr;

                sumaei = a+e+i;
                sumbfj = b+f+j;
                sumcgk = c+g+k;
                sumdhl = d+h+l;

                String sumaeiS = Integer.toString(sumaei);
                String sumbfjS = Integer.toString(sumbfj);
                String sumcgkS = Integer.toString(sumcgk);
                String sumdhlS = Integer.toString(sumdhl);

                String sumstimulateS = Integer.toString(sumstimulate);
                String sumcontrolS = Integer.toString(sumcontrol);
                String sumrelaxS = Integer.toString(sumrelax);
                String sumemotional＿supportS = Integer.toString(sumemotional＿support);
                String sumdesireS = Integer.toString(sumdesire);
                String sumhabitualS = Integer.toString(sumhabitual);

                FirebaseDatabase database = FirebaseDatabase.getInstance("https://wedproject-d750d.firebaseio.com/");
                DatabaseReference myRef = database.getReference("usersAssessment/" + sb);

                Stop_Smoking_Really Stopsmokint = new Stop_Smoking_Really(
                        sumaeiS,
                        sumbfjS,
                        sumcgkS,
                        sumdhlS
                );
                myRef.child("戒菸指數").setValue(Stopsmokint);

                Why_smoking why_smoking = new Why_smoking(
                        sumstimulateS,
                        sumcontrolS,
                        sumrelaxS,
                        sumemotional＿supportS,
                        sumdesireS,
                        sumhabitualS
                );
                myRef.child("為什麼戒菸？").setValue(why_smoking);


                SmokeStatus smokeStatus = new SmokeStatus(
                        edt_assessment_smoking_year.getText().toString(),
                        edt_assessment_date_smoking.getText().toString(),
                        //edt_assessment_week_smoking.getText().toString(),
                        edt_assessment_quit_smoking_date.getText().toString(),
                        edt_assessment_save_money.getText().toString());
                myRef.child("評估資料").child("第一次評估資料").setValue(smokeStatus);

                Intent intent = new Intent(InsertAssessment.this, MainActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);
            }

        }
    };
}
