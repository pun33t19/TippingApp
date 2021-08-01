package com.app.tipper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.slider.Slider;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

class emptyTextError extends Exception{
    @Nullable
    @Override
    public String getMessage() {
        return "Enter a value";
    }


}


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

        String amount=inputEditText.getText().toString();
        float tipPercent=slider.getValue();
       isEmpty(amount,tipPercent);

    }

    public void nextScreen(String amount,float tipPercent){
        Intent intent=new Intent(this,resultScreen.class);
        int totalBill=Integer.parseInt(amount);
        float tip= (float) (totalBill*(tipPercent/100)*1.0);
        String finalTip=Float.toString(tip);
        intent.putExtra(Extra,finalTip);
        intent.putExtra(Extra2,amount);
        startActivity(intent);
    }
    public void isEmpty(String text,float tipPercent){
        if(text.isEmpty()){
            try {
                throw new emptyTextError();
            }
            catch(Exception e){
                Snackbar.make(inputEditText,e.getMessage(),Snackbar.LENGTH_SHORT)
                        .setBackgroundTint(getResources().getColor(R.color.backgroundTint))
                        .setTextColor(getResources().getColor(R.color.TextColor))
                        .show();
            }
        }
        else
            nextScreen(text,tipPercent);
    }



}