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
    TextView show_week_smoking;
    TextView show_date_smoking;
    TextView show_quit_smoking_date;
    //TextView show_smoking_money;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.status, container, false);
        final String TAG="Status";
        show_smoking_year = (TextView)view.findViewById(R.id.show_smoking_year) ;
        show_week_smoking = (TextView)view.findViewById(R.id.show_week_smoking) ;
        show_date_smoking = (TextView)view.findViewById(R.id.show_date_smoking) ;
        show_quit_smoking_date = (TextView)view.findViewById(R.id.show_quit_smoking_date) ;
        //show_smoking_money = (TextView)view.findViewById(R.id.show_smoking_money) ;
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

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                /*User user = dataSnapshot.getValue(User.class);
                // [START_EXCLUDE]
                Log.d(TAG, "Value is: " + user);*/
                SmokeStatus value = dataSnapshot.getValue(SmokeStatus.class);
                show_smoking_year.setText(value.getsmokeage());
                show_week_smoking.setText(value.getsmokehowmuchweek());
                show_date_smoking.setText(value.getsmokehowmuchday());
                show_quit_smoking_date.setText(value.getsmokequitday());
                //show_smoking_money.setText(value.getsmokemoney());
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

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("目前狀態");
    }
}
