package ru.mirea.nurmukhamedovara.intentfilter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: разметка загружена");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickOpenBrowser(View view) {
        Uri address = Uri.parse("https://www.mirea.ru/");

        Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);

        startActivity(openLinkIntent);

        Log.i(TAG, "Открываем браузер с сайтом МИРЭА");
    }

    public void onClickShare(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);

        shareIntent.setType("text/plain");

        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "МИРЭА");

        String fullName = "Нурмухамедова Русмина Альвердовна";
        shareIntent.putExtra(Intent.EXTRA_TEXT, fullName);

        startActivity(Intent.createChooser(shareIntent, "Поделиться через..."));
        Log.i(TAG, "Открываем диалог выбора приложения для шаринга");
    }
}