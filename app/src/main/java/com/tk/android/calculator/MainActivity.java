package com.tk.android.calculator;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static char ADDITION = '+';
    private static char SUBTRACTION = '-';
    private static char MULTIPLICATION = '*';
    private static char DIVISION = '/';
    private char currentAction = 0;
    private int currCtr = -1;
    private int operator = 0;
    private double value1 = Double.NaN;
    private double value2;
    private boolean isEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isEqual = false;
        Button button0 = (Button)findViewById(R.id.buttonZero);
        Button button1 = (Button)findViewById(R.id.buttonOne);
        Button button2 = (Button)findViewById(R.id.buttonTwo);
        Button button3 = (Button)findViewById(R.id.buttonThree);
        Button button4 = (Button)findViewById(R.id.buttonFour);
        Button button5 = (Button)findViewById(R.id.buttonFive);
        Button button6 = (Button)findViewById(R.id.buttonSix);
        Button button7 = (Button)findViewById(R.id.buttonSeven);
        Button button8 = (Button)findViewById(R.id.buttonEight);
        Button button9 = (Button)findViewById(R.id.buttonNine);

        Button buttonMultiply = (Button)findViewById(R.id.buttonMultiply);
        Button buttonDivide = (Button)findViewById(R.id.buttonDivide);
        Button buttonAdd = (Button)findViewById(R.id.buttonAdd);
        Button buttonSubtract = (Button)findViewById(R.id.buttonSubtract);

        Button buttonDot = (Button)findViewById(R.id.buttonDot);
        Button buttonEqual = (Button)findViewById(R.id.buttonEqual);
        Button buttonClear = (Button)findViewById(R.id.buttonClear);

        final TextView answerView = (TextView) findViewById(R.id.answerView);
        final EditText editT = (EditText) findViewById(R.id.editText);

        button0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + "0");
                currCtr++;
            }
        });
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + "1");
                currCtr++;
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + "2");
                currCtr++;
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + "3");
                currCtr++;
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + "4");
                currCtr++;
            }
        });
        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + "5");
                currCtr++;
            }
        });
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + "6");
                currCtr++;
            }
        });
        button7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + "7");
                currCtr++;
            }
        });
        button8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + "8");
                currCtr++;
            }
        });
        button9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + "9");
                currCtr++;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editT.setText(editT.getText() + ".");
                currCtr++;
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getCalculation(editT,answerView);
                currentAction = MULTIPLICATION;
                currCtr++;
                operator = currCtr;
                editT.setText(editT.getText() + "*");
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getCalculation(editT,answerView);
                currentAction = DIVISION;
                currCtr++;
                operator = currCtr;
                editT.setText(editT.getText() + "/");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getCalculation(editT,answerView);
                currentAction = ADDITION;
                currCtr++;
                operator = currCtr;
                editT.setText(editT.getText() + "+");
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getCalculation(editT,answerView);
                currentAction = SUBTRACTION;
                currCtr++;
                operator = currCtr;
                editT.setText(editT.getText() + "-");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                isEqual = true;
                getCalculation(editT,answerView);

            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                operator = 0;
                currCtr = -1;
                value1 = Double.NaN;
                value2 = 0;
                answerView.setText(null);
                editT.setText(null);
            }
        });
    }
    private void getCalculation(EditText editT, TextView answerView){
        if(!Double.isNaN(value1)){
            String answer = editT.getText().toString();
            value2 = stringToDouble(answer.substring(operator + 1, currCtr+1));
            if(Double.isNaN(value2) || Double.isNaN(value1)){
                answerView.setText("ERROR");
                value1 = Double.NaN;
                operator = 0;
                currCtr = -1;
                return;
            }
            if(currentAction == ADDITION){
                value1 = value1 + value2;
            }
            else if(currentAction == SUBTRACTION){
                value1 = value1 - value2;
            }
            else if(currentAction == MULTIPLICATION){
                value1 = value1*value2;
            }
            else if(currentAction == DIVISION){
                value1 = value1/value2;
            }
            if(isEqual){
                answerView.setText(Double.toString(value1));
                editT.setText(null);
                value1 = Double.NaN;
                operator = 0;
                currCtr = -1;
                currentAction = 0;
                isEqual = false;
            }
        }else{
            value1 = stringToDouble(editT.getText().toString());
        }
    }

    private double stringToDouble(String val){
        String value;
        try{
            return Double.parseDouble(val);
        }catch (Exception e){
            return Double.NaN;
        }

    }

}
