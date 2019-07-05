package com.example.idziennik;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.idziennik.db.AppDatabase;
import com.example.idziennik.db.Klass;
import com.example.idziennik.db.Subject;

import java.util.List;

public class KlassesList extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klasses_list);
        setTitle(getResources().getText(R.string.choose_klass_tittle));

        Bundle b = getIntent().getExtras();
        Subject currentSubject = (Subject) b.getSerializable("subject");

        recyclerView = findViewById(R.id.recyclerView_klasses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        getKlasses();
    }

    private void getKlasses() {
        class GetKlasses extends AsyncTask<Void, Void, List<Klass>> {

            @Override
            protected List<Klass> doInBackground(Void... voids) {
                List<Klass> klassList = AppDatabase
                        .getDatabase(getApplicationContext())
                        .klassDao()
                        .getAll();

                System.out.println(klassList);
                return klassList;
            }

            @Override
            protected void onPostExecute(List<Klass> klasses) {
                super.onPostExecute(klasses);
                KlassAdapter adapter = new KlassAdapter(KlassesList.this, klasses);
                recyclerView.setAdapter(adapter);
            }
        }

        GetKlasses gk = new GetKlasses();
        gk.execute();

    }
}
