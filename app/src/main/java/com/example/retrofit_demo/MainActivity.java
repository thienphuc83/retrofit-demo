package com.example.retrofit_demo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<Example> {

    private final String key_api = "9fd4581a0377d675761b350cc9a405c1";

    TextView tvTitle, tvStatus, tvOverview, tvBudget;
    Button btnCallAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.tvTitle);
        tvStatus = findViewById(R.id.tvStatus);
        tvOverview = findViewById(R.id.tvOverview);
        tvBudget = findViewById(R.id.tvBudget);
        btnCallAPI = findViewById(R.id.btnCallAPI);

        // call api
        btnCallAPI.setOnClickListener(v -> onCallAPI(key_api));

    }

    private void onCallAPI(String key_api) {
        APIServer.apiServer.getExample(key_api).enqueue(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(Call<Example> call, Response<Example> response) {
        if (response.body() == null) {
            Toast.makeText(this, "Call api success but null data!", Toast.LENGTH_SHORT).show();
            return;
        }
        tvTitle.setText(response.body().getTitle());
        tvStatus.setText(response.body().getStatus());
        tvOverview.setText(response.body().getOverview());
        tvBudget.setText(response.body().getBudget() + "");
        Toast.makeText(this, "Call api success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Call<Example> call, Throwable t) {
        Toast.makeText(this, "Call api fail!", Toast.LENGTH_SHORT).show();
    }
}