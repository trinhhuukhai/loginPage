package com.example.loginpage.page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.loginpage.R;

public class Start extends AppCompatActivity implements View.OnClickListener {

    private String selectedTopicName = "";
    LinearLayout java,php,python,c;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

         java = findViewById(R.id.javaLayout);
         java.setOnClickListener(this);

         php = findViewById(R.id.phpLayout);
         php.setOnClickListener(this);

         python = findViewById(R.id.pythonLayout);
         python.setOnClickListener(this);

         c = findViewById(R.id.clayout);
         c.setOnClickListener(this);

        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.javaLayout:
                selectedTopicName = "java";
                java.setBackgroundResource(R.drawable.back_white_stroke);
                php.setBackgroundResource(R.drawable.round_back_white);
                python.setBackgroundResource(R.drawable.round_back_white);
                c.setBackgroundResource(R.drawable.round_back_white);
                break;
            case R.id.phpLayout:
                selectedTopicName = "php";
                php.setBackgroundResource(R.drawable.back_white_stroke);
                java.setBackgroundResource(R.drawable.round_back_white);
                python.setBackgroundResource(R.drawable.round_back_white);
                c.setBackgroundResource(R.drawable.round_back_white);
                break;
            case R.id.pythonLayout:
                selectedTopicName = "python";
                python.setBackgroundResource(R.drawable.back_white_stroke);
                java.setBackgroundResource(R.drawable.round_back_white);
                php.setBackgroundResource(R.drawable.round_back_white);
                c.setBackgroundResource(R.drawable.round_back_white);
                break;
            case R.id.clayout:
                selectedTopicName = "c#";
                c.setBackgroundResource(R.drawable.back_white_stroke);
                java.setBackgroundResource(R.drawable.round_back_white);
                python.setBackgroundResource(R.drawable.round_back_white);
                php.setBackgroundResource(R.drawable.round_back_white);
                break;
            case R.id.startBtn:
                startQuizz();
                break;
        }

    }

    private void startQuizz() {
        if (selectedTopicName.isEmpty()){
            Toast.makeText(Start.this,"Please select the Topic",Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(Start.this, Quizz.class);
            intent.putExtra("selectedTopic", selectedTopicName);
            startActivity(intent);

            finish();
        }

    }
}