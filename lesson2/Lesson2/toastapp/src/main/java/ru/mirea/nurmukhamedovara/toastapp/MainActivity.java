package ru.mirea.nurmukhamedovara.toastapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Button buttonShowToast;

    private static final String STUDENT_NUMBER = "11";
    private static final String STUDENT_GROUP = "БСБО-51-24";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        buttonShowToast = findViewById(R.id.buttonShowToast);

        buttonShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCharacterCountToast();
            }
        });
    }

    private void showCharacterCountToast() {
        String inputText = editTextInput.getText().toString();

        int characterCount = inputText.length();

        String message = "СТУДЕНТ № " + STUDENT_NUMBER +
                " ГРУППА " + STUDENT_GROUP +
                " Количество символов - " + characterCount;

        Toast toast = Toast.makeText(
                getApplicationContext(),
                message,
                Toast.LENGTH_SHORT
        );
        toast.show();
    }
}