package com.example.idziennik;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.idziennik.db.AppDatabase;
import com.example.idziennik.db.Grade;
import com.example.idziennik.db.Subject;

import java.util.List;

public class StudentGradeForTeacher extends AppCompatActivity {
    private TextView name;
    private TextView lastName;
    private RecyclerView recyclerView_exams;
    private RecyclerView recyclerView_tests;
    private RecyclerView recyclerView_verbals;
    private Button buttonAddGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_grade_for_teacher);

        setTitle(CurrentSubject.value.getName());


        buttonAddGrade = findViewById(R.id.button_add_grade);
        buttonAddGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditGrade.class);

                startActivity(intent);
            }
        });

        name = findViewById(R.id.textViewValue);
        lastName = findViewById(R.id.textViewLastName);
        name.setText(CurrentStudent.value.getImie());
        lastName.setText(CurrentStudent.value.getNazwisko());

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
                ExamAdapter adapter = new ExamAdapter(StudentGradeForTeacher.this, grades);
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
                TestAdapter adapter = new TestAdapter(StudentGradeForTeacher.this, grades);
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
                TestAdapter adapter = new TestAdapter(StudentGradeForTeacher.this, grades);
                recyclerView_verbals.setAdapter(adapter);
            }
        }

        GetVerbals gv = new GetVerbals();
        gv.execute();
    }
}

