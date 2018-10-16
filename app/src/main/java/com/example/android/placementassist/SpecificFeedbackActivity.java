package com.example.android.placementassist;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import static com.example.android.placementassist.FeedbackActivity.ANSWERED_QUESTION_LIST;

public class SpecificFeedbackActivity extends AppCompatActivity {

    /**
     * branch
     */
    private Spinner branchSpinner;
    private SpinnerArrayAdapter branchAdapter;
    private String branchSelected = null;

    private FloatingActionButton doneFab;
    private EditText impSubjectEt;

    List<Question> answeredQuestionList;
    int studentCategory;
    String rollNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_feedback);

        setupBranchSpinner();

        studentCategory = getIntent().getIntExtra(StudentActivity.EXTRA_STUDENT_CATEGORY, 1);
        rollNo = getIntent().getStringExtra(FeedbackActivity.STUDENT_ROLL_NO);
        


        impSubjectEt = (EditText) findViewById(R.id.important_subjects_et);
        doneFab = (FloatingActionButton) findViewById(R.id.done_fab);
        doneFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextContent = impSubjectEt.getText().toString().trim();
                if (allInputsValid(editTextContent)) {

                    insertDataIntoDb();
                    Toast.makeText(SpecificFeedbackActivity.this,
                            "Thanks",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SpecificFeedbackActivity.this, "Inputs not valid",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void insertDataIntoDb() {

        answeredQuestionList = (List<Question>) getIntent().
                getSerializableExtra(ANSWERED_QUESTION_LIST);

        Question question1 = answeredQuestionList.get(0);
        Question question2 = answeredQuestionList.get(1);
        Question question3 = answeredQuestionList.get(2);
        Question question4 = answeredQuestionList.get(3);
        Question question5 = answeredQuestionList.get(4);
        Question question6 = answeredQuestionList.get(5);
        Question question7 = answeredQuestionList.get(6);
        Question question8 = answeredQuestionList.get(7);
        Question question9 = answeredQuestionList.get(8);
        Question question10 = answeredQuestionList.get(9);
        Question question11 = answeredQuestionList.get(10);


        DatabaseOpenHelper dbOpenHelper = new DatabaseOpenHelper(this);
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("roll", rollNo);
        values.put("isPLaced", studentCategory);

        values.put("attend_w", question1.getmWeightage());
        values.put("clg_mks_w", question2.getmWeightage());
        values.put("lab_imp_w", question3.getmWeightage());
        values.put("self_study_w", question4.getmWeightage());
        values.put("coaching_w", question5.getmWeightage());
        values.put("event_w", question6.getmWeightage());
        values.put("project_w", question7.getmWeightage());
        values.put("team_w", question8.getmWeightage());
        values.put("gk_w", question9.getmWeightage());
        values.put("certificate_w", question10.getmWeightage());
        values.put("comm_class_w", question11.getmWeightage());

        values.put("attend_f", question1.getmKeyNotes());
        values.put("clg_mks_f", question2.getmKeyNotes());
        values.put("lab_imp_f", question3.getmKeyNotes());
        values.put("self_study_f", question4.getmKeyNotes());
        values.put("coaching_f", question5.getmKeyNotes());
        values.put("event_f", question6.getmKeyNotes());
        values.put("project_f", question7.getmKeyNotes());
        values.put("team_f", question8.getmKeyNotes());
        values.put("gk_f", question9.getmKeyNotes());
        values.put("certificate_f", question10.getmKeyNotes());
        values.put("comm_class_f", question11.getmKeyNotes());

        long rowId = db.insert(FeedbackDb.tablename, null, values);

        if (rowId != -1) {
            Toast.makeText(this, "Inserted : "+rowId, Toast.LENGTH_SHORT).show();
        }

    }

    private boolean allInputsValid(String editTextContent) {

        if ( editTextContent.isEmpty() || editTextContent.equals("") || branchSelected == null)
            return false;
        return true;
    }


    /**
     * setup branch spinner
     */
    private void setupBranchSpinner() {

        String[] branchArray = getResources().getStringArray(R.array.branch_array);
        branchSpinner = findViewById(R.id.branch_spinner);
        branchAdapter = new SpinnerArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, branchArray);
        branchSpinner.setAdapter(branchAdapter);
        branchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    branchSelected = parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
