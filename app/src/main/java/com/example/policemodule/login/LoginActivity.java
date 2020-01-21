package com.example.policemodule.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.policemodule.MainActivity;
import com.example.policemodule.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;

public class LoginActivity extends AppCompatActivity
{
    @BindView(R.id.activity_login_tv_email)
    TextView email;
    @BindView(R.id.activity_login_tv_password)
    TextView password;
    @BindView(R.id.activity_login_btn_login)
    Button button;
    @BindView(R.id.activity_login_tv_join)
            TextView join;



    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();


        authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null)
                {
                    Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId=email.getText().toString();
                String pwd=password.getText().toString();
                if(TextUtils.isEmpty(emailId))
                {
                    Toast.makeText(LoginActivity.this, "Plese enter valid email", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(pwd))
                {
                    Toast.makeText(LoginActivity.this,"Please enter valid password",Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.signInWithEmailAndPassword(emailId,pwd)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    finish();
                                }
                                else
                                    Toast.makeText(LoginActivity.this,"Login failed or user not found",Toast.LENGTH_SHORT).show();
                            }

                        });
                join.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });
    }
    protected void onstart()
    {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
}
