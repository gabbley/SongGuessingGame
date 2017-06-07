package com.example.baniquedg.themesongguesser;

import android.content.Intent;
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
        Variables user = (Variables) this.getApplication();
        user.setUsername(login.getText().toString());
    }

    public void userLoggedIn(View view){
        Variables user = (Variables) this.getApplication();
        user.setUsername(login.getText().toString());
        goToClass(HomeScreen.class);
    }

    public void guestLogin(View view){
        Variables user = (Variables) this.getApplication();
        user.setUsername("Guest");
        goToClass(HomeScreen.class);
    }

    public void goToClass(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
