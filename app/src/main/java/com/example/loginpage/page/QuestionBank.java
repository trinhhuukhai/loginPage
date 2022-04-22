package com.example.loginpage.page;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    private static List<QuestionList> javaQuestions() {
        return questionLists();
    }

    private static List<QuestionList> questionLists() {
        final List<QuestionList> questionLists = new ArrayList<>();

        //create object of Question list class and pass a question along with option and answer
        final QuestionList question1 = new QuestionList("cau hoi 1", "1", "2", "3", "4", "1", "");
        final QuestionList question2 = new QuestionList("cau hoi 2", "1", "2", "3", "4", "1", "");
        final QuestionList question3 = new QuestionList("cau hoi 3", "1", "2", "3", "4", "1", "");
        final QuestionList question4 = new QuestionList("cau hoi 4", "1", "2", "3", "4", "1", "");
        final QuestionList question5 = new QuestionList("cau hoi 5", "1", "2", "3", "4", "1", "");
        final QuestionList question6 = new QuestionList("cau hoi 6", "1", "2", "3", "4", "1", "");

        //add all question to List<QuestionList>

        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add(question6);
        return questionLists;
    }


    private static List<QuestionList> phpQuestions() {
        final List<QuestionList> questionLists = new ArrayList<>();

        //create object of Question list class and pass a question along with option and answer
        final QuestionList question1 = new QuestionList("cau hoi 1", "1", "2", "3", "4", "1", "");
        final QuestionList question2 = new QuestionList("cau hoi 2", "1", "2", "3", "4", "1", "");
        final QuestionList question3 = new QuestionList("cau hoi 3", "1", "2", "3", "4", "1", "");
        final QuestionList question4 = new QuestionList("cau hoi 4", "1", "2", "3", "4", "1", "");
        final QuestionList question5 = new QuestionList("cau hoi 5", "1", "2", "3", "4", "1", "");
        final QuestionList question6 = new QuestionList("cau hoi 6", "1", "2", "3", "4", "1", "");

        //add all question to List<QuestionList>

        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add(question6);

        return questionLists();
    }

    private static List<QuestionList> pythonQuestions() {
        final List<QuestionList> questionLists = new ArrayList<>();

        //create object of Question list class and pass a question along with option and answer
        final QuestionList question1 = new QuestionList("cau hoi 1", "1", "2", "3", "4", "1", "");
        final QuestionList question2 = new QuestionList("cau hoi 2", "1", "2", "3", "4", "1", "");
        final QuestionList question3 = new QuestionList("cau hoi 3", "1", "2", "3", "4", "1", "");
        final QuestionList question4 = new QuestionList("cau hoi 4", "1", "2", "3", "4", "1", "");
        final QuestionList question5 = new QuestionList("cau hoi 5", "1", "2", "3", "4", "1", "");
        final QuestionList question6 = new QuestionList("cau hoi 6", "1", "2", "3", "4", "1", "");

        //add all question to List<QuestionList>

        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add(question6);

        return questionLists();
    }

    private static List<QuestionList> cQuestions() {
        final List<QuestionList> questionLists = new ArrayList<>();

        //create object of Question list class and pass a question along with option and answer
        final QuestionList question1 = new QuestionList("cau hoi 1", "1", "2", "3", "4", "1", "");
        final QuestionList question2 = new QuestionList("cau hoi 2", "1", "2", "3", "4", "1", "");
        final QuestionList question3 = new QuestionList("cau hoi 3", "1", "2", "3", "4", "1", "");
        final QuestionList question4 = new QuestionList("cau hoi 4", "1", "2", "3", "4", "1", "");
        final QuestionList question5 = new QuestionList("cau hoi 5", "1", "2", "3", "4", "1", "");
        final QuestionList question6 = new QuestionList("cau hoi 6", "1", "2", "3", "4", "1", "");

        //add all question to List<QuestionList>

        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add(question6);

        return questionLists();
    }

    public static List<QuestionList> getQuestions(String selectedTopicName) {
        switch (selectedTopicName) {
            case "java":
                return javaQuestions();
            case "php":
                return phpQuestions();
            case "python":
                return pythonQuestions();
            default:
                return cQuestions();
        }
    }


}
