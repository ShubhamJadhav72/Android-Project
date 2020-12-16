package com.example.omsaiwashing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button SignIn;
    EditText UsernameEt;
    TextView SignUp;
    EditText PasswordEt,fullName,contact,gmailAdd;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        UsernameEt = findViewById(R.id.editText7);
        PasswordEt = findViewById(R.id.editText11);

        fullName = findViewById(R.id.editText12);
        contact = findViewById(R.id.editText14);
        gmailAdd= findViewById(R.id.editText13);
        SignIn=findViewById(R.id.button4);
        SignUp=findViewById(R.id.textView7);

        SignUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                openActivity3();
            }
        });
    }
    public void openActivity3()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void OnLogin(View view) {

        String user_name = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String fullname = fullName.getText().toString();
        String gmail = gmailAdd.getText().toString();
        String contactN = contact.getText().toString();
        if(user_name.isEmpty()){
            UsernameEt.setError("Please enter Username");
            UsernameEt.requestFocus();
        }
        else  if(password.isEmpty()){
            PasswordEt.setError("Please enter your password");
            PasswordEt.requestFocus();
        }
        if(fullname.isEmpty()){
            fullName.setError("Please enter Your fullname");
            fullName.requestFocus();
        }
        else  if(password.isEmpty()){
            PasswordEt.setError("Please enter password");
            PasswordEt.requestFocus();
        }

        if(gmail.isEmpty()) {
            Toast.makeText(getApplicationContext(),"enter email address",Toast.LENGTH_SHORT).show();
        }else {
            if (gmail.trim().matches(emailPattern)) {
            } else {
                Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
            }
        }

        if(contactN.isEmpty()){
            contact.setError("Please enter your contact");
            contact.requestFocus();
        }
        else  if(user_name.isEmpty() && password.isEmpty()){
            Toast.makeText(RegisterActivity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
        }



        RegisterBackground background = new RegisterBackground(this);

        background.execute(user_name, password,fullname,gmail,contactN);


    }

}
