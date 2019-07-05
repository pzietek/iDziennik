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

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private Context mCtx;
    private List<Grade> testList;

    public TestAdapter(Context mCtx, List<Grade> testList) {
        this.mCtx = mCtx;
        this.testList = testList;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_grade, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        Grade g = testList.get(position);
        holder.textViewImie.setText(Integer.toString(g.getValue()));
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewImie;

        public TestViewHolder(View itemView) {
            super(itemView);
            textViewImie = itemView.findViewById(R.id.textViewValue);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Grade grade = testList.get(getAdapterPosition());
            //Intent intent = new Intent(mCtx, StudentGrade.class);
            //intent.putExtra("user", user);
            Toast.makeText(mCtx, Integer.toString(grade.getValue()), Toast.LENGTH_SHORT).show();
            // mCtx.startActivity(intent);
        }
    }
}
