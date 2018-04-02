package de.thi.container.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import de.thi.container.R;
import de.thi.container.data.ContainerApplication;
import de.thi.container.data.User;
import de.thi.container.exceptions.LoginUsernameMissingEx;
import de.thi.container.logik.Login;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText tfUsername;
    private EditText tfPassword;
    private TextView tvLoginError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

    }

    public void initUI(){
        this.tfUsername = (EditText)this.findViewById(R.id.tvUsername);
        this.tfPassword = (EditText)this.findViewById(R.id.tfPassword);
        this.btnLogin = (Button)this.findViewById(R.id.btnLogin);
        this.tvLoginError = (TextView)this.findViewById(R.id.tvLoginError);
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryLogin();
            }
        });

    }

    public void tryLogin(){
        String username = this.tfUsername.getText().toString();
        String password = this.tfPassword.getText().toString();

        Login login = new Login();
        try {
            login.login(username, password);
            setCurrentUser(username);
            switchToMainMenu();
        } catch(LoginUsernameMissingEx e){
            tvLoginError.setText("Username benötigt");
        }


    }

    public void switchToMainMenu(){
        Intent myIntent = new Intent(this, MainMenuActivity.class);
        startActivity(myIntent);
    }

    public void setCurrentUser(String username){
        User user = new User(username);
        ContainerApplication containerApplication = (ContainerApplication) getApplicationContext();
        containerApplication.setCurrentUser(user);
    }
}
