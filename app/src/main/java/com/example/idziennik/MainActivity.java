package com.example.idziennik;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.idziennik.db.AppDatabase;
import com.example.idziennik.db.User;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText loginText;
    private EditText passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //<< this
        this.setContentView(R.layout.activity_main);

        loginText = findViewById(R.id.editTextLogin);
        passText = findViewById(R.id.editTextPassword);

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginGiven = loginText.getText().toString();
                String passGiven = passText.getText().toString();

                zaloguj(loginGiven, passGiven);

            }
        });
    }

    private void zaloguj(final String loginGiven, final String passGiven) {
        class Zaloguj extends AsyncTask<Void, Void, User> {
            private String login = loginGiven;
            private String password = passGiven;

            @Override
            protected User doInBackground(Void... voids) {
                User user = AppDatabase
                        .getDatabase(getApplicationContext())
                        .userDao()
                        .getByLogin(loginGiven);

                return user;
            }

            @Override
            protected void onPostExecute(User u) {
                super.onPostExecute(u);
                if (u != null && passGiven.equals(u.getHaslo())) {
                    CurrentUser currentUser = new CurrentUser(u);
                    if(u.getTyp() == 's') {
                        Intent i = new Intent(getApplicationContext(), MenuStudent.class);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(getApplicationContext(), MenuTeacher.class);
                        startActivity(i);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "ZLY LOGIN LUB HASLO", Toast.LENGTH_SHORT).show();
                }
            }
        }
        Zaloguj zaloguj = new Zaloguj();
        zaloguj.execute();
    }

}
