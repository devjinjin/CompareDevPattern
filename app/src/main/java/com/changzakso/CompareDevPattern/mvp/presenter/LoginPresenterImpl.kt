package com.changzakso.CompareDevPattern.mvp.presenter

import com.changzakso.CompareDevPattern.mvc.model.User
import com.changzakso.CompareDevPattern.mvp.view.MvpLoginView

class LoginPresenterImpl(
    private val mvpLoginView: MvpLoginView
) : LoginPresenter {
    override val user: User
        get() = User()

    override fun login() {
        val userName = mvpLoginView.userName.toString()
        val password = mvpLoginView.password.toString()

        val isLoginSuccess = user.login(userName, password)

        mvpLoginView.onLoginResult(isLoginSuccess)

    }
}
