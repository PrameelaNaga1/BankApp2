package com.example.mlrit.bankapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    TextView td1;
    EditText ed2;
    Button bb2;
    Button bb3;
    Button bb4;
    Button bb5;
    Button bb6;
    int Balance=1000000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.e1);
        ed2=(EditText)findViewById(R.id.e2);
        bb2=(Button)findViewById(R.id.b2);
        bb3=(Button)findViewById(R.id.b3);
        bb4=(Button)findViewById(R.id.b4);
        bb5=(Button)findViewById(R.id.b5);
        bb6=(Button)findViewById(R.id.b6);
        td1=(TextView)findViewById(R.id.t1);
        ed2.setVisibility(View.INVISIBLE);
        bb3.setVisibility(View.INVISIBLE);
        bb4.setVisibility(View.INVISIBLE);
        bb5.setVisibility(View.INVISIBLE);
        bb6.setVisibility(View.INVISIBLE);
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pin= ed1.getText().toString();
                ed1.setText("");
                if(pin.isEmpty()){
                    ed1.setError("EMPTY");
                }
                else
                {
                    int pin1=Integer.parseInt(pin);
                    if(pin1==3456){
                        bb2.setVisibility(View.INVISIBLE);
                        ed1.setVisibility(View.INVISIBLE);
                        bb3.setVisibility(View.VISIBLE);
                        bb4.setVisibility(View.VISIBLE);
                        bb5.setVisibility(View.VISIBLE);
                        bb6.setVisibility(View.VISIBLE);
                        ed2.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        bb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bb2.setVisibility(View.VISIBLE);
                ed1.setVisibility(View.VISIBLE);
                ed2.setVisibility(View.INVISIBLE);
                bb3.setVisibility(View.INVISIBLE);
                bb4.setVisibility(View.INVISIBLE);
                bb5.setVisibility(View.INVISIBLE);
                bb6.setVisibility(View.INVISIBLE);
            }
        });

        bb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1= ed2.getText().toString();
                 if (s1.isEmpty()){
                    ed2.setError("empty");

                }
                else {
                    int amount= (int) Long.parseLong(s1);
                    Balance=Balance+amount;
                    td1.setText(""+Balance);
                                         //SmsManager sms=SmsManager.getDefault();
                    //sms.sendTextMessage("9490369886",null,"you have deposited:",+Balance);


                }
            }
        });
        bb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String s1=ed2.getText().toString();
                int amount= (int) Long.parseLong(s1);
                if(amount>Balance){
                    td1.setText("Balance not available");
                }
                else if(amount%100==0){
                    Balance=Balance-amount;
                    td1.setText(""+Balance);
                    //SmsManager sms=SmsManager.getDefault();
                   // sms.sendTextMessage("9490369886",null,"you have withdrawn:",+Balance);


                }
                else {
                    ed2.setText("Invalid entry");
                }
            }
        });
        bb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                             td1.setText(""+Balance);
            }
        });

    }
}
