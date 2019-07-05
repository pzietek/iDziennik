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

public class KlassAdapter extends RecyclerView.Adapter<KlassAdapter.KlassViewHolder> {

    private Context mCtx;
    private List<Klass> klassList;

    public KlassAdapter(Context mCtx, List<Klass> klassList) {
        this.mCtx = mCtx;
        this.klassList = klassList;
    }

    @Override
    public KlassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_item, parent, false);
        return new KlassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KlassViewHolder holder, int position) {
        Klass k = klassList.get(position);
        holder.textViewName.setText(k.getName());
    }

    @Override
    public int getItemCount() {
        return klassList.size();
    }

    class KlassViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;

        public KlassViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewValue);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Klass klass = klassList.get(getAdapterPosition());
            //Toast.makeText(mCtx, subject.getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mCtx, AllUsersList.class);


            mCtx.startActivity(intent);
        }
    }
}
