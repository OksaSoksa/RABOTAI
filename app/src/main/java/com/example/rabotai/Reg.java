package com.example.rabotai;

import android.content.Intent;
import android.nfc.tech.NfcV;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class Reg extends AppCompatActivity {
    private static final String TAG = "Reg";
    NavigationView navigationView;
    private EditText login,password;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    private Button registacia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        login = findViewById(R.id.email);
        password = findViewById(R.id.pas);
        registacia = findViewById(R.id.regist);
        navigationView = findViewById(R.id.navi);
        mAuth = FirebaseAuth.getInstance();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.auth:
                        Intent toAuth = new Intent (Reg.this,Auth.class);
                        startActivity(toAuth);
                        break;
                    case R.id.main:
                        Intent toMain = new Intent(Reg.this,MainActivity.class);
                        startActivity(toMain);
                        break;
                }
                return false;
            }
        });
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user !=null){
                    Log.e(TAG,"onAuthStateChanged:signed_in:"+user.getEmail());
                    //toastMessage("Successfully sign in");
                } else {
                    Log.e(TAG,"onAuthStateChanged:signed_out");
                    //toastMessage("Successfully sign ou!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!t");
                }

            }
        };
        registacia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("asdd ad","dfdfgdfg");
                String memail = login.getText().toString();
                Log.e("mail ad","111    1     "+ memail);
                String mpass = password.getText().toString();
                Log.e("pass ad","11111    " + mpass);
                registration(memail,mpass);
            }
        });
    }
    public void registration (String memail, String mpass){
        mAuth.createUserWithEmailAndPassword(memail,mpass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    toastMessage("Регистрация успешна");
                    Intent toMain = new Intent(Reg.this,MainActivity.class);
                    startActivity(toMain);
                }else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        toastMessage("Пользователь с такой почтой уже зарегистрирован");
                    } else {
                        toastMessage("Регистрация провальна");
                    }
                }
            }
        });
    };
    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop(){
        super.onStop();
        if (mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
