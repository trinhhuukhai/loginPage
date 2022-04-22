package com.example.loginpage.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.TintTypedArray;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginpage.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Quizz extends AppCompatActivity implements View.OnClickListener {

    TextView score, question, timer, selectedTopic;
    AppCompatButton option1, option2, option3, option4, nextBtn;
    ImageView backBtn;

    private Timer quizzTimer;
    private int totalTimeInMin = 1;
    private int seconds = 0;

    private List<QuestionList> questionLists;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);

        score = findViewById(R.id.score);
        question = findViewById(R.id.question);
        selectedTopic = findViewById(R.id.topicName);
        timer = findViewById(R.id.timer);

        option1 = findViewById(R.id.option1);
        option1.setOnClickListener(this);

        option2 = findViewById(R.id.option2);
        option2.setOnClickListener(this);

        option3 = findViewById(R.id.option3);
        option3.setOnClickListener(this);

        option4 = findViewById(R.id.option4);
        option4.setOnClickListener(this);

        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(this);

        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");
        selectedTopic.setText(getSelectedTopicName);

        questionLists = QuestionBank.getQuestions(getSelectedTopicName);

        startTimer(timer);

        score.setText((currentQuestionPosition + 1) + "/" + questionLists.size());
        question.setText(questionLists.get(0).getQuestion());
        option1.setText(questionLists.get(0).getOption1());
        option2.setText(questionLists.get(0).getOption2());
        option3.setText(questionLists.get(0).getOption3());
        option4.setText(questionLists.get(0).getOption4());

    }

    private void startTimer(TextView timer){ // ham set timer
        quizzTimer = new Timer();
        quizzTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds == 0){
                    totalTimeInMin--;
                    seconds = 59;
                }else if (totalTimeInMin == 0 && seconds == 0){
                    quizzTimer.purge();
                    quizzTimer.cancel();

                    Toast.makeText(Quizz.this, "Time over", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Quizz.this, QuizzResult.class);
                    intent.putExtra("correct :", getCorrectAnswer());
                    intent.putExtra("incorrect", getInCorrectAnswer());
                    startActivity(intent);


                    finish();
                }else {
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String.valueOf(totalTimeInMin);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length() == 1){
                            finalMinutes = "0" + finalMinutes;
                        }
                        if (finalSeconds.length() == 1) {
                            finalSeconds = "0" + finalSeconds;
                        }

                        timer.setText(finalMinutes + ":" + finalSeconds);
                    }
                });
            }
        },1000,1000);
    }

    private int getCorrectAnswer(){
        int correctAnswer = 0;
        for (int i = 0; i<questionLists.size(); i++){
            final String getSelectedAnswer = questionLists.get(i).getUserSelectedAnswer();
            final  String getAnswer = questionLists.get(i).getAnswer();

            if (getSelectedAnswer.equals(getAnswer)){
                correctAnswer++;
            }
        }
        return correctAnswer;
    }
    private int getInCorrectAnswer(){
        int correctAnswer = 0;
        for (int i = 0; i<questionLists.size(); i++){
            final String getSelectedAnswer = questionLists.get(i).getUserSelectedAnswer();
            final  String getAnswer = questionLists.get(i).getAnswer();

            if (!getSelectedAnswer.equals(getAnswer)){
                correctAnswer++;
            }
        }
        return correctAnswer;
    }
    private void revealAnswer(){
        final String getAnswer = questionLists.get(currentQuestionPosition).getAnswer();

        if (option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green1);
            option1.setTextColor(Color.WHITE);
        }else if (option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green1);
            option2.setTextColor(Color.WHITE);
        }else if (option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green1);
            option3.setTextColor(Color.WHITE);
        }else if (option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green1);
            option4.setTextColor(Color.WHITE);
        }
    }

    private void changeNextQuestion(){
        currentQuestionPosition++;
        if ((currentQuestionPosition+1) == questionLists.size()){
            nextBtn.setText("Submit Quizz");
        }
        if (currentQuestionPosition < questionLists.size()){
            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.round_back_stroke2);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_stroke2);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_stroke2);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_stroke2);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            score.setText((currentQuestionPosition + 1) + "/" + questionLists.size());
            question.setText(questionLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionLists.get(currentQuestionPosition).getOption4());

        }else {
            Intent intent = new Intent(Quizz.this,QuizzResult.class);
            intent.putExtra("correct", getCorrectAnswer());
            intent.putExtra("incorrect", getInCorrectAnswer());
            startActivity(intent);

            finish();
        }
    }

    @Override
    public void onBackPressed() {
        quizzTimer.purge();
        quizzTimer.cancel();

        startActivity(new Intent(Quizz.this, Start.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backBtn:
                onBackPressed();
                break;
            case R.id.option1:
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_back_red);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
                break;
            case R.id.option2:
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_back_red);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
                break;
            case R.id.option3:
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_back_red);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
                break;
            case R.id.option4:
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_back_red);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
                break;
            case R.id.nextBtn:
                if (selectedOptionByUser.isEmpty()){
                    Toast.makeText(Quizz.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }else{
                    changeNextQuestion();
                }
                break;

        }
    }
}