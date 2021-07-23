package com.app.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class resultScreen extends AppCompatActivity {
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.TextView2);

        Intent intent=getIntent();

        String finaltip=intent.getStringExtra(MainActivity.Extra);
        String finalBill=intent.getStringExtra(MainActivity.Extra2);

        DecimalFormat df=new DecimalFormat("##,###.##");
       float finalvalue=Float.parseFloat(finaltip);
       int finalamount=Integer.parseInt(finalBill);


        textView2.setText("The Final bill amount is:\n"+df.format(finalamount)+" ₹");
        textView1.setText("The final tip provided is:\n"+df.format(finalvalue)+" ₹");
    }


}