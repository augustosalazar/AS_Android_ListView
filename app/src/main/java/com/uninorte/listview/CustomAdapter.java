package com.uninorte.listview;


import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private static final String TAG = "CustomAdapterH";
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

        view.setMinimumHeight(getH(view));

        return view;
    }

    private int getH(View view){

        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        int h = view.getHeight();
        int height = dm.heightPixels;
        int listItemHeight = height / getCount();


        if (h * getCount() >  height) {
            Log.d(TAG, "Op1 h " + h + " height " + height + " listItemHeight " + listItemHeight + " " + getCount());
            return h;
        }
        else {
            Log.d(TAG, "Op2 h " + h + " height " + height + " listItemHeight " + listItemHeight + " " + getCount());
            return listItemHeight;
        }
    }


}
