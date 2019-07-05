package com.example.idziennik;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.idziennik.db.AppDatabase;
import com.example.idziennik.db.Subject;

import java.util.List;

public class SubjectsList extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_list);

        recyclerView = findViewById(R.id.recyclerview_subjects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        getSubjects();
    }

    private void getSubjects() {
        class GetSubjects extends AsyncTask<Void, Void, List<Subject>> {

            @Override
            protected List<Subject> doInBackground(Void... voids) {
                List<Subject> subjectList = AppDatabase
                        .getDatabase(getApplicationContext())
                        .subjectDao()
                        .getAll();

                return subjectList;
            }

            @Override
            protected void onPostExecute(List<Subject> subjects) {
                super.onPostExecute(subjects);
                SubjectAdapter adapter = new SubjectAdapter(SubjectsList.this, subjects);
                recyclerView.setAdapter(adapter);
            }
        }

        GetSubjects gs = new GetSubjects();
        gs.execute();
    }
}
