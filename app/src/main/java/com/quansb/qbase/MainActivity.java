package com.quansb.qbase;

import android.os.Bundle;
import android.widget.TextView;

import com.quansb.qbase.http.HttpClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvGet = findViewById(R.id.tv_get);

        HttpClient httpClient=new HttpClient();
        tvGet.setOnClickListener(v -> {
            httpClient.get();
        });

    }


}