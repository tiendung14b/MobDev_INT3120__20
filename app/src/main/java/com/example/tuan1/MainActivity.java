package com.example.tuan1;

import static android.util.Log.println;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ProgressBar progressBar = findViewById(R.id.progressBar);
        NumberPicker numberPicker = findViewById(R.id.numberpicker);
        if (numberPicker != null) {
            numberPicker.setMinValue(1);
            numberPicker.setMaxValue(1000);
            numberPicker.setWrapSelectorWheel(true);
            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    progressBar.setProgress(newVal * 100 / numberPicker.getMaxValue(), true);
                }
            });
        }

//        for donation button
        final int[] donate_amount = {0};
        Button button = findViewById(R.id.donate__button);
        TextView donation_total = findViewById(R.id.donation__total);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Neu duoc mong thay cho em co hoi go 4 diem a :(", Toast.LENGTH_SHORT).show();
                donate_amount[0] += numberPicker.getValue();
                donation_total.setText("Total: $" + String.format(String.valueOf(donate_amount[0])));
            }
        });
    }
}