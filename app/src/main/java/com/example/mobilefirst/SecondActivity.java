package com.example.mobilefirst;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    EditText et3;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);

        et3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = et2.getText().toString();
                String check=et3.getText().toString();
                if(password.equals(check)){
                    et2.setBackgroundColor(Color.GREEN);
                    et3.setBackgroundColor(Color.GREEN);
                }
                else{
                    et2.setBackgroundColor(Color.RED);
                    et3.setBackgroundColor(Color.RED);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이메일 입력 확인
                if( et1.getText().toString().length() == 0 ) {
                    Toast.makeText(SecondActivity.this, "Email을 입력하세요!", Toast.LENGTH_SHORT).show();
                    et1.requestFocus();
                    return;
                }

                // 비밀번호 입력 확인
                if( et2.getText().toString().length() == 0 ) {
                    Toast.makeText(SecondActivity.this, "비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    et2.requestFocus();
                    return;
                }

                // 비밀번호 확인 입력 확인
                if( et3.getText().toString().length() == 0 ) {
                    Toast.makeText(SecondActivity.this, "비밀번호 확인을 입력하세요!", Toast.LENGTH_SHORT).show();
                    et3.requestFocus();
                    return;
                }

                // 비밀번호 일치 확인
                if( !et2.getText().toString().equals(et3.getText().toString()) ) {
                    Toast.makeText(SecondActivity.this, "비밀번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();
                    et2.setText("");
                    et3.setText("");
                    et2.requestFocus();
                    return;
                }

                Intent result = new Intent();
                result.putExtra("email", et1.getText().toString());

                // 자신을 호출한 Activity로 데이터를 보낸다.
                setResult(RESULT_OK, result);
                finish();
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
