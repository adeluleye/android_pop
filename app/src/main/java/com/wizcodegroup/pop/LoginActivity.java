package com.wizcodegroup.pop;

/**
 * Created by Lheye on 4/20/15.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private Button btnLogin, btnRegister;
    private EditText usernameInput, passwordInput;
    private ImageView avatar;
    private String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeView();
    }

    public void initializeView(){
        btnLogin = (Button) findViewById(R.id.loginBtn);
        btnRegister = (Button) findViewById(R.id.registerBtn);
        usernameInput = (EditText) findViewById(R.id.username);
        passwordInput = (EditText) findViewById(R.id.password);
        avatar = (ImageView) findViewById(R.id.avatar);
    }

    public void btnLogin(View view){
        username = usernameInput.getText().toString().trim();
        password = passwordInput.getText().toString().trim();
        String myHint = "Username/Password cannot be less than 6 characters";
        String usernameAndPasswordCannotBeEmpty = "Username and Password cannot be Empty";
        String usernameOrPasswordCannotBeEmpty = "Username or Password Field cannot be Empty";
        String success = "Successfully Logged In";
        String myUserName = "admin123";
        String myPassword = "admin123";

        if (username.equals(myUserName)){
            if(password.equals(myPassword)){
                Toast.makeText(this, success, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }

        else if(username.length() <= 5){
            if(password.length() <=5){
                Toast.makeText(this, myHint, Toast.LENGTH_LONG).show();
            }
        }

        /*else if (username.equals("") && password.equals("")){
            Toast.makeText(this, usernameAndPasswordCannotBeEmpty, Toast.LENGTH_LONG).show();
        }*

        /*else if (password.equals("") || password.equals("")){
            Toast.makeText(this, usernameOrPasswordCannotBeEmpty, Toast.LENGTH_LONG).show();
        }*/

        else{
            Toast.makeText(this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
        }



    }

    public void btnRegisterClicked(View view){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
