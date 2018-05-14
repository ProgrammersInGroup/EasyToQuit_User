package com.easytoquit.easytoquit_user.mFragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.easytoquit.easytoquit_user.MainActivity;
import com.easytoquit.easytoquit_user.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static android.content.ContentValues.TAG;

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

        getActivity().setTitle("問題Q&A");

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
        }
    };
}
