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
import android.widget.ImageView;

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
    Button back;
    ImageView image;
    String text2Qr;
    Bitmap bitmap;
    public final static int QRCodeWidth = 500 ;

    /*GlobalVariable gv = (GlobalVariable)getActivity().getApplicationContext();
    String phone = gv.getPhone();*/




    //DatabaseReference myRef = database.getReference("users/0935901509/phone");


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.health_stop, container, false);
        image = (ImageView)view.findViewById(R.id.iv);
        back = (Button)view.findViewById(R.id.back);


        //讀出檔案
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
        DatabaseReference myRef = database.getReference("users/" + sb + "/phone");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                text2Qr = dataSnapshot.getValue(String.class);
                //text2Qr = "0935901509";
                Log.d(TAG, "Phone: " + text2Qr);
                try {
                    bitmap = TextToImageEncode(text2Qr);

                    image.setImageBitmap(bitmap);

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());

            }
        });
        back.setOnClickListener(onClick);


        return view;
    }

    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRCodeWidth, QRCodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.black):getResources().getColor(R.color.white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("健康小站");

    }

    private View.OnClickListener onClick = new View.OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    };
}
