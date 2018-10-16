package com.example.android.placementassist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionHolder> {

    private static List<Question> mQuestionList;
    private Context mContext;

    public QuestionAdapter(Context context, List<Question> questions) {
        this.mContext = context;
        mQuestionList = questions;
    }

    @Override
    public QuestionHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.feedback_row_layout,
                parent, false);

        return new QuestionHolder(view);
    }

    @Override
    public void onBindViewHolder(QuestionHolder holder, final int position) {

        final Question currentQuestionObject = mQuestionList.get(position);

        String question = currentQuestionObject.getmQuestion();

        holder.mQuestionTv.setText(question);
        holder.mWeightageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               currentQuestionObject.setmWeightage(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        holder.mKeyNotesEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentQuestionObject.setmKeyNotes(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mQuestionList.size();
    }

    public class QuestionHolder extends RecyclerView.ViewHolder {

        TextView mQuestionTv;
        EditText mKeyNotesEt;
        SeekBar mWeightageSeekBar;

        public QuestionHolder(View itemView) {
            super(itemView);

            mQuestionTv = (TextView) itemView.findViewById(R.id.question_tv);
            mKeyNotesEt = (EditText) itemView.findViewById(R.id.key_note_et);
            mWeightageSeekBar = (SeekBar) itemView.findViewById(R.id.weightage_seek_bar);
        }
    }

    public static List<Question> getAnsweredQuesList() { return mQuestionList; }
}


