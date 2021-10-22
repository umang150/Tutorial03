package com.example.tutorial3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button log;
    private EditText email;
    private EditText passw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setTitle(getResources().getString(R.string.app_title));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log = findViewById(R.id.login);
        email =findViewById(R.id.email);
        passw =findViewById(R.id.password);



        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailadd = email.getText().toString().trim();
                if (email.getText().toString().equals("admin@gmail.com") && passw.getText().toString().equals("admin"))
                {
                    Intent intent =new Intent(MainActivity.this,welcome.class);
                    startActivity(intent);

                }
                if (passw.getText().toString().length()<5)
                {
                    Toast.makeText(MainActivity .this, "Passeord  Sholud be 5 Digits", Toast.LENGTH_SHORT).show();
                    passw.requestFocus();

                }
                if (passw.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter Password...", Toast.LENGTH_SHORT).show();
                    passw.requestFocus();
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(emailadd).matches())
                {
                    Toast.makeText(MainActivity.this, "Plass Enter Valid Email Address..", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                }
                if(email.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter Valid MailAddredss", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                }

            }
        });

    }
}