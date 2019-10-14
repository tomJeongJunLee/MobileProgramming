package com.example.mobilefirst;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    EditText et6;
    TextView text1;
    RadioButton rb1;
    RadioButton rb2;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et5=(EditText)findViewById(R.id.et5);
        et6=(EditText)findViewById(R.id.et6);
        text1=(TextView)findViewById(R.id.text1);
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);

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
                // 이름 입력 확인
                if( et4.getText().toString().length() == 0 ) {
                    Toast.makeText(SecondActivity.this, "이름을 입력하세요!", Toast.LENGTH_SHORT).show();
                    et4.requestFocus();
                    return;
                }
                // 번호 입력 확인
                if( et5.getText().toString().length() == 0 ) {
                    Toast.makeText(SecondActivity.this, "번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    et5.requestFocus();
                    return;
                }
                // 주소 입력 확인
                if( et6.getText().toString().length() == 0 ) {
                    Toast.makeText(SecondActivity.this, "주소를 입력하세요!", Toast.LENGTH_SHORT).show();
                    et6.requestFocus();
                    return;
                }
                // 동의란 입력 확인
                if( rb1.isChecked()==false ) {
                    Toast.makeText(SecondActivity.this, "동의란을 확인해주세요", Toast.LENGTH_SHORT).show();
                    rb1.requestFocus();
                    return;
                }
                if( rb2.isChecked()==true) {
                    Toast.makeText(SecondActivity.this, "거절하시면 회원가입이 안됩니다.", Toast.LENGTH_SHORT).show();
                    rb2.requestFocus();
                    return;
                }

                Intent result = new Intent();
                result.putExtra("email", et1.getText().toString());
                result.putExtra("password",et2.getText().toString());


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
