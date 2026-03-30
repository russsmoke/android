package com.example.intentapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvCurrentTime;
    private Button btnSendTime;
    private String currentTimeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Инициализация компонентов
        tvCurrentTime = findViewById(R.id.tvCurrentTime);
        btnSendTime = findViewById(R.id.btnSendTime);

        // Получаем системное время
        long dateInMillis = System.currentTimeMillis();
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        currentTimeString = sdf.format(new Date(dateInMillis));

        // Отображаем время в TextView первой активности
        tvCurrentTime.setText("Текущее время: " + currentTimeString);
    }
    // Метод для передачи времени во вторую активность
    public void sendTimeToSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        // Передаем время во вторую активность
        intent.putExtra("current_time", currentTimeString);
        startActivity(intent);
    }
}