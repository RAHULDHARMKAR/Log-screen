package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText user, pass;
    private static TextView textView;
    private static Button login_button;
    int attempt_count = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user = (EditText) findViewById(R.id.editTextUser);
        pass = (EditText) findViewById(R.id.editTextPassword);
        textView = (TextView) findViewById(R.id.textViewAttempt);
        login_button = (Button) findViewById(R.id.loginButton);
        textView.setText("Attemp Left " + Integer.toString(attempt_count));

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringUser = user.getText().toString();
                String stringPass = pass.getText().toString();

                if (stringUser.equals("user") && stringPass.equals("pass")) {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.putExtra("UserName",stringUser);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                    attempt_count--;
                    textView.setText("Attemp Left " + Integer.toString(attempt_count));
                    if (attempt_count == 0) {
                        login_button.setEnabled(false);
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();

    }
}
