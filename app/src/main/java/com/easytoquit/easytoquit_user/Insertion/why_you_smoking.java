package com.easytoquit.easytoquit_user.Insertion;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.easytoquit.easytoquit_user.R;
import com.easytoquit.easytoquit_user.RetreiveData.Why_smoking;
import com.easytoquit.easytoquit_user.mFragment.Status;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by chenyunjing on 2018/5/15.
 */

public class why_you_smoking extends Fragment {
    int sumstimulate;
    int sumcontrol;
    int sumrelax;
    int sumemotional＿support;
    int sumdesire;
    int sumhabitual;

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

    Button sure;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.why_you_smoking, container, false);
        final String TAG = "Status";

        sure =(Button)view.findViewById(R.id.btn_sure);
        sure.setOnClickListener(onclick);

        spirit=(RadioGroup)view.findViewById(R.id.spirit_choose);
        spirit1=(RadioButton)view.findViewById(R.id.spirit_choose1);
        spirit2=(RadioButton)view.findViewById(R.id.spirit_choose2);
        spirit3=(RadioButton)view.findViewById(R.id.spirit_choose3);
        spirit4=(RadioButton)view.findViewById(R.id.spirit_choose4);
        spirit5=(RadioButton)view.findViewById(R.id.spirit_choose5);

        pleasure=(RadioGroup)view.findViewById(R.id.pleasure_choose);
        pleasure1=(RadioButton)view.findViewById(R.id.pleasure_choose1);
        pleasure2=(RadioButton)view.findViewById(R.id.pleasure_choose2);
        pleasure3=(RadioButton)view.findViewById(R.id.pleasure_choose3);
        pleasure4=(RadioButton)view.findViewById(R.id.pleasure_choose4);
        pleasure5=(RadioButton)view.findViewById(R.id.pleasure_choose5);

        happy=(RadioGroup)view.findViewById(R.id.happy_choose);
        happy1=(RadioButton)view.findViewById(R.id.happy_choose1);
        happy2=(RadioButton)view.findViewById(R.id.happy_choose2);
        happy3=(RadioButton)view.findViewById(R.id.happy_choose3);
        happy4=(RadioButton)view.findViewById(R.id.happy_choose4);
        happy5=(RadioButton)view.findViewById(R.id.happy_choose5);

        angry=(RadioGroup)view.findViewById(R.id.angry_choose);
        angry1=(RadioButton)view.findViewById(R.id.angry_choose1);
        angry2=(RadioButton)view.findViewById(R.id.angry_choose2);
        angry3=(RadioButton)view.findViewById(R.id.angry_choose3);
        angry4=(RadioButton)view.findViewById(R.id.angry_choose4);
        angry5=(RadioButton)view.findViewById(R.id.angry_choose5);

        unbearable=(RadioGroup)view.findViewById(R.id.unbearable_choose);
        unbearable1=(RadioButton)view.findViewById(R.id.unbearable_choose1);
        unbearable2=(RadioButton)view.findViewById(R.id.unbearable_choose2);
        unbearable3=(RadioButton)view.findViewById(R.id.unbearable_choose3);
        unbearable4=(RadioButton)view.findViewById(R.id.unbearable_choose4);
        unbearable5=(RadioButton)view.findViewById(R.id.unbearable_choose5);

        no＿perception=(RadioGroup)view.findViewById(R.id.no_perception_choose);
        no＿perception1=(RadioButton)view.findViewById(R.id.no_perception_choose1);
        no＿perception2=(RadioButton)view.findViewById(R.id.no_perception_choose2);
        no＿perception3=(RadioButton)view.findViewById(R.id.no_perception_choose3);
        no＿perception4=(RadioButton)view.findViewById(R.id.no_perception_choose4);
        no＿perception5=(RadioButton)view.findViewById(R.id.no_perception_choose5);

        stimulate=(RadioGroup)view.findViewById(R.id.stimulate_choose);
        stimulate1=(RadioButton)view.findViewById(R.id.stimulate_choose1);
        stimulate2=(RadioButton)view.findViewById(R.id.stimulate_choose2);
        stimulate3=(RadioButton)view.findViewById(R.id.stimulate_choose3);
        stimulate4=(RadioButton)view.findViewById(R.id.stimulate_choose4);
        stimulate5=(RadioButton)view.findViewById(R.id.stimulate_choose5);

        moment=(RadioGroup)view.findViewById(R.id.moment_choose);
        moment1=(RadioButton)view.findViewById(R.id.moment_choose1);
        moment2=(RadioButton)view.findViewById(R.id.moment_choose2);
        moment3=(RadioButton)view.findViewById(R.id.moment_choose3);
        moment4=(RadioButton)view.findViewById(R.id.moment_choose4);
        moment5=(RadioButton)view.findViewById(R.id.moment_choose5);

        madeyouhappy=(RadioGroup)view.findViewById(R.id.madeyouhappy_choose);
        madeyouhappy1=(RadioButton)view.findViewById(R.id.madeyouhappy_choose1);
        madeyouhappy2=(RadioButton)view.findViewById(R.id.madeyouhappy_choose2);
        madeyouhappy3=(RadioButton)view.findViewById(R.id.madeyouhappy_choose3);
        madeyouhappy4=(RadioButton)view.findViewById(R.id.madeyouhappy_choose4);
        madeyouhappy5=(RadioButton)view.findViewById(R.id.madeyouhappy_choose5);

        irritability=(RadioGroup)view.findViewById(R.id.irritability_choose);
        irritability1=(RadioButton)view.findViewById(R.id.irritability_choose1);
        irritability2=(RadioButton)view.findViewById(R.id.irritability_choose2);
        irritability3=(RadioButton)view.findViewById(R.id.irritability_choose3);
        irritability4=(RadioButton)view.findViewById(R.id.irritability_choose4);
        irritability5=(RadioButton)view.findViewById(R.id.irritability_choose5);

        clearperception=(RadioGroup)view.findViewById(R.id.clearperception_choose);
        clearperception1=(RadioButton)view.findViewById(R.id.clearperception_choose1);
        clearperception2=(RadioButton)view.findViewById(R.id.clearperception_choose2);
        clearperception3=(RadioButton)view.findViewById(R.id.clearperception_choose3);
        clearperception4=(RadioButton)view.findViewById(R.id.clearperception_choose4);
        clearperception5=(RadioButton)view.findViewById(R.id.clearperception_choose5);

        another=(RadioGroup)view.findViewById(R.id.another_choose);
        another1=(RadioButton)view.findViewById(R.id.another_choose1);
        another2=(RadioButton)view.findViewById(R.id.another_choose2);
        another3=(RadioButton)view.findViewById(R.id.another_choose3);
        another4=(RadioButton)view.findViewById(R.id.another_choose4);
        another5=(RadioButton)view.findViewById(R.id.another_choose5);

        better=(RadioGroup)view.findViewById(R.id.better_choose);
        better1=(RadioButton)view.findViewById(R.id.better_choose1);
        better2=(RadioButton)view.findViewById(R.id.better_choose2);
        better3=(RadioButton)view.findViewById(R.id.better_choose3);
        better4=(RadioButton)view.findViewById(R.id.better_choose4);
        better5=(RadioButton)view.findViewById(R.id.better_choose5);

        joy=(RadioGroup)view.findViewById(R.id.joy_choose);
        joy1=(RadioButton)view.findViewById(R.id.joy_choose1);
        joy2=(RadioButton)view.findViewById(R.id.joy_choose2);
        joy3=(RadioButton)view.findViewById(R.id.joy_choose3);
        joy4=(RadioButton)view.findViewById(R.id.joy_choose4);
        joy5=(RadioButton)view.findViewById(R.id.joy_choose5);

        release=(RadioGroup)view.findViewById(R.id.release_choose);
        release1=(RadioButton)view.findViewById(R.id.release_choose1);
        release2=(RadioButton)view.findViewById(R.id.release_choose2);
        release3=(RadioButton)view.findViewById(R.id.release_choose3);
        release4=(RadioButton)view.findViewById(R.id.release_choose4);
        release5=(RadioButton)view.findViewById(R.id.release_choose5);

        exclude=(RadioGroup)view.findViewById(R.id.exclude_choose);
        exclude1=(RadioButton)view.findViewById(R.id.exclude_choose1);
        exclude2=(RadioButton)view.findViewById(R.id.exclude_choose2);
        exclude3=(RadioButton)view.findViewById(R.id.exclude_choose3);
        exclude4=(RadioButton)view.findViewById(R.id.exclude_choose4);
        exclude5=(RadioButton)view.findViewById(R.id.exclude_choose5);

        desire=(RadioGroup)view.findViewById(R.id.desire_choose);
        desire1=(RadioButton)view.findViewById(R.id.desire_choose1);
        desire2=(RadioButton)view.findViewById(R.id.desire_choose2);
        desire3=(RadioButton)view.findViewById(R.id.desire_choose3);
        desire4=(RadioButton)view.findViewById(R.id.desire_choose4);
        desire5=(RadioButton)view.findViewById(R.id.desire_choose5);

        whytime=(RadioGroup)view.findViewById(R.id.whytime_choose);
        whytime1=(RadioButton)view.findViewById(R.id.whytime_choose1);
        whytime2=(RadioButton)view.findViewById(R.id.whytime_choose2);
        whytime3=(RadioButton)view.findViewById(R.id.whytime_choose3);
        whytime4=(RadioButton)view.findViewById(R.id.whytime_choose4);
        whytime5=(RadioButton)view.findViewById(R.id.whytime_choose5);
        return view;
    }
    View.OnClickListener onclick = new View.OnClickListener() {

        public void onClick(View v) {

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

            String sumstimulateS = Integer.toString(sumstimulate);
            String sumcontrolS = Integer.toString(sumcontrol);
            String sumrelaxS = Integer.toString(sumrelax);
            String sumemotional＿supportS = Integer.toString(sumemotional＿support);
            String sumdesireS = Integer.toString(sumdesire);
            String sumhabitualS = Integer.toString(sumhabitual);

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




            FirebaseDatabase database = FirebaseDatabase.getInstance("https://wedproject-d750d.firebaseio.com/");
            DatabaseReference myRef = database.getReference("usersAssessment/" + sb);

            Why_smoking why_smoking = new Why_smoking(
                    sumstimulateS,
                    sumcontrolS,
                    sumrelaxS,
                    sumemotional＿supportS,
                    sumdesireS,
                    sumhabitualS
            );

            myRef.child("為什麼戒菸？").setValue(why_smoking);


            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, new Status());
            ft.commit();


            /*int number;
            Intent intent1 = getActivity().getIntent();
            number = intent1.getIntExtra("number", 4);
            Log.e("idontwantit", "number: "+number);
            if(number ==4){
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, new Status());
                ft.commit();
                *//*Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("number", 10);
                Intent intent2 = getActivity().getIntent();
                intent2.putExtra("id", 1);
                startActivity(intent);*//*
            }
            if(number ==3){
                Intent intent2 = getActivity().getIntent();
                intent2.putExtra("id", 1);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);
            }*/


           /* int number;
            Intent intent1 = getActivity().getIntent();
            number = intent1.getIntExtra("number", 3);
            Log.e("aa", "number_Now:"+ number);
            intent1.putExtra("number", 4);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, new Status());
            ft.commit();*/
        }


    };
    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("你真的有心想要戒菸嗎？");

    }
}
