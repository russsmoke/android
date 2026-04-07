package com.example.simplefragmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_CURRENT_FRAGMENT = "current_fragment";
    private boolean isFirstFragmentShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Восстанавливаем состояние после поворота
        if (savedInstanceState != null) {
            isFirstFragmentShowing = savedInstanceState.getBoolean(KEY_CURRENT_FRAGMENT, true);
        }

        // Проверяем, в какой ориентации находится приложение
        View fragmentContainer = findViewById(R.id.fragmentContainerView);

        if (fragmentContainer != null) {
            // Портретная ориентация - настраиваем кнопки и загружаем фрагмент
            setupPortraitMode();

            // Загружаем последний активный фрагмент (только при первом создании)
            if (savedInstanceState == null) {
                loadFragment(isFirstFragmentShowing);
            }
        }
        // Для горизонтальной ориентации фрагменты уже загружены из layout-land
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Сохраняем какой фрагмент был показан
        outState.putBoolean(KEY_CURRENT_FRAGMENT, isFirstFragmentShowing);
    }

    private void setupPortraitMode() {
        Button btnFirst = findViewById(R.id.btnFirstFragment);
        Button btnSecond = findViewById(R.id.btnSecondFragment);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFirstFragmentShowing = true;
                loadFragment(true);
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFirstFragmentShowing = false;
                loadFragment(false);
            }
        });
    }

    private void loadFragment(boolean showFirst) {
        Fragment fragment = showFirst ? new FirstFragment() : new SecondFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .commit();
    }
}