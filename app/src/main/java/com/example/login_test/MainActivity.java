package com.example.login_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragments.BlankFragment;

public class MainActivity extends AppCompatActivity {
Button logout;
SharedPreferences sp,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logout=(Button)findViewById(R.id.logoutBtn);
        sp=getSharedPreferences("login",MODE_PRIVATE);
        sp2=getSharedPreferences("logout",MODE_PRIVATE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                sp2.edit().putBoolean("log",true).apply();
                sp.edit().putBoolean("logged",false).apply();
            }
        });
    }

}