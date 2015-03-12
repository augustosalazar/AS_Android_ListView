package com.uninorte.listview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private String[] values;

    public CustomAdapter(Context context,String[] values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return values[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        String s = values[position];

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row, null);
        }

        TextView f1 = (TextView) view.findViewById(R.id.tvField1);
        Button button = (Button) view.findViewById(R.id.btnRemove);
        button.setFocusableInTouchMode(false);
        button.setFocusable(false);
        f1.setText(s);
        button.setTag(s);

        view.setTag(s);

        return view;
    }
}
