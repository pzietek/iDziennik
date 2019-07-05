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

public class VerbalAdapter extends RecyclerView.Adapter<VerbalAdapter.VerbalViewHolder> {

    private Context mCtx;
    private List<Grade> verbalList;

    public VerbalAdapter(Context mCtx, List<Grade> verbalList) {
        this.mCtx = mCtx;
        this.verbalList = verbalList;
    }

    @Override
    public VerbalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_grade, parent, false);
        return new VerbalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VerbalViewHolder holder, int position) {
        Grade g = verbalList.get(position);
        holder.textViewImie.setText(Integer.toString(g.getValue()));
    }

    @Override
    public int getItemCount() {
        return verbalList.size();
    }

    class VerbalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewImie;

        public VerbalViewHolder(View itemView) {
            super(itemView);
            textViewImie = itemView.findViewById(R.id.textViewValue);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Grade grade = verbalList.get(getAdapterPosition());
            //Intent intent = new Intent(mCtx, StudentGrade.class);
            //intent.putExtra("user", user);
            Toast.makeText(mCtx, Integer.toString(grade.getValue()), Toast.LENGTH_SHORT).show();
            // mCtx.startActivity(intent);
        }
    }
}
