package com.app.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextInputEditText inputEditText;
    TextInputLayout textInputLayout;
    Slider slider;
    public static final String Extra="com.app.tipper.tipValue";
    public static final String Extra2="com.app.tipper.tipAmount";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       inputEditText=findViewById(R.id.edittext);
       button=findViewById(R.id.button);
        slider=findViewById(R.id.slider);
       button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "working", Toast.LENGTH_SHORT).show();
        String amount=inputEditText.getText().toString();
        float tipPercent=slider.getValue();

        Intent intent=new Intent(this,resultScreen.class);
        int totalBill=Integer.parseInt(amount);
         float tip= (float) (totalBill*(tipPercent/100)*1.0);
         String finalTip=Float.toString(tip);
         intent.putExtra(Extra,finalTip);
         intent.putExtra(Extra2,amount);
        startActivity(intent);
    }
}