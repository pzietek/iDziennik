package com.example.idziennik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.idziennik.db.User;

public class MenuTeacher extends AppCompatActivity {
    private Button buttonGrades;
    private Button buttonProfil;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_teacher);


        user = CurrentUser.value;

        buttonGrades = findViewById(R.id.button_add_grades);
        buttonProfil = findViewById(R.id.button_profil);

        buttonGrades.setOnClickListener(new View.OnClickListener() {
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
