package com.example.alua.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aizhan.calculator.R;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button btOne, btTwo, btThree, btFour, btFive;
    Button btSix, btSeven, btEight, btNine, btZero;
    Button btPlus, btMinus, btDiv, btMult, btEqual, btClear;

    TextView textField;

    int operand1, operand2, flagAction;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            textField.setText(savedInstanceState.getString("str"));
            operand1 = savedInstanceState.getInt("firstOp");
            operand2 = savedInstanceState.getInt("secondOp");
            flagAction = savedInstanceState.getInt("operand");
        }
        else {
            operand1 = 0;
            operand2 = 0;
            result = 0;
            flagAction = 0;
            textField.setText(Integer.toString(operand1));
        }
        setContentView(R.layout.activity_main);

        btOne = (Button) findViewById(R.id.bnClickNumber1);
        btTwo = (Button) findViewById(R.id.bnClickNumber2);
        btThree = (Button) findViewById(R.id.bnClickNumber3);
        btFour = (Button) findViewById(R.id.bnClickNumber4);
        btFive = (Button) findViewById(R.id.bnClickNumber5);
        btSix = (Button) findViewById(R.id.bnClickNumber6);
        btSeven = (Button) findViewById(R.id.bnClickNumber7);
        btEight = (Button) findViewById(R.id.bnClickNumber8);
        btNine = (Button) findViewById(R.id.bnClickNumber9);
        btZero = (Button) findViewById(R.id.bnClickNumber0);

        btPlus = (Button) findViewById(R.id.bnClickAddition);
        btMinus = (Button) findViewById(R.id.bnClickSubstract);
        btMult = (Button) findViewById(R.id.bnClickMultiply);
        btDiv = (Button) findViewById(R.id.bnClickDivision);
        btEqual= (Button) findViewById(R.id.bnClickEqual);
        btClear = (Button) findViewById(R.id.bnClickClear);
        textField = (TextView) findViewById(R.id.txtFieldResults);

        btOne.setOnClickListener(this);
        btTwo.setOnClickListener(this);
        btThree.setOnClickListener(this);
        btFive.setOnClickListener(this);
        btFour.setOnClickListener(this);
        btSeven.setOnClickListener(this);
        btSix.setOnClickListener(this);
        btEight.setOnClickListener(this);
        btNine.setOnClickListener(this);
        btZero.setOnClickListener(this);
        btPlus.setOnClickListener(this);
        btMult.setOnClickListener(this);
        btMinus.setOnClickListener(this);
        btDiv.setOnClickListener(this);
        btClear.setOnClickListener(this);
        btEqual.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bnClickClear:
                operand1 = 0;
                operand2 = 0;
                result = 0;
                flagAction = 0;
                textField.setText(Integer.toString(operand1));
                break;
            case R.id.bnClickNumber1:
                ClickNumber(1);
                break;
            case R.id.bnClickNumber2:
                ClickNumber(2);
                break;
            case R.id.bnClickNumber3:
                ClickNumber(3);
                break;
            case R.id.bnClickNumber4:
                ClickNumber(4);
                break;
            case R.id.bnClickNumber5:
                ClickNumber(5);
                break;
            case R.id.bnClickNumber6:
                ClickNumber(6);
                break;
            case R.id.bnClickNumber7:
                ClickNumber(7);
                break;
            case R.id.bnClickNumber8:
                ClickNumber(8);
                break;
            case R.id.bnClickNumber9:
                ClickNumber(9);
                break;
            case R.id.bnClickNumber0:
                ClickNumber(0);
                break;
            case R.id.bnClickAddition:
                if(flagAction == 0) flagAction = 1;
                break;
            case R.id.bnClickSubstract:
                if(flagAction == 0) flagAction = 2;
                break;
            case R.id.bnClickMultiply:
                if(flagAction == 0) flagAction = 3;
                break;
            case R.id.bnClickDivision:
                if(flagAction == 0) flagAction = 4;
                break;

            case R.id.bnClickEqual:
                switch (flagAction){
                    case 1:
                        result = operand1 + operand2;
                        textField.setText(Double.toString(result));
                        operand1 = 0;
                        operand2 = 0;
                        result = 0;
                        flagAction = 0;
                        break;
                    case 2:
                        result = operand1 - operand2;
                        textField.setText(Double.toString(result));
                        operand1 = 0;
                        operand2 = 0;
                        result = 0;
                        flagAction = 0;
                        break;
                    case 3:
                        result = operand1 * operand2;
                        textField.setText(Double.toString(result));
                        operand1 = 0;
                        operand2 = 0;
                        result = 0;
                        flagAction = 0;
                        break;
                    case 4:
                        result = (double) operand1 / (double) operand2;
                        textField.setText(Double.toString(result));
                        operand1 = 0;
                        operand2 = 0;
                        result = 0;
                        flagAction = 0;
                        break;
                    default:
                        Toast.makeText(this, "Choose operation", Toast.LENGTH_LONG);

                }



        }

    }

    public void ClickNumber(int num){
        if(flagAction == 0){
            operand1 = operand1*10 + num;
            textField.setText(Integer.toString(operand1));
        }
        else{
            operand2 = operand2 * 10 + num;
            textField.setText(Integer.toString(operand2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("str", textField.getText().toString());
        outState.putString("firstOp", Integer.toString(operand1));
        outState.putString("secondOp", Integer.toString(operand2));
        outState.putString("operand", Integer.toString(flagAction));
        super.onSaveInstanceState(outState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        textField.setText(savedInstanceState.getString("str").toString());
        flagAction = savedInstanceState.getInt("operand");
        operand1 = savedInstanceState.getInt("firstOp");
        operand2 = savedInstanceState.getInt("secondOp");
    }

}
