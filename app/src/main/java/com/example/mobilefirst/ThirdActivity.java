package com.example.mobilefirst;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    ImageButton ib1;
    TextView tv1;
    TextView tv3;
    TextView tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_login);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        ib1=(ImageButton) findViewById(R.id.ib1);
        tv1=(TextView)findViewById(R.id.tv1);
        tv3=(TextView) findViewById(R.id.tv3);
        tv4=(TextView) findViewById(R.id.tv4);

        ib1.setOnClickListener(onClickListener);
        et1.addTextChangedListener(textWatcher);
        et2.addTextChangedListener(textWatcher);


    }
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!et1.getText().toString().equals("") && !et2.getText().toString().equals("")) {
                tv3.setVisibility(View.INVISIBLE);
                tv4.setVisibility(View.INVISIBLE);
            }

        }
    };


    ImageButton.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int a = Integer.parseInt(et1.getText().toString()+"");
            int b = Integer.parseInt(et2.getText().toString()+"");
            int cnt=0;
            int div=b/a;
            int change2=div%100;
            int num=div-change2;
            int num1=b-((a-1)*num);
            if(num>+0) {
                tv3.setText((a-1)+"명 :"+num + "원씩");
                tv4.setText("1명 : " + num1+"원");
                tv3.setVisibility(View.VISIBLE);
                tv4.setVisibility(View.VISIBLE);

            }
        }
    };


}
