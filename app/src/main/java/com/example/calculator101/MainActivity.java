package com.example.calculator101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnplus,btnsubstract,btnmultiply,btndivide,btnequals,btnclear;
private TextView txtResult;
Integer firstInput=0,secondInput=0;
boolean isAdd,isSub,isMultiply,isDivide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn_0);
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        btn5=findViewById(R.id.btn_5);
        btn6=findViewById(R.id.btn_6);
        btn7=findViewById(R.id.btn_7);
        btn8=findViewById(R.id.btn_8);
        btn9=findViewById(R.id.btn_9);
        btnplus=findViewById(R.id.btn_plus);
        btnsubstract=findViewById(R.id.btn_minus);
        btnmultiply=findViewById(R.id.btn_multiply);
        btndivide=findViewById(R.id.btn_div);
        btnequals=findViewById(R.id.btn_equal);
        btnclear=findViewById(R.id.btn_clear);
       txtResult=findViewById(R.id.text_result);

       btnplus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(txtResult.getText().toString().length()!=0){
                   firstInput=Integer.valueOf(txtResult.getText().toString());
                   isAdd=true;
                   txtResult.setText(null);
               }
           }
       });
        btnsubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtResult.getText().toString().length()!=0){
                    firstInput=Integer.valueOf(txtResult.getText().toString());
                    isSub=true;
                    txtResult.setText(null);
                }
            }
        });
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtResult.getText().toString().length()!=0){
                    firstInput=Integer.valueOf(txtResult.getText().toString());
                    isMultiply=true;
                    txtResult.setText(null);
                }
            }
        });
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtResult.getText().toString().length()!=0){
                    firstInput=Integer.valueOf(txtResult.getText().toString());
                    isDivide=true;
                    txtResult.setText(null);
                }
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstInput=0;
                secondInput=0;
                txtResult.setText("");
            }
        });
        btnequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAdd||isSub||isMultiply||isDivide){
                    secondInput=Integer.valueOf(txtResult.getText().toString());
                }
                if(isAdd){
                    txtResult.setText(firstInput+secondInput+"");
                    isAdd=false;
                }
                if(isSub){
                    txtResult.setText(firstInput-secondInput+"");
                    isSub=false;
                }
                if(isMultiply){
                    txtResult.setText(firstInput*secondInput+"");
                    isMultiply=false;
                }
                if(isDivide){
                    double resultvalue=firstInput/secondInput;
                    txtResult.setText(String.format("%.2f",resultvalue));
                    isDivide=false;
                }
            }
        });
    }

    public void numberOperation(View view) {
        Button button= (Button) view;
        txtResult.setText(txtResult.getText().toString()+button.getText().toString());
    }
}