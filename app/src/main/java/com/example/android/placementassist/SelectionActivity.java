package com.example.android.placementassist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }

    public void onSelectionButtonClicked(View view) {
        Intent nextActivityIntent = new Intent();

        switch (view.getId()) {
            case R.id.selection_company :
                nextActivityIntent.setClass(this, CompanyActivity.class);
                break;
            case R.id.selection_student :
                nextActivityIntent.setClass(this, StudentActivity.class);
                break;
            case R.id.selection_institute :
                nextActivityIntent.setClass(this, InstituteActivity.class);
        }

        startActivity(nextActivityIntent);
    }
}
