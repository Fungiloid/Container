package de.thi.container.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.thi.container.R;
import de.thi.container.data.ContainerApplication;
import de.thi.container.data.User;

public class MainMenuActivity extends AppCompatActivity {

    TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        initUI();

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setUsername();
    }

    public void initUI(){
        this.tvUsername = (TextView) this.findViewById(R.id.tvUsername);
    }

    public void setUsername(){
        ContainerApplication containerApplication = (ContainerApplication) getApplicationContext();
        User user = containerApplication.getCurrentUser();
        tvUsername.setText(user.getName());
    }
}
