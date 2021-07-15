package com.tharun.saathealthtestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private EditText signupName,signupPhno,signupEmail,signupPassword;
    private Button signup;
    private TextView toLogin;
    private ProgressBar progressBar;
    String userId;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signupName = findViewById(R.id.etName);
        signupPhno = findViewById(R.id.etphno);
        signupEmail = findViewById(R.id.etSignupEmail);
        signupPassword = findViewById(R.id.etSignupPassword);
        signup = findViewById(R.id.btnSignup);
        toLogin = findViewById(R.id.txtToLogin);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressbar);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = signupEmail.getText().toString().trim();
                String password = signupPassword.getText().toString().trim();
                final String name = signupName.getText().toString();
                final String phone = signupPhno.getText().toString();

                if(TextUtils.isEmpty(name)){
                    signupName.setError("Name cannot be empty");
                    return;
                }

                if(phone.length() != 10){
                    signupPhno.setError("Phone number not valid");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    signupEmail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    signupPassword.setError("Password is Required.");
                    return;
                }
                if(password.length() < 6){
                    signupPassword.setError("Password Must be greater than 6 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // Register the user in firebase
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                            userId = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(userId);
                            Map<String,Object> user = new HashMap<>();
                            Map<String,Object> user1 = new HashMap<>();
                            user.put("name",name);
                            user.put("email",email);
                            user.put("phone",phone);
                            documentReference.set(user);
                            String points = "0";
                            user1.put("points",points);
                            DocumentReference documentReference1 = fstore.collection("users").document(userId).collection("userpoints").document(userId);
                            documentReference1.set(user1);
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(RegisterActivity.this, "Error ! " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
}