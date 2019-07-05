package com.example.idziennik;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.idziennik.db.Klass;
import com.example.idziennik.db.Subject;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    private Context mCtx;
    private List<Subject> subjectList;

    public SubjectAdapter(Context mCtx, List<Subject> subjectList) {
        this.mCtx = mCtx;
        this.subjectList = subjectList;
    }

    @Override
    public SubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_item, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubjectViewHolder holder, int position) {
        Subject s = subjectList.get(position);
        holder.textViewName.setText(s.getName());
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    class SubjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;

        public SubjectViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewValue);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Subject subject = subjectList.get(getAdapterPosition());
            //Toast.makeText(mCtx, subject.getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mCtx, KlassesList.class);
            intent.putExtra("subject", subject);

            mCtx.startActivity(intent);
        }
    }
}
