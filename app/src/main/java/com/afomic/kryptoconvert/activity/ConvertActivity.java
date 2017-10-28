package com.afomic.kryptoconvert.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afomic.kryptoconvert.R;

import org.w3c.dom.Text;

/**
 * Created by rechael on 10/23/2017.
 */

        public class ConvertActivity extends AppCompatActivity {
   Integer input;
    Double result;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert);


        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
       final double conversionValue = getIntent().getDoubleExtra("conversionValue",0.00);
        final String cryptoString = getIntent().getStringExtra("from");
        final String currencyString = getIntent().getStringExtra("to");
        String conv = String.valueOf(conversionValue);
        final TextView putCurrency = (TextView) findViewById(R.id.put_currency);
        putCurrency.setVisibility(View.INVISIBLE);
       final EditText currencyEdit = (EditText) findViewById(R.id.to_edit_text);
        if (!currencyEdit.getText().toString().equals("")){
        input =  Integer.parseInt(currencyEdit.getText().toString());
            result =input *conversionValue;}

    Button fromTo = (Button) findViewById(R.id.button_fromto);
        fromTo.setText(cryptoString + " to " + currencyString);
        fromTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putCurrency.setVisibility(View.VISIBLE);
                Toast.makeText(ConvertActivity.this, String.valueOf(input), Toast.LENGTH_SHORT).show();

                putCurrency.setText("1 " + cryptoString + "equals " +String.valueOf(result) + currencyString);
            }
        });


        //set Text to V
        Toast.makeText(this, conv, Toast.LENGTH_LONG).show();


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
