package xandao.com.estudoone;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;


public class LoginActivity extends AppCompatActivity {
    Button button;
    RelativeLayout faceLogin;
    LinearLayout signup;
    RelativeLayout enterForm;
    TextInputLayout inputEmail;
    TextInputLayout inputPass;
    EditText editEmail;
    EditText editPass;

    boolean firstStep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        faceLogin = (RelativeLayout) findViewById(R.id.login_screen_button_facebook);
        signup = (LinearLayout) findViewById(R.id.login_screen_signup);
        button = (Button) findViewById(R.id.login_screen_button_enter);
        enterForm = (RelativeLayout) findViewById(R.id.login_screen_enter_form);
        inputEmail = (TextInputLayout) findViewById(R.id.login_screen_email_edit_layout);
        inputPass = (TextInputLayout) findViewById(R.id.login_screen_pass_edit_layout);
        editEmail = (EditText) findViewById(R.id.login_screen_email_edit);
        editPass = (EditText) findViewById(R.id.login_screen_pass_edit);
        firstStep = true;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstStep) {
                    enterForm.setVisibility(View.VISIBLE);
                    button.animate().translationY(250);
                    faceLogin.animate().translationY(500);
                    signup.animate().translationY(500);
                    enterForm.animate().translationY(-1400);
                    firstStep = false;
                }else{
                    goMain();
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
            enterForm.setVisibility(View.GONE);
            firstStep = true;
        }else{
            super.onBackPressed();
        }
    }

    private void goMain(){
        if(validate()){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
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
        new MaterialDialog.Builder(this).title(R.string.forgot_pass)
                .customView(R.layout.forgot_dialog, true)
                .positiveText(R.string.forgot_ok).cancelable(true).positiveColor(
                getResources().getColor(R.color.colorRedSignUp)).negativeColor(
                getResources().getColor(R.color.colorRedSignUp)).negativeText(
                R.string.forgot_cancel).onPositive(new MaterialDialog.SingleButtonCallback(){
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
            }
        }).show();
    }

    private boolean validate(){
        String email = editEmail.getText().toString().trim();
        String pass = editPass.getText().toString().trim();
        boolean valid = true;
        if(email.isEmpty()){
            inputEmail.setErrorEnabled(true);
            editEmail.setError(getString(R.string.err_msg));
            valid = false;
        }
        if (pass.isEmpty()){
            inputPass.setErrorEnabled(true);
            editPass.setError(getString(R.string.err_msg));
            valid = false;
        }
        return valid;
    }
}
