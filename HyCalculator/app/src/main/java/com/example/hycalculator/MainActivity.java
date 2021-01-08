package com.example.hycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnDot,btnEqual,btnAdd,btnSub,btnMultiple,btnDivision,btnModule,btnBracket,btnClear;
    TextView DisInput,DisOutput;
    boolean checkBracket=false;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnMultiple=findViewById(R.id.btnMultiple);
        btnDivision=findViewById(R.id.btnDivision);

        btnEqual=findViewById(R.id.btnEqual);
        btnBracket=findViewById(R.id.btnBracket);
        btnClear=findViewById(R.id.btnClear);
        btnDot= findViewById(R.id.btnDot);
        btnModule=findViewById(R.id.btnModule);

        DisInput=findViewById(R.id.DisInput);
        DisOutput=findViewById(R.id.DisOutput);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisInput.setText("");
                DisOutput.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"-");
            }
        });

        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"×");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"÷");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                process = process.replaceAll("×","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll("÷","/");

                Context rhino=Context.enter();

                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();

                }catch (Exception e){
                    finalResult="0";


                }
                DisOutput.setText(finalResult);
            }
        });

        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBracket){
                    process=DisInput.getText().toString();
                    DisInput.setText(process+ ")");
                    checkBracket=false;
                }else{
                    process=DisInput.getText().toString();
                    DisInput.setText(process+ "(");
                    checkBracket=true;
                }
            }
        });

        btnModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+"%");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process=DisInput.getText().toString();
                DisInput.setText(process+".");
            }
        });

    }
}