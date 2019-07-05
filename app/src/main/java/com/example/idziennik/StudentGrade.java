package com.example.idziennik;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.idziennik.db.AppDatabase;
import com.example.idziennik.db.Grade;
import com.example.idziennik.db.User;

import java.util.List;

public class StudentGrade extends AppCompatActivity {
    private TextView name;
    private TextView lastName;
    private RecyclerView recyclerView_exams;
    private RecyclerView recyclerView_tests;
    private RecyclerView recyclerView_verbals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_grade);

        Bundle b = getIntent().getExtras();
        User currentUser = (User) b.getSerializable("user");

        name = findViewById(R.id.textViewValue);
        lastName = findViewById(R.id.textViewLastName);
        name.setText(currentUser.getImie());
        lastName.setText(currentUser.getNazwisko());

        recyclerView_exams = findViewById(R.id.recyclerView_exams);
        recyclerView_exams.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_exams.addItemDecoration(new DividerItemDecoration(recyclerView_exams.getContext(),
                DividerItemDecoration.HORIZONTAL));

        recyclerView_tests = findViewById(R.id.recyclerView_tests);
        recyclerView_tests.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_tests.addItemDecoration(new DividerItemDecoration(recyclerView_tests.getContext(),
                DividerItemDecoration.HORIZONTAL));

        recyclerView_verbals = findViewById(R.id.recyclerView_verbals);
        recyclerView_verbals.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_verbals.addItemDecoration(new DividerItemDecoration(recyclerView_verbals.getContext(),
                DividerItemDecoration.HORIZONTAL));
        getExams();
        getTests();
        getVerbals();
    }

    private void getExams() {
        class GetExams extends AsyncTask<Void, Void, List<Grade>> {

            @Override
            protected List<Grade> doInBackground(Void... voids) {
                List<Grade> examList = AppDatabase
                        .getDatabase(getApplicationContext())
                        .gradeDao()
                        .getGrades('s');

                return examList;
            }

            @Override
            protected void onPostExecute(List<Grade> grades) {
                super.onPostExecute(grades);
                ExamAdapter adapter = new ExamAdapter(StudentGrade.this, grades);
                recyclerView_exams.setAdapter(adapter);
            }
        }

        GetExams ge = new GetExams();
        ge.execute();
    }

    private void getTests() {
        class GetTests extends AsyncTask<Void, Void, List<Grade>> {

            @Override
            protected List<Grade> doInBackground(Void... voids) {
                List<Grade> testList = AppDatabase
                        .getDatabase(getApplicationContext())
                        .gradeDao()
                        .getGrades('k');

                return testList;
            }

            @Override
            protected void onPostExecute(List<Grade> grades) {
                super.onPostExecute(grades);
                TestAdapter adapter = new TestAdapter(StudentGrade.this, grades);
                recyclerView_tests.setAdapter(adapter);
            }
        }

        GetTests gt = new GetTests();
        gt.execute();
    }

    private void getVerbals() {
        class GetVerbals extends AsyncTask<Void, Void, List<Grade>> {

            @Override
            protected List<Grade> doInBackground(Void... voids) {
                List<Grade> verbalList = AppDatabase
                        .getDatabase(getApplicationContext())
                        .gradeDao()
                        .getGrades('o');

                return verbalList;
            }

            @Override
            protected void onPostExecute(List<Grade> grades) {
                super.onPostExecute(grades);
                TestAdapter adapter = new TestAdapter(StudentGrade.this, grades);
                recyclerView_verbals.setAdapter(adapter);
            }
        }

        GetVerbals gv = new GetVerbals();
        gv.execute();
    }
}

