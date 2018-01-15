package xandao.com.estudoone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.transitionseverywhere.*;

public class LoginActivity extends AppCompatActivity {
    Button button;
    RelativeLayout faceLogin;
    LinearLayout signup;
    RelativeLayout enterForm;

    boolean firstStep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        faceLogin = (RelativeLayout) findViewById(R.id.login_screen_button_facebook);
        signup = (LinearLayout) findViewById(R.id.login_screen_signup);
        button = (Button) findViewById(R.id.login_screen_button_enter);
        enterForm = (RelativeLayout) findViewById(R.id.login_screen_enter_form);
        firstStep = true;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstStep) {
                    button.animate().translationY(250);
                    faceLogin.animate().translationY(500);
                    signup.animate().translationY(500);
                    enterForm.animate().translationY(-1400);
                    firstStep = false;
                }else{
                    Toast.makeText(LoginActivity.this,"ENTRAR EM BREVE!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(!firstStep) {
            button.animate().translationY(0);
            faceLogin.animate().translationY(0);
            signup.animate().translationY(0);
            enterForm.animate().translationY(0);
            firstStep = true;
        }else{
            super.onBackPressed();
        }
    }

    public void loginFace(View v){
        Toast.makeText(this,"EM BREVE!!!", Toast.LENGTH_SHORT).show();
    }

    public void signupScreen(View v){
        Intent signup = new Intent(this, SignUpActivity.class);
        startActivity(signup);
    }

    public  void loginForgoten(View v){
        Toast.makeText(LoginActivity.this,"LEMBRAR EM BREVE!!!", Toast.LENGTH_SHORT).show();
    }
}
