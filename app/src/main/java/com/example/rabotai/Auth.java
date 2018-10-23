package com.example.rabotai;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;

public class Auth extends AppCompatActivity {
    private static final String TAG = "Auth";
    NavigationView navigationView;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText log,pass;
    private Button btnsign;
    private Button btnreg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        navigationView= findViewById(R.id.navi);
        log = findViewById(R.id.login);
        pass = findViewById(R.id.password);
        btnsign = findViewById(R.id.btnsign);
        btnreg = findViewById(R.id.btnreg);
        mAuth = FirebaseAuth.getInstance();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.auth:
                        break;
                    case R.id.main:
                        Intent toMain = new Intent(Auth.this,MainActivity.class);
                        startActivity(toMain);
                        break;
                }
                return false;
            }
        });
        mAuthListener =new FirebaseAuth.AuthStateListener() {
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
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = log.getText().toString();
                String password = pass.getText().toString();
                if (!email.equals("")&&!password.equals("")){
                    Log.e("Srabotalo","Srabotalo");
                    mAuth.signInWithEmailAndPassword(email,password);
                    toastMessage("Успешная авторизация");
                    Intent myMainCativity = new Intent(Auth.this,MainActivity.class );
                    startActivity(myMainCativity);
                } else {
                    toastMessage("VVedi chota");
                }
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toReg = new Intent (Auth.this,Reg.class);
                startActivity(toReg);
            }
        });



       /* btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memail = log.getText().toString();
                String mpass = pass.getText().toString();
                registration(memail,mpass);
            }
        });*/
    }
    /*public void registration (String memail, String mpass){
        mAuth.createUserWithEmailAndPassword(memail,mpass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    toastMessage("Регистрация успешна");
                }else {
                    toastMessage("Регистрация провальна");
                }
            }
        });
    };*/
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
