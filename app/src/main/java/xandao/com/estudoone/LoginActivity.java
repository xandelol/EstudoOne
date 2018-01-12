package xandao.com.estudoone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginFace(View v){
        Toast.makeText(this,"EM BREVE!!!", Toast.LENGTH_SHORT);
    }

    public void signupScreen(View v){
        Intent signup = new Intent(this, SignUpActivity.class);
        startActivity(signup);
    }
}
