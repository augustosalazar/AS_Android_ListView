package com.uninorte.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Fragment2 extends Fragment {

    private ListView mLv;
    public Fragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mLv = (ListView) rootView.findViewById(R.id.listView);

        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View",

                "Adapter implementation2",
                "Simple List View In Android2",
                "Create List View Android2",
                "Android Example2",
                "List View Source Code2",
                "List View Array Adapter2",
                "Android Example List View2",

                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View",
        };

        CustomAdapter adapter = new CustomAdapter(getActivity(), values);


        mLv.setAdapter(adapter);

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long index) {
                Log.d("List", "Texto "+ (String) view.getTag());
            }
        });

        return rootView;
    }
}

