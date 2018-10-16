package com.example.android.placementassist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {

    private static final int PLACED = 1;
    private static final int NOT_PLACED = 0;
    public static final String EXTRA_STUDENT_CATEGORY = "student_category";
    private int mStudentCategory = -1;
    private Button mNextButton;
    private RadioGroup mStudentCategoryRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        mStudentCategoryRadioGroup = (RadioGroup) findViewById(R.id.student_category_rg);
        mStudentCategoryRadioGroup.clearCheck();

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextButtonClicked();
            }
        });
    }

    private void onNextButtonClicked() {
        if (mStudentCategory != -1) {
            Intent reviewActivityIntent = new Intent(this, FeedbackActivity.class);
            reviewActivityIntent.putExtra(EXTRA_STUDENT_CATEGORY, mStudentCategory);
            startActivity(reviewActivityIntent);
        } else {
            Toast.makeText(this,"Select Student Category", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRadioButtonClicked(View view) {
        int clickedButtonId = view.getId();

        switch (clickedButtonId) {
            case R.id.placed_rb :
                mStudentCategory = 1;
                break;
            case R.id.not_placed_rb :
                mStudentCategory = 0;
                break;
            default :
                mStudentCategory = -1;
                break;
        }
    }

}
