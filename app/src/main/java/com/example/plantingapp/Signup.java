package com.example.plantingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {
   private FirebaseAuth mAuth;
    TextInputEditText editTextEmail,editTextPassword,editTextUsername,editTextConfirmPassword;
    Button btn_Signup;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        editTextConfirmPassword= findViewById(R.id.cnfrmpassword);
        editTextUsername=findViewById(R.id.username);
        btn_Signup = findViewById(R.id.btn_SIGNUP2);

        editTextEmail.setTextColor(Color.WHITE);
        editTextPassword.setTextColor(Color.WHITE);
        editTextConfirmPassword.setTextColor(Color.WHITE);
        editTextUsername.setTextColor(Color.WHITE);

        mAuth = FirebaseAuth.getInstance();
        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, password, confirmPassword;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());
                confirmPassword =String.valueOf(editTextConfirmPassword.getText());

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Signup.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Signup.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(Signup.this, "Enter Password Again", Toast.LENGTH_SHORT).show();
                    return;
                }
                signIn(email, password);
            }
        });
    }
    private void signIn(String email, String password) {
        // [START sign_in_with_email]

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Signup.this, "SignIn Successful!",
                                    Toast.LENGTH_SHORT).show();

                            FirebaseUser user = mAuth.getCurrentUser();
                            goToMainActivity();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Signup.this, "SignIn failed!",
                                    Toast.LENGTH_SHORT).show();


                        }
                    }

                });
    }
    private void goToMainActivity(){
        Intent intent = new Intent(Signup.this, first_activity.class);
        startActivity(intent);

    }
}

