package com.kedochanh.myapplication.presenter;

import com.kedochanh.myapplication.view.LoginView;

/**
 * Created by Hoang Phuong on 3/22/2018.
 */

public class LoginPresenterImp  implements LoginPresenter {
    LoginView loginView;

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
    }


    @Override
    public void validateUser(String username, String password) {
        // Query user
        if(username.equals("phuong") && password.equals("123"))
            loginView.loginSuccess();
        else
            loginView.loginFail();
    }
}
