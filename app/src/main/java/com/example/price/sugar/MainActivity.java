package com.example.price.sugar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.takeretrofit.model.Login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Login().login("13222222222","123");
    }
}
