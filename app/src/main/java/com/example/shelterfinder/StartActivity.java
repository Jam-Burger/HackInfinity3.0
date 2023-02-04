package com.example.shelterfinder;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        FirebaseAuth auth = FirebaseAuth.getInstance();

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        new Handler().postDelayed(() -> {
            Intent intent;
            if (auth.getCurrentUser() == null) {
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                Toast.makeText(this, "here", Toast.LENGTH_SHORT).show();
            } else {
                intent = new Intent(getApplicationContext(), MainActivity.class);
            }
            startActivity(intent);
            finish();
        }, 4000);
    }
}