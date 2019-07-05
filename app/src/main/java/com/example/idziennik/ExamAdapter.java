package com.example.idziennik;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idziennik.db.Grade;

import java.util.List;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ExamViewHolder> {

    private Context mCtx;
    private List<Grade> examList;

    public ExamAdapter(Context mCtx, List<Grade> examList) {
        this.mCtx = mCtx;
        this.examList = examList;
    }

    @Override
    public ExamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_grade, parent, false);
        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExamViewHolder holder, int position) {
        Grade g = examList.get(position);
        holder.textViewImie.setText(Integer.toString(g.getValue()));
    }

    @Override
    public int getItemCount() {
        return examList.size();
    }

    class ExamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewImie;

        public ExamViewHolder(View itemView) {
            super(itemView);
            textViewImie = itemView.findViewById(R.id.textViewValue);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Grade grade = examList.get(getAdapterPosition());
            //Intent intent = new Intent(mCtx, StudentGrade.class);
            //intent.putExtra("user", user);
            Toast.makeText(mCtx, Integer.toString(grade.getValue()), Toast.LENGTH_SHORT).show();
           // mCtx.startActivity(intent);
        }
    }
}
