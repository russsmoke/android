package com.example.favoritebook;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {

    private EditText editTextBook;
    private EditText editTextQuote;
    private TextView textViewDevBook;
    private TextView textViewDevQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_share);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextBook = findViewById(R.id.editTextBook);
        editTextQuote = findViewById(R.id.editTextQuote);
        textViewDevBook = findViewById(R.id.textViewDevBook);
        textViewDevQuote = findViewById(R.id.textViewDevQuote);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String bookName = extras.getString(MainActivity.BOOK_NAME_KEY);
            String quoteName = extras.getString(MainActivity.QUOTES_KEY);

            textViewDevBook.setText("Любимая книга разработчика: " + bookName);
            textViewDevQuote.setText("Цитата: " + quoteName);
        }
    }
    public void sendData(View view) {
        String userBook = editTextBook.getText().toString();
        String userQuote = editTextQuote.getText().toString();

        String message;
        if (!userBook.isEmpty() && !userQuote.isEmpty()) {
            message = "Название Вашей любимой книги: " + userBook + ". Цитата: " + userQuote;
        } else if (!userBook.isEmpty()) {
            message = "Название Вашей любимой книги: " + userBook + ". Цитата: не введена";
        } else if (!userQuote.isEmpty()) {
            message = "Название Вашей любимой книги: не введено. Цитата: " + userQuote;
        } else {
            message = "Название Вашей любимой книги и цитата не введены";
        }

        Intent data = new Intent();
        data.putExtra(MainActivity.USER_MESSAGE, message);

        setResult(Activity.RESULT_OK, data);
        finish();
    }
}