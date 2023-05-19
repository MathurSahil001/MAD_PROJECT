package com.nadjemni.bmicalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private LinearLayout containerL;
    private TextView bmiValueTV;
    private ImageView bmiFlagImgView;
    private TextView bmiLabelTV;
    private TextView commentTV;
    private ImageView advice1IMG;
    private TextView advice1TV;
    private ImageView advice2IMG;
    private TextView advice2TV;
    private ImageView advice3IMG;
    private TextView advice3TV;
    private Button skipResultBTN;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        containerL = findViewById(R.id.containerL);
        bmiValueTV = findViewById(R.id.bmiValueTV);
        bmiFlagImgView = findViewById(R.id.bmiFlagImgView);
        bmiLabelTV = findViewById(R.id.bmiLabelTV);
        commentTV = findViewById(R.id.commentTV);
        advice1IMG = findViewById(R.id.advice1IMG);
        advice1TV = findViewById(R.id.advice1TV);
        advice2IMG = findViewById(R.id.advice2IMG);
        advice2TV = findViewById(R.id.advice2TV);
        advice3IMG = findViewById(R.id.advice3IMG);
        advice3TV = findViewById(R.id.advice3TV);
        skipResultBTN = findViewById(R.id.skipResultBTN);

        skipResultBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });

        double bmi = getIntent().getDoubleExtra("bmi", -1.0);
        if (bmi == -1.0) {
            containerL.setVisibility(View.GONE);
        } else {
            bmiValueTV.setText(String.valueOf(bmi));
            if (bmi < 18.5) {
                containerL.setBackgroundResource(R.color.colorYellow);
                bmiFlagImgView.setImageResource(R.drawable.exclamationmark);
                bmiLabelTV.setText("You have an UnderWeight!");
                commentTV.setText("Here are some advices To help you increase your weight");
                advice1IMG.setImageResource(R.drawable.nowater);
                advice1TV.setText("Don't drink water before meals");
                advice2IMG.setImageResource(R.drawable.bigmeal);
                advice2TV.setText("Use bigger plates");
                advice3TV.setText("Get quality sleep");
            } else if (bmi > 25) {
                containerL.setBackgroundResource(R.color.colorRed);
                bmiFlagImgView.setImageResource(R.drawable.warning);
                bmiLabelTV.setText("You have an OverWeight!");
                commentTV.setText("Here are some advices To help you decrease your weight");
                advice1IMG.setImageResource(R.drawable.water);
                advice1TV.setText("Drink water a half hour before meals");
                advice2IMG.setImageResource(R.drawable.twoeggs);
                advice2TV.setText("Eat only two meals per day and make sure that they contain high protein");
                advice3IMG.setImageResource(R.drawable.nosugar);
                advice3TV.setText("Drink coffee or tea and avoid sugary food");
            }
        }
    }
}
