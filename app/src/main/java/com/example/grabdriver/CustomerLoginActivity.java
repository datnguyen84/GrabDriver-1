package com.example.grabdriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CustomerLoginActivity extends AppCompatActivity {

    private EditText editTextMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        editTextMobile = findViewById(R.id.editTextMobile_customer);


        findViewById(R.id.buttonContinue_customer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile_customer = editTextMobile.getText().toString().trim();

                if (mobile_customer.isEmpty() || mobile_customer.length() < 10) {
                    editTextMobile.setError("Enter a valid mobile");
                    editTextMobile.requestFocus();
                    return;
                }

                Intent intent = new Intent(CustomerLoginActivity.this, VeryPhoneCustomerACtivity.class);
                intent.putExtra("mobile_customer", mobile_customer);
                startActivity(intent);
            }
        });
    }
}
