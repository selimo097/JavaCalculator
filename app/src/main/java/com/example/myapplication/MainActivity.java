package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public float result;//return a result for operations
    public float firstValue;//entering the first value
    String operation;
    int operationContinue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnC=(Button) findViewById(R.id.buttonC);
        final Button btnDiv=(Button) findViewById(R.id.buttonDiv);
        final Button btnMult=(Button) findViewById(R.id.buttonMult);
        final Button btnSum=(Button) findViewById(R.id.buttonSum);
        final Button btnSub=(Button) findViewById(R.id.buttonSub);
        final Button btnPlusMinus=(Button) findViewById(R.id.buttonPlusMinus);
        final Button btnEqual=(Button) findViewById(R.id.buttonEqual);
        final Button btnBack=(Button) findViewById(R.id.buttonBack);
        final TextView txtScreen=(TextView) findViewById(R.id.textscreen);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtScreen.setText("0");
                result = 0;
                operationContinue=0;
            }
        });
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstValue>=0){
                    EqualAction();
                }
                else{
                    firstValue=Float.valueOf(ReadScreen());
                    operation="Sum";
                    operationContinue=1;
                }

            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstValue>=0){
                    EqualAction();
                }
                else{
                    firstValue=Float.valueOf(ReadScreen());
                    operation="Sub";
                    operationContinue=1;
                }

            }
        });

    }
    public void NumberClick(View commonButton){
        TextView TextScreen=(TextView) findViewById(R.id.textscreen);
        Button btnCommon=(Button) commonButton;
        txtScreen.setText(ReadScreen()+btnCommon.getText().toString());

    }



    public void EqualAction(){
        TextView txtScreen= (TextView) findViewById(R.id.textscreen);
        try {
            float secondValue = Float.parseFloat(ReadScreen());
            if (operation.equals("Sum")){
                result = firstValue + secondValue;

            }
            else if(operation.equals("Sub")){
                result = firstValue - secondValue;
            }
            else if(operation.equals("Mult")){
                result = firstValue * secondValue;
            }
            else if(operation.equals("Div")){
                result = firstValue / secondValue;
            }
            txtScreen.setText(String.valueOf(result).toString());
            operationContinue = 1;//because use result for first value
            firstValue= (float) result;

        }
        catch (Exception err){
            Log.e("Calculator",err.getMessage().toString());

        }
    }
    public String ReadScreen(){
        TextView  txtScreen=(TextView) findViewById(R.id.textscreen);
        String screenNumber=txtScreen.getText().toString();
        if (screenNumber.equals("0")){
            return "";

        }
        if (operationContinue==1){
            screenNumber="";
            operationContinue=0;

        }
        return screenNumber;
    }


}
