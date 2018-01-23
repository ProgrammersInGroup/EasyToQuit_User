package com.easytoquit.easytoquit_user.History;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.easytoquit.easytoquit_user.Meeting.MeetingAll;
import com.easytoquit.easytoquit_user.Meeting.MeetingFirst;
import com.easytoquit.easytoquit_user.Meeting.MeetingSecond;
import com.easytoquit.easytoquit_user.R;

public class History_Meeting extends AppCompatActivity {

    private ListView lv;
    private static String[] meeting_category = {"總表", "戒菸衛教暨個案管理紀錄表(第 1 次)", "戒菸衛教暨個案管理紀錄表(第 2 次)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history__meeting);
        setTitle("訪談記錄列表");

        lv = (ListView) findViewById(R.id.listView_history_meeting);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, meeting_category));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getActivity(), information_category[i], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();;
                if (i == 0) {
                    intent.setClass(History_Meeting.this, MeetingAll.class);
                } else if (i == 1) {
                    intent.setClass(History_Meeting.this, MeetingFirst.class);
                } else {
                    intent.setClass(History_Meeting.this, MeetingSecond.class);
                }
                startActivity(intent);
            }
        });
    }
}
