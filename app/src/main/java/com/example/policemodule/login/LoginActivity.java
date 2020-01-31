package com.example.policemodule.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.policemodule.MainActivity;
import com.example.policemodule.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity
{
    @BindView(R.id.relative_layout)
    RelativeLayout relativeLayout;

    @BindView(R.id.activity_login_tv_email)
    TextView email;
    @BindView(R.id.activity_login_tv_password)
    TextView passwords;
    @BindView(R.id.activity_login_btn_login)
    Button login;
    @BindView(R.id.activity_login_tv_join)
    TextView join;


    FirebaseAuth firebaseAuth;
   FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
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


      /*  login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String msg;
                String emailId=email.getText().toString();
                String password=passwords.getText().toString();
                if(emailId.isEmpty() || password.isEmpty())
                {
                    msg="Fields are empty";
                    showSnackbar(msg);
                    return;
                }
                if((!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()))
                {
                    msg="Email is Invalid";
                    showSnackbar(msg);
                    return;
                }
                if(password.length()<=6)
                {
                    msg="Password should be longer than 6 character";
                    showSnackbar(msg);
                    return;
                }
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);

            }
        });

            //TODO extract the string from the edit texts and validate the strings . Check whether the entered email is a valid email or not
            // check whether the password is longer than 6 characters . Also if the password is not that long prepare a SnackBar to dislay
            // the error.Once everything is correct jump to the next activity.
        }
        public void showSnackbar(String msg)
        {
            Snackbar snackbar= Snackbar.make(relativeLayout,msg,Snackbar.LENGTH_INDEFINITE)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Snackbar snackbar1=Snackbar.make(relativeLayout,"Undo Successful",Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });
            snackbar.show();
        }*/

         login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = email.getText().toString();
                String pwd = passwords.getText().toString();
                if (TextUtils.isEmpty(emailId)) {
                    Toast.makeText(LoginActivity.this, "Plese enter valid email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(LoginActivity.this, "Please enter valid password", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.signInWithEmailAndPassword(emailId, pwd)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);//will be commented out
                                    startActivity(intent);//will be commented out
                                    Toast.makeText(LoginActivity.this, "Login failed or user not found", Toast.LENGTH_SHORT).show();
                                }
                            }

                        });
            }});

                join.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivity(intent);

                    }});
                }
    protected void onstart()
    {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
}
