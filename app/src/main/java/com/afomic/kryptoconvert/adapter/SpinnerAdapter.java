package com.afomic.kryptoconvert.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afomic.kryptoconvert.R;

/**
 * Created by rechael on 10/22/2017.
 */

public class SpinnerAdapter extends BaseAdapter {
    private Context mContext;
    private String[] stringArray;
    public SpinnerAdapter(Context context, String[] array){
        mContext=context;
        stringArray=array;

    }
    @Override
    public int getCount() {
        if(stringArray==null){
            return 0;
        }
        return stringArray.length;
    }

    @Override
    public String getItem(int position) {
        return stringArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView =LayoutInflater.from(mContext).inflate(R.layout.text_view, parent,false);
        TextView mTextView=(TextView) convertView.findViewById(R.id.spinner_contents);
        String value=getItem(position);
        mTextView.setText(value);

        return convertView;
    }
}
