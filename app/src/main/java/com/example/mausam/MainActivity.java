package com.example.mausam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity /*implements AdapterView.OnItemSelectedListener*/ {
    Spinner spinner1, spinner2;
    String city,state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1=findViewById(R.id.states);
        spinner2=findViewById(R.id.city);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                state = parent.getItemAtPosition(position).toString();

                if(spinner1.getItemAtPosition(position).equals("Andhra Pradesh")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Andhra_Pradesh)));
           }
        else if(spinner1.getItemAtPosition(position).equals("Bihar")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Bihar)));
        }
           else if(spinner1.getItemAtPosition(position).equals("Delhi")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Delhi)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Gujarat")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Gujarat)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Haryana")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Haryana)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Jharkhand")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Jharkhand)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Karnataka")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Karnataka)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Kerala")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Kerala)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Madhya Pradesh")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Madhya_Pradesh)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Maharashtra")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Maharashtra)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Odisha")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Odisha)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Punjab")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Punjab)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Rajasthan")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Rajasthan)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Tamil Nadu")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Tamil_Nadu)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Telangana")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Telangana)));
           }
           else if(spinner1.getItemAtPosition(position).equals("Uttar Pradesh")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.Uttar_Pradesh)));
           }
           else if(spinner1.getItemAtPosition(position).equals("West Bengal")){
                    spinner2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(R.array.West_Bengal)));
           }
                spinner2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                city = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }

        });

    }

    public void findTemp(View view) {
        Intent intent=new Intent(MainActivity.this,Wheather.class);
        intent.putExtra("state",state);
        intent.putExtra("city",city);
        startActivity(intent);
    }
}