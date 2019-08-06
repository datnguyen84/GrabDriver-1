package com.example.grabdriver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class WelcomeActivity extends AppCompatActivity {

    private Button WelcomeDriverButton;
    private Button WelcomeCustomButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        WelcomeCustomButton = (Button) findViewById(R.id.wellcome_customer_btn);
        WelcomeDriverButton = (Button) findViewById(R.id.welcome_driver_btn);

        WelcomeCustomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  LoginRegisterCusTomerIntent = new Intent(WelcomeActivity.this, CustomerLoginActivity.class);
                startActivity(LoginRegisterCusTomerIntent);
            }
        });

        WelcomeDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  LoginRegisterDriverIntent = new Intent(WelcomeActivity.this, DriverLoginActivity.class);
                startActivity(LoginRegisterDriverIntent);
            }
        });
    }
}
