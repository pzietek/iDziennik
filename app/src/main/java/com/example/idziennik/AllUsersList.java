package com.example.idziennik;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.idziennik.db.AppDatabase;
import com.example.idziennik.db.User;

import java.util.List;

public class AllUsersList extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users_list);

        recyclerView = findViewById(R.id.recyclerview_users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));
        
        getUsers();
    }

    private void getUsers() {
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = AppDatabase
                        .getDatabase(getApplicationContext())
                        .userDao()
                        .getAll();

                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);
                UsersAdapter adapter = new UsersAdapter(AllUsersList.this, users);
                recyclerView.setAdapter(adapter);
            }
        }

        GetUsers gt = new GetUsers();
        gt.execute();
    }
}

