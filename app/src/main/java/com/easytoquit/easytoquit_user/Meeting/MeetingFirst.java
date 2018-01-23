package com.easytoquit.easytoquit_user.Meeting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.easytoquit.easytoquit_user.R;

public class MeetingFirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_first);

        setTitle("戒菸衛教暨個案管理紀錄表(第 1 次)");
    }
}
