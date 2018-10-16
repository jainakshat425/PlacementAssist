package com.example.android.placementassist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FeedbackActivity extends AppCompatActivity {

    public static final String ANSWERED_QUESTION_LIST = "answered_questions_list";
    public static final String STUDENT_ROLL_NO = "roll_no";
    private int mStudentCategory;

    private RecyclerView mRecyclerView;
    private LayoutManager mLayoutManager;
    private QuestionAdapter mQuestonAdapter;

    private FloatingActionButton nextButton;
    EditText rollNoEt;

    private List<String> keyNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        mStudentCategory = getIntent().getIntExtra(StudentActivity.EXTRA_STUDENT_CATEGORY,
                1);

        rollNoEt = (EditText) findViewById(R.id.roll_no_et);
        nextButton = (FloatingActionButton) findViewById(R.id.next_button_fb);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextButtonClicked();
            }
        });

        Toast.makeText(this, "StudentToBePlacedDb Category = "+mStudentCategory, Toast.LENGTH_SHORT)
                .show();


        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mQuestonAdapter = new QuestionAdapter(this, getQuestionsList());

        mRecyclerView.setAdapter(mQuestonAdapter);

    }

    private void onNextButtonClicked() {

        List<Question> answeredQuestionList = QuestionAdapter.getAnsweredQuesList();
        if (!rollNoEt.getText().toString().trim().isEmpty()) {
            Intent branchSpecificIntent = new Intent(this, SpecificFeedbackActivity.class);
            branchSpecificIntent.putExtra(ANSWERED_QUESTION_LIST, (Serializable) answeredQuestionList);
            branchSpecificIntent.putExtra(StudentActivity.EXTRA_STUDENT_CATEGORY, mStudentCategory);
            branchSpecificIntent.putExtra(STUDENT_ROLL_NO, rollNoEt.getText().toString().trim());
            startActivity(branchSpecificIntent);
        } else {
            rollNoEt.setError("PLease Enter a Valid Roll No.");
        }
    }

    private List<Question> getQuestionsList() {

        List<Question> questionsList = new ArrayList<>();

        questionsList.add(new Question("Attendance Priority"));
        questionsList.add(new Question("College Marks Importance"));
        questionsList.add(new Question("Lab Importance"));
        questionsList.add(new Question("Self Study Importance"));
        questionsList.add(new Question("Cochin Importance"));
        questionsList.add(new Question("Event Participation Importance"));
        questionsList.add(new Question("Projects Importance"));
        questionsList.add(new Question("Team Importance"));
        questionsList.add(new Question("General Knowledge Importance"));
        questionsList.add(new Question("Certificate Importance"));
        questionsList.add(new Question("Communication Classes Importance"));
        return questionsList;
    }
}
