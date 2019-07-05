package com.example.idziennik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.idziennik.db.User;

public class Menu extends AppCompatActivity {
    private Button buttonChooseSubject;
    private Button buttonProfil;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Bundle b = getIntent().getExtras();
        //user = (User) b.getSerializable("user");
        user = CurrentUser.value;

        buttonChooseSubject = findViewById(R.id.button_choose_subject);
        buttonProfil = findViewById(R.id.button_profil);

        buttonChooseSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubjectsList.class);
                startActivity(intent);
            }
        });

        buttonProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Profil.class);
                startActivity(intent);
            }
        });
    }
}
