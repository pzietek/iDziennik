package com.example.idziennik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idziennik.db.User;

import org.w3c.dom.Text;

public class Profil extends AppCompatActivity {
    private User curretUser = CurrentUser.value;
    private Button buttonChangeLogin;
    private Button buttonChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        TextView name = findViewById(R.id.textView_profile_name);
        TextView lastName = findViewById(R.id.textView_profile_lastName);
        TextView login = findViewById(R.id.textView_profile_loginValue);
        TextView password = findViewById(R.id.textView_profile_passwordValue);
        name.setText(curretUser.getImie());
        lastName.setText(curretUser.getNazwisko());
        login.setText(curretUser.getLogin());
        password.setText(curretUser.getHaslo());

        buttonChangeLogin = findViewById(R.id.button_profile_changeLogin);
        buttonChangePassword = findViewById(R.id.button_profile_changePassword);

        buttonChangeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profil.this, "Moze kiedys", Toast.LENGTH_SHORT).show();
            }
        });

        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profil.this, "Moze kiedys", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
