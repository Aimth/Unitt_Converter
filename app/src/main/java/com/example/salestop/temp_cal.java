package com.example.salestop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;

public class temp_cal extends AppCompatActivity {

    CardView cv_fromUnit, cv_toUnit, cv_convert;
    RelativeLayout mCLayout;
    String fromUnit = "Celcius";
    String toUnit = "Fahrenheit";
    TextView tv_fromUnit, tv_toUnit;
    EditText et_fromUnit, et_toUnit;

    String[] values = new String[]{"celcius","Fahrenheit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_cal);

        cv_fromUnit = findViewById(R.id.fromUnit);
        cv_toUnit = findViewById(R.id.toUnit);
        cv_convert = findViewById(R.id.cv_convert);

        mCLayout = findViewById(R.id.temp_relativeLayout);

        tv_fromUnit = findViewById(R.id.tv_fromUnit);
        tv_toUnit = findViewById(R.id.tv_toUnit);

        tv_fromUnit.setText(values[0]);
        tv_toUnit.setText(values[1]);

        et_fromUnit = findViewById(R.id.et_fromUnit);
        et_toUnit = findViewById(R.id.et_toUnit);

        cv_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempInput = et_fromUnit.getText().toString();
                if (tempInput.equals(" ") || tempInput == null) {
                    et_fromUnit.setError("Please enter some value");
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(celciusToFahrenheit(Double.parseDouble(tempInput)));
                        }
                    } else {
                        if (tv_fromUnit.getText().toString().equals(values[1])) {
                            if (tv_toUnit.getText().toString().equals(values[0])) {
                                et_toUnit.setText(fahrenheitToCelcius(Double.parseDouble(tempInput)));
                            } else if (tv_toUnit.getText().toString().equals(values[1])) {
                                et_toUnit.setText(tempInput);
                            }
                        }
                    }
                }

            }
        });

        cv_toUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(temp_cal.this);
                builder.setTitle("choose Unit");

                String[] flowers= new String[]{"celcius","Fahrenheit"};

                builder.setSingleChoiceItems(flowers, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialoginterface, int i) {
                        String selectedItem= Arrays.asList(flowers).get(i);
                        toUnit=selectedItem;
                        tv_toUnit.setText(toUnit);
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        cv_fromUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(temp_cal.this);
                builder.setTitle("choose Unit");

                String[] flowers= new String[]{"celcius","Fahrenheit"};

                builder.setSingleChoiceItems(flowers, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialoginterface, int i) {
                        String selectedItem= Arrays.asList(flowers).get(i);
                        fromUnit=selectedItem;
                        tv_fromUnit.setText (fromUnit);
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
    private String celciusToFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        return String.valueOf(fahrenheit);
    }

    private String fahrenheitToCelcius(double fahrenheit) {
        double celcius = (fahrenheit - 32) * 5 / 9;
        return String.valueOf(celcius);
    }
}