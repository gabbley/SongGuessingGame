package com.example.baniquedg.themesongguesser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    private EditText login;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        loginInfo();
    }

    public void loginInfo(){
        login = (EditText) findViewById(R.id.txtboxLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        Variables example = (Variables) this.getApplication();
        example.setUsername(login.getText().toString());
    }

    public void userLoggedIn(View view){


        login.getText();
    }
}
