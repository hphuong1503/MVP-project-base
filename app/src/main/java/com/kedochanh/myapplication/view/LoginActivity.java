package com.kedochanh.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kedochanh.myapplication.R;
import com.kedochanh.myapplication.presenter.LoginPresenter;
import com.kedochanh.myapplication.presenter.LoginPresenterImp;

public class LoginActivity extends BaseActivity implements LoginView {
    EditText etUsername, etPassword;
    Button btnLogin;
    LoginPresenter  loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        manageClick();
        loginPresenter = new LoginPresenterImp(this);
    }

    private void manageClick() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.validateUser(etUsername.getText().toString(),etPassword.getText().toString());
            }
        });
    }

    private void init() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
    }
}
