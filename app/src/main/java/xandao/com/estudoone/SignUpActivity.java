package xandao.com.estudoone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    Button buttonFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        buttonFinish = findViewById(R.id.signup_screen_button_finish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void signupFace(View v){
        Toast.makeText(this,"EM BREVE!!!",Toast.LENGTH_SHORT).show();
    }
}
