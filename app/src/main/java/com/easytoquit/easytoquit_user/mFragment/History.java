package com.easytoquit.easytoquit_user.mFragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.easytoquit.easytoquit_user.History.History_Meeting;
import com.easytoquit.easytoquit_user.R;

/**
 * Created by Polaris0712 on 11/01/2018.
 */

public class History extends Fragment {

    private ListView lv;
    private static String[] history_category = {"訪談紀錄"};

    public static History newInstance(){

        History history = new History();
        return history;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history, container, false);
        lv = (ListView) view.findViewById(R.id.listView_history);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, history_category));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getActivity(), information_category[i], Toast.LENGTH_SHORT).show();
                Intent intent;
                if(i == 0){
                    intent  = new Intent();
                    intent.setClass(getActivity(),History_Meeting.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), "Cannot Show The Item", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("歷史資料");
    }
}
