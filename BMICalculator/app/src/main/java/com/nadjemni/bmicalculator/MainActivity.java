package com.nadjemni.bmicalculator;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private EditText weightEDTX;
    private EditText heightEDTX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEDTX = findViewById(R.id.weightEditText);
        heightEDTX = findViewById(R.id.heightEditText);

        Button calculateBtn = findViewById(R.id.calculateBtn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightString = weightEDTX.getText().toString();
                String heightString = heightEDTX.getText().toString();

                if (!weightString.isEmpty() && !heightString.isEmpty()) {
                    double weight = Double.parseDouble(weightString);
                    double height = Double.parseDouble(heightString) / 100;

                    if (weight > 0 && weight < 600 && height >= 0.50 && height < 2.50) {
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("bmi", calculateBMI(weight, height));
                        startActivity(intent);
                    } else {
                        showErrorSnack("Incorrect Values");
                    }
                } else {
                    showErrorSnack("A field is missing");
                }
            }
        });
    }

    private void showErrorSnack(String errorMsg) {
        View container = findViewById(R.id.container);
        Snackbar snackbar = Snackbar.make(container, "Error: " + errorMsg + "!", Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundResource(R.color.colorRed);
        snackbar.show();
    }

    private double calculateBMI(double weight, double height) {
        BigDecimal result = BigDecimal.valueOf(weight / (height * height));
        result = result.setScale(2, RoundingMode.HALF_EVEN);
        return result.doubleValue();
    }
}
