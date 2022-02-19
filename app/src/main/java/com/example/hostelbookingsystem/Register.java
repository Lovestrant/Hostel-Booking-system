package com.example.hostelbookingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText fullName, phoneNumber, securityKey, secKeyConfirm, password, passConfirm;
    TextView redirect; DatabaseReference reff;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Binding widgets
        fullName = findViewById(R.id.fullName);
        phoneNumber = findViewById(R.id.phone_number);
        securityKey = findViewById(R.id.security_key);
        secKeyConfirm = findViewById(R.id.confirm_key);
        password = findViewById(R.id.password_register);
        passConfirm = findViewById(R.id.passConfirm);
        Register = findViewById(R.id.btn_register);
        redirect = findViewById(R.id.sign_redirect2);



        reff = FirebaseDatabase.getInstance().getReference().child("Authentication");
        //onclick Listener to btn
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //perform action
                //getting texts from input
                String FullName = fullName.getText().toString();
                String PhoneNumber = phoneNumber.getText().toString();
                String SecurityKey = securityKey.getText().toString();
                String SecurityKeyConfirm = secKeyConfirm.getText().toString();
                String Password = password.getText().toString();
                String PassConfirm = passConfirm.getText().toString();

                //ensure editTexts are not empty
                if(FullName.isEmpty()|| PhoneNumber.isEmpty() || SecurityKey.isEmpty()
                        || SecurityKeyConfirm.isEmpty() || Password.isEmpty() || PassConfirm.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill All fields", Toast.LENGTH_SHORT).show();
                }else if(PassConfirm != Password) {
                    Toast.makeText(getApplicationContext(), "Password should match with its Confirmation", Toast.LENGTH_SHORT).show();
                }else if(SecurityKey != SecurityKeyConfirm){
                    Toast.makeText(getApplicationContext(), "Security key Must match with its confirmation", Toast.LENGTH_SHORT).show();
                }else{

                    //Call object class
                    Member member = new Member(FullName.trim(),SecurityKey.trim(),PhoneNumber.trim(),Password.trim());
                    reff.child("Member1").setValue("member");
                    Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_SHORT).show();

                }

            }
        });

        //onclick listener to redirect textview
        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
