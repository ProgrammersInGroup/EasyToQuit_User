package com.easytoquit.easytoquit_user.mFragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.easytoquit.easytoquit_user.MainActivity;
import com.easytoquit.easytoquit_user.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Polaris0712 on 11/01/2018.
 */

public class Health_Stop extends Fragment {
    Button send;
    String text2Qr;
    Bitmap bitmap;
    EditText test;
    public final static int QRCodeWidth = 500 ;

    /*GlobalVariable gv = (GlobalVariable)getActivity().getApplicationContext();
    String phone = gv.getPhone();*/
    //DatabaseReference myRef = database.getReference("users/0935901509/phone");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.health_stop, container, false);

       test = view.findViewById(R.id.autoCompleteTextView);
       send = view.findViewById(R.id.back);

        send.setOnClickListener(onClick);

        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("意見回饋");

    }

    private View.OnClickListener onClick = new View.OnClickListener() {

        public void onClick(View v) {
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
            DatabaseReference myRef = database.getReference("Q&A/" + sb);
            myRef.child("使用者問題").setValue(test.getText().toString());
            Intent intent = new Intent();
            intent.setClass(getActivity(), MainActivity.class);
            startActivity(intent);

            new AlertDialog.Builder(getActivity())
                    .setMessage("確認送出！")
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.content_frame, new Status());
                            ft.commit();
                            //Toast.makeText(getActivity().getApplicationContext(), "我已經了解了！", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        }


    };


}
