package com.example.mausam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Wheather extends AppCompatActivity {
String state,city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheather);

        Intent intent=getIntent();
        state=intent.getStringExtra("state");
        city=intent.getStringExtra("city");
        //Toast.makeText(Wheather.this,state+"--"+city,Toast.LENGTH_LONG).show();
        TextView head=(TextView)findViewById(R.id.head);
        head.setText(city+", "+state);

        //API CALL
        String url="http://api.airvisual.com/v2/city?city="+city+"&state="+state+"&country=India&key=1a2e9c99-4486-4fb2-8d3b-43b3717fe1bc";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONObject jsonObject=response.getJSONObject("data");

                                    JSONObject current=jsonObject.getJSONObject("current");
                                    JSONObject weather=current.getJSONObject("weather");
                                    int temp=weather.optInt("tp");
                                    int humidity=weather.optInt("hu");
                                    double ws=weather.optInt("ws");
                                    String symbolCode=weather.optString("ic");
                                    int atm=weather.optInt("pr");
                                    TextView tempVal=(TextView)findViewById(R.id.tempValue);
                                    TextView atVal=(TextView)findViewById(R.id.atmValue);
                                    TextView humiVal=(TextView)findViewById(R.id.humiPre);
                                    TextView wispeed=(TextView)findViewById(R.id.windValue);
                                    ImageView symbol=(ImageView)findViewById(R.id.symbol);
                                    tempVal.setText(temp+"\u2103");
                                    atVal.setText(atm+"hPa");
                                    humiVal.setText(humidity+"%");
                                    wispeed.setText(ws+"m/s");

                                    if(symbolCode.equals("01d")){
                                    symbol.setImageResource(R.drawable.d01);
                                    }
                                    else if(symbolCode.equals("01n")){
                                        symbol.setImageResource(R.drawable.n01);
                                    }
                                    else if(symbolCode.equals("02d")){
                                        symbol.setImageResource(R.drawable.d02);
                                    }
                                    else if(symbolCode.equals("02n")){
                                        symbol.setImageResource(R.drawable.n02);
                                    }
                                    else if(symbolCode.equals("03d")){
                                        symbol.setImageResource(R.drawable.d03);
                                    }
                                    else if(symbolCode.equals("04d")){
                                        symbol.setImageResource(R.drawable.d04);
                                    }
                                    else if(symbolCode.equals("09d")){
                                        symbol.setImageResource(R.drawable.d09);
                                    }
                                    else if(symbolCode.equals("10d")){
                                        symbol.setImageResource(R.drawable.d10);
                                    }
                                    else if(symbolCode.equals("10n")){
                                        symbol.setImageResource(R.drawable.n10);
                                    }
                                    else if(symbolCode.equals("11d")){
                                        symbol.setImageResource(R.drawable.d11);
                                    }
                                    else if(symbolCode.equals("13d")){
                                        symbol.setImageResource(R.drawable.d13);
                                    }
                                    else if(symbolCode.equals("50d")){
                                        symbol.setImageResource(R.drawable.d50);
                                    }
                                    else if(symbolCode.equals("50n")){
                                        symbol.setImageResource(R.drawable.n50);
                                    }
                                    else if(symbolCode.equals("04n")){
                                        symbol.setImageResource(R.drawable.d04);
                                    }
                                    else if(symbolCode.equals("03n")){
                                        symbol.setImageResource(R.drawable.d03);
                                    }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Wheather.this,"Something is wrong" , Toast.LENGTH_LONG).show();

                    }
                });
        // Add the request to the RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}