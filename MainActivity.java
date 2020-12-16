package com.example.omsaiwashing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button SignIn;
    EditText UsernameEt;
    TextView Signup;
    EditText PasswordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = findViewById(R.id.editText);
        PasswordEt = findViewById(R.id.editText2);
        SignIn=findViewById(R.id.button3);
        Signup=findViewById(R.id.textView2);


        Signup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                openActivity3();
            }
        });

    }
    public void openActivity3()
    {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void OnLogin(View view) {

        String user_name = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        if(user_name.isEmpty()){
            UsernameEt.setError("Please enter email id");
            UsernameEt.requestFocus();
        }
        else  if(password.isEmpty()){
            PasswordEt.setError("Please enter your password");
            PasswordEt.requestFocus();
        }
        else  if(user_name.isEmpty() && password.isEmpty()){
            Toast.makeText(MainActivity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
        }



            MainFromBackground backgroundWorker = new MainFromBackground(this);

            backgroundWorker.execute(user_name, password);


    }
}
