package com.example.idziennik;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.idziennik.db.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private Context mCtx;
    private List<User> userList;

    public UsersAdapter(Context mCtx, List<User> userList) {
        this.mCtx = mCtx;
        this.userList = userList;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_item, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        User u = userList.get(position);
        holder.textViewImie.setText(u.getImie());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewImie;

        public UsersViewHolder(View itemView) {
            super(itemView);
            textViewImie = itemView.findViewById(R.id.textViewValue);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            User user = userList.get(getAdapterPosition());
            CurrentStudent currentStudent = new CurrentStudent(user);
            Intent intent = new Intent(mCtx, StudentGradeForTeacher.class);

            mCtx.startActivity(intent);
        }
    }
}
