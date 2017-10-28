package com.afomic.kryptoconvert.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afomic.kryptoconvert.R;
import com.afomic.kryptoconvert.activity.ConvertActivity;
import com.afomic.kryptoconvert.activity.MainActivity;
import com.afomic.kryptoconvert.model.ConversionClass;

import java.util.List;

/**
 * Created by rechael on 10/25/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public interface onItemClickListener{
        void onItemClick(ConversionClass conversion);
    }
    private Context context;
    private MainActivity mA;
    private List<ConversionClass> mConversionClass;
    private onItemClickListener listener;


    public RecyclerAdapter(Context context, List<ConversionClass> conversionClass){
        this.context = context;
        this.mConversionClass = conversionClass;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ConversionClass mConversionClass = this.mConversionClass.get(position);
        final String from = mConversionClass.getFrom();
       final  String to = mConversionClass.getTo();
       final double value = mConversionClass.getValue();
            holder.textViewFrom .setText(from);
            holder.textViewTo.setText(to);
            holder.textVewToValue.setText(String.valueOf(value));
            holder.cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    Intent mIntent = new Intent(context, ConvertActivity.class);
                    mIntent.putExtra("conversionValue",value);
                    mIntent.putExtra("from",from);
                    mIntent.putExtra("to", to);
                    context.startActivity(mIntent);


                }
            });
    }

    @Override
    public int getItemCount() {

    return mConversionClass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        CardView cardView;
        TextView textViewFrom;
        TextView textViewTo;
        TextView textVewToValue;
        public ViewHolder(View v){

            super(v);
            context = v.getContext();
        linearLayout = (LinearLayout) v.findViewById(R.id.cardLinearLay);
            cardView = (CardView) v.findViewById(R.id.cardView);
            textViewFrom= (TextView) v.findViewById(R.id.from);
            textViewTo= (TextView) v.findViewById(R.id.to);
            textVewToValue = (TextView) v.findViewById(R.id.toValue);
    }

    }


   
}
