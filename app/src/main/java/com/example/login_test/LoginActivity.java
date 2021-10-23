package com.example.login_test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import fragments.BlankFragment;

public class LoginActivity extends AppCompatActivity {

    Button login;
    SharedPreferences sp,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.loginBtn);

        sp = getSharedPreferences("login",MODE_PRIVATE);
        sp2=getSharedPreferences("logout",MODE_PRIVATE);

        if(sp.getBoolean("logged",false)){
            goToMainActivity();
        }
//        if(sp2.getBoolean("log",false)){
//        loadFragment(new BlankFragment());}
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
                sp.edit().putBoolean("logged",true).apply();
            }
        });
        findViewById(R.id.loginBtntest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new BlankFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
        System.out.println("This has been passed ...........................................");
    }

    public void goToMainActivity(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}