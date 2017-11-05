package com.afomic.kryptoconvert.activity;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


import com.afomic.kryptoconvert.adapter.RecyclerAdapter;
import com.afomic.kryptoconvert.adapter.SpinnerAdapter;
import com.afomic.kryptoconvert.model.ConversionClass;
import com.afomic.kryptoconvert.model.CryptoPojo;
import com.afomic.kryptoconvert.R;
import com.afomic.kryptoconvert.rest.ApiClient;
import com.afomic.kryptoconvert.rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public String cryptoString;
    public String currencyString;
    public String[] cryptoArray;
    public String[] currencyArray;
    public double getCurrency;
    public ProgressDialog progressDialog;



    ArrayList<ConversionClass> mListConversionClass;
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager mLinearLayoutManager;

    public final static String LIST_STATE_KEY = "recycler_list_state";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(LIST_STATE_KEY,mListConversionClass);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            mListConversionClass=savedInstanceState.getParcelableArrayList(LIST_STATE_KEY);
        }

        currencyArray = getResources().getStringArray(R.array.currency);
        cryptoArray = getResources().getStringArray(R.array.crypto);
        if(mListConversionClass==null){
            mListConversionClass = new ArrayList<>();

        }
        recyclerView = (RecyclerView) findViewById(R.id.recykler_view);
        recyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerAdapter = new RecyclerAdapter(this, mListConversionClass);
        recyclerView.setAdapter(recyclerAdapter);

        //Set up Spinners
        Spinner cryptoSpinner = (Spinner) findViewById(R.id.crypto);
        SpinnerAdapter mSpinnerAdapter = new SpinnerAdapter(this, cryptoArray);
        cryptoSpinner.setAdapter(mSpinnerAdapter);


        Spinner currencySpinner = (Spinner) findViewById(R.id.currency);
        SpinnerAdapter currencyAdapter = new SpinnerAdapter(this, currencyArray);
        currencySpinner.setAdapter(currencyAdapter);


        // Set On Item Selected Listener for both spinners.
        cryptoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 1) {
                    cryptoString = cryptoArray[position];
                } else {
                    cryptoString = "aa";
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        currencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 1) {
                    currencyString = currencyArray[position];
                } else {
                    currencyString = "aa";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        Button gobutton = (Button) findViewById(R.id.go_to);
        gobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cryptoString.equals(currencyString) || cryptoString.equals("aa") || currencyString.equals("aa")) {
                    Toast.makeText(MainActivity.this, "You must select valid options", Toast.LENGTH_LONG).show();

                } else {
                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("Please wait.... ");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    makeNetworkCall();

                }

            }


        });


    }

    public void makeNetworkCall() {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<CryptoPojo> call = apiService.getConversion(cryptoString, currencyString);
        call.enqueue(new Callback<CryptoPojo>() {

            @Override
            public void onResponse(Call<CryptoPojo> call, Response<CryptoPojo> response) {

                switch (currencyString) {
                    case "USD":
                        getCurrency = response.body().getUsDollars();
                        break;
                    case "NGR":
                        getCurrency = response.body().getNaira();
                        break;
                    case "GBP":
                        getCurrency = response.body().getPounds();
                        break;
                    case "EUR":
                        getCurrency = response.body().getEuros();
                        break;
                    case "ETH":
                        getCurrency = response.body().getEretheum();
                        break;
                    case "BTC":
                        getCurrency = response.body().getBitcoin();
                        break;
                    case "JPY":
                        getCurrency = response.body().getJapanYen();
                        break;
                    case "CAD":
                        getCurrency = response.body().getCanadaDolls();
                        break;
                    case "AUD":
                        getCurrency = response.body().getAustrlDolls();
                        break;
                    case "HKD":
                        getCurrency = response.body().getHkd();
                        break;
                    case "CHF":
                        getCurrency = response.body().getChf();
                        break;
                    case "KYD":
                        getCurrency = response.body().getKyd();
                        break;
                    case "GIP":
                        getCurrency = response.body().getGip();
                        break;
                    case "JOD":
                        getCurrency = response.body().getJod();
                        break;
                    case "OMR":
                        getCurrency = response.body().getOmr();
                        break;
                    case "KWD":
                        getCurrency = response.body().getKwd();
                        break;

                }


                progressDialog.dismiss();
                fillList();

            }

            @Override
            public void onFailure(Call<CryptoPojo> call, Throwable t) {

                progressDialog.dismiss();
                createDialog();
                Log.e("Failure", t.toString());


            }
        });
    }

    public void createDialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Sorry an error occurred: ");
        builder.setCancelable(false);
        builder.setPositiveButton("Refresh", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressDialog.setMessage("Please wait.... ");
                progressDialog.show();
                progressDialog.setCancelable(false);
                makeNetworkCall();
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog mAlertDialog1 = builder.create();
        mAlertDialog1.show();
    }


    public void fillList() {
        mListConversionClass.add(new ConversionClass( currencyString, cryptoString, getCurrency));
        recyclerAdapter.notifyDataSetChanged();
    }

}



