package com.example.lesson_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etThemes, etMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id._email);
        etThemes = findViewById(R.id._themes);
        etMessage = findViewById(R.id._message);
        btnSend = findViewById(R.id._btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, themes, message;
                email = etEmail.getText().toString();
                themes = etThemes.getText().toString();
                message = etMessage.getText().toString();

                if (email.equals("") && themes.equals("") && message.equals("")){
                    Toast.makeText(MainActivity.this, "Необходимо заполнить все поля!", Toast.LENGTH_SHORT).show();
                }else{
                    sendEmail(message,message,email);
                }
            }
        });
    }
    public void sendEmail(String themes,String message,String email){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, themes);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose email client:"));
    }
}