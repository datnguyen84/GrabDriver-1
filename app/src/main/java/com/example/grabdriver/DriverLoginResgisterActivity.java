package com.example.grabdriver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DriverLoginResgisterActivity extends AppCompatActivity {

    private Button DriverLoginButton;
    private Button DriverRegisterButton;
    private TextView DriverregisterLink;
    private TextView DriverStatus;
    private EditText EmailDriver;
    private EditText PasswordDriver;
    private ProgressDialog loadingBAr;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login_resgister);
        mAuth = FirebaseAuth.getInstance();

        DriverLoginButton = (Button) findViewById(R.id.driver_login_btn);
        DriverRegisterButton = (Button) findViewById(R.id.driver_register_btn);
        DriverregisterLink = (TextView) findViewById(R.id.register_driver_link);
        DriverStatus = (TextView) findViewById(R.id.driver_status);
        EmailDriver=(EditText) findViewById(R.id.Email_Driver );
        PasswordDriver = (EditText)findViewById(R.id.password_Driver);
        loadingBAr = new ProgressDialog(this);

        DriverRegisterButton.setVisibility(View.INVISIBLE);
        DriverRegisterButton.setEnabled(false);

        DriverregisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DriverLoginButton.setVisibility(View.INVISIBLE);
                DriverregisterLink.setVisibility(View.INVISIBLE);
                DriverStatus.setText("Register Driver");

                DriverRegisterButton.setVisibility(View.VISIBLE);
                DriverRegisterButton.setEnabled(true);
            }
        });

        DriverRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = EmailDriver.getText().toString();
                String password = PasswordDriver.getText().toString();
                
                RegisterDriver(email,password);
                
            }
        });
    }

    private void RegisterDriver(String email, String password) {
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(DriverLoginResgisterActivity.this,"Please write Email...",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(DriverLoginResgisterActivity.this,"Please write password...",Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBAr.setTitle("Driver RegisTration");
            loadingBAr.setMessage("please wait...");
            loadingBAr.show();

            mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(DriverLoginResgisterActivity.this,"Register ok",Toast.LENGTH_SHORT).show();
                        loadingBAr.dismiss();
                    }
                    else
                    {
                        Toast.makeText(DriverLoginResgisterActivity.this,"Register fail",Toast.LENGTH_SHORT).show();
                        loadingBAr.dismiss();

                    }
                }
            });
        }
    }
}
