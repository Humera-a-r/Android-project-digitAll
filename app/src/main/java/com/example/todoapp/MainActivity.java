package com.example.todoapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    EditText input;
    Spinner unit;
    TextView km,m,cm,mm,microm,nm,mile,yard,foot,inch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        cm = findViewById(R.id.cm);
        mm =findViewById(R.id.mm);
        microm = findViewById(R.id.microm);
        nm = findViewById(R.id.nm);
        mile = findViewById(R.id.mile);
        yard = findViewById(R.id.yard);
        foot = findViewById(R.id.foot);
        inch = findViewById(R.id.inch);

        String[] arr = {"km", "m", "cm", "mm", "microm", "nm", "mile", "yard", "foot", "inch"};
        unit.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arr));

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
                unit.setSelection(i); // Add this line
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                   update();

            }
        });

    }
    private void update(){
        if(!input.getText().toString().equals("")&&!unit.getSelectedItem().toString().equals("")){
            double in =Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()){
                case "km":
                    setkm(in);
                    break;
                case "m":
                    setkm(in/1000);
                    break;
                case "cm":
                    setkm(in/100000);
                    break;
                case "mm":
                    setkm(in/1000000);
                    break;
                case "microm":
                    setkm(in/1000000000);
                    break;
                case "nm":
                    double d=1000000*1000000;
                    setkm(in/d);
                    break;
                case "mile":
                    setkm(in*1.609);
                    break;
                case "yard":
                    setkm(in/1094);
                    break;
                case "foot":
                    setkm(in/3281);
                    break;
                case "inch":
                    setkm(in/39370);
                    break;

            }
        }
    }

    private void setkm(double km_in) {
        if (km != null) km.setText(String.valueOf(km_in));
        if (m != null) m.setText(String.valueOf(km_in * 10000));
        if (cm != null) cm.setText(String.valueOf(km_in * 100000));
        if (mm != null) mm.setText(String.valueOf(km_in*1000000));
        if (microm!= null) microm.setText(String.valueOf(km_in * 1000000000));
        if (nm != null) nm.setText(String.valueOf(km_in * 1000000*1000000));
        if (mile != null) mile.setText(String.valueOf(km_in/1.609));
        if (yard!= null) yard.setText(String.valueOf(km_in * 1094));
        if (foot != null) foot.setText(String.valueOf(km_in * 3281));
        if (inch != null) inch.setText(String.valueOf(km_in * 39370));



    }
}

