package com.easytoquit.easytoquit_user.mFragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.easytoquit.easytoquit_user.Insertion.InsertProfile;
import com.easytoquit.easytoquit_user.R;
import com.easytoquit.easytoquit_user.RetreiveData.Stop_Smoking_Really;
import com.easytoquit.easytoquit_user.RetreiveData.User;
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

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

/**
 * Created by Polaris0712 on 13/01/2018.
 */

public class Profile extends Fragment {
    private static final String TAG = "MainActivity";
    TextView name;
    TextView gender;
    TextView age;
    TextView phone;
    private ImageButton editbt;
    CircleImageView profile_image;
    String BitmapString;
    Bitmap mBitmapImage;

    ImageView image;
    String text2Qr;
    Bitmap bitmap;
    public final static int QRCodeWidth = 500 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, container, false);
        name = (TextView)view.findViewById(R.id.name) ;
        gender = (TextView)view.findViewById(R.id.gender) ;
        age = (TextView)view.findViewById(R.id.age) ;
        phone = (TextView)view.findViewById(R.id.phone) ;
        profile_image = (CircleImageView) view.findViewById(R.id.profile_image);
        editbt = (ImageButton)view.findViewById(R.id.imageButton);
        editbt.setOnClickListener(onclick);
        image = (ImageView)view.findViewById(R.id.iv);

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
        //改為用暫存檔讀取資料庫
        DatabaseReference myRef = database.getReference("users/" + sb);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                /*User user = dataSnapshot.getValue(User.class);
                // [START_EXCLUDE]
                Log.d(TAG, "Value is: " + user);*/
                User value = dataSnapshot.getValue(User.class);
                name.setText(value.getName());
                age.setText(value.getAge());
                gender.setText(value.getGender());
                phone.setText(value.getPhone());
                BitmapString = value.getBitmapString();
                mBitmapImage=getBitmap(BitmapString);
                //lets put the image in the image view
                //Bitmap d = new BitmapDrawable(this.getResources() , selectedImage).getBitmap();
                int nh = (int) ( mBitmapImage.getHeight() * (512.0 / mBitmapImage.getWidth()) );
                Bitmap scaled = Bitmap.createScaledBitmap(mBitmapImage, 512, nh, true);
                profile_image.setImageBitmap(scaled);
                Log.d(TAG, "Value is: " + value.getName());

                text2Qr = value.getPhone();
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
    private View.OnClickListener onclick = new View.OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent(getActivity(),InsertProfile.class);
            startActivity(intent);


        }

    };
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("個人檔案");
    }
    public Bitmap getBitmap(String x){

        byte[] bitmapArray;
        bitmapArray = Base64.decode(x,Base64.DEFAULT);
        Bitmap bmp = BitmapFactory.decodeByteArray(bitmapArray
                , 0 , bitmapArray.length);
        return bmp;


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
}
