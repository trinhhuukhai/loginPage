package com.example.loginpage.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.loginpage.R;

public class QuizzResult extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton startNewBtn;
    TextView correct, incorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_result);

        startNewBtn = findViewById(R.id.startNewBtn);
        startNewBtn.setOnClickListener(this);

        correct = findViewById(R.id.correctAnswer);
        incorrect = findViewById(R.id.IncorrectAnswer);

        final int getCorrectAnswer = getIntent().getIntExtra("correct", 0);
        final int getIncorrectAnswer = getIntent().getIntExtra("incorrect", 0);

        correct.setText((String.valueOf(getCorrectAnswer)));
        incorrect.setText((String.valueOf(getIncorrectAnswer)));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startNewBtn:
                startActivity(new Intent(QuizzResult.this, Quizz.class));
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizzResult.this, Quizz.class));
        finish();
    }
}