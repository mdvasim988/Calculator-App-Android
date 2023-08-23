package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,ba,bs,bm,bd,bmod,bdot,bopen,bclose,bclear,bequal;
    ImageButton bback;
    EditText input;
    TextView resulttext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button) findViewById(R.id.bclear);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Clear All input")
                        .setMessage("Are you sure?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                input.setText("");
                                resulttext.setText("");
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"Selected option is No",Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog= builder.create();
                dialog.show();
            }
        });
        setVals();
    }
    public void setVals(){
        b1 = findViewById(R.id.b1);
        b2  = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        ba = findViewById(R.id.badd);
        bs = findViewById(R.id.bsub);
        bm = findViewById(R.id.bmul);
        bd = findViewById(R.id.bdiv);
        bmod = findViewById(R.id.bmod);
        bdot = findViewById(R.id.bdot);
        bopen = findViewById(R.id.bopen);
        bclose = findViewById(R.id.bclose);
        bback = findViewById(R.id.bback);
        input = findViewById(R.id.input);
        //bclear = findViewById(R.id.bclear);
        bequal = findViewById(R.id.bequal);

        resulttext = findViewById(R.id.resultText);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        ba.setOnClickListener(this);
        bs.setOnClickListener(this);
        bm.setOnClickListener(this);
        bd.setOnClickListener(this);
        bmod.setOnClickListener(this);
        bdot.setOnClickListener(this);
        bopen.setOnClickListener(this);
        bclose.setOnClickListener(this);
        //bclear.setOnClickListener(this);
        bback.setOnClickListener(this);;

        bequal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int pos=input.getText().toString().length();
        String str = "";
        String str2 ="";
        str = input.getText().toString();
        switch(view.getId()){
            case R.id.b1:
                str+=1;
                input.setText(str+str2);
                break;
            case R.id.b2:
                str+=2;
                input.setText(str+str2);
                break;
            case R.id.b3:
                str+=3;
                input.setText(str+str2);
                break;
            case R.id.b4:
                str+=4;
                input.setText(str+str2);
                break;
            case R.id.b5:
                str+=5;
                input.setText(str+str2);
                break;
            case R.id.b6:
                str+=6;
                input.setText(str+str2);
                break;
            case R.id.b7:
                str+=7;
                input.setText(str+str2);
                break;
            case R.id.b8:
                str+=8;
                input.setText(str+str2);
                break;
            case R.id.b9:
                str+=9;
                input.setText(str+str2);
                break;
            case R.id.b0:
                str+=0;
                input.setText(str+str2);
                break;
            case R.id.badd:
                str+='+';
                input.setText(str+str2);
                break;
            case R.id.bsub:
                str+='-';
                input.setText(str+str2);
                break;
            case R.id.bmul:
                str+='*';
                input.setText(str+str2);
                break;
            case R.id.bdiv:
                str+='/';
                input.setText(str+str2);
                break;
            case R.id.bmod:
                str+='%';
                input.setText(str+str2);
                break;
            case R.id.bdot:
                str+='.';
                input.setText(str+str2);
                break;
            case R.id.bopen:
                str+='(';
                input.setText(str+str2);
                break;
            case R.id.bclose:
                str+=')';
                input.setText(str+str2);
                break;
            case R.id.bback:
                String in = input.getText().toString();
                if(in.matches(""))
                {
                    Toast.makeText(this, "there is no input", Toast.LENGTH_SHORT).show();
                }
                else {
                    str = new String(str.toCharArray(), 0, str.length() - 1);
                    input.setText(str + str2);
                }
                break;
            case R.id.bequal:
                displayresult();
                break;

        }


    }

    public void displayresult(){
        try {
            String str = input.getText().toString();
            Infixevaluation infixevaluation = new Infixevaluation();
            double ans = infixevaluation.infix(str, str.length());
            if (ans == Math.round(ans)) {
                resulttext.setText((int)ans + "");
            } else {
                resulttext.setText(ans + "");
            }
            input.clearFocus();
        }catch(EmptyStackException e){
            Toast.makeText(getApplicationContext(),"Please Check Expression..!",Toast.LENGTH_SHORT).show();

        }

    }
}
