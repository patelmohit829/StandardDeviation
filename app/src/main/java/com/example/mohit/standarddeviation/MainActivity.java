package com.example.mohit.standarddeviation;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int i = 0,l,a=3;
    Double n = 0.0,p = 0.0,m, number,mean,sd, Variance;
    Double[] ar = new Double[100];

    public void mean(View view) {
        p = 0.0;
        final EditText textField = (EditText) findViewById(R.id.textField);
        final TextView answer = (TextView) findViewById(R.id.answer);
        final TextView myTextView = (TextView) findViewById(R.id.myTextView);
        final TextView meanText = (TextView) findViewById(R.id.meanText);
        final TextView varianceText = (TextView) findViewById(R.id.varianceText);
        final TextView sdText = (TextView) findViewById(R.id.sdText);


        if(TextUtils.isEmpty(textField.getText().toString())||textField.getText().toString().equals("-")||textField.getText().toString().equals("."))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter Number", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        } else {
            number = Double.parseDouble(textField.getText().toString());
            mean = (number + n) / (i + 1);
            n = number + n;

            ar[i] = number;
            for (l = 0; l <= i; l++) {

                m = (ar[l] - mean) * (ar[l] - mean);
                p = p + m;


            }
            sd = Math.sqrt(p / (i + 1));
            myTextView.append(number.toString()+"\n");
            i++;
        }
        textField.setText("");

        if(a==3){
            sdText.setTextColor(Color.parseColor("#ffffff"));
            answer.setText(sd.toString());
        }else if(a==1){
            answer.setText(mean.toString());
        }else if(a==2){
            Variance = sd*sd;
            answer.setText(Variance.toString());
        }

        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                answer.setText("0");
                sd = 0.0;
                textField.setText("");
                myTextView.setText("");
                mean = 0.0;number=0.0;n=0.0;p=0.0;m=0.0;i=0;

            }
        });
        meanText.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                answer.setText(mean.toString());
                meanText.setTextColor(Color.parseColor("#ffffff"));
                varianceText.setTextColor(Color.parseColor("#a1e9bb"));
                sdText.setTextColor(Color.parseColor("#a1e9bb"));
                a=1;

            }
        });
        varianceText.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                Variance = sd*sd;
                answer.setText(Variance.toString());
                varianceText.setTextColor(Color.parseColor("#ffffff"));
                sdText.setTextColor(Color.parseColor("#a1e9bb"));
                meanText.setTextColor(Color.parseColor("#a1e9bb"));
                a=2;

            }
        });
        sdText.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                answer.setText(sd.toString());
                sdText.setTextColor(Color.parseColor("#ffffff"));
                meanText.setTextColor(Color.parseColor("#a1e9bb"));
                varianceText.setTextColor(Color.parseColor("#a1e9bb"));
                a=3;


            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_front_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
