package com.google.drive.anytimebunk;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textview1);
        textView2 = (TextView) findViewById(R.id.textview2);
        textView3 = (TextView) findViewById(R.id.textview3);
        textView4 = (TextView) findViewById(R.id.textview4);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button) {
            String h1 = editText1.getText().toString();
            String h2 = editText2.getText().toString();
            String h3 = editText3.getText().toString();
            textView4.setText("");
            if(!h1.isEmpty() && !h2.isEmpty() && !h3.isEmpty()) {
                float held = Integer.parseInt(h1);
                float present = Integer.parseInt(h2);
                float desired = Integer.parseInt(h3);
                if (held > 1000 || held < 1 || present > 1000 || present < 1 || desired > 100 || desired < 0 || held < present) {
                    textView.setText("-__- seriously?");
                } else {
                    float actual = present / held;
                    if (actual * 100 > desired) {
                        float a = ((present * 100) - (held * desired)) / desired;
                        textView.setText("you can bunk " + a + " classes ;)");
                        textView4.setText("your current attendance is " + actual * 100 + "%");
                    } else {
                        float a = ((desired * held) - (present * 100)) / (100 - desired);
                        textView.setText("you must attend " + a + " classes :(");
                        textView4.setText("your current attendance is " + actual * 100 + "%");
                    }
                }
            }
                else
                {
                    textView.setText("Bunk-O-Meter");
                    textView4.setText("Fill All Fields");
                }


        }
    }
}